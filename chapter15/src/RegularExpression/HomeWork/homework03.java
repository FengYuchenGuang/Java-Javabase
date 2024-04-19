package RegularExpression.HomeWork;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hxz
 *  对 url 进行解析
 *  1、要求得到协议是什么   http https
 *  2、域名是什么
 *  3、端口是什么
 *  4、文件名是什么
 */
public class homework03 {
    public static void main(String[] args) {
        String content1 = "http://www.sohu.com:8080/abc/xxx/uuuy/index.htm";

        String regStr = "^(http(?:s?))://([A-Za-z.]+):([\\d]+)([\\w/-]+)*/([\\w.]+)$";
        String regStr1 = "^([A-Za-z]+)://([A-Za-z.]+):([\\d]+)([\\w/-]+)*/([\\w.]+)$";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content1);
        if (matcher.matches()){//整体匹配
            System.out.println(matcher.group(0));
            System.out.println("协议 = "+matcher.group(1));
            System.out.println("域名 = "+matcher.group(2));
            System.out.println("端口 = "+matcher.group(3));
            System.out.println("文件名 = "+matcher.group(5));

        }else {
            System.out.println("没有匹配成功~~~");
        }
    }
}
