package studay.Draw_.DrawTank;

import javax.swing.*;

/**
 * @author hxz
 */
public class DrawTank extends JFrame {
    //���� MyPanel
    MyPanel mp = null;

    public static void main(String[] args) {
        DrawTank drawTank = new DrawTank();
    }

    // ������
    public DrawTank() {
        mp = new MyPanel();
        this.add(mp);//�����(������Ϸ�Ļ�ͼ����)

        this.setSize(1000, 750);

        //ʹ��Ļ����
        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

