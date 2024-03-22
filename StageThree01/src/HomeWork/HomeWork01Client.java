package HomeWork;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author hxz
 * 使用字符流方式，
 * 1、客户端发送 "name",服务器端接收到后回复 "我是hxz"
 * 2、客户端发生 "hobby",服务器端接收到后回复 "编写java程序"
 * 3、不是，回复， "你说啥？"
 */
public class HomeWork01Client {
    public static void main(String[] args) throws IOException {
        //思路
        //1. 连接服务端 (ip , 端口）
        //解读: 连接本机的 9999 端口, 如果连接成功，返回 Socket 对象
        //如果连接远程服务器，那么就要可以直接填入 IP地址或域名
//        Socket socket = new Socket("180.101.50.188", 9999);
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket 返回=" + socket.getClass());

        // ====检测 输入====
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的问题：");
        String putin = scanner.next();


        //2. 连接上后，生成 Socket, 通过 socket.getOutputStream()
        // 得到 和 socket 对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        //3. 通过输出流，写入数据到 数据通道
        bufferedWriter.write(putin);
        bufferedWriter.newLine();
        bufferedWriter.flush();
        //*********设置结束标记*********
        socket.shutdownOutput();

        //======接收消息======
        //客户端 接收字符输入流 显示内容
        InputStream inputStream = socket.getInputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String readLen;
        while ((readLen = bufferedReader.readLine()) != null) {
            System.out.println(readLen);//根据读取到的实际长度，显示内容.
        }

        //4. 关闭流对象和 socket, 必须关闭
        bufferedReader.close();
        outputStream.close();
        socket.close();
        System.out.println("客户端退出.....");
    }
}
