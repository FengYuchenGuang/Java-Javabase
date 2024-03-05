package hxz.Debug_;


//F7(跳入) F8(跳过) shift+F8(跳出) F9(resume,执行到下一个断点)
// F7：跳入方法内
// F8: 逐行执行代码.
// shift+F8: 跳出方法

public class debug01 {
    public static void main(String[] args) {
        //演示逐行执行代码
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += i;
            System.out.println("i=" + i);
            System.out.println("sum=" + i);
        }
        System.out.println("退出 for....");
    }
}
