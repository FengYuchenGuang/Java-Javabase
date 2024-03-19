package studay.TankWar04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Vector;

/**
 * @author hxz
 * <p>
 * ======不管怎样先把 坦克方向先调整======
 * 1、添加防止坦克重叠代码，出现重叠后无法移动
 * 1.1 要将下次移动后的位置与其他坦克进行检测，不是当前位置
 * <p>
 * 2、转变方向时，产生重叠，出现无法继续移动问题
 * 2.1 转变方向时也要判断是否会重叠
 * <p>
 * 3、出现无法左右移动 (左右代码判断是否重叠时 取非了)
 * 4、坦克转向时出现重叠
 * 4.1 转向前也要判断是否重叠（对下一次转向后是否重叠进行判断）
 * <p>
 * 5、还是出现了重叠是因为在设置随机方向时直接设置成功了，没有判断是否会重叠
 * <p>
 * <p>
 * 5、玩家死亡后，刷新后马上再次死亡会立刻刷新，
 * <p>
 * <p>
 * ======IO流应用到其中========
 * 6、记录玩家总成绩，存盘退出， 新建一个记录类 Recorder
 * 6.1 子弹超出游戏界面后，还是会在成绩界面显示
 * 原因是没有将子弹边界检测的界面设置为游戏界面
 * <p>
 * <p>
 * 7、记录当时敌人坦克坐标，存盘退出
 *  7.1 依旧在 Recorder 中记录 myRecorder.dat
 * <p>
 * <p>
 * ====
 * 8、玩游戏时，可以选择开新游戏还是继续上局游戏
 */

class TankWar04 extends JFrame implements Runnable {
    public int widthframe = 1300;
    public int GameWidthframe = 1000;
    public int heightframe = 600;
    Player1 player1 = null;
    int enemyNum = 6;
    TankWar04 myJFrame = this;

    Vector<EnemyTank> enemyTankList = new Vector<>();

    //爆炸列表
    Vector<Boom> booms = new Vector<>();


    public TankWar04() throws Exception {
        //加载爆炸图片
        Boom.BoomStart();
        booms.add(new Boom(0, 0, this));
        Recorder.loadRecordInfo(this);
        if (player1 == null){
            player1 = new Player1(500, 400, this);
        }

        if (enemyTankList.isEmpty()){
            for (int i = 0; i < enemyNum; i++) {
                enemyTankList.add(new EnemyTank(100+i*100, 100, 7, this));
            }
        }
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
        this.addKeyListener(new KeyMonitor());

        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //在JFrame中 增加相应关闭窗口的处理
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("游戏已经关闭~~~");
                try {
                    Recorder.writeRecordInfo(myJFrame);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        //启动线程，自动重绘
        new Thread(this).start();


    }

    public void showInfo(Graphics g) {
        g.setColor(Color.BLACK);
        Font font = new Font("宋体", Font.BOLD, 25);
        g.setFont(font);

        g.drawString("您累计击毁敌方坦克：", 1020, 70);
        drawTank(1020, 100, g, Direction.DOWN, TankLabel.EnemyTank);
        drawTank(1020, 200, g, Direction.DOWN, TankLabel.Player);

        //重新设置颜色
        g.setColor(Color.BLACK);
        font = new Font("宋体", Font.BOLD, 50);
        g.setFont(font);
        g.drawString(Recorder.getNum() + "", 1080, 145);
        g.drawString(Recorder.getLife() + "", 1080, 245);
    }

    public void drawTank(int Px, int Py, Graphics g, Direction direct, TankLabel label) {
        //根据不同类型坦克，设置不同颜色
        switch (label) {
            case Player: //我们的坦克
                g.setColor(Color.cyan);
                break;
            case EnemyTank: //敌人的坦克
                g.setColor(Color.yellow);
                break;
        }

        //根据坦克方向，来绘制坦克
        switch (direct) {
            case UP: //表示向上
                g.fill3DRect(Px, Py, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(Px + 30, Py, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(Px + 10, Py + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(Px + 10, Py + 20, 20, 20);//画出圆形盖子
                g.drawLine(Px + 20, Py + 30, Px + 20, Py);//画出炮筒
                break;
            case RIGHT: //表示向右
                g.fill3DRect(Px, Py, 60, 10, false);//画出坦克左边轮子
                g.fill3DRect(Px, Py + 30, 60, 10, false);//画出坦克右边轮子
                g.fill3DRect(Px + 10, Py + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(Px + 20, Py + 10, 20, 20);//画出圆形盖子
                g.drawLine(Px + 30, Py + 20, Px + 60, Py + 20);//画出炮筒
                break;
            case DOWN: //表示向下
                g.fill3DRect(Px, Py, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(Px + 30, Py, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(Px + 10, Py + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(Px + 10, Py + 20, 20, 20);//画出圆形盖子
                g.drawLine(Px + 20, Py + 30, Px + 20, Py + 60);//画出炮筒
                break;
            case LEFT: //表示向左
                g.fill3DRect(Px, Py, 60, 10, false);//画出坦克左边轮子
                g.fill3DRect(Px, Py + 30, 60, 10, false);//画出坦克右边轮子
                g.fill3DRect(Px + 10, Py + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(Px + 20, Py + 10, 20, 20);//画出圆形盖子
                g.drawLine(Px + 30, Py + 20, Px, Py + 20);//画出炮筒
                break;
            default:
                System.out.println("暂时没有处理");
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
        //绘制实心矩形
        gImage.setColor(Color.white);
        gImage.fillRect(0, 0, widthframe, heightframe);
        gImage.setColor(Color.gray);
        gImage.fillRect(0, 0, GameWidthframe, heightframe);

        //====6、记录玩家总成绩=====
        showInfo(gImage);


        //绘制玩家
        if (player1.isAlive) {
            player1.PaintSelf(gImage);
        }


        //绘制敌人、并绘制敌方坦克子弹
        for (EnemyTank enemyTank : enemyTankList) {
            enemyTank.PaintSelf(gImage);
            for (Shot shot : enemyTank.shots) {
                shot.PaintSelf(gImage);
            }

        }

        //绘制玩家子弹
        for (Shot shot : player1.shots) {
            shot.PaintSelf(gImage);
        }


        //绘制爆炸特效
        if (!booms.isEmpty()) {
            Vector<Boom> removeBooms = new Vector<>();
            for (Boom boom : this.booms) {
                if (boom.isAlive) {
                    boom.PaintSelf(gImage);
                } else {
                    removeBooms.add(boom);
                }

            }
            //删除已经爆炸完的boom
            booms.removeAll(removeBooms);
        }


        g.drawImage(offscreenImage, 0, 0, this);
    }

    class newPlayer extends Thread {
        private TankWar04 MyPanel;

        public newPlayer(TankWar04 myPanel) {
            MyPanel = myPanel;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (!player1.isAlive) {
                player1 = new Player1(500, 400, MyPanel);
            }
        }
    }


    @Override
    public void run() {
        while (true) {
            //判断玩家是否阵亡
            if (!player1.isAlive) {
                //定义一个新线程，在新线程中过一秒后再重新添加 player1
                new newPlayer(this).start();
            }


            //每50毫秒也自动重绘一次，用于更新其他自动改变的值
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println(shots.isEmpty());
//            System.out.println(booms.isEmpty() + "数量为："+booms.size());
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

    public static void main(String[] args) throws Exception {
        TankWar04 tankWar04 = new TankWar04();
        tankWar04.start();
        //游戏结束后
//        Recorder.writeRecordInfo();
    }
}

