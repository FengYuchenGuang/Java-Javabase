package studay.Draw_01.DrawTank;

import javax.swing.*;
import java.awt.*;

/**
 * @author hxz
 *  ̹�˴�ս�Ļ�ͼ����
 */
public class MyPanel extends JPanel {
    //�����ҵ�̹��
    Play01 play1 = null;
    //����з���̹��
    Play01 enemy1 = null;
    Play01 enemy2 = null;
    Play01 enemy3 = null;

    public MyPanel() {
        play1 = new Play01(100, 100);//��ʼ���Լ�̹��
        enemy1= new Play01(400, 400);//��ʼ���з�̹��
        enemy2= new Play01(500, 400);//��ʼ���з�̹��
        enemy3= new Play01(600, 400);//��ʼ���з�̹��
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//�����Σ�Ĭ�Ϻ�ɫ
        //����̹��-��װ����
        drawTank(play1.getX(), play1.getY(), g, 0, 0);

        drawTank(enemy1.getX(), enemy1.getY(), g, 1, 1);
        drawTank(enemy2.getX(), enemy2.getY(), g, 2, 1);
        drawTank(enemy3.getX(), enemy3.getY(), g, 3, 1);

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
            case 1: //��ʾ����
                g.fill3DRect(x, y, 60, 10, false);//����̹���������
                g.fill3DRect(x, y+30, 60, 10, false);//����̹���ұ�����
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//����̹�˸���
                g.fillOval(x + 20, y + 10, 20, 20);//����Բ�θ���
                g.drawLine(x + 30, y + 20, x+60, y+20);//������Ͳ
                break;
            case 2: //��ʾ����
                g.fill3DRect(x, y, 10, 60, false);//����̹���������
                g.fill3DRect(x + 30, y, 10, 60, false);//����̹���ұ�����
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//����̹�˸���
                g.fillOval(x + 10, y + 20, 20, 20);//����Բ�θ���
                g.drawLine(x + 20, y + 30, x + 20, y+60);//������Ͳ
                break;
            case 3: //��ʾ����
                g.fill3DRect(x, y, 60, 10, false);//����̹���������
                g.fill3DRect(x, y+30, 60, 10, false);//����̹���ұ�����
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//����̹�˸���
                g.fillOval(x + 20, y + 10, 20, 20);//����Բ�θ���
                g.drawLine(x + 30, y + 20, x, y+20);//������Ͳ
                break;
            default:
                System.out.println("��ʱû�д���");
        }
    }
}

