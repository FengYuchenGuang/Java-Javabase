package RegularExpression;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hxz
 * 反向引用 $1 (group号)
 */
public class regexp14 {

    @Test
    public void test1(){
        String content = "122135584561";
        String regStr = "(\\d)(\\d)\\2\\1";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()){
            System.out.println("符合条件的数字为：" + matcher.group(0));
        }
    }

    @Test
    public void test2(){
        String content = "asdad12456-444555666asdadas";
        String regStr = "\\d{5}-(\\d)\\1{2}(\\d)\\2{2}(\\d)\\3{2}";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()){
            System.out.println("符合条件的数字为：" + matcher.group(0));
        }
    }

    public static void main(String[] args) {
        String content = "我....我要....学学学学....编程 java!!!";
        //1. 去掉所有的.
        Pattern pattern = Pattern.compile("\\.");
        Matcher matcher = pattern.matcher(content);

        content = matcher.replaceAll("");
        System.out.println("content 1 = " + content);
        //2. 去掉重复的字 我我要学学学学编程 java!
        // 思路
        //(1) 使用 (.)\\1+  // + 匹配一次或多次 检测到则必有重复数字
        //(2) 使用 反向引用$1 来替换匹配到的内容
        // 注意：因为正则表达式变化，所以需要重置 matcher
        pattern = Pattern.compile("(.)\\1+");//分组的捕获内容记录到$1
        matcher = pattern.matcher(content);
        while (matcher.find()) {
         System.out.println("找到=" + matcher.group(0));
        }
        //
        // //使用 反向引用$1 来替换匹配到的内容
         content = matcher.replaceAll("$1");
        // System.out.println("content=" + content);


        //3. 使用一条语句 去掉重复的字 我我要学学学学编程 java!
//        content = Pattern.compile("(.)\\1+").matcher(content).replaceAll("$1");
        System.out.println("content 2 = " + content);
    }
}
