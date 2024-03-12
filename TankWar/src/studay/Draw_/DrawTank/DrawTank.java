package studay.Draw_.DrawTank;

import javax.swing.*;

/**
 * @author hxz
 */
public class DrawTank extends JFrame {
    //定义 MyPanel
    MyPanel mp = null;

    public static void main(String[] args) {
        DrawTank drawTank = new DrawTank();
    }

    // 构造器
    public DrawTank() {
        mp = new MyPanel();
        this.add(mp);//把面板(就是游戏的绘图区域)

        this.setSize(1000, 750);

        //使屏幕居中
        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

