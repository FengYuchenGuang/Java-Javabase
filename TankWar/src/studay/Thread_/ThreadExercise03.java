package studay.Thread_;

import java.util.Scanner;

/**
 * @author hxz
 * 1���������û��ֱ��ͬһ������ȡǮ���ܶ10,000��
 * 2��ÿ��ȡ1,000 ������ʱ������ȡ��
 * 3�����ܳ��ֳ�ȡ���� -> �߳�ͬ������
 * <p>
 * ���������ȡǮ��ͬ�أ� ����ʼ��ʱ���������
 */
public class ThreadExercise03 {
    public static void main(String[] args) {
        Thread05 man1 = new Thread05(400);
        Thread05 man2 = new Thread05(800);

        man1.setName("����");
        man2.setName("����");

        man1.start();
        man2.start();
    }
}

class Thread05 extends Thread {
    private static int price = 10000;
    private static Object obj = new Object();
    private int get = 1000;

    public Thread05() {
    }

    public Thread05(int get) {
        this.get = get;
    }

    public void getMoney() {
        //����� obj ������һ���ǹ�ƽ��
        synchronized (obj) { ///��ʱ this ����һ������
            if (price < get) {
                return;
            }
            price -= get;
            System.out.println(currentThread().getName() + " ȡ�� " + get + " ��ʣ " + price);
        }
    }

    @Override
    public void run() {
        while (price > 0) {
            getMoney();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("�߳� " + currentThread().getName() + " ����...");
    }
}
