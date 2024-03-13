package studay.Thread_;

/**
 * @author hxz
 * �߳���ֹ�ķ���
 * 1���������н���
 * 2��ʹ���˳���־�˳��߳�
 * 3��Interrupt ���������߳�  һ�� Interrupt ���ж��̣߳����ǽ���
 *   ���ǿ���ͨ�������쳣�� break ����ѭ��״̬���Ӷ��������л����������̵߳�ִ�С�
 *   ���� ThreadMethod01.java
 *    3.1 �̴߳�������״̬
 *    3.2 �߳�δ��������״̬
 * 4��stop ������ֹ�̣߳��̲߳���ȫ��
 */
public class ThreadExit_ {
    public static void main(String[] args) {
        T05 t05 = new T05();
        t05.start();
    }
}

class T05 extends Thread {
    private boolean loop = true;
    int ticketNum = 0;

    @Override
    public void run() {
        while (loop) {
            if (ticketNum > 100) {
                System.out.println("��Ʊ����...");
                this.stop();
            }

            //���� 50 ����, ģ��
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("���� T  run...." + ticketNum++);
        }
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
