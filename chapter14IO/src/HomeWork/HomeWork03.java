package HomeWork;


import java.io.*;
import java.util.Properties;

/**
 * @author hxz
 * 1、编写一个 dog.properties
 * name=tom
 * age=5
 * color=red
 * 2、编写 Dog类(name,age,color) 创建一个对象，读取 dog.properties 用相应的内容完成属性初始化，并输出
 * 3、将创建的 Dog 对象，序列化到文件 dog.dat 中
 */
public class HomeWork03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String fileName = "src\\HomeWork\\dog.properties";
        String fileName1 = "src\\HomeWork\\dog.dat";
        Properties properties = new Properties();
        properties.load(new FileReader(fileName));
        properties.list(System.out);

        Dog dog = new Dog(properties.getProperty("name"), Integer.valueOf(properties.getProperty("age")),
                properties.getProperty("color"));

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName1));
        objectOutputStream.writeObject(dog);

        objectOutputStream.close();
        System.out.println("====文件 dog.dat 写入成功====\n\n");
        System.out.println("====文件 dog.dat 读取====");

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName1));
        System.out.println(objectInputStream.readObject());

        System.out.println("程序结束...");

    }
}

class Dog implements Serializable {
    private String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
