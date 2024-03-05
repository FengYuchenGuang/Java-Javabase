package hxz.Exception_;

/**
 * @author hxz
 */
public class try_catch03 {
    public static void main(String[] args) {

        /*
        可以进行 try-finally 配合使用, 这种用法相当于没有捕获异常，
        因此程序会直接崩掉/退出。应用场景，就是执行一段代码，不管是否发生异常，
        都必须执行某个业务逻辑
        */
        try {
            int num1 = 10;
            int num2 = 0;
            int res = num1 / num2;
        }finally {
            System.out.println("finally 代码块被执行...");
        }

        System.out.println("程序继续运行....");
    }
}
