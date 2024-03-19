package studay.TankWar05;

import java.awt.*;


/**
 * @author hxz
 */
public class Boom extends GameObject {
    int x;
    int y;
    //爆炸图集
    public static Image[] imgs = new Image[11];

    //切换到那张图片
    int explodeCount = 0;
    boolean isAlive = true;

    public Boom(int x, int y, TankWar05 panel) {
        this.x = x;
        this.y = y;
        MyPanel = panel;
    }


    public static void BoomStart() {
        for(int i = 0; i < 11;i++) {
            imgs[i] = Toolkit.getDefaultToolkit().getImage(Boom.class.getResource("/pic/explosion/" +(i+1)+".png"));
        }
    }

    @Override
    public void PaintSelf(Graphics g) {
        //每次进入，绘制一张爆炸图片，直到爆炸效果结束
        //子弹移除，坦克移除，不影响爆炸类继续在坦克爆炸位置输出
        if(explodeCount < 11 ) {
            g.drawImage(imgs[explodeCount], x, y, 50,50,null);
            explodeCount++;

        }else if (isAlive){
            isAlive = false;
        }
    }

    @Override
    public Rectangle GetBoundary() {
        return null;
    }
}
