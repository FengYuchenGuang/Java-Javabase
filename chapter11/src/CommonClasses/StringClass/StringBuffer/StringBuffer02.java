package CommonClasses.StringClass.StringBuffer;

/**
 * @author hxz
 */
public class StringBuffer02 {
    public static void main(String[] args) {
        //看 String——>StringBuffe
        String str = "hello tom";

        //方式 1 使用构造器
        //注意： 返回的才是 StringBuffer 对象，对 str 本身没有影响
        StringBuffer stringBuffer = new StringBuffer(str);
        //方式 2 使用的是 append 方法
        StringBuffer stringBuffer1 = new StringBuffer();
        stringBuffer1 = stringBuffer1.append(str);

        //看看 StringBuffer ->String
        StringBuffer stringBuffer3 = new StringBuffer("韩顺平教育");
        //方式 1 使用 StringBuffer 提供的 toString 方法
        String s = stringBuffer3.toString();
        //方式 2: 使用构造器来搞定
        String s1 = new String(stringBuffer3);
    }
}
