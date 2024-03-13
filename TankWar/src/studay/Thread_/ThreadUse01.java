package studay.Thread_;


//�Ϻ�˵��
//1. ��һ����̳��� Thread �࣬ ����Ϳ��Ե����߳�ʹ��
//2. ���ǻ���д run ������д���Լ���ҵ�����
//3. run Thread �� ʵ���� Runnable �ӿڵ� run ����
/*
    @Override
    public void run() {
        if (target != null) {
            target.run();
        }
    }
*/
/**
 * @author hxz
 * ��ʾͨ���̳� Thread �ഴ���߳�
 */
public class ThreadUse01 {
    public static void main(String[] args) {
        //���� Cat ���󣬿��Ե����߳�ʹ��
        Cat01 cat = new Cat01();
        //�Ϻ���Դ��
        /*
        (1)
            public synchronized void start() {
                start0();
            }
        (2)
            //start0() �Ǳ��ط������� JVM ����, �ײ��� c/c++ʵ��
            //����ʵ�ֶ��̵߳�Ч���� �� start0(), ������ run
            private native void start0();
        */
        cat.start();//�����߳�-> ���ջ�ִ�� cat �� run ����

        //cat.run();//run ��������һ����ͨ�ķ���, û������������һ���̣߳��ͻ�� run ����ִ����ϣ�������ִ��

        //˵��: �� main �߳�����һ�����߳� Thread-0, ���̲߳�������, �����ִ��
        //��ʱ ���̺߳����߳��ǽ���ִ��..
        System.out.println("���̼߳���ִ�� currentThread = " + Thread.currentThread().getName());//���� main
        for(int i = 0; i < 160; i++) {
            System.out.println("���߳� i=" + i);
            //�����߳�����
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Cat01 extends Thread{
    int times = 0;

    //��дrun������ʵ���Լ���ҵ���߼�
    @Override
    public void run() {
        while (true) {
            //���߳�ÿ�� 1 �롣�ڿ���̨��� ������, ����Сè�䡱
            System.out.println("����, ����Сè��" + (++times) + " �߳���=" + Thread.currentThread().getName());

            //�ø��߳����� 1 �� ctrl+alt+t
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (times == 100) {
                break;//�� times �� 10, �˳� while, ��ʱ�߳�Ҳ���˳�.. }
            }
        }
    }
}
