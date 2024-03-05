package hxz.Override_;

public class Dog extends Animal{
    //老韩解读
    //1. 因为 Dog 是 Animal 子类
    //2. Dog 的 cry 方法和 Animal 的 cry 定义形式一样(名称、返回类型、参数)
    //3. 这时我们就说 Dog 的 cry 方法，重写了 Animal 的 cry 方法
    public void cry() {
        System.out.println("小狗汪汪叫..");
    }
    //细节: 子类方法的返回类型和父类方法返回类型一样，
    // 或者是父类返回类型的子类
    // 比如 父类 返回类型是 Object ,
    // 子类方法返回类型是 String
    public String m1() {
        return null;
    }
    //这里 Object 不是 String 的子类，因此编译错误
    // public Object m2() {
    // return null;
    // }
    // public BBB m3() {
    // return null;
    // }
    //细节: 子类方法不能缩小父类方法的访问权限 【演示】
    //public > protected > 默认>private
    public void eat() {
    }
}

class AAA {
}

class BBB extends AAA {
}
