package studay.TankWar03;

import java.awt.*;

/**
 * @author hxz
 */
public class Shot extends Bullrt implements Runnable {
    private boolean loop; //�߳���ֹ��

    public Shot(int x, int y, Direction direction, int speed, int type, TankWar03 panel) {
        super(x, y, direction, speed, type, panel);
        adjustPosition();
        new Thread(this).start();
    }

    //�����ӵ���ʼλ��
    private void adjustPosition() {
        if (direction == Direction.UP) {
            x += 15;
            y -= 10;
        } else if (direction == Direction.DOWN) {
            x += 15;
            y += 60;
        } else if (direction == Direction.RIGHT) {
            x += 60;
            y += 15;
        } else if (direction == Direction.LEFT) {
            x -= 10;
            y += 15;
        }
    }

    //����ӵ��Ƿ����
    public boolean moveToBoundary() {
        if (x > MyPanel.widthframe || x < 0 || y < 0 || y > MyPanel.heightframe) {
            return true;
        }
        return false;
    }

    //�ӵ��Ƿ�ײ����̹�ˣ�����type �����ж��ӵ����ͣ�
    //��ӱ�ը��Ч
    public synchronized boolean hitTank() {
        if (type == 1) {
            for (EnemyTank enemyTank : MyPanel.enemyTankList) {
                //ײ��
                if (enemyTank.GetBoundary().intersects(this.GetBoundary())) {
                    MyPanel.enemyTankList.remove(enemyTank);
                    MyPanel.booms.add(new Boom(enemyTank.getPx(),enemyTank.getPy(),MyPanel));
                    return true;
                }
            }
        } else if (type == 2) {
            if (MyPanel.player1 == null){
                return false;
            }
            //ײ��
            if (MyPanel.player1.GetBoundary().intersects(this.GetBoundary())) {
                System.out.println("��Ϸ����");
                MyPanel.player1.isAlive = false;
//                MyPanel.player1 = null;
                MyPanel.booms.add(new Boom(MyPanel.player1.getPx(),MyPanel.player1.getPy(),MyPanel));
                return true;
            }

        }
        return false;
    }

    @Override
    public void PaintSelf(Graphics g) {
        drawBullrts(g);
    }

    @Override
    public Rectangle GetBoundary() {
        return new Rectangle(x, y, size, size);
    }

    @Override
    public void run() {
        //�߳�������ÿ��50ms ����ӵ��Ƿ񴥷��¼��������߿򣩣�
        // ���ǣ����ƶ��ӵ�
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //����ӵ��Ƿ�Ӧ������
            if (moveToBoundary() || hitTank()) {
                MyPanel.shots.remove(this);
                break;
            }


            //�ƶ��ӵ�
            switch (direction) {
                case UP:
                    y -= speed;
                    break;
                case DOWN:
                    y += speed;
                    break;
                case LEFT:
                    x -= speed;
                    break;
                case RIGHT:
                    x += speed;
                    break;
            }
        }
    }
}
