package Socket_;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author hxz
 * 使用 BufferedInputStream BufferedOutputStream
 *
 * 1、编写一个服务器端，和一个客户端
 * 2、服务器端在 8888 端口监听
 * 3、客户端连接到服务器端，发送 一张图片 "d:\\共浮一白.png"
 * 4、服务器端接收到 客户端发送的 图片，保存到 src下，并发送 "收到图片"，再退出
 * 5、该程序需要使用 StreamUtils.java (自己写的)
 */
public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {


        //客户端连接服务端 8888，得到 Socket 对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        //创建读取磁盘文件的输入流
        String FileName = "d:\\共浮一白.png";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(FileName));
        //bytes 就是 filePath 对应的字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        //通过 socket 获取到输出流, 将 bytes 数据发送给服务端
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);
        bos.flush();
        socket.shutdownOutput(); //结束标记

        bis.close();
        //=====接收从服务端回复的消息=====
        InputStream inputStream = socket.getInputStream();
        //使用 StreamUtils 的方法，直接将 inputStream 读取到的内容 转成字符串
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);

        //关闭相关的流
        bos.close();
        socket.close();



    }
}
