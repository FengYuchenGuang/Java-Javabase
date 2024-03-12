package TankWarOld.oldTankWar;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Base extends GameObject{

	//»ùµØµÄ³ß´ç
	public int baseWidth = 50;
	public int baseHeight = 50;
	
	int HP;
	
	public Base(String img, int x, int y, StartGameTankWar GameTankWar,int HP) {
		super(img, x, y, GameTankWar);
		// TODO Auto-generated constructor stub
		this.HP = HP;
	}

	@Override
	public void paintSelf(Graphics g) {
		g.drawImage(img, X, Y, null);
		//images.img_secelt.paintIcon(this, g, X,Y);
		
	}

	@Override
	public Rectangle getRect() {
		
		return new Rectangle(X, Y, baseWidth, baseHeight);
		
	}
	
	
	
}
