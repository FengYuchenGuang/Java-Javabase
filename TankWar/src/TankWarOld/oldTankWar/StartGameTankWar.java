package TankWarOld.oldTankWar;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;


public class StartGameTankWar extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    //private Image photo = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/TankWarOld.Images/背景.jpg"));

    /*
     *双缓存解决屏幕闪烁问题
     */
    //定义双缓存图片
    Image offscreenImage = null;


    //定义窗体的长宽
    static public int widthframe = 1000, heightframe = 600;

    //指针图片
    Image start_select = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/TankWarOld/Images/tank2.jpg"));

    //指针初始坐标
    int selectX = 250;
    int selectY = 160;

    //游戏状态： 0 游戏未开始 1 游戏开始 2 游戏暂停 3 游戏结束
    int game_flag = 0;

    //游戏模式： 0 游戏未开始 1 单人模式 2 双人模式
    int game_secelt = 0; //图表显示界面
    int enter = 0;     //游戏模式确定


    /*
     * 定义玩家1与玩家2
     */
    Player1 Player1 = new Player1("/TankWarOld/Player1/tank1_up.gif", 100, 500, this, "/TankWarOld/Player1/tank1_up.gif",
            "/TankWarOld/Player1/tank1_down.gif", "/TankWarOld/Player1/tank1_right.gif", "/TankWarOld/Player1/tank1_left.gif");

    Player2 Player2 = new Player2("/TankWarOld/Player2/tank2_up.gif", 850, 500, this, "/TankWarOld/Player2/tank2_up.gif",
            "/TankWarOld/Player2/tank2_down.gif", "/TankWarOld/Player2/tank2_right.gif", "/TankWarOld/Player2/tank2_left.gif");

    /*
     * 坦克1与坦克2发射的子弹列表
     */
    ArrayList<Bullets1> bulletsList = new ArrayList<Bullets1>();
    //我方子弹击中后的消除列表
    ArrayList<Bullets1> removeList = new ArrayList<Bullets1>();
    //	//敌方坦克子弹列表
