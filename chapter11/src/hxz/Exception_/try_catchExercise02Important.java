package hxz.Exception_;

import java.util.Scanner;

/**
 * @author hxz
 */
public class try_catchExercise02Important {
    public static void main(String[] args) {
        //如果用户输入的不是一个整数，就提示他反复输入，直到输入一个整数为止
        //思路
        //1. 创建 Scanner 对象
        //2. 使用无限循环，去接收一个输入
        //3. 然后将该输入的值，转成一个 int
        //4. 如果在转换时，抛出异常，说明输入的内容不是一个可以转成 int 的内容
        //5. 如果没有抛出异常，则 break 该循环
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        String inputStr = "";
        while (true) {
            System.out.println("请输入一个整数:"); //
            inputStr = scanner.next();
            try {
                num = Integer.parseInt(inputStr); //这里是可能抛出异常
                break;
            } catch (NumberFormatException e){
                System.out.println("你输入的不是一个整数:");
            }
        }

        System.out.println("你输入的值是=" + num);
    }
}
