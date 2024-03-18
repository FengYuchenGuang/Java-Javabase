package HomeWork;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author hxz
 * 1、判断d盘下是否有文件夹 mytemp ，如果没有就创建 mytemp
 * 2、在 d:\\mytemp 目录下，创建文件 hello.txt
 * 3、如果 hello.txt 已经存在，提示该文件已经存在，不再创建
 * 4、在 hello.txt 文件中写入 hello,world~~~
 */
public class HomeWork01 {
    public static void main(String[] args) throws IOException {
        String dirName = "d:\\mytemp";
        String fileName = "d:\\mytemp\\hello.txt";

        //1、
        File file = new File(dirName);
        if (!file.exists()) {
            file.mkdir();
            System.out.println(dirName + " 创建成功~");
        }

        //2、3、
        File file1 = new File(fileName);
        try {
            boolean newFile = file1.createNewFile();
            if (newFile) {
                System.out.println(fileName + " 创建成功~");

            }else {
                System.out.println("文件已存在~");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true));
        bufferedWriter.write("hello,world~~~");

        bufferedWriter.close();

        System.out.println("程序结束...");
    }
}
