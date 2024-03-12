package TankWarOld.oldTankWar;

import java.awt.*;





public abstract class GameObject {
	//图片
	public Image img; 
	//坐标
	public int X; 
	public int Y; 
	//界面
	public StartGameTankWar GameTankWar;
	
	public GameObject(String img, int x ,int y, StartGameTankWar GameTankWar) {
		//this.img = Toolkit.getDefaultToolkit().getImage(img);
		this.img = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(img));
		//this.img = new ImageIcon(ClassLoader.getSystemResource(img)).getImage();
		this.X = x;
		this.Y = y;
		this.GameTankWar = GameTankWar;
	}
	
	
	
	/*
	 * 公用的方法
	 */
	//绘制方法
	public abstract void paintSelf(Graphics g);
	
	//返回自身矩形的方法，方便之后的碰撞检测
	public abstract Rectangle getRect();
	
	
	
	
	
}
