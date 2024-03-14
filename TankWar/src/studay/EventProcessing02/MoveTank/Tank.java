package studay.EventProcessing02.MoveTank;

import java.awt.*;

/**
 * @author hxz
 */
public abstract class Tank {
    protected int Px;
    protected int Py;
    protected Direction tankDirection = Direction.UP;
    protected int speed = 5;

    public Tank(int px, int py, Direction direction) {
        Px = px;
        Py = py;
        this.tankDirection = direction;
    }

    public Tank(int px, int py, Direction tankDirection, int speed) {
        Px = px;
        Py = py;
        this.tankDirection = tankDirection;
        this.speed = speed;
    }

    //公共方法
    public abstract void PaintSelf(Graphics g);

    /*
     * 坦克移动的方法
     */
    public void tankUp() {
        tankDirection = Direction.UP;
        Py -= speed;
//        if(!hitWall(X,Y-speed) && !moveToBorder(X,Y-speed)) {
//            this.Y -= speed;
//        }
    }

    public void tankDown() {
        tankDirection = Direction.DOWN;
        Py += speed;
    }

    public void tankLeft() {
        tankDirection = Direction.LEFT;
        Px -= speed;
    }

    public void tankRight() {
        tankDirection = Direction.RIGHT;
        Px += speed;
    }


    //编写方法，画出坦克
    /**
     * @param x 坦克的左上角 x 坐标
     * @param y 坦克的左上角 y 坐标
     * @param g 画笔
     * @param direct 坦克方向（上下左右）
     * @param type 坦克类型
     */
    public void drawTank(int x, int y, Graphics g, Direction direct, int type) {
        //根据不同类型坦克，设置不同颜色
        switch (type) {
            case 0: //我们的坦克
                g.setColor(Color.cyan);
                break;
            case 1: //敌人的坦克
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
                g.fill3DRect(Px, Py+30, 60, 10, false);//画出坦克右边轮子
                g.fill3DRect(Px + 10, Py + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(Px + 20, Py + 10, 20, 20);//画出圆形盖子
                g.drawLine(Px + 30, Py + 20, Px+60, Py+20);//画出炮筒
                break;
            case DOWN: //表示向下
                g.fill3DRect(Px, Py, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(Px + 30, Py, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(Px + 10, Py + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(Px + 10, Py + 20, 20, 20);//画出圆形盖子
                g.drawLine(Px + 20, Py + 30, Px + 20, Py+60);//画出炮筒
                break;
            case LEFT: //表示向左
                g.fill3DRect(Px, Py, 60, 10, false);//画出坦克左边轮子
                g.fill3DRect(Px, Py+30, 60, 10, false);//画出坦克右边轮子
                g.fill3DRect(Px + 10, Py + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(Px + 20, Py + 10, 20, 20);//画出圆形盖子
                g.drawLine(Px + 30, Py + 20, Px, Py+20);//画出炮筒
                break;
            default:
                System.out.println("暂时没有处理");
        }
    }
}
