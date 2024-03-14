package studay.Draw_01.DrawTank;

/**
 * @author hxz
 * //ÿ500���� ִ��һ�� ActionListener ��ķ���
 *             Timer timer = new Timer(1000, new ActionListener() {
 *                 @Override
 *                 public void actionPerformed(ActionEvent e) {
 *                     moveEnemyTank();
 *                     repaint();
 *                 }
 *             });
 *             timer.start();
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class EnemyTankGa extends JPanel implements KeyListener {
    private int playerTankX = 200; // ���̹��λ��
    private int playerTankY = 200;
    private int playerTankDirection = 0; // ���̹�˳�ʼ���� (0:��, 1:��, 2:��, 3:��)
    private final int TANK_SPEED = 5; // ̹���ƶ��ٶ�

    private EnemyTank enemyTank;

    public EnemyTankGa() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.WHITE);
        setFocusable(true);
        addKeyListener(this);

        // ��������̹��
        enemyTank = new EnemyTank();
        enemyTank.startMoving();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawPlayerTank(g);
        enemyTank.drawEnemyTank(g);
    }

    private void drawPlayerTank(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        // ���ݵ�ǰ�������̹��
        switch (playerTankDirection) {
            case 0: // ����
                g2d.fillRect(playerTankX, playerTankY, 30, 50);
                g2d.fillRect(playerTankX + 10, playerTankY - 10, 10, 10);
                break;
            case 1: // ����
                g2d.fillRect(playerTankX, playerTankY, 50, 30);
                g2d.fillRect(playerTankX + 50, playerTankY + 10, 10, 10);
                break;
            case 2: // ����
                g2d.fillRect(playerTankX, playerTankY, 30, 50);
                g2d.fillRect(playerTankX + 10, playerTankY + 50, 10, 10);
                break;
            case 3: // ����
                g2d.fillRect(playerTankX, playerTankY, 50, 30);
                g2d.fillRect(playerTankX - 10, playerTankY + 10, 10, 10);
                break;
        }
    }

    private void movePlayerTank() {
        switch (playerTankDirection) {
            case 0:
                playerTankY -= TANK_SPEED;
                break;
            case 1:
                playerTankX += TANK_SPEED;
                break;
            case 2:
                playerTankY += TANK_SPEED;
                break;
            case 3:
                playerTankX -= TANK_SPEED;
                break;
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_UP:
                playerTankDirection = 0;
                movePlayerTank();
                break;
            case KeyEvent.VK_RIGHT:
                playerTankDirection = 1;
                movePlayerTank();
                break;
            case KeyEvent.VK_DOWN:
                playerTankDirection = 2;
                movePlayerTank();
                break;
            case KeyEvent.VK_LEFT:
                playerTankDirection = 3;
                movePlayerTank();
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    // ����̹����
    class EnemyTank {
        private int enemyTankX = 50; // ��ʼλ��
        private int enemyTankY = 50;
        private int enemyTankDirection; // �������

        public void startMoving() {
            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    moveEnemyTank();
                    repaint();
                }
            });
            timer.start();
        }

        public void drawEnemyTank(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.GREEN);
            g2d.fillRect(enemyTankX, enemyTankY, 30, 50);
        }

        private void moveEnemyTank() {
            Random random = new Random();
            enemyTankDirection = random.nextInt(4); // �������
            switch (enemyTankDirection) {
                case 0:
                    enemyTankY -= TANK_SPEED;
                    break;
                case 1:
                    enemyTankX += TANK_SPEED;
                    break;
                case 2:
                    enemyTankY += TANK_SPEED;
                    break;
                case 3:
                    enemyTankX -= TANK_SPEED;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Tank Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            EnemyTankGa tankGame = new EnemyTankGa();
            frame.getContentPane().add(tankGame);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
