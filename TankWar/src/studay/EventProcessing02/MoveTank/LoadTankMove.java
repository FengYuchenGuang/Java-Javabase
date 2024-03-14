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
     *双缓存解决屏幕闪烁问题
     */
    //定义双缓存图片
    Image offscreenImage = null;

    public void start() {
        this.setSize(widthframe, heightframe);

        //窗口 JFrame 对象可以监听键盘事件, 即可以监听到面板发生的键盘事件
        //事件源，可以是按钮，窗口。 监听发生的键盘事件
        this.addKeyListener(new LoadTankMove.KeyMonitor());

        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        repaint();
        while (true) {
            //每50毫秒也自动重绘一次，用于更新其他自动改变的值
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

        //创建和窗口一样大小的图片
        if (offscreenImage == null) {
            offscreenImage = this.createImage(widthframe, heightframe);

        }

        //获取该图片的画笔
        Graphics gImage = offscreenImage.getGraphics();

        //设置画笔颜色
        gImage.setColor(Color.gray);

        //绘制实心矩形
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
