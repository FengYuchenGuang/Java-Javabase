package CommunicationSystem.Server.Service;

import CommunicationSystem.QQCommon.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

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
            System.out.println("服务端 和 客户端(" + userId + ")保存通讯，读取数据...");
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message ms = (Message) ois.readObject();
                //后面会使用 message =======


            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
