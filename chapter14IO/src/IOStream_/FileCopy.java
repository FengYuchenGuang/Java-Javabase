package IOStream_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author hxz
 * 文件拷贝，也可以是图片和音乐
 * D:\图片\崩坏星穹铁道\静态
 * 这里使用 FileInputStream
 * FileInputStream
 * 是字节处理流，因此可以拷贝二进制文件
 * 如果使用字符处理流则会损坏二进制文件，无法拷贝
 */
public class FileCopy {
    public static void main(String[] args) throws IOException {
        //完成文件拷贝
        //完成 文件拷贝，将 D:\\图片\\崩坏星穹铁道\\静态\\共浮一白.png 拷贝 d:\\
        //思路分析
        //1. 创建文件的输入流 , 将文件读入到程序
        //2. 创建文件的输出流， 将读取到的文件数据，写入到指定的文件.
        String srcFilePath = "d:\\图片\\崩坏星穹铁道\\静态\\共浮一白.png";
        String destFilePath = "d:\\共浮一白复制.png";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(srcFilePath);
            fileOutputStream = new FileOutputStream(destFilePath);
            //定义一个字节数组,提高读取效果
            byte[] buf = new byte[1024];
            int readLen = 0;
            //这里为什么不用 append =true 是因为这里是边读边写，
            // 写的时候，文件没有关闭，直到整张图片读完才关闭
            while ((readLen = fileInputStream.read(buf)) != -1) {
                //读取到后，就写入到文件 通过 fileOutputStream
                //即，是一边读，一边写
                fileOutputStream.write(buf, 0, readLen);//一定要使用这个方法
            }
            System.out.println("拷贝 ok~");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭输入流和输出流，释放资源
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
