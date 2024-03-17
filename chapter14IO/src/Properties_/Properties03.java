package Properties_;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author hxz
 * 创建一个新的 properties 文件
 * 修改 properties 文件
 */
public class Properties03 {
    public static void main(String[] args) throws IOException {
        //创建一个新的 properties 文件
        System.out.println("=====创建一个新的 properties 文件=====");
        // 使用 Properties 类来创建 配置文件, 修改配置文件内容
        Properties properties1 = new Properties();
        //创建
        //1.如果该文件没有 key 就是创建
        //2.如果该文件有 key ,就是修改
        properties1.setProperty("charset", "utf8");
        properties1.setProperty("user", "汤姆");//注意保存时，是中文的 unicode 码值
        properties1.setProperty("pwd", "888888");
        //将 k-v 存储文件中即可
        properties1.store(new FileOutputStream("src\\mysql2.properties"), null);
        System.out.println("保存配置文件成功~");


        //修改 properties 文件
        System.out.println("=====修改 properties 文件=====");
        //使用 Properties 类来创建 配置文件, 修改配置文件内容
        Properties properties2 = new Properties();
        //2. 加载指定配置文件
        properties2.load(new FileReader("src\\mysql.properties"));
        properties2.list(System.out);
        //创建
        //3.如果该文件没有 key 就是创建
        //4.如果该文件有 key ,就是修改
        properties2.setProperty("charset", "utf8");
        properties2.setProperty("user", "汤姆");//注意保存时，是中文的 unicode 码值
        properties2.setProperty("pwd", "888888");

        properties2.store(new FileOutputStream("src\\mysql1.properties"), null);
        System.out.println("保存配置文件成功~");

    }
}
