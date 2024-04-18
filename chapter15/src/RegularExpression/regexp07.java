package RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hxz
 * ^ 整个字符串开头
 * $ 整个字符串结尾
 *      MULTILINE 或 (?m) 可以改变 ^ $ 为每行的开头与结尾
 *
 * \b   匹配一个字边界，即字与空格间的位置。例如，"er\b"匹配"never"中的"er"，但不匹配"verb"中的"er"。
 *
 * \B   非字边界匹配。"er\B"匹配"verb"中的"er"，但不匹配"never"中的"er"。
 *
 */
public class regexp07 {
    public static void main(String[] args) {
        String content = "123-abc hanshunping sphan nn2828han";

        //以至少 1 个数字开头，后接任意个小写字母的字符串
        String regStr1 = "^[0-9]+[a-z]*";
        //以至少 1 个数字开头, 必须以至少一个小写字母结束
        String regStr2 = "^[0-9]+\\-[a-z\\s\\d]+$";
        //表示匹配边界的 han[这里的边界是指：被匹配的字符串最后, // 也可以是空格的子字符串的后面]
        String regStr3 = "han\\b";
        //和\\b 的含义刚刚相反
        String regStr4 = "han\\B";

        Pattern pattern = Pattern.compile(regStr2);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到=" + matcher.group(0));
        }
    }
}
