package studay.TankWar03;

import java.awt.*;

/**
 * @author hxz
 */
public class Shot extends Bullrt implements Runnable {
    private boolean loop; //线程终止符

    public Shot(int x, int y, Direction direction, int speed, int type, TankWar03 panel) {
        super(x, y, direction, speed, type, panel);
        adjustPosition();
        new Thread(this).start();
    }

    //调整子弹初始位置
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

    //检测子弹是否出界
    public boolean moveToBoundary() {
        if (x > MyPanel.widthframe || x < 0 || y < 0 || y > MyPanel.heightframe) {
            return true;
        }
        return false;
    }

    //子弹是否撞击到坦克（根据type 可以判断子弹类型）
    //添加爆炸特效
    public synchronized boolean hitTank() {
        if (type == 1) {
            for (EnemyTank enemyTank : MyPanel.enemyTankList) {
                //撞击
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
            //撞击
            if (MyPanel.player1.isAlive && MyPanel.player1.GetBoundary().intersects(this.GetBoundary())) {
                System.out.println("游戏结束");
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
        //线程启动，每过50ms 检测子弹是否触发事件（超出边框），
        // 不是，则移动子弹
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //检测子弹是否应该销毁
            if (moveToBoundary() || hitTank()) {
                MyPanel.shots.remove(this);
                break;
            }


            //移动子弹
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
