package studay.Thread_;

/**
 * @author hxz
 * 线程终止的方法
 * 1、正常运行结束
 * 2、使用退出标志退出线程
 * 3、Interrupt 方法结束线程  一般 Interrupt 是中断线程，不是结束
 *   但是可以通过捕获异常后 break 跳出循环状态，从而让我们有机会结束这个线程的执行。
 *   具体 ThreadMethod01.java
 *    3.1 线程处于阻塞状态
 *    3.2 线程未处于阻塞状态
 * 4、stop 方法终止线程（线程不安全）
 */
public class ThreadExit_ {
    public static void main(String[] args) {
        T05 t05 = new T05();
        t05.start();
    }
}

class T05 extends Thread {
    private boolean loop = true;
    int ticketNum = 0;

    @Override
    public void run() {
        while (loop) {
            if (ticketNum > 100) {
                System.out.println("售票结束...");
                this.stop();
            }

            //休眠 50 毫秒, 模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口 T  run...." + ticketNum++);
        }
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
