package hxz.Exception_;

/**
 * @author hxz
 * 五大运行时异常
 * NullPointerException
 * ArithmeticException
 * ArrayIndexOutOfBoundsException
 * ClassCastException 类型转换异
 * NumberFormatException 数字格式不正确异常
 */
public class Exception02 {
    public static void main(String[] args) {
        A b = new B(); //向上转型
        B b2 = (B)b;//向下转型，这里是 OK
        C c2 = (C)b;//这里抛出 ClassCastException


        String name = "韩顺平教育";
        String name1 = "1234";
        //将 String 转成 int
        int num1 = Integer.parseInt(name);//抛出 NumberFormatException
        System.out.println(num1);//1234

        int num = Integer.parseInt(name);//抛出 NumberFormatException
        System.out.println(num);//1234
    }
}

class A {}
class B extends A {}
class C extends A {}
