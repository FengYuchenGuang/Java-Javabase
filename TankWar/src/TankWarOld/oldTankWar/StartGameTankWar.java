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
    //private Image photo = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/TankWarOld.Images/����.jpg"));

    /*
     *˫��������Ļ��˸����
     */
    //����˫����ͼƬ
    Image offscreenImage = null;


    //���崰��ĳ���
    static public int widthframe = 1000, heightframe = 600;

    //ָ��ͼƬ
    Image start_select = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/TankWarOld/Images/tank2.jpg"));

    //ָ���ʼ����
    int selectX = 250;
    int selectY = 160;

    //��Ϸ״̬�� 0 ��Ϸδ��ʼ 1 ��Ϸ��ʼ 2 ��Ϸ��ͣ 3 ��Ϸ����
    int game_flag = 0;

    //��Ϸģʽ�� 0 ��Ϸδ��ʼ 1 ����ģʽ 2 ˫��ģʽ
    int game_secelt = 0; //ͼ����ʾ����
    int enter = 0;     //��Ϸģʽȷ��


    /*
     * �������1�����2
     */
    Player1 Player1 = new Player1("/TankWarOld/Player1/tank1_up.gif", 100, 500, this, "/TankWarOld/Player1/tank1_up.gif",
            "/TankWarOld/Player1/tank1_down.gif", "/TankWarOld/Player1/tank1_right.gif", "/TankWarOld/Player1/tank1_left.gif");

    Player2 Player2 = new Player2("/TankWarOld/Player2/tank2_up.gif", 850, 500, this, "/TankWarOld/Player2/tank2_up.gif",
            "/TankWarOld/Player2/tank2_down.gif", "/TankWarOld/Player2/tank2_right.gif", "/TankWarOld/Player2/tank2_left.gif");

    /*
     * ̹��1��̹��2������ӵ��б�
     */
    ArrayList<Bullets1> bulletsList = new ArrayList<Bullets1>();
    //�ҷ��ӵ����к�������б�
    ArrayList<Bullets1> removeList = new ArrayList<Bullets1>();
    //	//�з�̹���ӵ��б�
