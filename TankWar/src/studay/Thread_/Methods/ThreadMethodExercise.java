package studay.Thread_.Methods;

/**
 * @author hxz
 * ��ϰ��
 * 1�����߳�ÿ��1s����� hi��һ��ʮ��
 * 2������� hi 5 ʱ���������̣߳�Ҫ��ʵ�� Runnable����ÿ��1s��� hello��
 * �ȸ��߳����ʮ�� hello ���˳�
 * 3�����̼߳������ hi ��ֱ�����߳��˳�
 */
public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {
        SayHello sayHello = new SayHello();
        Thread thread = new Thread(sayHello);

        for (int i = 0; i < 10; i++) {
            System.out.println("hi " + i);
            Thread.sleep(1000);
            if (i == 4) {//�����
                thread.start();
                thread.join();
            }
        }
        System.out.println("���߳̽���...");
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
        System.out.println("���߳̽���...");
    }
}
