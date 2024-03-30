package reflection_;

/**
 * @author hxz
 */
public class Dog {
    private String name = "小狗";
    public int age = 18;

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    public void hi() {
//        System.out.println("hi " + name);
    }

    public void cry() {
        System.out.println(name + " 哭了~~~");
    }

}
