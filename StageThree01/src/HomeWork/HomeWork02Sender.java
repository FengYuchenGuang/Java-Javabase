package HomeWork;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @author hxz
 * 使用 UDP 协议完成，
 * 1、接收端在 8899 接口等待接受数据（receive）
 * 2、发送端向接收端发送数据 "四大名著是那些"
 * 3、接收端收到 该问题后 返回 "四大名著分别为《西游记》《红楼梦》《三国演义》《水浒传》"
 *    否则返回 "what？"
 */
public class HomeWork02Sender {
    public static void main(String[] args) throws IOException {
        //1.创建 DatagramSocket 对象，准备在 9998 端口 接收数据
        DatagramSocket socket = new DatagramSocket(9998);

        // =====接收问题======
        System.out.println("请输入你的问题：");
        Scanner scanner = new Scanner(System.in);
        String question = scanner.next();

        //2. 将需要发送的数据，封装到 DatagramPacket 对象
        byte[] data = question.getBytes(); //
        //说明: 封装的 DatagramPacket 对象 data 内容字节数组 , data.length , 主机(IP) , 端口
        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 8899);
        socket.send(packet);

        //3.==== 接收从 A 端回复的信息 =====
        //(1) 构建一个 DatagramPacket 对象，准备接收数据
        // 在前面讲解 UDP 协议时，老师说过一个数据包最大 64k
        byte[] buf = new byte[1024];
        packet = new DatagramPacket(buf, buf.length);
        //(2) 调用 接收方法, 将通过网络传输的 DatagramPacket 对象
        // 填充到 packet 对象
        //老师提示: 当有数据包发送到 本机的 9998 端口时，就会接收到数据
        // 如果没有数据包发送到 本机的 9998 端口, 就会阻塞等待.
        socket.receive(packet);
        //(3) 可以把 packet 进行拆包，取出数据，并显示.
        int length = packet.getLength();//实际接收到的数据字节长度
        data = packet.getData();//接收到数据
        String s = new String(data, 0, length);
        System.out.println(s);

        //关闭资源
        socket.close();
        System.out.println("B 端退出");
    }
}
