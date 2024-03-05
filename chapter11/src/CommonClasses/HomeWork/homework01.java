package CommonClasses.HomeWork;

/**
 * @author hxz
 * 1、将字符串中指定部分反转 ->  "abcdef"  -> "aedcbf"
 * public static String reverse(String str, int n1, int n2)
 */
public class homework01 {
    public static void main(String[] args) {
        String s = "abcdefghijk";
        int n1 = 1, n2 = 7;
        String sR = null;
        System.out.println("====交换前====");
        System.out.println(s);
        try {
            sR = reverse(s, n1, n2);
            System.out.println("====交换后====");
            System.out.println("将字符串中 " + n1 + " 到 " + n2 + " 部分反转 = \n" + sR);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    public static String reverse(String str, int n1, int n2) {
        //对输入参数要进行一个验证
        // 技巧：将正确情况列出然后取反即可
        if (!(str != null && n1 < n2 && n1 >= 0 && n2 < str.length())) {
            throw new RuntimeException("参数不正确");
        }

        char[] chars = str.toCharArray();
        char temp;
        //将字符串中指定部分反转
        for (int i = 0; i < (n2 - n1 + 1) / 2; i++) {
            temp = chars[n1 + i];
            chars[n1 + i] = chars[n2 - i];
            chars[n2 - i] = temp;
        }

        return new String(chars);
    }
}
