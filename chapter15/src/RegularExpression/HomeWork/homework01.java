package RegularExpression.HomeWork;

/**
 * @author hxz
 * 验证电子邮件格式是否合法
 * 1、只能有一个@
 * 2、@前是用户名，可以是 a-z A-Z 0-9 _ - 字符
 * 3、@后面是域名 域名只能是英文字母 sohu.com 有 .
 * 4、写出对应的正则表达式，验证输入的字符串是否满足规则
 */
public class homework01 {
    public static void main(String[] args) {
        String content1 = "ankskfp237@163.com";
        String content2 = "232060172@hdu.edu.cn";

        String regStr = "^[\\w-]+@[a-zA-Z.]+$";
        String regStr1 = "^[\\w-]+@([a-zA-Z]+\\.)+[a-zA-Z]+$";

        if (content1.matches(regStr1)) {
            System.out.println("content1 : " + content1 + "  ---验证通过~~~");
        } else {
            System.out.println("content1 : " + content1 + "  ---验证失败~~~");
        }

        System.out.println("========================");
        if (content2.matches(regStr1)) {
            System.out.println("content2 : " + content2 + "  ---验证通过~~~");
        } else {
            System.out.println("content2 : " + content2 + "  ---验证失败~~~");
        }

    }
}
