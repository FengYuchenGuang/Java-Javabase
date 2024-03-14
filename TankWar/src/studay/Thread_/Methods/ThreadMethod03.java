package studay.Thread_.Methods;

/**
 * @author hxz
 * �û��߳����ػ��߳�
 * ��dt����Ϊ�ػ��̣߳��������߳̽�����dtҲ�Զ�����
 *
 * �ػ��̵߳�ʹ�����
 * 1�������߳�ʱ��ϣ����һ���̼߳�������̣߳�������ȥ��ȡ�����̵߳���Ϣʱ������ʹ���ػ��߳�
 * 2����
 */
public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread dt = new MyDaemonThread();
        //��dt����Ϊ�ػ��̣߳��������߳̽�����dtҲ�Զ�����
        dt.setDaemon(true);
        dt.start();
        for (int i = 1; i <= 10; i++) {
            Thread.sleep(500);
            System.out.println("��ǿ���๤��--------" + i);
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
            System.out.println("���غ��Ά��������죬������~~~"+count);
            count++;
        }
    }
}
