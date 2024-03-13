package studay.Thread_.Methods;

/**
 * @author hxz
 * 1��setName  //�����߳����ƣ�ʹ֮��ʹ�õĲ�������ͬ������ʹ��
 * 2��getName  //�����߳�����
 * 3��start  //��ʼ�߳�
 * 4��run  //�����߳� run ���������Ǵ����̣߳�ֻ��һ��������
 * 5��setPriority  //�����߳����ȼ�
 * 6��getPriority  //��ȡ�߳����ȼ�
 * 7��sleep  //����ָ��ʱ��
 * 8��interrupt  //�ж��߳�  ���ǿ���ͨ�������쳣�� break ����ѭ��״̬���Ӷ��������л����������̵߳�ִ�С�
 */
public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {
        T01 t01 = new T01();

        t01.setName("hxz");
        //�����߳����ȼ�
        t01.setPriority(Thread.MAX_PRIORITY);
        //�������߳�
        t01.start();

        //��ǰ �ж� ���̵߳�����
        for (int i = 0; i < 5; i++) {
            //Thread.currentThread().getName() ��ȡ�߳���
            System.out.println("�߳� " + Thread.currentThread().getName() + " ������..." + i);
            System.out.println("�߳� " + Thread.currentThread().getName() + " �����ȼ�Ϊ��" + t01.getPriority());
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
                //Thread.currentThread().getName() ��ȡ�߳���
                System.out.println("�߳� " + Thread.currentThread().getName() + " ������..." + i);
            }

            //���� 50 ����, ģ��
            try {
                System.out.println("�߳� " + Thread.currentThread().getName() + " ����������...");
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                //���߳�ִ�е�һ�� interrupt ����ʱ���ͻ� catch һ���쳣�����Լ����Լ���ҵ�����
                System.out.println("�߳� " + Thread.currentThread().getName() + " �� interrupt...");
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
