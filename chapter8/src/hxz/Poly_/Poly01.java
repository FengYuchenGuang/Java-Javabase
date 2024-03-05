package hxz.Poly_;

public class Poly01 {
    public static void main(String[] args) {
        Master master = new Master("hxz");
        Dog dog1 = new Dog("小怪");
        Bone bone1 = new Bone("骨头");
        Cat cat1 = new Cat("小花猫");
        Fish fish1 = new Fish("黄花鱼");

        master.feed(dog1,bone1);
        System.out.println("==============");
        master.feed(cat1,fish1);


    }
}
