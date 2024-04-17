package RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hxz
 *
 * 正则表达式语法
 */
public class regexp03 {
    public static void main(String[] args) {
        String content = "abc$(a.bc(123( )";
        //匹配( => \\(
        //匹配. => \\.
        String regStr1 = "\\.";
        String regStr2 = "\\d\\d\\d";
        String regStr3 = "\\d{3}";
        Pattern pattern = Pattern.compile(regStr3);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到 " + matcher.group(0));
        }
    }
}
