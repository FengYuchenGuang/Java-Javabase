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

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }
}
