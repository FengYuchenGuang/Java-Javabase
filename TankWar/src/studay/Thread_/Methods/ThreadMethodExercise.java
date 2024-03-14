package studay.Thread_.Methods;

/**
 * @author hxz
 * 练习题
 * 1、主线程每隔1s，输出 hi，一共十次
 * 2、当输出 hi 5 时，启动子线程（要求实现 Runnable），每隔1s输出 hello，
 * 等该线程输出十次 hello 后，退出
 * 3、主线程继续输出 hi ，直到主线程退出
 */
public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {
        SayHello sayHello = new SayHello();
        Thread thread = new Thread(sayHello);

        for (int i = 0; i < 10; i++) {
            System.out.println("hi " + i);
            Thread.sleep(1000);
            if (i == 4) {//第五次
                thread.start();
                thread.join();
            }
        }
        System.out.println("主线程结束...");
    }
}

class SayHello implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hello! " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("子线程结束...");
    }
}