//	ArrayList<EnemyBullrts> enemyBullrtsList = new ArrayList<EnemyBullrts>();
    //添加玩家列表
    ArrayList<Tank> playerList = new ArrayList<Tank>();

    //添加一个围墙列表
    ArrayList<Wall> wallList = new ArrayList<Wall>();
    //创建敌方坦克的列表
    ArrayList<EnemyTank> EnemyTankList = new ArrayList<EnemyTank>();
    //添加一个基地列表
    ArrayList<Base> baseList = new ArrayList<Base>();
    //添加一个爆炸列表
    ArrayList<Boom> boomList = new ArrayList<Boom>();

    /*
     * 定义敌方坦克的变量
     */
    //坦克从大到小分三种
    EnemyTank EnemyTank1 = new EnemyTank("/TankWarOld/otherTanks/tank3_up.png", 500, 110, this, "/TankWarOld/otherTanks/tank3_up.png",
            "/TankWarOld/otherTanks/tank3_down.png", "/TankWarOld/otherTanks/tank3_left.png", "/TankWarOld/otherTanks/tank3_right.png", 58, 58);

    EnemyTank EnemyTank2 = new EnemyTank("/TankWarOld/otherTanks/tank2_up.gif", 400, 110, this, "/TankWarOld/otherTanks/tank2_up.gif",
            "/TankWarOld/otherTanks/tank2_down.gif", "/TankWarOld/otherTanks/tank2_left.gif", "/TankWarOld/otherTanks/tank2_right.gif", 35, 35);

    EnemyTank EnemyTank3 = new EnemyTank("/TankWarOld/otherTanks/tank1_up.png", 600, 110, this, "/TankWarOld/otherTanks/tank1_up.png",
            "/TankWarOld/otherTanks/tank1_down.png", "/TankWarOld/otherTanks/tank1_left.png", "/TankWarOld/otherTanks/tank1_right.png", 34, 34);


    /*
     * 控制敌方坦克的速度
     */
    //重绘次数
    int count = 0;
    //控制敌人数量
    int EnemyCount = 1;
    int bornTank = 0;

    //获得比赛胜利或失败
    static boolean Win = false;
    static boolean Defeat = false;
    static boolean Base = true;


    //窗口启动方法
    public void windowsStart() {
        //给窗体加一个标题
        setTitle("坦克大战     by:hxz 2021/9/18");

        //窗体初始大小
        setSize(widthframe, heightframe);

        //使屏幕居中
        setLocationRelativeTo(null);

        //窗口关闭时程序随之关闭
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //将窗体设置为不可调节大小
        setResizable(false);

        //默认情况下这个窗体是隐藏的，必须要将窗体显现出来
        setVisible(true);

        //给窗口添加键盘监视器
        this.addKeyListener(new StartGameTankWar.KeyMonitor());


        //重绘
        while (true) {

//			//当敌方坦克数量为零且生成坦克数至少为4时，游戏才胜利（即至少击败5辆坦克才能获胜）
//			if(EnemyCount == 0 && bornTank >= 4) {
//				Win= true;
//			}else {
//				Win= false;
//			}

            //当敌方坦克数量为零时，游戏胜利
            if (EnemyCount == 0) {
                Win = true;
            } else {
                Win = false;
            }

            //画布每重绘100次就添加一辆敌方坦克并且敌方坦克数量不能大于10
            if (count % 100 == 1 && count != 1 && EnemyCount < 10 && !Win && !Defeat) {
                //随机生成敌方坦克位置
                Random random = new Random();

                int rnum = random.nextInt(950);

                //将敌方坦克添加进敌方坦克列表中
                AddEnemyTank(rnum, 80);

                //计算敌方坦克增加数量
                bornTank++;


            }
            repaint();
            try {
                Thread.sleep(50);

            } catch (Exception e) {
                e.printStackTrace();

            }

        }

    }

    /*
     * 给面板上色
     */
    public void paint(Graphics g) {
        //这一句是调用父类的 paint方法
        //会先画白布，再去画缓存布，导致画面闪烁
//		super.paint(g);
        //System.out.println(bulletsList.size());
        //System.out.println(EnemyTankList.size());
        //创建和窗口一样大小的图片
        if (offscreenImage == null) {
            offscreenImage = this.createImage(widthframe, heightframe);

        }

        //获取该图片的画笔
        Graphics gImage = offscreenImage.getGraphics();

        /*
         * 绘制纯色背景
         */
        //设置画笔颜色
        gImage.setColor(Color.gray);

        //绘制实心矩形
        gImage.fillRect(0, 0, widthframe, heightframe);

        //images.img_backgrund.paintIcon(this, gImage, 0,0);

        /*
         * 给窗口页启动添加文字
         */
        //改变画笔颜色
        gImage.setColor(Color.blue);

        //设置字体样式：三种效果：字体样式，加粗效果，字体大小
        gImage.setFont(new Font("仿宋", Font.BOLD, 50));

        //写入的文字
        if (enter == 0) {
            gImage.drawString("选择游戏模式", 290, 200);
            gImage.drawString("单人模式", 330, 300);
            gImage.drawString("双人模式", 330, 400);

            //绘制指针
            gImage.drawImage(start_select, selectX, selectY, null);
            //images.img_secelt.paintIcon(this, gImage, selectX,selectY);
        } else if (enter == 1 || enter == 2) {
            //重新计数敌方坦克数量
            EnemyCount = EnemyTankList.size();
            /*
             * 指示游戏进入什么模式
             */
//			gImage.drawString("游戏开始",330,200);
//			if(enter == 1) {
//				gImage.drawString("单人模式",330,300);
//				
//			}else if(enter == 2) {
//				gImage.drawString("双人模式",330,300);
//				
//				
//				/*
//				 * 因为用到了玩家列表，所以可以不用
//				 */
//				//在双人模式中将玩家2坦克绘制出来
//				//TankWarOld.Player2.paintSelf(gImage);
//				
//			}

            //绘制围墙元素
            for (Wall walls : wallList) {
                walls.paintSelf(gImage);


            }

            //绘制围墙元素
            for (Base base : baseList) {
                base.paintSelf(gImage);


            }

            //画布重绘一次
            count++;

            //将玩家列表中的坦克绘制出来
            for (Tank tank : playerList) {
                tank.paintSelf(gImage);

            }

            //如果基地被打爆，游戏失败
            if (baseList.size() == 0) {
                Defeat = true;
            }

            //如果玩家全被打死，游戏失败
            if (playerList.size() == 0) {
                Defeat = true;
            }


            //绘制敌方坦克
//			EnemyTank1.paintSelf(gImage);
//			EnemyTank2.paintSelf(gImage);
//			EnemyTank3.paintSelf(gImage);

            //循环坦克列表,绘制敌方坦克
            for (EnemyTank enemyTank : EnemyTankList) {
                enemyTank.paintSelf(gImage);


            }

            //循环玩家子弹列表，绘制子弹
            for (Bullets1 bullets1 : bulletsList) {
                bullets1.paintSelf(gImage);

            }

            //绘制爆炸列表
            for (Boom boom : boomList) {
                boom.paintSelf(gImage);

            }

            bulletsList.removeAll(removeList);

            //循环敌方坦克子弹列表，绘制子弹
//			for(EnemyBullrts enemyBullrts : enemyBullrtsList) {
//				enemyBullrts.paintSelf(gImage);
//				
//			}

            /*
             * 游戏结算界面
             */
            if (Win) {
                gImage.drawString("游戏胜利!!!", 330, 200);
            } else if (Defeat) {
                gImage.drawString("游戏失败!!!", 330, 200);
            }


        }

        /*
         * 将缓存区绘制好的图形一次性绘制到窗体中
         */
        g.drawImage(offscreenImage, 0, 0, this);
    }

    /*
     * 添加键盘监听
     */
    class KeyMonitor extends KeyAdapter {
        //按下键盘
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);

            //获取按下的按键值
            int KeyCode = e.getKeyCode();
            //获取按下的按键
