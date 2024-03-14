package studay.Thread_.Synchronised_;


/**
 * @author hxz
 * 线程同步机制
 * Synchronised
 *
 * 可以对 代码块、方法进行同步
 */
public class synchronized_ {
    public static void main(String[] args) {

        System.out.println("===使用实现接口方式来售票=====");
        //通过加入Synchronised同步锁，防止超卖
        SellTicket04 sellTicket04 = new SellTicket04();
        new Thread(sellTicket04).start();//第 1 个线程-窗口
        new Thread(sellTicket04).start();//第 2 个线程-窗口
        new Thread(sellTicket04).start();//第 3 个线程-窗口


    }
}


//实现接口方式
class SellTicket04 implements Runnable {
    private  int ticketNum = 100;//让多个线程共享 ticketNum
    boolean loop = true;

        //同步方法（静态的）的锁为当前类本身
        //老韩解读
        //1. public synchronized static void m1() {} 锁是加在 SellTicket03.class
        //2. 如果在静态方法中，实现一个同步代码块.
        /*
            synchronized (SellTicket04.class) {
                System.out.println("m2");
            }
        */

            public synchronized static void m1() {
            }

            public static void m2() {
                synchronized (SellTicket04.class) {
                    System.out.println("m2");
                }
            }

    //老韩说明
    //1. public synchronized void sell() {} 就是一个同步方法
    //2. 这时锁在 this 对象
//    public synchronized void sell(){ //同步方法, 在同一时刻， 只能有一个线程来执行 sell 方法
//        if (ticketNum <= 0) {
//            loop = false;
//            return;
//        }
//
//        System.out.println("窗口 " + Thread.currentThread().getName() +
//                " 售出一张票" + " 剩余票数=" + (--ticketNum));
//    }

    //3. 也可以在代码块上写 synchronize ,同步代码块, 互斥锁还是在 this 对象
    public /*synchronized*/ void sell(){ //同步方法, 在同一时刻， 只能有一个线程来执行 sell 方法

        //
        synchronized (this){
            if (ticketNum <= 0) {
                loop = false;
                return;
            }

            System.out.println("窗口 " + Thread.currentThread().getName() +
                    " 售出一张票" + " 剩余票数=" + (--ticketNum));
        }
    }

    @Override
    public void run() {
        while (loop) {
            sell();
            //休眠 50 毫秒, 模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("售票结束...");
    }
}