package studay.Thread_;

/**
 * @author hxz
 * ͨ��ʵ�ֽӿ� Runnable �������߳�
 */
public class ThreadUse02 {
    public static void main(String[] args) {
        Dog02 dog = new Dog02();
//        dog.start(); //���ﲻ�ܵ��� start
        //���� Thread ���󣬰� dog ����(ʵ�� Runnable),���� Thread
        Thread thread = new Thread(dog);
        thread.start();

        Tiger tiger = new Tiger();//ʵ���� Runnable
        ThreadProxy threadProxy = new ThreadProxy(tiger);
        threadProxy.start();

    }
}

class Animal {
}

class Tiger extends Animal implements Runnable {
    int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("�ϻ��໽�...." + " �߳���= " + Thread.currentThread().getName());

            //���� 1 ��
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 13) {
                break;
            }
        }
    }
}

//�̴߳����� , ģ����һ������� Thread ��
// ����������� Ϊ��Ҫ new Thread(dog); ��dog����
// ���������̻߳������߳�
class ThreadProxy implements Runnable {//����԰� Proxy �൱�� ThreadProxy
    private Runnable target = null;//���ԣ������� Runnable

    @Override
    public void run() {
        if (target != null) {
            target.run();//��̬�󶨣��������� Tiger��
        }
    }

    public ThreadProxy(Runnable target) {
        this.target = target;
    }


    public void start() {
        start0();//�������ʱ����ʵ�ֶ��̷߳���
    }

    public void start0() {
        run();
    }
}

class Dog02 implements Runnable { //ͨ��ʵ�� Runnable �ӿڣ������߳�
    int count = 0;

    @Override
    public void run() { //��ͨ����
        while (true) {
            System.out.println("С��������..hi " + (++count) + " " + Thread.currentThread().getName());
            //���� 1 ��
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 10) {
                break;
            }
        }
    }
}
