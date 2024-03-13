package studay.Thread_.Methods;

/**
 * @author hxz
 * 1、setName  //设置线程名称，使之与使用的参数名相同，便于使用
 * 2、getName  //返回线程名称
 * 3、start  //开始线程
 * 4、run  //调用线程 run 方法（不是创建线程，只是一个方法）
 * 5、setPriority  //更改线程优先级
 * 6、getPriority  //获取线程优先级
 * 7、sleep  //休眠指定时间
 * 8、interrupt  //中断线程  但是可以通过捕获异常后 break 跳出循环状态，从而让我们有机会结束这个线程的执行。
 */
public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {
        T01 t01 = new T01();

        t01.setName("hxz");
        //设置线程优先级
        t01.setPriority(Thread.MAX_PRIORITY);
        //启动子线程
        t01.start();

        //提前 中断 子线程的休眠
        for (int i = 0; i < 5; i++) {
            //Thread.currentThread().getName() 获取线程名
            System.out.println("线程 " + Thread.currentThread().getName() + " 运行中..." + i);
            System.out.println("线程 " + Thread.currentThread().getName() + " 的优先级为：" + t01.getPriority());
            Thread.sleep(1000);
        }
        t01.interrupt();


    }
}

class T01 extends Thread {
    private boolean loop = true;


    @Override
    public void run() {
        while (loop) {
            for (int i = 0; i < 100; i++) {
                //Thread.currentThread().getName() 获取线程名
                System.out.println("线程 " + Thread.currentThread().getName() + " 运行中..." + i);
            }

            //休眠 50 毫秒, 模拟
            try {
                System.out.println("线程 " + Thread.currentThread().getName() + " 正在休眠中...");
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                //该线程执行到一个 interrupt 方法时，就会 catch 一个异常，可以加入自己的业务代码
                System.out.println("线程 " + Thread.currentThread().getName() + " 被 interrupt...");
//                break;
            }

        }
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
