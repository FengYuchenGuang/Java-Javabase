package ObjectStream_;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author hxz
 * 一定要看一下 Dog.java 里面有重要注意事项
 */
public class ObjectInputStream_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filePath = "d:\\data.dat";
        // 1.创建流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
        // 2.读取， 注意顺序 （读取顺序一定要与序列化的顺序一致）
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());
        System.out.println(ois.readObject());


        // 3.关闭
        ois.close();
        System.out.println("以反序列化的方式读取(恢复)ok~");

    }
}
