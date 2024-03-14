package studay.TankWar03;

import java.awt.*;

/**
 * @author hxz
 */
public abstract class Bullrt extends GameObject{
    //子弹坐标
    protected int x;
    protected int y;
    //子弹方向
    protected Direction direction;
    //子弹速度
    protected int speed;
    //子弹类型
    protected int type;
    //子弹大小
    protected int size=10;


    public Bullrt(int x, int y, Direction direction, int speed, int type, TankWar03 panel) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.speed = speed;
        this.type = type;
        MyPanel = panel;
    }



    public void drawBullrts(Graphics g) {
        if (type == 1) {
            g.setColor(Color.white);
        } else if (type == 2) {
            g.setColor(Color.red);
        }
        g.fillOval(x, y, size, size);
    }

}
