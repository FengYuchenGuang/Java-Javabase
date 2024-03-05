package CommonClasses.WrapperClass;

/**
 * @author hxz
 */
public class CommonMethod {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE); //最大值
        System.out.println(Integer.MIN_VALUE); //最小值

        System.out.println(Character.isDigit('A')); //是否为数字  false
        System.out.println(Character.isLetter('B')); //是否为字母 true
        System.out.println(Character.isUpperCase('C')); //是否为大写 true
        System.out.println(Character.isLowerCase('D')); //是否为小写 false

        System.out.println(Character.isWhitespace('E')); //是否空格 false
        System.out.println(Character.toUpperCase('F')); //转成大写 F
        System.out.println(Character.isLowerCase('G')); //转成小写 false
    }
}
