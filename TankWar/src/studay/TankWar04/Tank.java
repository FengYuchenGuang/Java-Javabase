package studay.TankWar04;


import java.awt.*;
import java.io.Serializable;

/**
 * @author hxz
 */
public abstract class Tank extends GameObject {
    protected int Px;
    protected int Py;
    protected Direction tankDirection = Direction.UP;
    protected int speed = 5; //坦克速度
    protected int BullrtSpeed = 5; //子弹速度

    //坦克大小
    protected int width = 40;
    protected int height = 60;


    public Tank(int px, int py, Direction tankDirection, TankWar04 myPanel) {
        Px = px;
        Py = py;
        this.tankDirection = tankDirection;
        MyPanel = myPanel;
    }

    public Tank(int px, int py, Direction tankDirection, int speed, TankWar04 myPanel) {
        Px = px;
        Py = py;
        this.tankDirection = tankDirection;
        this.speed = speed;
        MyPanel = myPanel;
    }


    /*
     * 坦克移动的方法
     */
    public void tankUp() {
        tankDirection = Direction.UP;
        if (moveToBorder(Px, Py - speed)) {
            return;
        }
        Py -= speed;
    }

    public void tankDown() {
        tankDirection = Direction.DOWN;
        if (moveToBorder(Px, Py + speed)) {
            return;
        }
        Py += speed;
    }

    public void tankLeft() {
        tankDirection = Direction.LEFT;
        if (moveToBorder(Px - speed, Py)) {
            return;
        }
        Px -= speed;
    }

    public void tankRight() {
        tankDirection = Direction.RIGHT;
        if (moveToBorder(Px + speed, Py)) {
            return;
        }
        Px += speed;
    }

    //坦克是否出界检测（用下一次的坦克坐标进行检测）
    public boolean moveToBorder(int x, int y) {
        if (x < speed) {
            return true;
        } else if (x + 60 + speed > MyPanel.getWidth()) {
            return true;
        } else if (y < 30 + speed) {
            return true;
        } else if (y + 60 + speed > MyPanel.getHeight()) {
            return true;
        }
        return false;
    }


    //坦克是否重叠（用下一次的坦克坐标进行检测）
    public boolean IfOverlap(Tank t1, TankLabel label, int x, int y, Direction direction) {
        Rectangle rect1 = t1.GetNextBoundary(x, y,direction);
        Rectangle rect2;

        if (label == TankLabel.EnemyTank) {
            //检测是否与其他敌方坦克碰撞
            for (EnemyTank enemyTank : MyPanel.enemyTankList) {
                //不与自己检测
                if (t1 == enemyTank) {
                    continue;
                }
                //与其他坦克检测
                rect2 = enemyTank.GetBoundary();
                if (rect1.intersects(rect2)) {
                    return true;
                }
            }

            //检测是否与玩家碰撞
            if (rect1.intersects(MyPanel.player1.GetBoundary())) {
                return true;
            }
        } else if (label == TankLabel.Player) {
            //检测是否与其他敌方坦克碰撞
            for (EnemyTank enemyTank : MyPanel.enemyTankList) {
                //与其他敌方坦克检测
                rect2 = enemyTank.GetBoundary();
                if (rect1.intersects(rect2)) {
                    return true;
                }
            }
        }
        return false;
    }

    //坦克转向后是否重叠（不移动，用下一次的坦克方向坐标进行检测）
    public boolean IfOverlapTurnDirection(Tank t1, TankLabel label, Direction direction) {
        Rectangle rect1 = t1.GetNextBoundary(Px, Py,direction);
        Rectangle rect2;

        if (label == TankLabel.EnemyTank) {
            //检测是否与其他敌方坦克碰撞
            for (EnemyTank enemyTank : MyPanel.enemyTankList) {
                //不与自己检测
                if (t1 == enemyTank) {
                    continue;
                }
                //与其他坦克检测
                rect2 = enemyTank.GetBoundary();
                if (rect1.intersects(rect2)) {
                    return true;
                }
            }

            //检测是否与玩家碰撞
            if (rect1.intersects(MyPanel.player1.GetBoundary())) {
                return true;
            }
        } else if (label == TankLabel.Player) {
            //检测是否与其他敌方坦克碰撞
            for (EnemyTank enemyTank : MyPanel.enemyTankList) {
                //与其他敌方坦克检测
                rect2 = enemyTank.GetBoundary();
                if (rect1.intersects(rect2)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param x      坦克的左上角 x 坐标
     * @param y      坦克的左上角 y 坐标
     * @param g      画笔
     * @param direct 坦克方向（上下左右）
     * @param label  坦克类型
     */
    public void drawTank(int x, int y, Graphics g, Direction direct, TankLabel label) {
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

    public int getPx() {
        return Px;
    }

    public int getPy() {
        return Py;
    }

    public int getSpeed() {
        return speed;
    }

    public int getTankDirection() {
        if (tankDirection == Direction.UP){
            return 0;
        }else if (tankDirection ==Direction.DOWN){
            return 1;
        }else if (tankDirection ==Direction.LEFT){
            return 2;
        }else {
            return 3;
        }
    }

    public Rectangle GetNextBoundary(int x, int y, Direction direction) {
        Rectangle rectangle;
        switch (direction) {
            case UP:
            case DOWN:
                rectangle = new Rectangle(x, y, width, height);
                break;
            case RIGHT:
            case LEFT:
                rectangle = new Rectangle(x, y, height, width);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + direction);
        }
        return rectangle;
    }
}
