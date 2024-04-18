package RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hxz
 * 限定符
 * *         >= 0
 * +         >0
 * ?         0或1
 * {n}       n个
 * {n,}      n个 或大于 n个
 * {n,m}     n~m 个之间
 *
 * ? : 当此字符紧随任何其他限定符（*、+、?、{n}、{n,}、{n,m}）之后时，匹配模式是"非贪心的"。
 *      "非贪心的"模式匹配搜索到的、尽可能短的字符串，而默认的"贪心的"模式匹配搜索到的、
 *      尽可能长的字符串。例如，在字符串"oooo"中，"o+?"只匹配单个"o"，而"o+"匹配所有"o"。
 */
public class regexp06 {
    public static void main(String[] args) {
        String content = "a211111aaaaaa1hello";
        //a{3},1{4},\\d{2}
        String regStr1 = "a{3}";// 表示匹配 aaa
        String regStr2 = "1{4}";// 表示匹配 1111
        String regStr3 = "\\d{2}";// 表示匹配 两位的任意数字字符
        //a{3,4},1{4,5},\\d{2,5}
        //细节：java 匹配默认贪婪匹配，即尽可能匹配多的
        String regStr4 = "a{3,4}"; //表示匹配 aaa 或者 aaaa
        String regStr5 = "1{4,5}"; //表示匹配 1111 或者 11111
        String regStr6 = "\\d{2,5}"; //匹配 2 位数或者 3,4,5
        //1+
        String regStr7 = "1+"; //匹配一个 1 或者多个 1
        String regStr8 = "\\d+"; //匹配一个数字或者多个数字
        //1*
        String regStr9 = "1*"; //匹配 0 个 1 或者多个 1
        //演示?的使用, 遵守贪婪匹配
        String regStr10 = "a1?"; //匹配 a 或者 a1
        //非贪婪匹配
        String regStr11 = "a1?"; //匹配 a 或者 a1

        Pattern pattern = Pattern.compile(regStr10/*, Pattern.CASE_INSENSITIVE*/);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到 " + matcher.group(0));
        }
    }
}
