package studay.Draw_;

import javax.swing.*;
import java.awt.*;

/**
 * @author hxz
 * �����Ļ�ͼ����
 *
 * ��������������������½�
 * ��������ͼ������ͼƬ���ǰ������Ͻ�
 */
//JFrame ��Ӧ����,����������һ������
public class DrawCircle extends JFrame{
    //����һ�����
    private MyPanel01  mp = null;

    public static void main(String[] args) {
        new DrawCircle();
        System.out.println("�˳�����~");
    }

    public DrawCircle() {//������
        //��ʼ�����
        mp = new MyPanel01();

        //�������뵽����(����)
        this.add(mp);

        //���ô��ڵĴ�С
        this.setSize(1000, 600);

        //ʹ��Ļ����
        this.setLocationRelativeTo(null);

        //����������Ϊ���ɵ��ڴ�С
//        setResizable(false);

        //��������ڵ�С����������ȫ�˳�.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //������ʾ��Ĭ���ǲ���ʾ
        this.setVisible(true);
    }

}

//����һ����� Panel���̳� JPanel�࣬��ͼ�Σ����ڻ����ϻ�
class MyPanel01 extends JPanel {
    //˵��:
    //1. MyPanel �������һ������
    //2. Graphics g �� g ����һ֧����
    //3. Graphics �ṩ�˺ܶ��ͼ�ķ���
    //Graphics g
    @Override
    public void paint(Graphics g) {
        super.paint(g);//���ø�����ɳ�ʼ��

        System.out.println("paint ������������~");
        //����һ��Բ��.
//        g.drawOval(10, 10, 100, 100);

        //��ʾ���Ʋ�ͬ��ͼ��..
        //��ֱ�� drawLine(int x1,int y1,int x2,int y2)
        //g.drawLine(10, 10, 100, 100);

        //�����α߿� drawRect(int x, int y, int width, int height)
        //g.drawRect(10, 10, 100, 100);

        //����Բ�߿� drawOval(int x, int y, int width, int height)

        //������ fillRect(int x, int y, int width, int height)

        //���û��ʵ���ɫ
//        g.setColor(Color.blue);
//        g.fillRect(10, 10, 100, 100);

        //�����Բ fillOval(int x, int y, int width, int height)
//        g.setColor(Color.red);
//        g.fillOval(10, 10, 100, 100);

        //��ͼƬ drawImage(Image img, int x, int y, ..)
        //1. ��ȡͼƬ��Դ, /bg.png ��ʾ�ڸ���Ŀ�ĸ�Ŀ¼ȥ��ȡ bg.png ͼƬ��Դ
        // out ����
        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/pic/block/����.png"));
        g.drawImage(image, 900, 500, 50, 50, this);

        //���ַ��� drawString(String str, int x, int y)//д��
        //������������ɫ������
        g.setColor(Color.red);
        g.setFont(new Font("����", Font.BOLD, 50));

        //�������õ� 100�� 100�� �� "�������"  ====���½�======
        g.drawString("�������", 100, 100);

        //���û��ʵ����� setFont(Font font)

        //���û��ʵ���ɫ setColor(Color c)
    }
}
