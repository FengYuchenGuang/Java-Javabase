package HomeWork;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author hxz
 * 使用 UDP 协议完成，
 * 1、接收端在 8899 接口等待接受数据（receive）
 * 2、发送端向接收端发送数据 "四大名著是那些"
 * 3、接收端收到 该问题后 返回 "四大名著分别为《西游记》《红楼梦》《三国演义》《水浒传》"
 *    否则返回 "what？"
 */
public class HomeWork02Receiver {
    public static void main(String[] args) throws IOException {
        //1. 创建一个 DatagramSocket 对象，准备在 9999 接收数据
        DatagramSocket socket = new DatagramSocket(8899);

        //2. 构建一个 DatagramPacket 对象，准备接收数据
        // 在前面讲解 UDP 协议时，老师说过一个数据包最大 64k
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        //3. 调用 接收方法, 将通过网络传输的 DatagramPacket 对象
        // 填充到 packet 对象
        //老师提示: 当有数据包发送到 本机的 9999 端口时，就会接收到数据
        // 如果没有数据包发送到 本机的 9999 端口, 就会阻塞等待.
        System.out.println("接收端 A 等待接收数据..");
        socket.receive(packet);

        //4. 可以把 packet 进行拆包，取出数据，并显示.
        int length = packet.getLength();//实际接收到的数据字节长度
        byte[] data = packet.getData();//接收到数据
        String s = new String(data, 0, length);
        String answer = "";

        //======判断接受端的信息是那些？=====
        if ("四大名著是那些".equals(s)){
            answer = "四大名著分别为《西游记》《红楼梦》《三国演义》《水浒传》";
        }else {
            answer = "what?";
        }

        //===回复信息给 B 端
        //将需要发送的数据，封装到 DatagramPacket 对象
        data = answer.getBytes();
        //说明: 封装的 DatagramPacket 对象 data 内容字节数组 , data.length , 主机(IP) , 端口
        packet = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 9998);
        socket.send(packet);//发送

        //5. 关闭资源
        socket.close();
        System.out.println("A 端退出...");
    }
}
