package hxz.interface_;


public interface Inter02 {
    //可以写属性
    public int n1 = 10;
    //可以写方法
    //在接口中，抽象方法，可以省略abstract关键字
    public void hi();

    //在jdk8以后，可以有默认实现方法，
    // 需要使用default关键字修饰
    default public void ok(){
        System.out.println("interface Inter02 say ok...");
        cry1();
    }

    //jdk8后可以有静态方法
    // 1、接口中的静态方法可以在接口中使用
    // 2、也可以在其他地方直接通过接口调用（前提：导入该包）
    public static void cry1(){
        System.out.println("interface Inter02 cry1...");
    }

    public  void cry();
}
