package studay.Draw_01.DrawTank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * @author hxz
 */
public class TankGame extends JPanel implements KeyListener {
    private int tankX = 200; // ��ʼ̹��λ��
    private int tankY = 200;
    private int tankDirection = 0; // ̹�˳�ʼ���� (0:��, 1:��, 2:��, 3:��)
    private final int TANK_SPEED = 5; // ̹���ƶ��ٶ�

    public TankGame() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.WHITE);
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTank(g);
    }

    private void drawTank(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        // ���ݵ�ǰ�������̹��
        switch (tankDirection) {
            case 0: // ����
                g2d.fillRect(tankX, tankY, 30, 50);
                g2d.fillRect(tankX + 10, tankY - 10, 10, 10);
                break;
            case 1: // ����
                g2d.fillRect(tankX, tankY, 50, 30);
                g2d.fillRect(tankX + 50, tankY + 10, 10, 10);
                break;
            case 2: // ����
                g2d.fillRect(tankX, tankY, 30, 50);
                g2d.fillRect(tankX + 10, tankY + 50, 10, 10);
                break;
            case 3: // ����
                g2d.fillRect(tankX, tankY, 50, 30);
                g2d.fillRect(tankX - 10, tankY + 10, 10, 10);
                break;
        }
    }

    private void moveTank() {
        switch (tankDirection) {
            case 0:
                tankY -= TANK_SPEED;
                break;
            case 1:
                tankX += TANK_SPEED;
                break;
            case 2:
                tankY += TANK_SPEED;
                break;
            case 3:
                tankX -= TANK_SPEED;
                break;
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_UP:
                tankDirection = 0;
                moveTank();
                break;
            case KeyEvent.VK_RIGHT:
                tankDirection = 1;
                moveTank();
                break;
            case KeyEvent.VK_DOWN:
                tankDirection = 2;
                moveTank();
                break;
            case KeyEvent.VK_LEFT:
                tankDirection = 3;
                moveTank();
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Tank Game  byChatGPT");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            TankGame tankGame = new TankGame();
            //���ֶ�����
//            frame.getContentPane().add(tankGame);
            frame.add(tankGame);

            //���ô��ڴ�С
            //1�����ڴ�С�ᱻ����Ϊ��Ѵ�С��Ҳ����prefrredSize
//            frame.pack();
            //2���ֶ�����
            frame.setSize(1000,600);

            //���ھ���
            frame.setLocationRelativeTo(null);

            //���ӻ�
            frame.setVisible(true);
        });
    }
}