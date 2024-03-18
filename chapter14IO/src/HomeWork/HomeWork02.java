package HomeWork;

import java.io.*;

/**
 * @author hxz
 * 1、使用 BifferedReader 读取一个文本文件，为每行加上行号，
 * 再联通内容一并输出到屏幕上
 * 2、如果文本编码为 gbk ，读取会出现 中文乱码
 * 2.1、默认按照 utf-8 处理
 * 2.2、因此我们要使用转换流，将 FileInputStream -> InputStreamReader[可以指定编码]
 * -> BufferedReader
 */
public class HomeWork02 {
    public static void main(String[] args) throws IOException {
        String fileName = "src\\hello.txt";
        //默认按照 utf-8 处理
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(fileName));
        //字节流转为字符流处理，并指定编码为 gbk
        BufferedReader bufferedReader2 = new BufferedReader(
                new InputStreamReader(new FileInputStream(fileName), "gbk"));

        String readLine;
        int num = 1;


        while ((readLine = bufferedReader1.readLine()) != null) {
            System.out.println("第 " + num + " 行内容为：" + readLine);
            num++;
        }

        bufferedReader1.close();


    }
}
