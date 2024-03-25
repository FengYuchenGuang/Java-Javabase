package CommunicationSystem.Server.Service;

import CommunicationSystem.QQCommon.Message;
import CommunicationSystem.QQCommon.MessageType;
import CommunicationSystem.QQCommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hxz
 * 服务器，在9999端口监听，等待客户端连接，并保持通信
 *
 * 端口可以写在配置文件中
 */
public class QQServer {
    private ServerSocket ss = null;
    //创建一个集合，存放多个用户，如果是这些用户登录，那就认为是合法的
    //这里我们也可以使用 ConcurrentHashMap，可以处理并发的集合，没有线程安全问题
    // HashMap 没有处理线程安全问题，因此在多线程情况下是不安全的
    private static ConcurrentHashMap<String,User> validUsers = new ConcurrentHashMap<>();

    static {//在静态代码块中，初始化 validUsers
        validUsers.put("hxz",new User("hxz","123456"));
        validUsers.put("100",new User("100","234567"));
        validUsers.put("200",new User("200","345678"));
        validUsers.put("300",new User("300","456789"));
        validUsers.put("至尊宝",new User("至尊宝","111111"));
        validUsers.put("紫霞",new User("紫霞","222222"));
        validUsers.put("菩提老祖",new User("菩提老祖","333333"));

    }

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
                //验证用户登录（先写死，后面可以使用数据库验证）===========
                // 单点登录 最原始的方法，判断 当前连接线程中是否有该账号，没有则说明没有登陆，可以
                if (checkUserLogin(u.getUserId(),u.getPasswd()) &&
                      ManageClientThreads.getServerConnectClientThread(u.getUserId()) == null){
                    //可以登录，返回true
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    //回复给客户端是否成功登录
                    oos.writeObject(message);
                    //创建一个线程和客户端保持通信
                    ServerConnectClientThread serverConnectClientThread =
                            new ServerConnectClientThread(socket,u.getUserId());
                    //启动该线程
                    serverConnectClientThread.start();
                    //将该线程加入到服务器 线程集合中
                    ManageClientThreads.addClientThread(u.getUserId(),serverConnectClientThread);

                }else {
                    //登录失败
                    System.out.println("用户 id="+u.getUserId()+" pwd="+u.getPasswd()+" 验证失败...");
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    //回复给客户端是否成功登录
                    oos.writeObject(message);
                    //关闭 socket
                    socket.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //当服务端退出 while循环，说明服务器端不再监听
            //需要关闭资源
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean checkUserLogin(String uid, String pwd){
        User user = validUsers.get(uid);
        if (user == null){//说明该 uid 不存在
            return false;
        }

        if (!user.getPasswd().equals(pwd)){//uid 正确，密码错误
            return false;
        }

        return true;
    }
}
