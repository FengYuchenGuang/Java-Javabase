package Socket_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author hxz
 * *********设置结束标记*********
 *
 * 1、编写一个服务器端，和一个客户端
 * 2、服务器端在 9999端口监听
 * 3、客户端连接到服务器端，发送 "hello，server~~"，并接收到服务器端回发的 "hello,client~~"，然后退出
 * 4、服务器端接收到客户端发送的信息，输出，并发送 "hello,client~~"，并退出
 */
public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {
        //思路
        //1. 连接服务端 (ip , 端口）
        //解读: 连接本机的 9999 端口, 如果连接成功，返回 Socket 对象
        //如果连接远程服务器，那么就要可以直接填入 IP地址或域名
//        Socket socket = new Socket("180.101.50.188", 9999);
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket 返回=" + socket.getClass());

        //2. 连接上后，生成 Socket, 通过 socket.getOutputStream()
        // 得到 和 socket 对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();

        //3. 通过输出流，写入数据到 数据通道
        outputStream.write("hello, 你好".getBytes());
        //*********设置结束标记*********
        socket.shutdownOutput();

        //======接收消息======
        InputStream inputStream = socket.getInputStream();

        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readLen));//根据读取到的实际长度，显示内容.
        }

        //4. 关闭流对象和 socket, 必须关闭
        inputStream.close();
        outputStream.close();
        socket.close();
        System.out.println("客户端退出.....");
    }
}
