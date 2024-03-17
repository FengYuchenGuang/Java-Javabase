package ObjectStream_;

/**
 * @author hxz
 * 2、序列化对象时，默认将里面所有属性都进行序列化，但 static 和 transient修饰的对象不会被序列化
 * 3、序列化对象时，要求对象里面的属性的类型也要实现序列化接口
 */

public class Dog implements java.io.Serializable {
    private String name;
    private int age;
    private static String from;
    private transient String color;

    //1、serialVersionUID 序列化版本号，可以提高兼容性
    //类中添加新的方法属性和方法是，不会认为这是一个新的类
    private static final long serialVersionUID = 1L;

    public Dog(String name, int age, String from, String color) {
        this.name = name;
        this.age = age;
        this.from = from;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", from='" + from + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

