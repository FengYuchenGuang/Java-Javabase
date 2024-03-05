package CommonClasses.BigNum;

import java.math.BigDecimal;

/**
 * @author hxz
 */
public class BigDecimal_ {
    public static void main(String[] args) {
        //当我们需要保存一个精度很高的数时，double 不够用
        //可以是 BigDecimal
        // double d = 1999.11111111111999999999999977788d;
        // System.out.println(d);
        BigDecimal bigDecimal = new BigDecimal("1999.11");
        BigDecimal bigDecimal2 = new BigDecimal("3");
        System.out.println("bigDecimal = " + bigDecimal);

        //老韩解读
        //1. 如果对 BigDecimal 进行运算，比如加减乘除，需要使用对应的方法
        //2. 创建一个需要操作的 BigDecimal 然后调用相应的方法即可
        System.out.println("加法 = " + bigDecimal.add(bigDecimal2));
        System.out.println("减法 = " + bigDecimal.subtract(bigDecimal2));
        System.out.println("乘法 = " + bigDecimal.multiply(bigDecimal2));
        //System.out.println(bigDecimal.divide(bigDecimal2));//可能抛出异常 ArithmeticException
        //在调用 divide 方法时，指定精度即可. BigDecimal.ROUND_CEILING
        //如果有无限循环小数，就会保留 分子 的精度(除数,被除数分子最长位数为几位,则最多保留这么多位)
        System.out.println("除法 = " + bigDecimal.divide(bigDecimal2, BigDecimal.ROUND_CEILING));
    }
}
