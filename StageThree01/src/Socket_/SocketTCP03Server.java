package Socket_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author hxz
 * ****使用字符流*****
 * 服务器 接收字节输入流消息，通过转为字符流显示
 *
 * 服务器 使用字符输出流的方式回复信息
 *      使用字符输出流，不需要结束标记，该包装流自动设置了
 *
 * 1、编写一个服务器端，和一个客户端
 * 2、服务器端在 9999端口监听
 * 3、客户端连接到服务器端，发送 "hello，server~~"，并接收到服务器端回发的 "hello,client~~"，然后退出
 * 4、服务器端接收到客户端发送的信息，输出，并发送 "hello,client~~"，并退出
 */
public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        //思路
        //1. 在本机 的 9999 端口监听, 等待连接
        // 细节: 要求在本机没有其它服务在监听 9999
        // 细节：这个 ServerSocket 可以通过 accept() 返回多个 Socket[多个客户端连接服务器的 多并发]
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在 9999 端口监听，等待连接..");

        //2. 当没有客户端连接 9999 端口时，程序会 阻塞, 等待连接
        // 如果有客户端连接，则会返回 Socket 对象，程序继续
        Socket socket = serverSocket.accept();
        System.out.println("服务端 socket =" + socket.getClass());


        //3. 通过 socket.getInputStream() 读取客户端写入到数据通道的数据, 显示
        InputStream inputStream = socket.getInputStream();

        //4. IO 读取, 使用字符流, 老师使用 InputStreamReader 将 inputStream 转成字符流
        // InputStreamReader 不写，默认 utf-8
        //也可以进行多行内容读取
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
        String s;
        while ( (s = bufferedReader.readLine()) != null){
            System.out.println(s);//输出
        }

        //======回送消息======
        // 使用字符输出流的方式回复信息
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello,client~~字符输出"); // 不写 \r\n 那么需要插入换行符
        bufferedWriter.newLine();//插入一个换行符，表示写入的内容结束, 注意，要求对方使用 readLine()!!
        bufferedWriter.flush();// 如果使用的字符流，需要手动刷新，否则数据不会写入数据通道
        bufferedWriter.write("第二行内容~~~\r\n");
        bufferedWriter.flush();// 如果使用的字符流，需要手动刷新，否则数据不会写入数据通道
        bufferedWriter.write("第三行内容~~~\r\n");
        bufferedWriter.flush();// 如果使用的字符流，需要手动刷新，否则数据不会写入数据通道

        //*********设置结束标记*********
        socket.shutdownOutput();


        //5.关闭流和 socket
        bufferedWriter.close();//关闭外层流
        bufferedReader.close();
        socket.close();
        serverSocket.close();//关闭
        System.out.println("服务器关闭...");
    }
}
