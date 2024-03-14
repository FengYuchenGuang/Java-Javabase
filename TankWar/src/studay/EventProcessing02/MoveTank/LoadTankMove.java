package studay.EventProcessing02.MoveTank;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

/**
 * @author hxz
 */
public class LoadTankMove extends JFrame {
    int widthframe = 1000;
    int heightframe = 600;
    Player1 player1;
    Vector<EnemyTank> enemyTankList = new Vector<EnemyTank>();

    public LoadTankMove() throws HeadlessException {
        player1 = new Player1(500, 400);
        enemyTankList.add( new EnemyTank(200, 200,7));
        enemyTankList.add( new EnemyTank(400, 200,5));
        enemyTankList.add( new EnemyTank(600, 200,3));

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
        this.addKeyListener(new LoadTankMove.KeyMonitor());

        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        repaint();
        while (true) {
            //ÿ50����Ҳ�Զ��ػ�һ�Σ����ڸ��������Զ��ı��ֵ
            repaint();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

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

        player1.PaintSelf(gImage);

        for (EnemyTank enemyTank:enemyTankList) {
            enemyTank.PaintSelf(gImage);
        }

        g.drawImage(offscreenImage, 0, 0, this);
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
}
