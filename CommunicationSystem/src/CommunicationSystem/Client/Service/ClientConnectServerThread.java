package CommunicationSystem.Client.Service;

import CommunicationSystem.QQCommon.Message;
import CommunicationSystem.QQCommon.MessageType;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @author hxz
 * 和服务器端保持通信的线程
 */
public class ClientConnectServerThread extends Thread {
    //该线程需要持有 socket
    private Socket socket;

    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //该线程需要在后台保持不断与服务器通信 使用 while
        while (true) {
            System.out.println("客户端线程，等待读取服务器发送的信息...");
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //如果服务器没有发送信息，就会阻塞在这里，等待读取
                Message ms = (Message) ois.readObject();
                //后面会去使用 message
                //判断这个Message类型，然后做相应业务处理
                //如果读取到的是 服务端返回在线用户列表
                if (ms.getMesType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)) {
                    //取出在线列表信息并显示
                    //规定返回 在线用户列表的形式为 "100 200 至尊宝 hxz"
                    String[] onlineUsers = ms.getContent().split(" ");
                    System.out.println("\n=========当前在线用户列表=========");
                    for (int i = 0; i < onlineUsers.length; i++) {
                        System.out.println("用户：" + onlineUsers[i]);
                    }
                } else if (ms.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {
                    //普通聊天消息
                    //把服务器转发的消息，显示到控制台即可
                    System.out.println("\n" + ms.getSender() + " 说：" + ms.getContent() + " 时间：" + ms.getSendTime());

                }else if (ms.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)) {
                    //群发的聊天消息
                    //把服务器转发的消息，显示到控制台即可
                    System.out.println("\n" + ms.getSender() + " 对大家说：" + ms.getContent() + " 时间：" + ms.getSendTime());

                }else if (ms.getMesType().equals(MessageType.MESSAGE_SEND_FILE)) {
                    //接收文件
                    System.out.println("\n" + ms.getSender() + " 给" + ms.getGetter()
                            + " 发送了文件：从 " + ms.getSrc()+" 到 "+ms.getDest());

                    FileOutputStream fileOutputStream = new FileOutputStream(ms.getDest());
                    fileOutputStream.write(ms.getFileBytes());
                    fileOutputStream.close();
                    System.out.println("\n 保存文件成功~~~");
                }else if (ms.getMesType().equals(MessageType.MESSAGE_NEWS_TO_ALL)) {
                    //群发的聊天消息
                    //把服务器转发的消息，显示到控制台即可
                    System.out.println("\n" + ms.getSender() + " 对大家说：" + ms.getContent() + " 时间：" + ms.getSendTime());

                } else {
                    System.out.println("是其他类型 暂时不处理...");
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }


}
