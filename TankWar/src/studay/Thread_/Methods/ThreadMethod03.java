package studay.Thread_.Methods;

/**
 * @author hxz
 * 用户线程与守护线程
 * 将dt设置为守护线程，当所有线程结束后，dt也自动结束
 *
 * 守护线程的使用情况
 * 1、做多线程时，希望有一个线程监控其他线程，或者是去获取其他线程的信息时，可以使用守护线程
 * 2、等
 */
public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread dt = new MyDaemonThread();
        //将dt设置为守护线程，当所有线程结束后，dt也自动结束
        dt.setDaemon(true);
        dt.start();
        for (int i = 1; i <= 10; i++) {
            Thread.sleep(500);
            System.out.println("宝强辛苦工作--------" + i);
        }
    }
}

class MyDaemonThread extends Thread {

    @Override
    public void run() {
        int count = 1;
        for (; ; ) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("马蓉和宋喆快乐聊天，哈哈哈~~~"+count);
            count++;
        }
    }
}
