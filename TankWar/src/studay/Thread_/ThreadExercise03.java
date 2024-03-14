package studay.Thread_;

import java.util.Scanner;

/**
 * @author hxz
 * 1、有两个用户分别从同一个卡上取钱（总额：10,000）
 * 2、每次取1,000 当余额不足时，不能取款
 * 3、不能出现超取现象 -> 线程同步问题
 * <p>
 * 如果两个人取钱不同呢？ （初始化时传入参数）
 */
public class ThreadExercise03 {
    public static void main(String[] args) {
        Thread05 man1 = new Thread05(400);
        Thread05 man2 = new Thread05(800);

        man1.setName("张三");
        man2.setName("李四");

        man1.start();
        man2.start();
    }
}

class Thread05 extends Thread {
    private static int price = 10000;
    private static Object obj = new Object();
    private int get = 1000;

    public Thread05() {
    }

    public Thread05(int get) {
        this.get = get;
    }

    public void getMoney() {
        //这里的 obj 对象是一个非公平锁
        synchronized (obj) { ///此时 this 不是一个对象
            if (price < get) {
                return;
            }
            price -= get;
            System.out.println(currentThread().getName() + " 取出 " + get + " 还剩 " + price);
        }
    }

    @Override
    public void run() {
        while (price > 0) {
            getMoney();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("线程 " + currentThread().getName() + " 结束...");
    }
}
