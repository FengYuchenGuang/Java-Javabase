package studay.Draw_01;

import javax.swing.*;
import java.awt.*;

/**
 * @author hxz
 * 基础的画图操作
 *
 * 除了字体的设置是在左下角
 * 其他，画图、设置图片都是按照左上角
 */
//JFrame 对应窗口,可以理解成是一个画框
public class DrawCircle extends JFrame{
    //定义一个面板
    private MyPanel01  mp = null;

    public static void main(String[] args) {
        new DrawCircle();
        System.out.println("退出程序~");
    }

    public DrawCircle() {//构造器
        //初始化面板
        mp = new MyPanel01();

        //把面板放入到窗口(画框)
        this.add(mp);

        //设置窗口的大小
        this.setSize(1000, 600);

        //使屏幕居中
        this.setLocationRelativeTo(null);

        //将窗体设置为不可调节大小
//        setResizable(false);

        //当点击窗口的小×，程序完全退出.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //可以显示，默认是不显示
        this.setVisible(true);
    }

}

//定义一个面板 Panel，继承 JPanel类，画图形，就在画板上画
class MyPanel01 extends JPanel {
    //说明:
    //1. MyPanel 对象就是一个画板
    //2. Graphics g 把 g 理解成一支画笔
    //3. Graphics 提供了很多绘图的方法
    //Graphics g
    @Override
    public void paint(Graphics g) {
        super.paint(g);//调用父类完成初始化

        System.out.println("paint 方法被调用了~");
        //画出一个圆形.
//        g.drawOval(10, 10, 100, 100);

        //演示绘制不同的图形..
        //画直线 drawLine(int x1,int y1,int x2,int y2)
        //g.drawLine(10, 10, 100, 100);

        //画矩形边框 drawRect(int x, int y, int width, int height)
        //g.drawRect(10, 10, 100, 100);

        //画椭圆边框 drawOval(int x, int y, int width, int height)

        //填充矩形 fillRect(int x, int y, int width, int height)

        //设置画笔的颜色
//        g.setColor(Color.blue);
//        g.fillRect(10, 10, 100, 100);

        //填充椭圆 fillOval(int x, int y, int width, int height)
//        g.setColor(Color.red);
//        g.fillOval(10, 10, 100, 100);

        //画图片 drawImage(Image img, int x, int y, ..)
        //1. 获取图片资源, /bg.png 表示在该项目的根目录去获取 bg.png 图片资源
        // out 里面
        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/pic/block/基地.png"));
        g.drawImage(image, 900, 500, 50, 50, this);

        //画字符串 drawString(String str, int x, int y)//写字
        //给画笔设置颜色和字体
        g.setColor(Color.red);
        g.setFont(new Font("隶书", Font.BOLD, 50));

        //这里设置的 100， 100， 是 "北京你好"  ====左下角======
        g.drawString("北京你好", 100, 100);

        //设置画笔的字体 setFont(Font font)

        //设置画笔的颜色 setColor(Color c)
    }
}
