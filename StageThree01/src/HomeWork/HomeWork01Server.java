package HomeWork;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author hxz
 * 使用字符流方式，
 * 1、客户端发送 "name",服务器端接收到后回复 "我是hxz"
 * 2、客户端发生 "hobby",服务器端接收到后回复 "编写java程序"
 * 3、不是，回复， "你说啥？"
 */
public class HomeWork01Server {
    public static void main(String[] args) throws IOException {
        //思路
        //1. 在本机 的 9999 端口监听, 等待连接
        // 细节: 要求在本机没有其它服务在监听 9999
        // 细节：这个 ServerSocket 可以通过 accept() 返回多个 Socket[多个客户端连接服务器的 多并发]
        ServerSocket serverSocket = new ServerSocket(9999);

        //2. 当没有客户端连接 9999 端口时，程序会 阻塞, 等待连接
        // 如果有客户端连接，则会返回 Socket 对象，程序继续
        System.out.println("服务端，在 9999 端口监听，等待连接..");
        Socket socket = serverSocket.accept();


        //3. 通过 socket.getInputStream() 读取客户端写入到数据通道的数据, 显示
        InputStream inputStream = socket.getInputStream();

        //4. IO 读取, 使用字符流, 老师使用 InputStreamReader 将 inputStream 转成字符流
        // InputStreamReader 不写，默认 utf-8
        //也可以进行多行内容读取
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
        String s;
        String answer = "";
        while ( (s = bufferedReader.readLine()) != null){
            if("name".equals(s)){
                answer = "我是hxz";
            }else if("hobby".equals(s)){
                answer = "编写java程序";
            }else {
                answer = "你说啥？";
            }
        }

        //======回送消息======
        // 使用字符输出流的方式回复信息
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write(answer); // 不写 \r\n 那么需要插入换行符
        bufferedWriter.newLine();
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
