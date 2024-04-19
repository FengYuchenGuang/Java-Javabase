package RegularExpression.HomeWork;

/**
 * @author hxz
 *  验证是不是整数或者小数
 *  1、这题要考虑正负数
 */
public class homework02 {
    public static void main(String[] args) {
        String content1 = "123";
        String content2 = "-23.12";
        String content3 = "+8831.33";
        String content4 = "+28.31.33";
        String content5 = "+0028.3133";
        String content6 = "+0.3133";

        String regStr1 = "^[-+]?[\\d.]+$";
        // . 只能出现一次
        // 并且 . 和后面的可能不出现
        String regStr2 = "^[-+]?[\\d]+(\\.\\d+)?$";
        // 避免开头 00 或者 就是 0.~
        String regStr3 = "^[-+]?([1-9]\\d*)+(\\.\\d+)?$";
        String regStr = "^[-+]?([1-9]\\d*|0)(\\.\\d+)?$";

        if (content1.matches(regStr)) {
            System.out.println("content1 : " + content1 + "  ---验证通过~~~");
        } else {
            System.out.println("content1 : " + content1 + "  ---验证失败~~~");
        }

        if (content2.matches(regStr)) {
            System.out.println("content2 : " + content2 + "  ---验证通过~~~");
        } else {
            System.out.println("content2 : " + content2 + "  ---验证失败~~~");
        }

        if (content3.matches(regStr)) {
            System.out.println("content3 : " + content3 + "  ---验证通过~~~");
        } else {
            System.out.println("content3 : " + content3 + "  ---验证失败~~~");
        }

        if (content4.matches(regStr)) {
            System.out.println("content4 : " + content4 + "  ---验证通过~~~");
        } else {
            System.out.println("content4 : " + content4 + "  ---验证失败~~~");
        }

        if (content5.matches(regStr)) {
            System.out.println("content5 : " + content5 + "  ---验证通过~~~");
        } else {
            System.out.println("content5 : " + content5 + "  ---验证失败~~~");
        }

        if (content6.matches(regStr)) {
            System.out.println("content6 : " + content6 + "  ---验证通过~~~");
        } else {
            System.out.println("content6 : " + content6 + "  ---验证失败~~~");
        }
    }
}
