package studay.TankWar03;

import java.awt.*;

/**
 * @author hxz
 */
public abstract class Bullrt extends GameObject{
    //�ӵ�����
    protected int x;
    protected int y;
    //�ӵ�����
    protected Direction direction;
    //�ӵ��ٶ�
    protected int speed;
    //�ӵ�����
    protected int type;
    //�ӵ���С
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
