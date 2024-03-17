package Buffered_;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author hxz
 */
public class BufferedReader_ {
    public static void main(String[] args) throws IOException {
//        String filePath = "d:\\a.java";
        String filePath = "d:\\ok.txt";
        //创建 bufferedReader
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        //读取
        String line; //按行读取, 效率高
        //说明
        //1. bufferedReader.readLine() 是按行读取文件
        //2. 当返回 null 时，表示文件读取完毕
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        //关闭流, 这里注意，只需要关闭 BufferedReader ，因为底层会自动的去关闭 节点流
        //FileReader。
        /*
        public void close() throws IOException {
            synchronized (lock) {
                if (in == null)
                    return;
                try {
                    in.close();//in 就是我们传入的 new FileReader(filePath), 关闭了. } finally {
                    in = null;
                    cb = null;
                }
            }
        }
        */

        bufferedReader.close();
    }
}
