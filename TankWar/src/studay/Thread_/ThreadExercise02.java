package studay.Thread_;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Scanner;

/**
 * @author hxz
 * 1、在 main方法中启动两个线程
 * 2、线程一 循环随机打印100以内的整数
 * 3、当线程二从键盘读取了"Q"指令，结束线程一
 *
 * 调用start()方法后会先判断线程的状态是否为NEW，所以线程只能启动一次。
 *
 * 思路三：将线程一设置为守护线程
 */
public class ThreadExercise02 {
    public static void main(String[] args) throws InterruptedException {
        Thread01 thread01 = new Thread01();
        Thread02 thread02 = new Thread02();

        thread01.setName("thread01");
        thread02.setName("thread02");

        thread01.start();
        thread02.start();

        //方法一 第一遍我写的控制方法
        //通过检测 thread02 状态实现对其他线程的控制
        while (true){
            if (thread02.getState() == Thread.State.TERMINATED){
                thread01.setLoop(false);
                break;
            }
        }

        //方法二 让 thread04 持有 thread03 对象
        System.out.println("主程序方法一检测结束...");
        Thread.sleep(1000);


        Thread01 thread03 = new Thread01();
        Thread04 thread04 = new Thread04(thread03);

        thread03.setName("thread03");
        thread04.setName("thread04");

        thread03.start();
        thread04.start();

        System.out.println("主程序结束...");
    }
}

class Thread01 extends Thread {
    private int randomInt = 0;
    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            randomInt = (new Random()).nextInt(101);
            System.out.println("随机：" + randomInt);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
        System.out.println("线程 "+currentThread().getName()+" 结束...");
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}

class Thread02 extends Thread{
    Scanner myScanner = new Scanner(System.in);

    @Override
    public void run() {
        while (true){
            char next = myScanner.next().toUpperCase().charAt(0);

            if (next == 'Q'){
                break;
            }
            System.out.println("重新输入。。。");
        }
        System.out.println("线程 "+currentThread().getName()+" 结束...");

    }
}

class Thread04 extends Thread{
    Scanner myScanner = new Scanner(System.in);
    private Thread01 A;

    public Thread04() {
    }

    public Thread04(Thread01 a) {
        A = a;
    }

    @Override
    public void run() {
        while (true){
            char next = myScanner.next().toUpperCase().charAt(0);

            if (next == 'Q'){
                A.setLoop(false);
                break;
            }
            System.out.println("重新输入。。。");
        }
        System.out.println("线程 "+currentThread().getName()+" 结束...");

    }
}
