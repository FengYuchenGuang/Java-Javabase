package studay.EventProcessing.MoveTank;

import TankWarOld.oldTankWar.StartGameTankWar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author hxz
 */
public class LoadTankMove extends JFrame {
    Player1 player1 = new Player1(500, 400);
    EnemyTank enemyTank = new EnemyTank(200, 200,7);
    int widthframe = 1000;
    int heightframe = 600;

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
                Thread.sleep(50);
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
        enemyTank.PaintSelf(gImage);

        g.drawImage(offscreenImage, 0, 0, this);
    }

    class KeyMonitor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            player1.keyPress(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            player1.keyRelease(e);
        }
    }
}
