package RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hxz
 * 非捕获分组
 * (?:pattern)  匹配 pattern 但不捕获该匹配的子表达式，即它是一个非捕获匹配，不存储供以后使用的匹配。
 *              这对于用"or"字符 (|) 组合模式部件的情况很有用。例如，'industr(?:y|ies)
 *              是比 'industry|industries' 更经济的表达式。
 *
 * (?=pattern)  执行正向预测先行搜索的子表达式，该表达式匹配处于匹配 pattern 的字符串的起始点的字符串。
 *              它是一个非捕获匹配，即不能捕获供以后使用的匹配。例如，'Windows (?=95|98|NT|2000)'
 *              匹配"Windows 2000"中的"Windows"，但不匹配"Windows 3.1"中的"Windows"。
 *              预测先行不占用字符，即发生匹配后，下一匹配的搜索紧随上一匹配之后，而不是在组成预测先行的字符后。
 *
 * (?<=pattern) 其后 '(?<=95|98|NT|2000)Windows' 不能匹配 'XPWindows' 等其他不在括号里的内容
 *              例如匹配 '95Windows' 得到 'Windows' 不是 '95Windows'
 *
 * (?!pattern)  执行反向预测先行搜索的子表达式，该表达式匹配不处于匹配 pattern 的字符串的起始点的搜索字符串。
 *              它是一个非捕获匹配，即不能捕获供以后使用的匹配。例如，'Windows (?!95|98|NT|2000)'
 *              匹配"Windows 3.1"中的 "Windows"，但不匹配"Windows 2000"中的"Windows"。
 *              预测先行不占用字符，即发生匹配后，下一匹配的搜索紧随上一匹配之后，而不是在组成预测先行的字符后。
 *
 * (?<!pattern) 其后 '(?<!95|98|NT|2000)Windows' 匹配不是 '95Windows'...
 *              例如匹配 'XPWindows' 得到 'Windows' 不是 'XPWindows'
 *
 *
 */
public class regexp09 {
    public static void main(String[] args) {
        String content = "hello 韩顺平教育 jack 韩顺平老师 韩顺平同学 hello 韩顺平学生";

        // 找到 韩顺平教育 、韩顺平老师、韩顺平同学 子字符串
        String regStr1 = "韩顺平教育|韩顺平老师|韩顺平同学";
        //上面的写法可以等价非捕获分组, 注意：不能 matcher.group(1)
        String regStr2 = "韩顺平(?:教育|老师|同学)";
        String regStr21 = "韩顺平(教育|老师|同学)";

        //找到 韩顺平 这个关键字,但是要求只是查找韩顺平教育和 韩顺平老师 中包含有的韩顺平
        //下面也是非捕获分组，不能使用 matcher.group(1)
        String regStr3 = "韩顺平(?=教育|老师)";
        //找到 韩顺平 这个关键字,但是要求只是查找 不是 (韩顺平教育 和 韩顺平老师) 中包含有的韩顺平
        //下面也是非捕获分组，不能使用 matcher.group(1)
        String regStr4 = "韩顺平(?!教育|老师)";

        Pattern pattern = Pattern.compile(regStr21);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到: " + matcher.group(0));
        }
    }
}