//	ArrayList<EnemyBullrts> enemyBullrtsList = new ArrayList<EnemyBullrts>();
    //�������б�
    ArrayList<Tank> playerList = new ArrayList<Tank>();

    //���һ��Χǽ�б�
    ArrayList<Wall> wallList = new ArrayList<Wall>();
    //�����з�̹�˵��б�
    ArrayList<EnemyTank> EnemyTankList = new ArrayList<EnemyTank>();
    //���һ�������б�
    ArrayList<Base> baseList = new ArrayList<Base>();
    //���һ����ը�б�
    ArrayList<Boom> boomList = new ArrayList<Boom>();

    /*
     * ����з�̹�˵ı���
     */
    //̹�˴Ӵ�С������
    EnemyTank EnemyTank1 = new EnemyTank("/TankWarOld/otherTanks/tank3_up.png", 500, 110, this, "/TankWarOld/otherTanks/tank3_up.png",
            "/TankWarOld/otherTanks/tank3_down.png", "/TankWarOld/otherTanks/tank3_left.png", "/TankWarOld/otherTanks/tank3_right.png", 58, 58);

    EnemyTank EnemyTank2 = new EnemyTank("/TankWarOld/otherTanks/tank2_up.gif", 400, 110, this, "/TankWarOld/otherTanks/tank2_up.gif",
            "/TankWarOld/otherTanks/tank2_down.gif", "/TankWarOld/otherTanks/tank2_left.gif", "/TankWarOld/otherTanks/tank2_right.gif", 35, 35);

    EnemyTank EnemyTank3 = new EnemyTank("/TankWarOld/otherTanks/tank1_up.png", 600, 110, this, "/TankWarOld/otherTanks/tank1_up.png",
            "/TankWarOld/otherTanks/tank1_down.png", "/TankWarOld/otherTanks/tank1_left.png", "/TankWarOld/otherTanks/tank1_right.png", 34, 34);


    /*
     * ���Ƶз�̹�˵��ٶ�
     */
    //�ػ����
    int count = 0;
    //���Ƶ�������
    int EnemyCount = 1;
    int bornTank = 0;

    //��ñ���ʤ����ʧ��
    static boolean Win = false;
    static boolean Defeat = false;
    static boolean Base = true;


    //������������
    public void windowsStart() {
        //�������һ������
        setTitle("̹�˴�ս     by:hxz 2021/9/18");

        //�����ʼ��С
        setSize(widthframe, heightframe);

        //ʹ��Ļ����
        setLocationRelativeTo(null);

        //���ڹر�ʱ������֮�ر�
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //����������Ϊ���ɵ��ڴ�С
        setResizable(false);

        //Ĭ�������������������صģ�����Ҫ���������ֳ���
        setVisible(true);

        //��������Ӽ��̼�����
        this.addKeyListener(new StartGameTankWar.KeyMonitor());


        //�ػ�
        while (true) {

//			//���з�̹������Ϊ��������̹��������Ϊ4ʱ����Ϸ��ʤ���������ٻ���5��̹�˲��ܻ�ʤ��
//			if(EnemyCount == 0 && bornTank >= 4) {
//				Win= true;
//			}else {
//				Win= false;
//			}

            //���з�̹������Ϊ��ʱ����Ϸʤ��
            if (EnemyCount == 0) {
                Win = true;
            } else {
                Win = false;
            }

            //����ÿ�ػ�100�ξ����һ���з�̹�˲��ҵз�̹���������ܴ���10
            if (count % 100 == 1 && count != 1 && EnemyCount < 10 && !Win && !Defeat) {
                //������ɵз�̹��λ��
                Random random = new Random();

                int rnum = random.nextInt(950);

                //���з�̹����ӽ��з�̹���б���
                AddEnemyTank(rnum, 80);

                //����з�̹����������
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
     * �������ɫ
     */
    public void paint(Graphics g) {
        //��һ���ǵ��ø���� paint����
        //���Ȼ��ײ�����ȥ�����沼�����»�����˸
//		super.paint(g);
        //System.out.println(bulletsList.size());
        //System.out.println(EnemyTankList.size());
        //�����ʹ���һ����С��ͼƬ
        if (offscreenImage == null) {
            offscreenImage = this.createImage(widthframe, heightframe);

        }

        //��ȡ��ͼƬ�Ļ���
        Graphics gImage = offscreenImage.getGraphics();

        /*
         * ���ƴ�ɫ����
         */
        //���û�����ɫ
        gImage.setColor(Color.gray);

        //����ʵ�ľ���
        gImage.fillRect(0, 0, widthframe, heightframe);

        //images.img_backgrund.paintIcon(this, gImage, 0,0);

        /*
         * ������ҳ�����������
         */
        //�ı仭����ɫ
        gImage.setColor(Color.blue);

        //����������ʽ������Ч����������ʽ���Ӵ�Ч���������С
        gImage.setFont(new Font("����", Font.BOLD, 50));

        //д�������
        if (enter == 0) {
            gImage.drawString("ѡ����Ϸģʽ", 290, 200);
            gImage.drawString("����ģʽ", 330, 300);
            gImage.drawString("˫��ģʽ", 330, 400);

            //����ָ��
            gImage.drawImage(start_select, selectX, selectY, null);
            //images.img_secelt.paintIcon(this, gImage, selectX,selectY);
        } else if (enter == 1 || enter == 2) {
            //���¼����з�̹������
            EnemyCount = EnemyTankList.size();
            /*
             * ָʾ��Ϸ����ʲôģʽ
             */
//			gImage.drawString("��Ϸ��ʼ",330,200);
//			if(enter == 1) {
//				gImage.drawString("����ģʽ",330,300);
//				
//			}else if(enter == 2) {
//				gImage.drawString("˫��ģʽ",330,300);
//				
//				
//				/*
//				 * ��Ϊ�õ�������б����Կ��Բ���
//				 */
//				//��˫��ģʽ�н����2̹�˻��Ƴ���
//				//TankWarOld.Player2.paintSelf(gImage);
//				
//			}

            //����ΧǽԪ��
            for (Wall walls : wallList) {
                walls.paintSelf(gImage);


            }

            //����ΧǽԪ��
            for (Base base : baseList) {
                base.paintSelf(gImage);


            }

            //�����ػ�һ��
            count++;

            //������б��е�̹�˻��Ƴ���
            for (Tank tank : playerList) {
                tank.paintSelf(gImage);

            }

            //������ر��򱬣���Ϸʧ��
            if (baseList.size() == 0) {
                Defeat = true;
            }

            //������ȫ����������Ϸʧ��
            if (playerList.size() == 0) {
                Defeat = true;
            }


            //���Ƶз�̹��
//			EnemyTank1.paintSelf(gImage);
//			EnemyTank2.paintSelf(gImage);
//			EnemyTank3.paintSelf(gImage);

            //ѭ��̹���б�,���Ƶз�̹��
            for (EnemyTank enemyTank : EnemyTankList) {
                enemyTank.paintSelf(gImage);


            }

            //ѭ������ӵ��б������ӵ�
            for (Bullets1 bullets1 : bulletsList) {
                bullets1.paintSelf(gImage);

            }

            //���Ʊ�ը�б�
            for (Boom boom : boomList) {
                boom.paintSelf(gImage);

            }

            bulletsList.removeAll(removeList);

            //ѭ���з�̹���ӵ��б������ӵ�
//			for(EnemyBullrts enemyBullrts : enemyBullrtsList) {
//				enemyBullrts.paintSelf(gImage);
//				
//			}

            /*
             * ��Ϸ�������
             */
            if (Win) {
                gImage.drawString("��Ϸʤ��!!!", 330, 200);
            } else if (Defeat) {
                gImage.drawString("��Ϸʧ��!!!", 330, 200);
            }


        }

        /*
         * �����������ƺõ�ͼ��һ���Ի��Ƶ�������
         */
        g.drawImage(offscreenImage, 0, 0, this);
    }

    /*
     * ��Ӽ��̼���
     */
    class KeyMonitor extends KeyAdapter {
        //���¼���
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);

            //��ȡ���µİ���ֵ
            int KeyCode = e.getKeyCode();
            //��ȡ���µİ���
//			char KeyChar = e.getKeyChar();
            //���ؼ�ֵ
//			System.out.println(KeyCode);
//			System.out.println(KeyChar);

            //�������ģʽѡ�����
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

            //����ڵ���ģʽ
            if (enter == 1) {

                switch (KeyCode) {
                    case 27:
                        //�˳�
                        enter = 0;
                        game_secelt = 0;
                        selectX = 240;
                        selectY = 165;
                        Defeat = false;
                        Win = false;
                        Base = true;
                        count = 0;//�ػ��������
                        //�˳�ʱӦ�����̹��
                        Player1.X = 100;
                        Player1.Y = 500;
                        playerList.clear();
                        EnemyTankList.clear();
                        //�˳�ʱ�����ͼ
                        wallList.clear();
                        baseList.clear();
                        break;
                    default:
                        if (!Defeat && !Win && Base) {
                            Player1.keyPressed(e);
                        }


                }

            }


            //�����˫��ģʽ
            if (enter == 2) {

                switch (KeyCode) {
                    case 27:
                        //�˳�
                        enter = 0;
                        game_secelt = 0;
                        selectX = 240;
                        selectY = 165;
                        Defeat = false;
                        Win = false;
                        Base = true;
                        count = 0;//�ػ��������
                        //�˳�ʱӦ���������б�
                        Player1.X = 100;
                        Player1.Y = 500;
                        Player2.X = 850;
                        Player2.Y = 500;
                        playerList.clear();
                        EnemyTankList.clear();
                        //�˳�ʱ�����ͼ
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


        //�ɿ�����
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);

            Player1.keyRelease(e);
            Player2.keyRelease(e);

        }


    }


    public static void main(String[] args) {
        //����һ������
        StartGameTankWar Start_frame = new StartGameTankWar();

        Start_frame.windowsStart();


    }


    /*
     * ����һ�����̹��
     */
    public void AddEnemyTank(int placeX, int placeY) {

        EnemyTankList.add(new EnemyTank("/TankWarOld/otherTanks/tank3_up.png", placeX, placeY, this,
                "/TankWarOld/otherTanks/tank3_up.png", "/TankWarOld/otherTanks/tank3_down.png",
                "/TankWarOld/otherTanks/tank3_right.png", "/TankWarOld/otherTanks/tank3_left.png", 58, 58));

    }


    /*
     * ���Ƶ�ͼ(LevelΪ�ؿ�������Ӧ��ͬ��ͼ)
     */
    public void PaintMap(int Level) {

        switch (Level) {
            case 1:
                //���Χǽ
                for (int i = 0; i < 20; i++) {
                    wallList.add(new Wall("/TankWarOld/Ground/����.png", 50 * i, 150, this, 2));

                }
                for (int i = 0; i < 4; i++) {
                    wallList.add(new Wall("/TankWarOld/Ground/ש��.png", 300, 200 + i * 50, this, 1));

                }
                for (int i = 0; i < 4; i++) {
                    wallList.add(new Wall("/TankWarOld/Ground/ש��.png", 600, 200 + i * 50, this, 1));

                }

                wallList.add(new Wall("/TankWarOld/Ground/ש��.png", 400, 550, this, 1));
                wallList.add(new Wall("/TankWarOld/Ground/ש��.png", 400, 500, this, 1));
                wallList.add(new Wall("/TankWarOld/Ground/ש��.png", 450, 500, this, 1));
                wallList.add(new Wall("/TankWarOld/Ground/ש��.png", 500, 550, this, 1));
                wallList.add(new Wall("/TankWarOld/Ground/ש��.png", 500, 500, this, 1));

                baseList.add(new Base("/TankWarOld/Ground/����.png", 450, 550, this, 1));
                break;
            case 2:
                //���Χǽ
                for (int i = 0; i < 20; i++) {
                    wallList.add(new Wall("/TankWarOld/Ground/����.png", 50 * i, 150, this, 2));

                }
                for (int i = 0; i < 4; i++) {
                    wallList.add(new Wall("/TankWarOld/Ground/��ԭ.png", 300, 200 + i * 50, this, 1));

                }
                for (int i = 0; i < 4; i++) {
                    wallList.add(new Wall("/TankWarOld/Ground/��ԭ.png", 600, 200 + i * 50, this, 1));

                }

                wallList.add(new Wall("/TankWarOld/Ground/ש��.png", 400, 550, this, 1));
                wallList.add(new Wall("/TankWarOld/Ground/ש��.png", 400, 500, this, 1));
                wallList.add(new Wall("/TankWarOld/Ground/ש��.png", 450, 500, this, 1));
                wallList.add(new Wall("/TankWarOld/Ground/ש��.png", 500, 550, this, 1));
                wallList.add(new Wall("/TankWarOld/Ground/ש��.png", 500, 500, this, 1));

                baseList.add(new Base("/TankWarOld/Ground/����.png", 450, 550, this, 1));
                break;


        }


    }

}
