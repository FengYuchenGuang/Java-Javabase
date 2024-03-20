package Socket_;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author hxz
 * <p>
 * 1、编写一个服务器端，和一个客户端
 * 2、服务器端在 8888 端口监听
 * 3、客户端连接到服务器端，发送 一张图片 "d:\\共浮一白.png"
 * 4、服务器端接收到 客户端发送的 图片，保存到 src下，并发送 "收到图片"，再退出
 * 5、该程序需要使用 StreamUtils.java
 */
public class TCPFileUploadServer {
    public static void main(String[] args) throws Exception {
        //1. 服务端在本机监听 8888 端口
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端在 8888 端口监听....");

        //2. 等待连接
        Socket socket = serverSocket.accept();

        //3. 读取客户端发送的数据
        // 通过 Socket 得到输入流
        InputStream inputStream = socket.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        //4. 将得到 bytes 数组，写入到指定的路径，就得到一个文件了
        String FileName = "src\\共浮一白.png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(FileName));
        bos.write(bytes);
        bos.close();

        // 向客户端回复 "收到图片"
        // 通过 socket 获取到输出流(字符)
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("收到图片 " + FileName);
        bufferedWriter.flush();//把内容刷新到数据通道
        socket.shutdownOutput();//设置写入结束标记


        //关闭其他资源
        bufferedWriter.close();//关闭外层流
        bis.close();
        socket.close();
        serverSocket.close();

    }
}
