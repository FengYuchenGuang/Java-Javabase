package CommonClasses.HomeWork;

/**
 * @author hxz
 * 输入一串字符串，判断里面有多少大写字母，多少小写字母，多少数字
 * 'A' <=  <= 'Z'
 * 'a' <=  <= 'z'
 * '0' <=  <= '9'
 */
public class homework04 {
    public static void main(String[] args) {
        String str = "sa1f6aDe45f6Fae5f1FefAF";
        countStr(str);
    }

    public static void countStr(String str) {
        if (str == null) {
            System.out.println("字符串不能为空...");
        }

        char[] chars = str.toCharArray();
        int n1 = 0;
        int n2 = 0;
        int n3 = 0;
        int other = 0;
        for (char c : chars) {
            if (c >= 'A' && c <= 'Z') {
                n1++;
            } else if (c >= 'a' && c <= 'z') {
                n2++;
            } else if (c >= '0' && c <= '9') {
                n3++;
            } else {
                other++;
            }
        }

        System.out.println("字符串：" + str);
        System.out.println("有大写字母 " + n1 + " 个");
        System.out.println("有小写字母 " + n2 + " 个");
        System.out.println("有数字    " + n3 + " 个");
    }
}
