package studay.EventProcessing02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author hxz
 * 演示小球通过键盘控制上下左右的移动-> 讲解 Java 的事件控制
 */
public class BallMove extends JFrame {
    MyPanel02 mp = null;

    public static void main(String[] args) {
        BallMove ballMove = new BallMove();
    }

    //构造器
    public BallMove() {
        mp = new MyPanel02();
        this.add(mp);
        this.setSize(400, 300);

        //窗口 JFrame 对象可以监听键盘事件, 即可以监听到面板发生的键盘事件
        //事件源，可以是按钮，窗口。 监听发生的键盘事件
        this.addKeyListener(mp);

        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

//定义一个面板 Panel，继承 JPanel类，画图形，就在画板上画
//面板, 可以画出小球
//KeyListener 是监听器, 可以监听键盘事件
class MyPanel02 extends JPanel implements KeyListener {
    //为了让小球可以移动, 把他的左上角的坐标(x,y)设置变量
    int x = 10;
    int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20); //默认黑色
    }

    //有字符输出时，该方法就会触发
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //当某个键按下，该方法会触发
    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println((char)e.getKeyCode() + "被按下..");
        //根据用户按下的不同键，来处理小球的移动 (上下左右的键)
        //在 java 中，会给每一个键，分配一个值(int)
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {//KeyEvent.VK_DOWN 就是向下的箭头对应的 code
            y += 5;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            y -= 5;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x -= 5;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x += 5;
        }
        //让面板重绘
        this.repaint();
    }

    //当某个键释放(松开)，该方法会触发
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
