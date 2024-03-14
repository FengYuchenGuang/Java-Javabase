package studay.Thread_.Synchronised_;


/**
 * @author hxz
 * �߳�ͬ������
 * Synchronised
 *
 * ���Զ� ����顢��������ͬ��
 */
public class synchronized_ {
    public static void main(String[] args) {

        System.out.println("===ʹ��ʵ�ֽӿڷ�ʽ����Ʊ=====");
        //ͨ������Synchronisedͬ��������ֹ����
        SellTicket04 sellTicket04 = new SellTicket04();
        new Thread(sellTicket04).start();//�� 1 ���߳�-����
        new Thread(sellTicket04).start();//�� 2 ���߳�-����
        new Thread(sellTicket04).start();//�� 3 ���߳�-����


    }
}


//ʵ�ֽӿڷ�ʽ
class SellTicket04 implements Runnable {
    private  int ticketNum = 100;//�ö���̹߳��� ticketNum
    boolean loop = true;

        //ͬ����������̬�ģ�����Ϊ��ǰ�౾��
        //�Ϻ����
        //1. public synchronized static void m1() {} ���Ǽ��� SellTicket03.class
        //2. ����ھ�̬�����У�ʵ��һ��ͬ�������.
        /*
            synchronized (SellTicket04.class) {
                System.out.println("m2");
            }
        */

            public synchronized static void m1() {
            }

            public static void m2() {
                synchronized (SellTicket04.class) {
                    System.out.println("m2");
                }
            }

    //�Ϻ�˵��
    //1. public synchronized void sell() {} ����һ��ͬ������
    //2. ��ʱ���� this ����
//    public synchronized void sell(){ //ͬ������, ��ͬһʱ�̣� ֻ����һ���߳���ִ�� sell ����
//        if (ticketNum <= 0) {
//            loop = false;
//            return;
//        }
//
//        System.out.println("���� " + Thread.currentThread().getName() +
//                " �۳�һ��Ʊ" + " ʣ��Ʊ��=" + (--ticketNum));
//    }

    //3. Ҳ�����ڴ������д synchronize ,ͬ�������, ������������ this ����
    public /*synchronized*/ void sell(){ //ͬ������, ��ͬһʱ�̣� ֻ����һ���߳���ִ�� sell ����

        //
        synchronized (this){
            if (ticketNum <= 0) {
                loop = false;
                return;
            }

            System.out.println("���� " + Thread.currentThread().getName() +
                    " �۳�һ��Ʊ" + " ʣ��Ʊ��=" + (--ticketNum));
        }
    }

    @Override
    public void run() {
        while (loop) {
            sell();
            //���� 50 ����, ģ��
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("��Ʊ����...");
    }
}