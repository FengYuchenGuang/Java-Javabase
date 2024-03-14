package studay.Thread_;

/**
 * @author hxz
 * �̵߳���������
 * �̵߳ļ���״̬
 * 1��NEW   ��δ�������̴߳��ڴ�״̬
 * 2��RUUNNABLE   ��java�������ִ�е��̴߳��ڴ�״̬
 * 3��BLOCKED    �������ȴ��������������̴߳��ڴ�״̬
 * 4��WAITING  //�ȴ�����֪���ȴ�ʱ�䣩
 * ���ڵȴ���һ���߳�ִ�д����������̴߳��ڴ�״̬  join
 * 5��TIMED_WAITING  //��ʱ�ȴ���֪���ȴ�ʱ�䣩  sleep
 * ���ڵȴ���һ���߳�ִ�ж��� �ﵽ ָ���ȴ�ʱ����̴߳��ڴ�״̬
 * 6��TERMINATED    ���˳����̴߳��ڴ�״̬
 */
public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        T06 t06 = new T06();
        t06.setName("t06");
        System.out.println("�߳� " + Thread.currentThread().getName() + " ״̬ " + Thread.currentThread().getState());
        System.out.println("�߳� " + t06.getName() + " ״̬ " + t06.getState());

        t06.start();

        while (Thread.State.TERMINATED != t06.getState() ){
            System.out.println("�߳� " + t06.getName() + " ״̬ " + t06.getState());
            Thread.sleep(100);
        }

        System.out.println("�߳� " + t06.getName() + " ״̬ " + t06.getState());
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
            //Thread.currentThread().getName() ��ȡ�߳���
            System.out.println("�߳� " + Thread.currentThread().getName() + " " + i);
            if (i == 9) {
                ///�߳�����
                Thread.yield();
            }
        }
    }
}