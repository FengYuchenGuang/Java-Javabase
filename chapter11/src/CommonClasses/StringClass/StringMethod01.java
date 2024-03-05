package CommonClasses.StringClass;

/**
 * @author hxz
 * 1. equals
 * 2. equalsIgnoreCase 忽略大小写的判断内容是否相等
 * 3. length 获取字符的个数，字符串的长度
 * 4. indexOf 获取 字符x 在 字符串对象 中第一次出现的索引，索引从 0 开始，如果找不到，返回-1
 * 5. lastIndexOf 获取字符在字符串中最后一次出现的索引，索引从 0 开始，如果找不到，返回-1
 * 6. substring 截取指定范围的子串
 */
public class StringMethod01 {
    public static void main(String[] args) {
        //1. equals 前面已经讲过了. 比较内容是否相同，区分大小写
        System.out.println("==============1、=============");
        String str1 = "hello";
        String str2 = "Hello";
        System.out.println(str1.equals(str2));//

        // 2. equalsIgnoreCase 忽略大小写的判断内容是否相等
        System.out.println("==============2、=============");
        String username = "johN";
        if ("john".equalsIgnoreCase(username)) {
            System.out.println("Success!");
        } else {
            System.out.println("Failure!");
        }

        // 3. length 获取字符的个数，字符串的长度
        System.out.println("==============3、=============");
        System.out.println("韩顺平".length());

        // 4. indexOf 获取 字符x 在 字符串对象 中第一次出现的索引，索引从 0 开始，如果找不到，返回-1
        System.out.println("==============4、=============");
        String s1 = "wer@terwe@g";
        int index = s1.indexOf('@');
        System.out.println(index);// 3
        System.out.println("we 第一次出现位置= " + s1.indexOf("we"));//0
        System.out.println("# 第一次出现位置= " + s1.indexOf("#"));//-1

        // 5. lastIndexOf 获取字符在字符串中最后一次出现的索引，索引从 0 开始，如果找不到，返回-1
        System.out.println("==============5、=============");
        s1 = "wer@terwe@g@";
        index = s1.lastIndexOf('@');
        System.out.println(index);//11
        System.out.println("ter 的位置= " + s1.lastIndexOf("ter"));//4
        System.out.println("we 的第一次出现位置= " + s1.indexOf("we"));//4
        System.out.println("we 的最后一次出现位置= " + s1.lastIndexOf("we"));//4

        // 6. substring 截取指定范围的子串
        System.out.println("==============6、=============");
        String name = "hello,张三，kkkk";
        //下面 name.substring(6) 从索引 6 开始截取后面所有的内容
        // ============(包括6)============
        System.out.println(name.substring(6));//截取后面的字符
        //name.substring(0,5)表示从索引 0 开始截取，截取到索引 5-1=4 位置
        System.out.println(name.substring(2,5));//llo
    }
}
