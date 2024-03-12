package TankWarOld.oldTankWar;

import java.awt.*;
import java.util.ArrayList;


public abstract class Tank extends GameObject{
	//̹�˵ĳߴ�
	public int tankWidth = 60;
	public int tankHeight = 58;
	//̹�˵��ٶ�
	public int speed = 7;
	//̹�˵ķ���
	public Direction tankDirection = Direction.UP;
	
	//̹���ĸ������ͼƬ
	public String upImg;
	public String downImg;
	public String rightImg;
	public String leftImg;

	//�������1�����2���ĸ��˶����� �տ�ʼ�ĸ������˶���Ϊ�٣������˶�
	public boolean player1_up = false;
	public boolean player1_down = false;
	public boolean player1_left = false;
	public boolean player1_right = false;
	
	public boolean player2_up = false;
	public boolean player2_down = false;
	public boolean player2_left = false;
	public boolean player2_right = false;	
	
	
	//̹�˹�����ȴ״̬ trueʱ������ȴ���޷�����
	public boolean attackCollDown1 = true;
	public boolean attackCollDown2 = true;
	
	//̹�˹���ʱ���� 1000ms
	public int attackCoolDownTime1 = 1000;
	public int attackCoolDownTime2 = 1000;
	
	public Tank(String img, int x ,int y, StartGameTankWar GameTankWar, String upImg, 
			String downImg, String rightImg, String leftImg) {
		//�̳и���
		super(img, x, y, GameTankWar);
		this.upImg = upImg;
		this.downImg = downImg;
		this.rightImg = rightImg;
		this.leftImg = leftImg;
		
		
	}
	
	//tank��ķ�����ֱ�Ӽ̳и���
	@Override
	public abstract void paintSelf(Graphics g);
	@Override
	public abstract Rectangle getRect();
	
	
	/*
	 *������߳�ʵ��̹�˹�����ȴʱ��ļ���
	 *��ȴʱ��δ���޷����������ӵ������������ӵ��ߣ�������ȴʱ�䣩 
	 */
	class attackCD1 extends Thread {
		@SuppressWarnings("deprecation")
		public void run() {
			//������״̬����Ϊ��ȴʱ��
			attackCollDown1 = false;
			
			//����1s
			try {
				Thread.sleep(attackCoolDownTime1);
				
			}catch (Exception e) {
				e.printStackTrace();
				
			}

			//������������ȴ״̬���
			attackCollDown1 = true;
			
			//��ֹ�߳�
			this.stop();
			
		}
		
	}
	
	
	
	class attackCD2 extends Thread {
		@SuppressWarnings("deprecation")
		public void run() {
			//������״̬����Ϊ��ȴʱ��
			attackCollDown2 = false;
			
			//����1s
			try {
				Thread.sleep(attackCoolDownTime2);
				
			}catch (Exception e) {
				e.printStackTrace();
				
			}

			//������������ȴ״̬���
			attackCollDown2 = true;
			
			//��ֹ�߳�
			this.stop();
			
		}
		
	}
	
	
	/*
	 * ̹���ƶ��ķ���
	 */
	public void tankUp() {
		tankDirection = Direction.UP;
		setImg(upImg);
		if(!hitWall(X,Y-speed) && !moveToBorder(X,Y-speed)) {
			this.Y -= speed;
		}
		
		
	}
	
	public void tankDown() {
		tankDirection = Direction.DOWN;	
		setImg(downImg);
		if(!hitWall(X,Y+speed ) && !moveToBorder(X,Y+speed)) {
			this.Y += speed;
		}
		
	}
	
	public void tankLeft() {
		tankDirection = Direction.LEFT;	
		setImg(leftImg);
		if(!hitWall(X-speed,Y) && !moveToBorder(X-speed,Y)) {
			this.X -= speed;
		}
		
	}
	
	public void tankRight() {
		tankDirection = Direction.RIGHT;		
		setImg(rightImg);
		if(!hitWall(X+speed,Y) && !moveToBorder(X+speed,Y)) {
			this.X += speed;
		}
		
		
	}
	
	
	//̹��1�����ӵ�����
	public void tankattack1() {
		if(attackCollDown1) {
			
			Point p = getHeadPoint();
			Bullets1 bullets1 = new Bullets1("/TankWarOld/bullets/bullets1_up.png",p.x, p.y, this.GameTankWar, tankDirection,
					"/TankWarOld/bullets/bullets1_up.png", "/TankWarOld/bullets/bullets1_down.png", "/TankWarOld/bullets/bullets1_left.png", "/TankWarOld/bullets/bullets1_right.png");
			//��������ӵ������б���
			this.GameTankWar.bulletsList.add(bullets1);	
			
			//��ʼ�߳�
			new attackCD1().start();
		}

	}
	
	
	//̹��2�����ӵ�����
	public void tankattack2() {
		if(attackCollDown2) {
			
			Point p = getHeadPoint();
			Bullets1 bullets2 = new Bullets1("/TankWarOld/bullets/bullets2_up.png",p.x, p.y, this.GameTankWar, tankDirection,
					"/TankWarOld/bullets/bullets2_up.png", "/TankWarOld/bullets/bullets2_down.png", "/TankWarOld/bullets/bullets2_left.png", "/TankWarOld/bullets/bullets2_right.png");
			//��������ӵ������б���
			this.GameTankWar.bulletsList.add(bullets2);
			
			//��ʼ�߳�
			new attackCD2().start();
			
		}
	}

	
	
	//̹��ͷ��������
	public Point getHeadPoint() {
		switch(tankDirection) {
		case UP :
			return new Point(X+tankWidth/2-5,Y);
		case DOWN :
			return new Point(X+tankWidth/2-5,Y+tankHeight);
		case LEFT :
			return new Point(X,Y+tankHeight/2-5);
		case RIGHT :
			return new Point(X+tankWidth,Y+tankHeight/2-5);
		default:
			return null;
		}
		
	}
	
	
	//̹��ײǽ��⣨����һ�ε�̹��������м�⣩
	public boolean hitWall(int x, int y) {
		//���ײǽ����true
		//Χǽ�б�
		ArrayList<Wall> WallList = this.GameTankWar.wallList;
		//̹����һ���γɵľ���
		Rectangle next = new Rectangle(x,y,tankWidth,tankHeight);
		//�����б�
		for(Wall wall : WallList) {
			if(next.intersects(wall.getRect())) {
				return true;
			}
			
		}
		return false;
	}
	
	
	//̹���Ƿ�����⣨����һ�ε�̹��������м�⣩
	public boolean moveToBorder(int x, int y) {
		if(x < 8 ) {
			return true;
		}else if(x+tankWidth+6 > this.GameTankWar.getWidth()) {
			return true;	
		}else if(y < 30) {
			return true;
		}else if(y + tankHeight+7> this.GameTankWar.getHeight()) {
			return true;
		}
		return false;
	}
	
	
	//ѡ���Ӧ��̹�˷���ͼƬ
	public void setImg(String img) {
		
		this.img = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(img));
		
	}
	
	
}
