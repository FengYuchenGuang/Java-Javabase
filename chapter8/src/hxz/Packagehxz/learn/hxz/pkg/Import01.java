package learn.hxz.pkg;

import java.util.Arrays;

public class Import01 {
    public static void main(String[] args) {
        //使用系统提供的 Arrays 完成数组排序
        int[] arr = {10,5,99,-65,33,26};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
