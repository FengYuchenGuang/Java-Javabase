package studay.Thread_.Methods;

/**
 * @author hxz
 * 1��yield �߳�����
 * 2��join   �̲߳��
 */
public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        T02 t02 = new T02();
        t02.setName("hxz");
        t02.start();

        for (int i = 0; i < 20; i++) {
            Thread.sleep(1000);
            //Thread.currentThread().getName() ��ȡ�߳���
            System.out.println("�߳� " + Thread.currentThread().getName() + " ������..." + i);
            if (i==4){
                System.out.println("С���Ѿ�����5�Σ����������...");
                //2��join   �̲߳��
                t02.join();
                System.out.println("���������...");

            }
        }
    }
}

class T02 extends Thread {
    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Thread.currentThread().getName() ��ȡ�߳���
            System.out.println("�߳� " + Thread.currentThread().getName() + " ������..." + i);
        }



    }

}