package hxz.Debug_;

import java.util.Arrays;

//演示如何直接执行到下一个断点 F9 resume。
// 老韩小技巧: 断点可以在 debug 过程中，动态的下
public class debug04 {
    public static void main(String[] args) {
        int[] arr = {1, -1, 10, -20 , 100};
        //我们看看 Arrays.sort 方法底层实现.->Debug
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println("hello100");
        System.out.println("hello200");
        System.out.println("hello300");
        System.out.println("hello400");
        System.out.println("hello500");
        System.out.println("hello600");
        System.out.println("hello700");

    }
}
