package studay.Thread_;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Scanner;

/**
 * @author hxz
 * 1���� main���������������߳�
 * 2���߳�һ ѭ�������ӡ100���ڵ�����
 * 3�����̶߳��Ӽ��̶�ȡ��"Q"ָ������߳�һ
 *
 * ����start()����������ж��̵߳�״̬�Ƿ�ΪNEW�������߳�ֻ������һ�Ρ�
 *
 * ˼·�������߳�һ����Ϊ�ػ��߳�
 */
public class ThreadExercise02 {
    public static void main(String[] args) throws InterruptedException {
        Thread01 thread01 = new Thread01();
        Thread02 thread02 = new Thread02();

        thread01.setName("thread01");
        thread02.setName("thread02");

        thread01.start();
        thread02.start();

        //����һ ��һ����д�Ŀ��Ʒ���
        //ͨ����� thread02 ״̬ʵ�ֶ������̵߳Ŀ���
        while (true){
            if (thread02.getState() == Thread.State.TERMINATED){
                thread01.setLoop(false);
                break;
            }
        }

        //������ �� thread04 ���� thread03 ����
        System.out.println("�����򷽷�һ������...");
        Thread.sleep(1000);


        Thread01 thread03 = new Thread01();
        Thread04 thread04 = new Thread04(thread03);

        thread03.setName("thread03");
        thread04.setName("thread04");

        thread03.start();
        thread04.start();

        System.out.println("���������...");
    }
}

class Thread01 extends Thread {
    private int randomInt = 0;
    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            randomInt = (new Random()).nextInt(101);
            System.out.println("�����" + randomInt);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
        System.out.println("�߳� "+currentThread().getName()+" ����...");
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}

class Thread02 extends Thread{
    Scanner myScanner = new Scanner(System.in);

    @Override
    public void run() {
        while (true){
            char next = myScanner.next().toUpperCase().charAt(0);

            if (next == 'Q'){
                break;
            }
            System.out.println("�������롣����");
        }
        System.out.println("�߳� "+currentThread().getName()+" ����...");

    }
}

class Thread04 extends Thread{
    Scanner myScanner = new Scanner(System.in);
    private Thread01 A;

    public Thread04() {
    }

    public Thread04(Thread01 a) {
        A = a;
    }

    @Override
    public void run() {
        while (true){
            char next = myScanner.next().toUpperCase().charAt(0);

            if (next == 'Q'){
                A.setLoop(false);
                break;
            }
            System.out.println("�������롣����");
        }
        System.out.println("�߳� "+currentThread().getName()+" ����...");

    }
}
