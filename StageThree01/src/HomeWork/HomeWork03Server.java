package HomeWork;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author hxz
 * 编写 服务器端 和 客户端程序
 * 1、客户端可以输入一个 文件名 ，服务器端收到名字后，可以给客户端 返回这个文件，如果
 *    服务器端没有这个文件，返回一个 默认的文件即可
 * 2、客户端接收到文件后 保存到本地 "d:\\"
 * 3、提示，可以使用自己编写的 StreamUtils.java
 */
public class HomeWork03Server {
    public static void main(String[] args) throws Exception {
        //1. 服务端在本机监听 8888 端口
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端在 8888 端口监听....");

        //2. 等待连接
        Socket socket = serverSocket.accept();

        //=====接收从服务端回复的下载内容=====
        InputStream inputStream = socket.getInputStream();
        //使用 StreamUtils 的方法，直接将 inputStream 读取到的内容 转成字符串
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = reader.readLine();
        String down = "";
        if ("共浮一白".equals(line)){
            down = "src\\" + line + ".png";
        }else {
            down = "src\\" + "天河迴星，银浦流云" + ".png";
        }


        //创建读取磁盘文件的输入流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(down));
        //bytes 就是 filePath 对应的字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bis);


        //通过 socket 获取到输出流, 将 bytes 数据发送给服务端
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);
        bos.flush();
        socket.shutdownOutput(); //结束标记

        //关闭其他资源
        bos.close();//关闭外层流
        bis.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务器退出...");
    }
}
