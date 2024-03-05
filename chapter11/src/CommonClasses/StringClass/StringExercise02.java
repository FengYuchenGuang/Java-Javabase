package CommonClasses.StringClass;

/**
 * @author hxz
 * String
 */
public class StringExercise02 {
    public static void main(String[] args) {
        //以下两种方法不一样 ，
        // "hello" + "abc" 常量相加，看的是池
        String a1 = "hello" + "abc"; //直接在常量池创建 "helloabc" 将地址传给a1

        String b1 = "hello";
        String b2 = "abc";
        //可以在这里断点debug 看，在这一句里 进出使用了三次StringBuilder方法
        // b1 + b2 变量相加，是在堆中
        String b3 = b1 + b2; //调用 StringBuilder() 将两个字符串拼接后  return new String("helloabc")

        //因此 a1 指向常量池中"helloabc"地址，
        //  而 b3指向 String 地址， String 再指向常量池中"helloabc"地址
        System.out.println(a1 == b3);  //false
        System.out.println(a1 == b3.intern()); //true


    }
}
