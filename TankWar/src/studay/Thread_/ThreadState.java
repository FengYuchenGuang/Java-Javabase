package studay.Thread_;

/**
 * @author hxz
 * 线程的生命周期
 * 线程的几种状态
 * 1、NEW   尚未启动的线程处于此状态
 * 2、RUUNNABLE   在java虚拟机中执行的线程处于此状态
 * 3、BLOCKED    被阻塞等待监视器锁定的线程处于此状态
 * 4、WAITING  //等待（不知道等待时间）
 * 正在等待另一个线程执行待定动作的线程处于此状态  join
 * 5、TIMED_WAITING  //超时等待（知道等待时间）  sleep
 * 正在等待另一个线程执行动作 达到 指定等待时间的线程处于此状态
 * 6、TERMINATED    已退出的线程处于此状态
 */
public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        T06 t06 = new T06();
        t06.setName("t06");
        System.out.println("线程 " + Thread.currentThread().getName() + " 状态 " + Thread.currentThread().getState());
        System.out.println("线程 " + t06.getName() + " 状态 " + t06.getState());

        t06.start();

        while (Thread.State.TERMINATED != t06.getState() ){
            System.out.println("线程 " + t06.getName() + " 状态 " + t06.getState());
            Thread.sleep(100);
        }

        System.out.println("线程 " + t06.getName() + " 状态 " + t06.getState());
    }
}


class T06 extends Thread {
    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Thread.currentThread().getName() 获取线程名
            System.out.println("线程 " + Thread.currentThread().getName() + " " + i);
            if (i == 9) {
                ///线程礼让
                Thread.yield();
            }
        }
    }
}