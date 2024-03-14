package studay.Draw_01.DrawTank;

import javax.swing.*;
import java.awt.*;

/**
 * @author hxz
 *  坦克大战的绘图区域
 */
public class MyPanel extends JPanel {
    //定义我的坦克
    Play01 play1 = null;
    //定义敌方的坦克
    Play01 enemy1 = null;
    Play01 enemy2 = null;
    Play01 enemy3 = null;

    public MyPanel() {
        play1 = new Play01(100, 100);//初始化自己坦克
        enemy1= new Play01(400, 400);//初始化敌方坦克
        enemy2= new Play01(500, 400);//初始化敌方坦克
        enemy3= new Play01(600, 400);//初始化敌方坦克
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//填充矩形，默认黑色
        //画出坦克-封装方法
        drawTank(play1.getX(), play1.getY(), g, 0, 0);

        drawTank(enemy1.getX(), enemy1.getY(), g, 1, 1);
        drawTank(enemy2.getX(), enemy2.getY(), g, 2, 1);
        drawTank(enemy3.getX(), enemy3.getY(), g, 3, 1);

    }

    //编写方法，画出坦克
    /**
     * @param x 坦克的左上角 x 坐标
     * @param y 坦克的左上角 y 坐标
     * @param g 画笔
     * @param direct 坦克方向（上下左右）
     * @param type 坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
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
            case 0: //表示向上
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y);//画出炮筒
                break;
            case 1: //表示向右
                g.fill3DRect(x, y, 60, 10, false);//画出坦克左边轮子
                g.fill3DRect(x, y+30, 60, 10, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出圆形盖子
                g.drawLine(x + 30, y + 20, x+60, y+20);//画出炮筒
                break;
            case 2: //表示向下
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y+60);//画出炮筒
                break;
            case 3: //表示向左
                g.fill3DRect(x, y, 60, 10, false);//画出坦克左边轮子
                g.fill3DRect(x, y+30, 60, 10, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出圆形盖子
                g.drawLine(x + 30, y + 20, x, y+20);//画出炮筒
                break;
            default:
                System.out.println("暂时没有处理");
        }
    }
}

