package CommonClasses.StringClass;

/**
 * @author hxz
 * 1. toUpperCase 转换成大写
 * 2. toLowerCase
 * 3. concat 拼接字符串
 * 4. replace 替换字符串中的字符
 * 5. split 分割字符串, 对于某些分割字符，我们需要 转义比如 | \\等
 * 6. toCharArray 转换成字符数
 * 7. compareTo 比较两个字符串的大小，如果前者大，
 *    则返回正数，后者大，则返回负数，如果相等，返回 0
 * 8. format 格式字符串
 */
public class StringMethod02 {
    public static void main(String[] args) {
        // 1. toUpperCase 转换成大写
        System.out.println("==============1、=============");
        String s = "heLLo";
        System.out.println(s.toUpperCase());//HELLO

        // 2. toLowerCase
        System.out.println("==============2、=============");
        System.out.println(s.toLowerCase());//hello

        // 3. concat 拼接字符串
        System.out.println("==============3、=============");
        String s1 = "宝玉";
        s1 = s1.concat("林黛玉").concat("薛宝钗").concat("together");
        System.out.println(s1);//宝玉林黛玉薛宝钗together

        // 4. replace 替换字符串中的字符
        System.out.println("==============4、=============");
        s1 = "宝玉 and 林黛玉 林黛玉 林黛玉";
        //在 s1 中，将 所有的 林黛玉 替换成薛宝钗
        // 老韩解读: s1.replace() 方法执行后，返回的结果才是替换过的.
        //          注意对 s1 没有任何影响
        String s11 = s1.replace("宝玉", "jack");
        System.out.println(s1);//宝玉 and 林黛玉 林黛玉 林黛玉
        System.out.println(s11);//jack and 林黛玉 林黛玉 林黛玉

        String s12 = s1.replace("林黛玉", "薛宝钗");
        System.out.println(s1);//宝玉 and 林黛玉 林黛玉 林黛玉
        System.out.println(s12);//宝玉 and 薛宝钗 薛宝钗 薛宝钗

        // 5. split 分割字符串, 对于某些分割字符，我们需要 转义比如 | \\等
        System.out.println("==============5、=============");
        String poem = "锄禾日当午,汗滴禾下土,谁知盘中餐,粒粒皆辛苦";
        //老韩解读：
        // 1. 以 , 为标准对 poem 进行分割 , 返回一个数组
        // 2. 在对字符串进行分割时，如果有特殊字符，需要加入 转义符 \
        String[] split1 = poem.split(",");
        poem = "E:\\aaa\\bbb";
        System.out.println(poem);
        String[] split2 = poem.split("\\\\");  //  其中因为 \ 为转义字符， \\ 代表一个\
        System.out.println("==分割后内容 split1 ===");
        for (int i = 0; i < split1.length; i++) {
            System.out.println(split1[i]);
        }
        System.out.println("==分割后内容 split2 ===");
        for (int i = 0; i < split2.length; i++) {
            System.out.println(split2[i]);
        }

        // 6. toCharArray 转换成字符数组
        System.out.println("==============6、=============");
        s = "happy";
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            System.out.println(chs[i]);
        }

        // 7. compareTo 比较两个字符串的大小，如果前者大，
        //     则返回正数，后者大，则返回负数，如果相等，返回 0
        // 老韩解读
        // (1) 如果长度相同，并且每个字符也相同，就返回 0
        // (2) 如果长度相同或者不相同，但是在进行比较时，可以区分大小
        // 就返回 if (c1 != c2) {
        //     return c1 - c2;
        // }
        // (3) 如果前面的部分都相同，就返回 str1.len - str2.len
        System.out.println("==============7、=============");
        String a = "jcck";// len = 3
        String b = "jack";// len = 4
        System.out.println(a.compareTo(b)); // 返回值是 'c' - 'a' = 2 的值
        System.out.println("asas".compareTo("asas")); // 0
        System.out.println("asas".compareTo("asat")); // 前者减后者 s - t
        System.out.println("asasss32".compareTo("asat")); // 比到不同的那一个 s - t
        System.out.println("as".compareTo("asatee")); // 都相同，比完了，长度相减 2 - 6
        System.out.println("asjjhh".compareTo("asj")); // 都相同，比完了，长度相减 6 - 3

        // 8. format 格式字符串
        /* 占位符有:
         * %s 字符串 %c 字符 %d 整型 %.2f 浮点型
         *
         */
        System.out.println("==============8、=============");
        String name = "john";
        int age = 10;
        double score = 56.857;
        char gender = '男';
        //将所有的信息都拼接在一个字符串.
        String info = "我的姓名是 " + name + " 年龄是 " + age +
                 "， 成绩是 " + score + " 性别是 " + gender + "。希望大家喜欢我！";
        System.out.println(info);
        //老韩解读
        //1. %s , %d , %.2f %c 称为占位符
        //2. 这些占位符由后面变量来替换
        //3. %s 表示后面由 字符串来替换
        //4. %d 是整数来替换
        //5. %.2f 表示使用小数来替换，替换后，只会保留小数点两位, 并且进行四舍五入的处理
        //6. %c 使用 char 类型来替换
        String formatStr = "我的姓名是%s 年龄是%d，成绩是%.2f 性别是%c。希望大家喜欢我！";
        String info2 = String.format(formatStr, name, age, score, gender);
        System.out.println("info2 = " + info2);
    }
}
