package studay.Draw_.DrawTank;

import javax.swing.*;
import java.awt.*;

/**
 * @author hxz
 *  ̹�˴�ս�Ļ�ͼ����
 */
public class MyPanel extends JPanel {
    //�����ҵ�̹��
    Play01 hero = null;
    public MyPanel() {
        hero = new Play01(100, 100);//��ʼ���Լ�̹��
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//�����Σ�Ĭ�Ϻ�ɫ
        //����̹��-��װ����
        drawTank(hero.getX(), hero.getY(), g, 0, 0);
    }

    //��д����������̹��
    /**
     * @param x ̹�˵����Ͻ� x ����
     * @param y ̹�˵����Ͻ� y ����
     * @param g ����
     * @param direct ̹�˷����������ң�
     * @param type ̹������
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        //���ݲ�ͬ����̹�ˣ����ò�ͬ��ɫ
        switch (type) {
            case 0: //���ǵ�̹��
                g.setColor(Color.cyan);
                break;
            case 1: //���˵�̹��
                g.setColor(Color.yellow);
                break;
        }

        //����̹�˷���������̹��
        switch (direct) {
            case 0: //��ʾ����
                g.fill3DRect(x, y, 10, 60, false);//����̹���������
                g.fill3DRect(x + 30, y, 10, 60, false);//����̹���ұ�����
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//����̹�˸���
                g.fillOval(x + 10, y + 20, 20, 20);//����Բ�θ���
                g.drawLine(x + 20, y + 30, x + 20, y);//������Ͳ
                break;
            default:
                System.out.println("��ʱû�д���");
        }
    }
}

