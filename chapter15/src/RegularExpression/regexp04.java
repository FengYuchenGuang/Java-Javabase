package RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hxz
 * 演示字符匹配符 的使用
 */
public class regexp04 {
    public static void main(String[] args) {
        String content = "a11c8abc _\nABCy @";

        String regStr1 = "[a-z]";//匹配 a-z 之间任意一个字符
        String regStr2 = "[A-Z]";//匹配 A-Z 之间任意一个字符
        String regStr3 = "abc";//匹配 abc 字符串[默认区分大小写]
        // (?i) 后面的不区分大小写
        String regStr4 = "(?i)abc";//匹配 abc 字符串[不区分大小写]
        String regStr5 = "[0-9]";//匹配 0-9 之间任意一个字符
        String regStr6 = "[^a-z]";//匹配 不在 a-z 之间任意一个字符
        String regStr7 = "[^0-9]";//匹配 不在 0-9 之间任意一个字符
        String regStr8 = "[abcd]";//匹配 在 abcd 中任意一个字符
        String regStr15 = "\\d";//匹配 0-9 的任意一个字符
        String regStr9 = "\\D";//匹配 不在 0-9 的任意一个字符
        String regStr10 = "\\w";//匹配 大小写英文字母, 数字，下划线
        String regStr11 = "\\W";//匹配 等价于 [^a-zA-Z0-9_]
        //\\s 匹配任何空白字符(空格,制表符等)
        String regStr12 = "\\s";
        //\\S 匹配任何非空白字符 ,和\\s 刚好相反
        String regStr13 = "\\S";
        //. 匹配出 \n 之外的所有字符,如果要匹配. 本身则需要使用 \\.
        String regStr14 = ".";
        //说明
        //1. 当创建 Pattern 对象时，指定 Pattern.CASE_INSENSITIVE, 表示匹配是不区分字母大小写.
        Pattern pattern = Pattern.compile(regStr14/*, Pattern.CASE_INSENSITIVE*/);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到 " + matcher.group(0));
        }
    }
}
