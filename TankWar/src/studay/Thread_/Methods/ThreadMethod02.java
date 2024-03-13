package studay.Thread_.Methods;

/**
 * @author hxz
 * 1、yield 线程礼让
 * 2、join   线程插队
 */
public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        T02 t02 = new T02();
        t02.setName("hxz");
        t02.start();

        for (int i = 0; i < 20; i++) {
            Thread.sleep(1000);
            //Thread.currentThread().getName() 获取线程名
            System.out.println("线程 " + Thread.currentThread().getName() + " 运行中..." + i);
            if (i==4){
                System.out.println("小弟已经运行5次，大哥先运行...");
                //2、join   线程插队
                t02.join();
                System.out.println("大哥运行完...");

            }
        }
    }
}

class T02 extends Thread {
    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Thread.currentThread().getName() 获取线程名
            System.out.println("线程 " + Thread.currentThread().getName() + " 运行中..." + i);
        }



    }

}