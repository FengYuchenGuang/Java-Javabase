package TankWarOld.oldTankWar;

import java.awt.*;


public class Boom extends GameObject{
	//爆炸图集
	public Image[] imgs = new Image[11]; 
	
	//切换到那张图片
	int explodeCount = 0;

	boolean isAlive = true;

	
	int Width = 127;
	int Height = 127;
	
	public void BoomStart() {
		for(int i = 0; i < 11;i++) {
			this.imgs[i] = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/TankWarOld/boom/" +(i+1)+".png"));
		}
	}
	

	public Boom(String img, int x, int y, StartGameTankWar GameTankWar) {
		super(img, x, y, GameTankWar);
		BoomStart(); 
	}
	

	@Override
	public void paintSelf(Graphics g) {
		//每次进入，绘制一张爆炸图片，直到爆炸效果结束
		//子弹移除，坦克移除，不影响爆炸类继续在坦克爆炸位置输出
		if(explodeCount < 11) {
			g.drawImage(imgs[explodeCount], X, Y, null);
			explodeCount++;
		}else if (isAlive){
			isAlive =false;
		}
		
	}
	
	
	
	@Override
	public Rectangle getRect() {
		
		return new Rectangle(X, Y, Width, Height);
		
	}

}
