package studay.TankWar03;

import java.awt.*;

/**
 * @author hxz
 */
public class Boom extends GameObject{
    int x;
    int y;
    //��ըͼ��
    public Image[] imgs = new Image[11];

    //�л�������ͼƬ
    int explodeCount = 0;

    public Boom(int x, int y,TankWar03 panel) {
        this.x = x;
        this.y = y;
        MyPanel = panel;
        BoomStart();
    }


    public void BoomStart() {
        for(int i = 0; i < 11;i++) {
            this.imgs[i] = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/pic/explosion/" +(i+1)+".png"));
        }
    }

    @Override
    public void PaintSelf(Graphics g) {
        //ÿ�ν��룬����һ�ű�ըͼƬ��ֱ����ըЧ������
        //�ӵ��Ƴ���̹���Ƴ�����Ӱ�챬ը�������̹�˱�ըλ�����
        if(explodeCount < 11) {
            g.drawImage(imgs[explodeCount], x, y, 50,50,null);
            explodeCount++;
        }else {
            MyPanel.booms.remove(this);
        }
    }

    @Override
    public Rectangle GetBoundary() {
        return null;
    }
}
