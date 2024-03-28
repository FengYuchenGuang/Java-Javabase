package CommunicationSystem.Server.Service;

import CommunicationSystem.QQCommon.Message;
import CommunicationSystem.QQCommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hxz
 * 该类的一个对象和某个客户端保持通信
 */
public class ServerConnectClientThread extends Thread {
    private Socket socket;
    private String userId;//连接到服务端的用户ID

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    @Override
    public void run() { //线程处于 run 状态，可以发送/接收消息
        while (true) {
            System.out.println("服务端 和 客户端(" + userId + ")保持通讯，读取数据...");
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message ms = (Message) ois.readObject();
                //后面会使用 message =======
                //判断这个Message类型，然后做相应业务处理
                if (ms.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
                    //客户端要求在线用户列表
                    System.out.println(ms.getSender() + " 要求在线用户列表");
                    String onlineUser = ManageClientThreads.getOnlineUser();
                    //构建一个 Message 对象，返回给客户端
                    Message returnMessage = new Message();
                    returnMessage.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    returnMessage.setContent(onlineUser);
                    returnMessage.setGetter(ms.getSender());
                    //返回客户端
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(returnMessage);
                } else if (ms.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {
                    //客户端退出
                    System.out.println(ms.getSender() + " 退出");
                    //将这个客户端从管理线程的集合移除
                    ManageClientThreads.removeClientThread(ms.getSender());
                    socket.close();//关闭连接
                    //退出线程
                    break;

                }else if (ms.getMesType().equals(MessageType.MESSAGE_COMM_MES)){
                    /******************重要理解，如何转发消息*****************/
                    //根据message获取getterUid，然后再得到对应的线程
                    ServerConnectClientThread serverConnectClientThread =
                            ManageClientThreads.getServerConnectClientThread(ms.getGetter());

                    //=====如果发送的用户不在线，那么可以将消息保存到数据库，实现离线消息留言，登陆后显示======
                    if (UserIFOffline(serverConnectClientThread,ms)){
                        continue;
                    }

                    //得到对应 socket 对象的输出流，将 message发给指定对象
                    ObjectOutputStream oos =
                            new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    oos.writeObject(ms);//转发消息

                }else if (ms.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)){
                    /******************重要理解，如何群发消息*****************/
                    //需要遍历管理线程的集合，把所有的线程 socket 得到，然后把 message发给 对象
                    Iterator<String> iterator = ManageClientThreads.getHm().keySet().iterator();
                    while (iterator.hasNext()) {
                        String uid =  iterator.next();
                        if (!uid.equals(ms.getSender())){//排除自己
                            //根据遍历的 uid，然后再得到对应的线程
                            ServerConnectClientThread serverConnectClientThread =
                                    ManageClientThreads.getServerConnectClientThread(uid);
                            //得到对应 socket 对象的输出流，将 message发给指定对象
                            ObjectOutputStream oos =
                                    new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                            //=====如果发送的用户不在线，那么可以将消息保存到数据库，实现离线消息留言，登陆后显示======
                            oos.writeObject(ms);//转发消息
                        }
                    }
                }else if (ms.getMesType().equals(MessageType.MESSAGE_SEND_FILE)){
                    //根据 getterUid 获取到对应的线程，将message对象转发
                    ServerConnectClientThread serverConnectClientThread =
                            ManageClientThreads.getServerConnectClientThread(ms.getGetter());

                    //=====如果发送的用户不在线，那么可以将消息保存到数据库，实现离线消息留言，登陆后显示======
                    if (UserIFOffline(serverConnectClientThread,ms)){
                        continue;
                    }

                    ObjectOutputStream oos = new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    //转发
                    oos.writeObject(ms);
                }else if (ms.getMesType().equals(MessageType.MESSAGE_OFFLINE_CONTENT)){
                    /******************查看是否有离线消息，有就发送*****************/
                    //查看是否有离线消息
                    if (QQServer.getOffLineDb().containsKey(ms.getSender())){//有离线消息
                        ArrayList<Message> messages = QQServer.getOffLineDb().get(ms.getSender());
                        Iterator<Message> iterator = messages.iterator();
                        while (iterator.hasNext()) {
                            Message offlineContent =  iterator.next();
                            if (offlineContent.getMesType().equals(MessageType.MESSAGE_COMM_MES)){
                                //根据message获取getterUid，然后再得到对应的线程
                                ServerConnectClientThread serverConnectClientThread =
                                        ManageClientThreads.getServerConnectClientThread(ms.getSender());

                                //得到对应 socket 对象的输出流，将 message发给指定对象
                                ObjectOutputStream oos =
                                        new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                                oos.writeObject(offlineContent);//转发消息

                            }else if (offlineContent.getMesType().equals(MessageType.MESSAGE_SEND_FILE)){
                                //根据 getterUid 获取到对应的线程，将message对象转发
                                ServerConnectClientThread serverConnectClientThread =
                                        ManageClientThreads.getServerConnectClientThread(ms.getSender());
                                ObjectOutputStream oos = new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                                //转发
                                oos.writeObject(offlineContent);
                            }
                        }
                        //删除该用户在服务器端的留言消息
                        QQServer.getOffLineDb().remove(ms.getSender());
                    }
                } else{
                    System.out.println("是其他类型 暂时不处理...");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    //=====如果发送的用户不在线，那么可以将消息保存到数据库，实现离线消息留言，登陆后显示======
    private boolean UserIFOffline(ServerConnectClientThread serverConnectClientThread,Message ms){
        //=====如果发送的用户不在线，那么可以将消息保存到数据库，实现离线消息留言，登陆后显示======
        if (serverConnectClientThread == null){
            ConcurrentHashMap<String, ArrayList<Message>> offLineDb = QQServer.getOffLineDb();
            ArrayList<Message> messages;
            if (!offLineDb.containsKey(ms.getGetter())){//如果该用户没有留言信息
                messages = new ArrayList<>();
                messages.add(ms);
                offLineDb.put(ms.getGetter(), messages);
            }else {
                messages = offLineDb.get(ms.getGetter());
                messages.add(ms);
            }
            return true;
        }
        return false;
    }

    public Socket getSocket() {
        return socket;
    }
}
