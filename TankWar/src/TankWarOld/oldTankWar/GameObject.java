package TankWarOld.oldTankWar;

import java.awt.*;





public abstract class GameObject {
	//ͼƬ
	public Image img; 
	//����
	public int X; 
	public int Y; 
	//����
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
	 * ���õķ���
	 */
	//���Ʒ���
	public abstract void paintSelf(Graphics g);
	
	//����������εķ���������֮�����ײ���
	public abstract Rectangle getRect();
	
	
	
	
	
}
