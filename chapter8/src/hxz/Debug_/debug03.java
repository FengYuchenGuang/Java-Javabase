package hxz.Debug_;

import java.util.Arrays;

//演示如何追源码，看看 java 设计者是怎么实现的。(提高编程思想)。
// 小技巧：将光标放在某个变量上，可以看到最新的数据。
public class debug03 {
    public static void main(String[] args) {
        int[] arr = {1, -1, 10, -20 , 100};
        //我们看看 Arrays.sort 方法底层实现.->Debug
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }

    }
}
