package studay.TankWar03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

/**
 * @author hxz
 *
 * 添加子弹后的问题
 * 1、子弹不移动，并且闪烁、颜色也不对
 *  子弹不移动：线程没有启动
 *  闪烁：没有使用双缓存图片得到的 缓存画布
 *  颜色也不对：眼神不好，是对的
 *
 * 2、向上，向左的子弹不移动
 *  向上，向左的子弹不移动：移动子弹的switch语句没有break
 *
 * 3、初始步骤完成后，添加子弹发射的冷却时间
 *  玩家中添加子弹时，设置一个线程里面重置 发射标识符 ，发射子弹后，
 *  进入冷却线程，标识符置 false，冷却后，重置为 true
 *
 * 4、修改不断重绘的操作，将面板设置为一个线程，每隔50ms重绘
 *
 * 5、进行子弹的攻击判断，出现问题
 *   5.1 我方子弹攻击到敌方坦克后，子弹未消失，并且出现异常
 *      原因：没有消除这颗子弹
 *   5.2 敌方子弹撞击后未消失
 *      原因：没有消除这颗子弹
 *   最终在子弹线程中，每次调用检测方法，返回一个布尔值，判断是否消除该子弹
 *
 * 6、添加爆炸效果
 *   添加图片的目录：
 *   1、./是当前目录
 *   2、.../是父级目录
 *   3、/是根目录
 *
 * 7、第一颗子弹打到后，没有爆炸（不论是先达到自己，还是达到敌人）
 *    在爆炸特效结束后删除自身每次会报异常
 *    7.1 第一次爆炸特效绘制时，图片没有加载完成，因为程序运行太快，而没有显示
 *        因此将图片设置为静态，程序加载时就 调用，进行图片加载
 *        初始化时，添加一个boom，作为图片加载
 *
 *    7.2 在遍历 Vector 列表时，删除自身会导致表变化，从而出现异常，因此我选择遍历时，
 *        将爆炸完的boom添加进临时的移除列表，遍历结束后移除
 *
 * 8、添加坦克不能越界
 *   8.1 玩家坦克移动到边界后无法在移动
 */

class TankWar03 extends JFrame implements Runnable{
    public int widthframe = 1000;
    public int heightframe = 600;
    Player1 player1;

    Vector<EnemyTank> enemyTankList = new Vector<>();
    //子弹列表
    Vector<Shot> shots =  new Vector<>();
    //爆炸列表
    Vector<Boom> booms =  new Vector<>();


    public TankWar03() throws HeadlessException {
        //加载爆炸图片
        Boom.BoomStart();
        booms.add(new Boom(0,0,this));
        player1 = new Player1(500, 400,this);
        enemyTankList.add( new EnemyTank(200, 530,7,this));
        enemyTankList.add( new EnemyTank(400, 520,5,this));
        enemyTankList.add( new EnemyTank(600, 520,3,this));

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

        //启动线程，自动重绘
        new Thread(this).start();


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

        //绘制玩家
        if (player1 != null){
            player1.PaintSelf(gImage);
        }


        //绘制敌人
        for (EnemyTank enemyTank:enemyTankList) {
            enemyTank.PaintSelf(gImage);
        }

        //绘制玩家子弹
        for (Shot shot:shots){
            shot.PaintSelf(gImage);
        }

        //绘制爆炸特效
        if (!booms.isEmpty()){
            Vector<Boom> removeBooms = new Vector<>();
            for (Boom boom: this.booms){
                if (boom.isAlive){
                    boom.PaintSelf(gImage);
                }else {
                    removeBooms.add(boom);
                }

            }
            //删除已经爆炸完的boom
            booms.removeAll(removeBooms);
        }


        g.drawImage(offscreenImage, 0, 0, this);
    }

    class newPlayer extends Thread{
        private TankWar03 MyPanel;

        public newPlayer(TankWar03 myPanel) {
            MyPanel = myPanel;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (!player1.isAlive){
                player1 = new Player1(500, 400,MyPanel);
            }
        }
    }


    @Override
    public void run() {
        while (true) {
            //判断玩家是否阵亡
            if (!player1.isAlive){
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

    public static void main(String[] args) {
        TankWar03 tankWar03 = new TankWar03();
        tankWar03.start();
    }
}