//			char KeyChar = e.getKeyChar();
            //返回键值
//			System.out.println(KeyCode);
//			System.out.println(KeyChar);

            //如果还在模式选择界面
            if (enter == 0) {

                switch (KeyCode) {
                    case KeyEvent.VK_UP:
                        game_secelt -= 1;
                        if (game_secelt < 0) game_secelt = 2;
                        if (game_secelt == 0) {
                            selectX = 240;
                            selectY = 165;
                        } else if (game_secelt == 1) {
                            selectX = 290;
                            selectY = 265;
                        } else if (game_secelt == 2) {
                            selectX = 290;
                            selectY = 365;
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        game_secelt += 1;
                        if (game_secelt > 2) game_secelt = 0;
                        if (game_secelt == 0) {
                            selectX = 240;
                            selectY = 165;
                        } else if (game_secelt == 1) {
                            selectX = 290;
                            selectY = 265;
                        } else if (game_secelt == 2) {
                            selectX = 290;
                            selectY = 365;
                        }
                        break;
                    case KeyEvent.VK_W:
                        game_secelt -= 1;
                        if (game_secelt < 0) game_secelt = 2;
                        if (game_secelt == 0) {
                            selectX = 240;
                            selectY = 165;
                        } else if (game_secelt == 1) {
                            selectX = 290;
                            selectY = 265;
                        } else if (game_secelt == 2) {
                            selectX = 290;
                            selectY = 365;
                        }
                        break;
                    case KeyEvent.VK_S:
                        game_secelt += 1;
                        if (game_secelt > 2) game_secelt = 0;
                        if (game_secelt == 0) {
                            selectX = 240;
                            selectY = 165;
                        } else if (game_secelt == 1) {
                            selectX = 290;
                            selectY = 265;
                        } else if (game_secelt == 2) {
                            selectX = 290;
                            selectY = 365;
                        }
                        break;
                    case KeyEvent.VK_ENTER:
                        if (enter != 0) break;
                        enter = game_secelt;
                        AddEnemyTank(450, 80);
                        PaintMap(2);
                        if (enter == 1) {
                            playerList.add(Player1);
                        } else if (enter == 2) {
                            playerList.add(Player1);
                            playerList.add(Player2);
                        }
                        break;
                    default:
                        break;

                }
            }

            //如果在单人模式
            if (enter == 1) {

                switch (KeyCode) {
                    case 27:
                        //退出
                        enter = 0;
                        game_secelt = 0;
                        selectX = 240;
                        selectY = 165;
                        Defeat = false;
                        Win = false;
                        Base = true;
                        count = 0;//重绘次数清零
                        //退出时应该清除坦克
                        Player1.X = 100;
                        Player1.Y = 500;
                        playerList.clear();
                        EnemyTankList.clear();
                        //退出时清除地图
                        wallList.clear();
                        baseList.clear();
                        break;
                    default:
                        if (!Defeat && !Win && Base) {
                            Player1.keyPressed(e);
                        }


                }

            }


            //如果在双人模式
            if (enter == 2) {

                switch (KeyCode) {
                    case 27:
                        //退出
                        enter = 0;
                        game_secelt = 0;
                        selectX = 240;
                        selectY = 165;
                        Defeat = false;
                        Win = false;
                        Base = true;
                        count = 0;//重绘次数清零
                        //退出时应该清楚玩家列表
                        Player1.X = 100;
                        Player1.Y = 500;
                        Player2.X = 850;
                        Player2.Y = 500;
                        playerList.clear();
                        EnemyTankList.clear();
                        //退出时清除地图
                        wallList.clear();
                        baseList.clear();
                        break;
                    default:
                        if (!Defeat && !Win && Base) {
                            Player2.keyPressed(e);
                            Player1.keyPressed(e);
                        }

                }

            }

        }


        //松开键盘
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);

            Player1.keyRelease(e);
            Player2.keyRelease(e);

        }


    }


    public static void main(String[] args) {
        //构建一个窗体
        StartGameTankWar Start_frame = new StartGameTankWar();

        Start_frame.windowsStart();


    }


    /*
     * 生成一个随机坦克
     */
    public void AddEnemyTank(int placeX, int placeY) {

        EnemyTankList.add(new EnemyTank("/TankWarOld/otherTanks/tank3_up.png", placeX, placeY, this,
                "/TankWarOld/otherTanks/tank3_up.png", "/TankWarOld/otherTanks/tank3_down.png",
                "/TankWarOld/otherTanks/tank3_right.png", "/TankWarOld/otherTanks/tank3_left.png", 58, 58));

    }


    /*
     * 绘制地图(Level为关卡数，对应不同地图)
     */
    public void PaintMap(int Level) {

        switch (Level) {
            case 1:
                //添加围墙
                for (int i = 0; i < 20; i++) {
                    wallList.add(new Wall("/TankWarOld/Ground/钢铁.png", 50 * i, 150, this, 2));

                }
                for (int i = 0; i < 4; i++) {
                    wallList.add(new Wall("/TankWarOld/Ground/砖块.png", 300, 200 + i * 50, this, 1));

                }
                for (int i = 0; i < 4; i++) {
                    wallList.add(new Wall("/TankWarOld/Ground/砖块.png", 600, 200 + i * 50, this, 1));

                }

                wallList.add(new Wall("/TankWarOld/Ground/砖块.png", 400, 550, this, 1));
                wallList.add(new Wall("/TankWarOld/Ground/砖块.png", 400, 500, this, 1));
                wallList.add(new Wall("/TankWarOld/Ground/砖块.png", 450, 500, this, 1));
                wallList.add(new Wall("/TankWarOld/Ground/砖块.png", 500, 550, this, 1));
                wallList.add(new Wall("/TankWarOld/Ground/砖块.png", 500, 500, this, 1));

                baseList.add(new Base("/TankWarOld/Ground/基地.png", 450, 550, this, 1));
                break;
            case 2:
                //添加围墙
                for (int i = 0; i < 20; i++) {
                    wallList.add(new Wall("/TankWarOld/Ground/钢铁.png", 50 * i, 150, this, 2));

                }
                for (int i = 0; i < 4; i++) {
                    wallList.add(new Wall("/TankWarOld/Ground/草原.png", 300, 200 + i * 50, this, 1));

                }
                for (int i = 0; i < 4; i++) {
                    wallList.add(new Wall("/TankWarOld/Ground/草原.png", 600, 200 + i * 50, this, 1));

                }

                wallList.add(new Wall("/TankWarOld/Ground/砖块.png", 400, 550, this, 1));
                wallList.add(new Wall("/TankWarOld/Ground/砖块.png", 400, 500, this, 1));
                wallList.add(new Wall("/TankWarOld/Ground/砖块.png", 450, 500, this, 1));
                wallList.add(new Wall("/TankWarOld/Ground/砖块.png", 500, 550, this, 1));
                wallList.add(new Wall("/TankWarOld/Ground/砖块.png", 500, 500, this, 1));

                baseList.add(new Base("/TankWarOld/Ground/基地.png", 450, 550, this, 1));
                break;


        }


    }

}
