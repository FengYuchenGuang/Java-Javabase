package RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hxz
 * 演示字符匹配符 的使用
 * 正则表达式元字符和特性
 * 字符匹配
 *      普通字符：普通字符按照字面意义进行匹配，例如匹配字母 "a" 将匹配到文本中的 "a" 字符。
 *      元字符：元字符具有特殊的含义，例如 \d 匹配任意数字字符，\w 匹配任意字母数字字符，. 匹配任意字符（除了换行符）等。
 * 量词
 *      *：匹配前面的模式零次或多次。
 *      +：匹配前面的模式一次或多次。
 *      ?：匹配前面的模式零次或一次。
 *      {n}：匹配前面的模式恰好 n 次。
 *      {n,}：匹配前面的模式至少 n 次。
 *      {n,m}：匹配前面的模式至少 n 次且不超过 m 次。
 * 字符类
 *      [ ]：匹配括号内的任意一个字符。例如，[abc] 匹配字符 "a"、"b" 或 "c"。
 *      [^ ]：匹配除了括号内的字符以外的任意一个字符。例如，[^abc] 匹配除了字符 "a"、"b" 或 "c" 以外的任意字符。
 * 边界匹配
 *      ^：匹配字符串的开头。
 *      $：匹配字符串的结尾。
 *      \b：匹配单词边界。
 *      \B：匹配非单词边界。
 * 分组和捕获
 *      ( )：用于分组和捕获子表达式。
 *      (?: )：用于分组但不捕获子表达式。
 * 特殊字符
 *      \：转义字符，用于匹配特殊字符本身。
 *      .：匹配任意字符（除了换行符）。
 *      |：用于指定多个模式的选择。
 *
 * 可以在 1、创建 Pattern对象时使用 Pattern.compile(regStr,CASE_INSENSITIVE)
 *       2、或者在 String 表达式中先使用  "(?i)abc"   表示 abc 不区分大小写
 * CASE_INSENSITIVE 或者 (?i) ： 表示正则匹配的时候忽略大小写，US-ASCII 字符下进行。
 *                          可以结合 UNICODE_CASE 的标记，基于 Unicode 的大小写不敏感的匹配就可以开启了
 *
 * COMMENTS 或者 (?x) ： 空白和 #开始直到行末的注释会被忽略掉
 *
 * DOTALL 或者 (?s) ： 这种模式下. 可以匹配所有字符，包括换行符，默认 .匹配除换行符以外的任意字符
 *
 * MULTILINE 或者 (?m) ： 更改 ^和 $ 的含义，以使它们分别与任何行的开头和结尾匹配，
 *                      而不只是与整个字符串的开头和结尾匹配。 注意：(?m)只有在正则表达式中
 *                      涉及到多行的^和$的匹配时，才使用 Multiline 模式。
 *
 * UNIX_LINES 或者 (?d) ： 在 .、^、&的行为中只识别换行符 \n
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
        Pattern pattern = Pattern.compile(regStr6/*, Pattern.CASE_INSENSITIVE*/);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到 " + matcher.group(0));
        }
    }
}
