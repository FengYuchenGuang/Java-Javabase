package studay.TankWar04;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.Random;
import java.util.Vector;

/**
 * @author hxz
 */
public class EnemyTank extends Tank{
    int EnemyMoveTime = 0;
    int RandomMoveTime = 6;
    boolean moveCD_flag = false;
    boolean attackCD_flag = false;
    Vector<Shot> shots = new Vector<>();
    //1、serialVersionUID 序列化版本号，可以提高兼容性
    //类中添加新的方法属性和方法是，不会认为这是一个新的类
//    private static final long serialVersionUID = 1L;

    public EnemyTank(int px, int py, TankWar04 myPanel) {
        super(px, py, Direction.DOWN, myPanel);
    }

    public EnemyTank(int px, int py, int speed, TankWar04 myPanel) {
        super(px, py, Direction.DOWN, speed, myPanel);
    }

    public EnemyTank(int px, int py, Direction tankDirection, int speed, TankWar04 myPanel) {
        super(px, py, tankDirection, speed, myPanel);
    }

    /*
     *添加新线程实现坦克移动CD
     *冷却时间未到无法继续移动
     */
    class moveCD extends Thread {
        @SuppressWarnings("deprecation")
        public void run() {
            moveCD_flag = true;
            //休眠200ms
            try {
                Thread.sleep(400);

            } catch (Exception e) {
                e.printStackTrace();

            }

            moveCD_flag = false;
            //终止线程
//            this.stop();
            //运行到这里，线程自然终止
        }
    }

    class attackCD extends Thread {
        @Override
        public void run() {
            attackCD_flag = true;
            //休眠200ms
            try {
                int num = RandomAttackTime();
                Thread.sleep(num);

            } catch (Exception e) {
                e.printStackTrace();

            }

            attackCD_flag = false;
        }
    }

    private void moveEnemyTank() {
        if (moveCD_flag) {
            return;
        }

        if (EnemyMoveTime > RandomMoveTime) {
            int i = 0;
            //转变方向时，判断四次随机方向是否可行，否则也强制退出，否则会卡住
            //四次随机方向无法转变时，将继续沿当前方向在运动一个随机时间
            while (true) {
                Direction temp = RandomEnemyDirection();
                //随机转向时 判断是否会重叠
                if (!IfOverlapTurnDirection(this, TankLabel.EnemyTank, temp)) {
                    tankDirection = temp;
                    break;
                }
                if (i == 3) {
                    break;
                }
                i++;
            }

            RandomMoveTime = new Random().nextInt(10) + 5;
            EnemyMoveTime = 0;
        } else {
            EnemyMoveTime++;
        }

        switch (tankDirection) {
            case UP:
                if (!IfOverlap(this, TankLabel.EnemyTank, Px, Py - speed, Direction.UP)) {
                    tankUp();
                }
                break;
            case DOWN:
                if (!IfOverlap(this, TankLabel.EnemyTank, Px, Py + speed, Direction.DOWN)) {
                    tankDown();
                }
                break;
            case LEFT:
                if (!IfOverlap(this, TankLabel.EnemyTank, Px - speed, Py, Direction.LEFT)) {
                    tankLeft();
                }
                break;
            case RIGHT:
                if (!IfOverlap(this, TankLabel.EnemyTank, Px + speed, Py, Direction.RIGHT)) {
                    tankRight();
                }
                break;
        }

        //开始线程
        new moveCD().start();
    }

    public void attack() {
        if (!attackCD_flag) {
            if (shots.size() < 3) {
                shots.add(new Shot(Px, Py, tankDirection, BullrtSpeed, 2, MyPanel));
                new attackCD().start();
            }
        }
    }

    //获取随机变量
    public Direction RandomEnemyDirection() {
        Random random = new Random();
        int rnum = random.nextInt(4);
        switch (rnum) {
            case 0:
                return Direction.UP;
            case 1:
                return Direction.DOWN;
            case 2:
                return Direction.LEFT;
            case 3:
                return Direction.RIGHT;
            default:
                return null;
        }

    }

    //获取随机变量
    public int RandomAttackTime() {
        Random random = new Random();
        return random.nextInt(1000) + 1000;
    }

    //检测是否有需要移除的子弹
    private void removeShots() {
        Vector<Shot> removeShots = new Vector<>();
        for (Shot s : this.shots) {
            if (!(s.isAlive())) {
                removeShots.add(s);
            }
        }
        this.shots.removeAll(removeShots);
    }

    @Override
    public void PaintSelf(Graphics g) {
//        System.out.println("EnemyTank direction = "+direction);
        drawTank(Px, Py, g, tankDirection, TankLabel.EnemyTank);
        moveEnemyTank();
        attack();
        removeShots();
    }

    @Override
    public Rectangle GetBoundary() {
        Rectangle rectangle;
        switch (tankDirection) {
            case UP:
            case DOWN:
                rectangle = new Rectangle(Px, Py, width, height);
                break;
            case RIGHT:
            case LEFT:
                rectangle = new Rectangle(Px, Py, height, width);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + tankDirection);
        }
        return rectangle;
    }


}
