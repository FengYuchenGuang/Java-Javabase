package studay.Thread_;

/**
 * @author hxz
 * 多线程
 * main 线程启动两个子线程
 */
public class Thread03 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.start();//启动第 1 个线程
        thread2.start();//启动第 2 个线程
        //...
    }
}

class T1 implements Runnable {
    int count = 0;
    @Override
    public void run() {
        while (true) {
            //每隔 1 秒输出 “hello,world”,输出 10 次
            System.out.println("hello,world " + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count == 10) {
                break;
            }
        }
    }
}

class T2 implements Runnable {
    int count = 0;
    @Override
    public void run() {
        //每隔 1 秒输出 “hi”,输出 5 次
        while (true) {
            System.out.println("hi " + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count == 5) {
                break;
            }
        }
    }
}

