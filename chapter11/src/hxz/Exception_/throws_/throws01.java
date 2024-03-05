package hxz.Exception_.throws_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author hxz
 */
public class throws01 {
    public static void main(String[] args) {
        try {
            f1();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            f2();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } finally {
            System.out.println("f2 finally 调用...");
        }

        System.out.println("程序继续运行....");
    }

    public static void f2() throws ArithmeticException {
        //1.对于编译异常，程序中必须处理，比如 try-catch 或者 throws
        //2.对于运行时异常，程序中如果没有处理，默认就是 throws 的方式处理
        int n1 = 10;
        int n2 = 0;
        double res = n1 / n2;
    }

    public static void f1() throws FileNotFoundException {
        //这里大家思考问题 调用 f3() 报错
        //老韩解读
        //1. 因为 f3() 方法抛出的是一个编译异常
        //2. 即这时，就要 f1() 必须处理这个编译异常
        //3. 在 f1() 中，要么 try-catch-finally ,或者继续 throws 这个编译异常
        f3(); // 抛出异常
    }

    public static void f3() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("d://aa.txt");
    }

    public static void f4() {
        //老韩解读:
        //1. 在 f4()中调用方法 f5() 是 OK
        //2. 原因是 f5() 抛出的是运行异常
        //3. 而 java 中，并不要求程序员显示处理,因为有默认处理机制
        f5();
    }

    public static void f5() throws ArithmeticException {
    }
}
