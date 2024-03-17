package ChangeTo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author hxz
 * 演示使用 InputStreamReader 转换流解决中文乱码问题
 * 默认情况下是按照 utf-8 读取
 * 将字节流 FileInputStream 转成字符流 InputStreamReader, 指定编码 gbk/utf-8
 */
public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
        String filePath = "d:\\agbk.txt";
        //解读
        //1. 把 FileInputStream 转成 InputStreamReader
        //2. 指定编码 gbk
        //InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "gbk");
        //3. 把 InputStreamReader 传入 BufferedReader
        //BufferedReader br = new BufferedReader(isr);

        //将 2 和 3 合在一起
        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(filePath), "utf-8")); //utf-8
        //4. 读取
        String s;
        while ((s = br.readLine() )!= null){
            System.out.println("读取内容=" + s);
        }



        //5. 关闭外层流
        br.close();
    }
}
