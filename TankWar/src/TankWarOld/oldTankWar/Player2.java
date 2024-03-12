package TankWarOld.oldTankWar;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Player2 extends Tank{

	public Player2(String img, int x ,int y, StartGameTankWar GameTankWar, String upImg, 
			String downImg, String rightImg, String leftImg) {
		super(img, x, y, GameTankWar,upImg, downImg, rightImg, leftImg);
		
	}
	
	
	
	//��ⰴ�����£�̹�˵��˶�
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		switch (keycode) {
		case KeyEvent.VK_UP :
			player2_up = true;
			break;
		case KeyEvent.VK_DOWN :
			player2_down = true;
			break;		
		case KeyEvent.VK_LEFT :
			player2_left = true;
			break;
		case KeyEvent.VK_RIGHT :
			player2_right = true;
			break;
		case KeyEvent.VK_P :
			tankattack2();
			break;			
		default :
			break;
		}
		
		
	}
	
	
	//��ⰴ���ɿ���̹�˵��˶�
	public void keyRelease(KeyEvent e) {
		int keycode = e.getKeyCode();
		
		//System.out.println(keycode);
		
		switch (keycode) {
		case KeyEvent.VK_UP :
			player2_up = false;
			break;
		case KeyEvent.VK_DOWN :
			player2_down = false;
			break;		
		case KeyEvent.VK_LEFT :
			player2_left = false;
			break;
		case KeyEvent.VK_RIGHT :
			player2_right = false;
			break;	
		default :
			break;
		}
		
		
	}
	
	//���1̹���ƶ�
	public void movetank() {
		
		if(player2_up == true) {
			tankUp();
		}else if(player2_down == true) {
			tankDown();
		}else if(player2_left == true) {
			tankLeft();
		}else if(player2_right == true) {
			tankRight();
		}
	}
	
	
	
//	tank��ķ�����ֱ�Ӽ̳и���
	@Override
	public void paintSelf(Graphics g) {
		g.drawImage(img, X, Y, null);
		//images.img_secelt.paintIcon(this, g, X,Y);
		 movetank();
		
	}
	
	
	
	@Override
	public Rectangle getRect() {
		
		
		return new Rectangle(X, Y, tankWidth, tankHeight);
		
	}
	
}
