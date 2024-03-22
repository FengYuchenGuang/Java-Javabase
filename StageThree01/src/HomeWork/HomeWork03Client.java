package HomeWork;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author hxz
 * 编写 服务器端 和 客户端程序
 * 1、客户端可以输入一个 文件名 ，服务器端收到名字后，可以给客户端 返回这个文件，如果
 *    服务器端没有这个文件，返回一个 默认的文件即可
 * 2、客户端接收到文件后 保存到本地 "d:\\"
 * 3、提示，可以使用自己编写的 StreamUtils.java
 *
 * 共浮一白
 */
public class HomeWork03Client {
    public static void main(String[] args) throws Exception {
        //客户端连接服务端 8888，得到 Socket 对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        // =====输入问题=======
        System.out.println("请输入你的想要下载的文件：");
        Scanner scanner = new Scanner(System.in);
        String downFile = scanner.next();

        // 向服务器发送需要下载的文件名
        // 通过 socket 获取到输出流(字符)
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write(downFile);
        bufferedWriter.flush();//把内容刷新到数据通道
        socket.shutdownOutput();//设置写入结束标记

        //=====接收从服务端 需要下载的文件=====
        InputStream inputStream = socket.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        //==========保存接收到的文件===============
        String FileName = "d:\\" + downFile + ".png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(FileName));
        bos.write(bytes);
        bos.flush();

        //关闭相关的流
        bos.close();
        bis.close();
        socket.close();
        System.out.println("客户端退出...");
    }
}
