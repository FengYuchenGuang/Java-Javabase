package CommunicationSystem.Client.Service;

import CommunicationSystem.QQCommon.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @author hxz
 * 和服务器端保持通信的线程
 */
public class ClientConnectServerThread extends Thread{
    //该线程需要持有 socket
    private Socket socket;

    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //该线程需要在后台保持不断与服务器通信 使用 while
        while (true){
            System.out.println("客户端线程，等待读取服务器发送的信息...");
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //如果服务器没有发送信息，就会阻塞在这里，等待读取
                Message ms = (Message) ois.readObject();
                //后面会去使用 message

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }


}
