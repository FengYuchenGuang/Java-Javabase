package studay.TankWar03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

/**
 * @author hxz
 *
 * ����ӵ��������
 * 1���ӵ����ƶ���������˸����ɫҲ����
 *  �ӵ����ƶ����߳�û������
 *  ��˸��û��ʹ��˫����ͼƬ�õ��� ���滭��
 *  ��ɫҲ���ԣ����񲻺ã��ǶԵ�
 *
 * 2�����ϣ�������ӵ����ƶ�
 *  ���ϣ�������ӵ����ƶ����ƶ��ӵ���switch���û��break
 *
 * 3����ʼ������ɺ�����ӵ��������ȴʱ��
 *  ���������ӵ�ʱ������һ���߳��������� �����ʶ�� �������ӵ���
 *  ������ȴ�̣߳���ʶ���� false����ȴ������Ϊ true
 *
 * 4���޸Ĳ����ػ�Ĳ��������������Ϊһ���̣߳�ÿ��50ms�ػ�
 *
 * 5�������ӵ��Ĺ����жϣ���������
 *   5.1 �ҷ��ӵ��������з�̹�˺��ӵ�δ��ʧ�����ҳ����쳣
 *      ԭ��û����������ӵ�
 *   5.2 �з��ӵ�ײ����δ��ʧ
 *      ԭ��û����������ӵ�
 *   �������ӵ��߳��У�ÿ�ε��ü�ⷽ��������һ������ֵ���ж��Ƿ��������ӵ�
 *
 * 6����ӱ�ըЧ��
 *   ���ͼƬ��Ŀ¼��
 *   1��./�ǵ�ǰĿ¼
 *   2��.../�Ǹ���Ŀ¼
 *   3��/�Ǹ�Ŀ¼
 *
 * 7����һ���ӵ��򵽺�û�б�ը���������ȴﵽ�Լ������Ǵﵽ���ˣ�
 *    �ڱ�ը��Ч������ɾ������ÿ�λᱨ�쳣
 *    7.1 ��һ�α�ը��Ч����ʱ��ͼƬû�м�����ɣ���Ϊ��������̫�죬��û����ʾ
 *        ��˽�ͼƬ����Ϊ��̬���������ʱ�� ���ã�����ͼƬ����
 *        ��ʼ��ʱ�����һ��boom����ΪͼƬ����
 *
 *    7.2 �ڱ��� Vector �б�ʱ��ɾ������ᵼ�±�仯���Ӷ������쳣�������ѡ�����ʱ��
 *        ����ը���boom��ӽ���ʱ���Ƴ��б������������Ƴ�
 *
 * 8�����̹�˲���Խ��
 *   8.1 ���̹���ƶ����߽���޷����ƶ�
 */

class TankWar03 extends JFrame implements Runnable{
    public int widthframe = 1000;
    public int heightframe = 600;
    Player1 player1;

    Vector<EnemyTank> enemyTankList = new Vector<>();
    //�ӵ��б�
    Vector<Shot> shots =  new Vector<>();
    //��ը�б�
    Vector<Boom> booms =  new Vector<>();


    public TankWar03() throws HeadlessException {
        //���ر�ըͼƬ
        Boom.BoomStart();
        booms.add(new Boom(0,0,this));
        player1 = new Player1(500, 400,this);
        enemyTankList.add( new EnemyTank(200, 530,7,this));
        enemyTankList.add( new EnemyTank(400, 520,5,this));
        enemyTankList.add( new EnemyTank(600, 520,3,this));

    }

    /*
     *˫��������Ļ��˸����
     */
    //����˫����ͼƬ
    Image offscreenImage = null;

    public void start() {
        this.setSize(widthframe, heightframe);

        //���� JFrame ������Լ��������¼�, �����Լ�������巢���ļ����¼�
        //�¼�Դ�������ǰ�ť�����ڡ� ���������ļ����¼�
        this.addKeyListener(new KeyMonitor());

        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //�����̣߳��Զ��ػ�
        new Thread(this).start();


    }

    @Override
    public void paint(Graphics g) {
//        super.paint(g);

        //�����ʹ���һ����С��ͼƬ
        if (offscreenImage == null) {
            offscreenImage = this.createImage(widthframe, heightframe);

        }

        //��ȡ��ͼƬ�Ļ���
        Graphics gImage = offscreenImage.getGraphics();

        //���û�����ɫ
        gImage.setColor(Color.gray);

        //����ʵ�ľ���
        gImage.fillRect(0, 0, widthframe, heightframe);

        //�������
        if (player1 != null){
            player1.PaintSelf(gImage);
        }


        //���Ƶ���
        for (EnemyTank enemyTank:enemyTankList) {
            enemyTank.PaintSelf(gImage);
        }

        //��������ӵ�
        for (Shot shot:shots){
            shot.PaintSelf(gImage);
        }

        //���Ʊ�ը��Ч
        if (!booms.isEmpty()){
            Vector<Boom> removeBooms = new Vector<>();
            for (Boom boom: this.booms){
                if (boom.isAlive){
                    boom.PaintSelf(gImage);
                }else {
                    removeBooms.add(boom);
                }

            }
            //ɾ���Ѿ���ը���boom
            booms.removeAll(removeBooms);
        }


        g.drawImage(offscreenImage, 0, 0, this);
    }

    class newPlayer extends Thread{
        private TankWar03 MyPanel;

        public newPlayer(TankWar03 myPanel) {
            MyPanel = myPanel;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (!player1.isAlive){
                player1 = new Player1(500, 400,MyPanel);
            }
        }
    }


    @Override
    public void run() {
        while (true) {
            //�ж�����Ƿ�����
            if (!player1.isAlive){
                //����һ�����̣߳������߳��й�һ������������ player1
                new newPlayer(this).start();
            }


            //ÿ50����Ҳ�Զ��ػ�һ�Σ����ڸ��������Զ��ı��ֵ
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println(shots.isEmpty());
//            System.out.println(booms.isEmpty() + "����Ϊ��"+booms.size());
        }
    }

    class KeyMonitor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            player1.keyPress(e);
            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            player1.keyRelease(e);
            repaint();
        }
    }

    public static void main(String[] args) {
        TankWar03 tankWar03 = new TankWar03();
        tankWar03.start();
    }
}

