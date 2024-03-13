package studay.Thread_;


//老韩说明
//1. 当一个类继承了 Thread 类， 该类就可以当做线程使用
//2. 我们会重写 run 方法，写上自己的业务代码
//3. run Thread 类 实现了 Runnable 接口的 run 方法
/*
    @Override
    public void run() {
        if (target != null) {
            target.run();
        }
    }
*/
/**
 * @author hxz
 * 演示通过继承 Thread 类创建线程
 */
public class ThreadUse01 {
    public static void main(String[] args) {
        //创建 Cat 对象，可以当做线程使用
        Cat01 cat = new Cat01();
        //老韩读源码
        /*
        (1)
            public synchronized void start() {
                start0();
            }
        (2)
            //start0() 是本地方法，是 JVM 调用, 底层是 c/c++实现
            //真正实现多线程的效果， 是 start0(), 而不是 run
            private native void start0();
        */
        cat.start();//启动线程-> 最终会执行 cat 的 run 方法

        //cat.run();//run 方法就是一个普通的方法, 没有真正的启动一个线程，就会把 run 方法执行完毕，才向下执行

        //说明: 当 main 线程启动一个子线程 Thread-0, 主线程不会阻塞, 会继续执行
        //这时 主线程和子线程是交替执行..
        System.out.println("主线程继续执行 currentThread = " + Thread.currentThread().getName());//名字 main
        for(int i = 0; i < 160; i++) {
            System.out.println("主线程 i=" + i);
            //让主线程休眠
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Cat01 extends Thread{
    int times = 0;

    //重写run方法，实现自己的业务逻辑
    @Override
    public void run() {
        while (true) {
            //该线程每隔 1 秒。在控制台输出 “喵喵, 我是小猫咪”
            System.out.println("喵喵, 我是小猫咪" + (++times) + " 线程名=" + Thread.currentThread().getName());

            //让该线程休眠 1 秒 ctrl+alt+t
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (times == 100) {
                break;//当 times 到 10, 退出 while, 这时线程也就退出.. }
            }
        }
    }
}
