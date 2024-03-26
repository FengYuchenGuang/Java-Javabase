package CommunicationSystem.Client.Service;

import CommunicationSystem.QQCommon.Message;
import CommunicationSystem.QQCommon.MessageType;
import CommunicationSystem.QQCommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author hxz
 * 该类完成用户登录验证和用户注册功能
 */
public class UserClientService {
    //可能在其他地方使用该user信息，因此需要设置为成员属性
    private User u = new User();
    //可能在其他地方使用 socket，因此需要设置为成员属性
    private Socket socket;



    //根据 uid pwd 到服务端验证该用户是否合法
    public boolean checkUserLogin(String uid,String pwd){
        boolean b = false;
        //创建user对象
        u.setUserId(uid);
        u.setPasswd(pwd);
        //连接服务器，验证用户信息
        try {
            socket =  new Socket(InetAddress.getByName("127.0.0.1"),9999);
            //得到 ObjectOutputStream 对象
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);//发送user对象

            //读取从服务器发回的 message 对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms = (Message) ois.readObject();

            if (ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){
                //登录成功
                //创建一个和服务器端保持通信的线程 -> ClientConnectServerThread
                ClientConnectServerThread clientConnectServerThread =
                        new ClientConnectServerThread(socket);
                //启动客户端线程
                clientConnectServerThread.start();
                //为了后面客户端的管理，我们将线程放入集合管理
                ManageClientConnectServerThread.addClientConnectServerThread(uid,clientConnectServerThread);
                b = true;
            }else {
                //如果登录失败，我们就没有成功启动和服务器通信的线程，关闭socket
                socket.close();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return b;
    }

    //向服务器请求在线用户列表
    public void getOnlineFriend(){
        //发送一个 Message,类型 MESSAGE_GET_ONLINE_FRIEND
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(u.getUserId());//说明要求者，只返回该要求者当前在线的好友

        //发送给服务器
        try {
            //应该得到当前线程的 socket 对应的 ObjectOutputStream
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);//发送一个Message对象，向服务器要求获取在线列表
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //编写方法退出客户端，并给服务端发送一个退出系统的 Message对象
    public void loginExit(){
        //发送一个 Message,类型 MESSAGE_GET_ONLINE_FRIEND
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(u.getUserId());//说明发送者是哪个客户端

        //发送 message
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
            System.out.println(u.getUserId()+" 退出系统");
            System.exit(0);//结束进程
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //向服务器询问是否有离线消息
    public void getOfflineContent(){
        //发送一个 Message,类型 MESSAGE_OFFLINE_CONTENT
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_OFFLINE_CONTENT);
        message.setSender(u.getUserId());//说明发送者是哪个客户端

        //发送 message
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }
}
