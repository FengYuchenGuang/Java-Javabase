package CommunicationSystem.Server.Service;

import CommunicationSystem.QQCommon.Message;
import CommunicationSystem.QQCommon.MessageType;
import CommunicationSystem.QQCommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author hxz
 * 服务器，在9999端口监听，等待客户端连接，并保持通信
 *
 * 端口可以写在配置文件中
 */
public class QQServer {
    private ServerSocket ss = null;

    public QQServer() {
        //注意：端口可以写在配置文件中
        System.out.println("服务器，在9999端口监听...");
        try {
            ss = new ServerSocket(9999);

            //监听是循环的，一直监听
            while (true){
                Socket socket = ss.accept();
                //得到 socket 关联的对象输入流
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //得到 socket 关联的对象输出流
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                User u = (User) ois.readObject();//读取客户端发送的 User 对象
                //创建一个 Message 对象，准备回复客户端
                Message message = new Message();
                //验证用户登录（先写死，后面可以使用数据库验证）
                if ("hxz".equals(u.getUserId()) && "123456".equals(u.getPasswd())){
                    //可以登录，返回true
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);

                    //创建一个线程和客户端保持通信
                    ServerConnectClientThread serverConnectClientThread =
                            new ServerConnectClientThread(socket,u.getUserId());
                    //启动该线程
                    serverConnectClientThread.start();
                    //将该线程加入到服务器 线程集合中


                }else {
                    //登录失败
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                }

                //回复给客户端是否成功登录
                oos.writeObject(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
