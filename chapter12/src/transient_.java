
import java.io.*;

/**
 * @author hxz
 * 1、实现Serializable接口
 * 2、transient序列化情况
 * 3、static序列化情况
 * https://blog.csdn.net/qq_44543508/article/details/103232007
 */
public class transient_ {
    public static void main(String[] args) {
        // UserInfo1 没有实现 Serializable 接口，因此出现无法序列化异常
//        UserInfo1 userInfo1=new UserInfo1("老王","123");
//        System.out.println("序列化之前信息："+userInfo1);
//
//        try {
//            ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream("userinfo1.txt"));
//            output.writeObject(userInfo1);
//            output.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        System.out.println("======实现Serializable接口======");
        UserInfo2 userInfo2 = new UserInfo2("程序员老王", "123");
        System.out.println("序列化之前信息：" + userInfo2);

        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("userinfo2.txt")); //第二步开始序列化操作
            output.writeObject(userInfo2);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("userinfo2.txt"));//第三步开始反序列化操作
            Object o = input.readObject();//ObjectInputStream的readObject方法会抛出ClassNotFoundException
            System.out.println("序列化之后信息：" + o);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        //特别注意结果，添加transient修饰的属性值为默认值null！
        // 如果被transient修饰的属性为int类型，那它被序列化之后值一定是0，
        // 当然各位可以去试试，这能说明什么呢？说明被标记为transient的属性
        // 在对象被序列化的时候不会被保存(或者说变量不会持久化)
        System.out.println("======transient序列化情况======");
        UserInfo3 userInfo3 = new UserInfo3("程序员老王", "123");
        System.out.println("序列化之前信息：" + userInfo3);

        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("userinfo3.txt")); //第二步开始序列化操作
            output.writeObject(userInfo3);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("userinfo3.txt"));//第三步开始反序列化操作
            Object o = input.readObject();//ObjectInputStream的readObject方法会抛出ClassNotFoundException
            System.out.println("序列化之后信息：" + o);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }



    }
}

//transient序列化情况
class UserInfo3 implements Serializable{
    private String name;
    private transient String password;

    public UserInfo3(String name, String psw) {
        this.name = name;
        this.password = psw;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

class UserInfo1 {  //================================注意这里没有实现Serializable接口
    private String name;
    private String password;

    public UserInfo1(String name, String psw) {
        this.name = name;
        this.password = psw;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

//实现Serializable接口
class UserInfo2 implements Serializable {  //第一步实现Serializable接口
    private String name;
    private String password;//都是普通属性==============================

    public UserInfo2(String name, String psw) {
        this.name = name;
        this.password = psw;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

