package ChangeTo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author hxz
 */
public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "d:\\agbk.txt";
        // 1.创建流对象
        OutputStreamWriter osw =
                new OutputStreamWriter(new FileOutputStream(filePath), "gbk");

        // 2.写入
        osw.write("hello,韩顺平教育~");

        // 3.关闭
        osw.close();
        System.out.println("保存成功~");
    }
}
