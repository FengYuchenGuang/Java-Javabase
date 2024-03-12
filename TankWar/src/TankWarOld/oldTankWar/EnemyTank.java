package TankWarOld.oldTankWar;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;


public class EnemyTank extends Tank {
	//�з�̹�˵ĳ���
	public int EnemyTankWidth;
	public int EnemyTankHeight;
	
	//�����ƶ�ʱ��
	int EnemyMoveTime = 0;

	Direction direction = Direction.UP;
	
	//̹�˹�����ȴ״̬ trueʱ������ȴ���޷�����
	public boolean attackCollDown = true;

	//̹�˹���ʱ���� 1000ms
	public int attackCoolDownTime = 1000;
	
	public EnemyTank(String img, int x, int y, StartGameTankWar GameTankWar, String upImg, String downImg,
			String rightImg, String leftImg, int EnemyTankWidth, int EnemyTankHeight) {
		super(img, x, y, GameTankWar, upImg, downImg, rightImg, leftImg);
		this.EnemyTankWidth = EnemyTankWidth;
		this.EnemyTankHeight = EnemyTankHeight;
		
	}
	
	
	/*
	 *������߳�ʵ��̹�˹�����ȴʱ��ļ���
	 *��ȴʱ��δ���޷����������ӵ������������ӵ��ߣ�������ȴʱ�䣩 
	 */
	class attackCD extends Thread {
		@SuppressWarnings("deprecation")
		public void run() {
			//������״̬����Ϊ��ȴʱ��
			attackCollDown = false;
			
			//����1s
			try {
				Thread.sleep(attackCoolDownTime);
				
			}catch (Exception e) {
				e.printStackTrace();
				
			}

			//������������ȴ״̬���
			attackCollDown = true;
			
			//��ֹ�߳�
			this.stop();
			
		}
		
	}
			
	
	//��ȡ�������
	public Direction RandomEnemyDirection() {
		Random random = new Random();
		int rnum = random.nextInt(4);
		switch(rnum) {
		case 0 :
			return Direction.UP;
		case 1 :
			return Direction.DOWN;
		case 2 :
			return Direction.LEFT;
		case 3 :
			return Direction.RIGHT;
		default :
			return null;
		}
		
	}

	
	
	/*
	 * �з�̹�˷���仯���ƶ�
	 */
	public void EnemyTankMove() {
		
		EnemyAttack();
		
		if(EnemyMoveTime > 10) {
			direction = RandomEnemyDirection();
			EnemyMoveTime = 0;
		}else {
			EnemyMoveTime++;
		}
		if(Y == 0 || X == 0 || Y == StartGameTankWar.heightframe - 58 || X == StartGameTankWar.widthframe - 60) {
			direction = RandomEnemyDirection();
			EnemyMoveTime = 0;
		}
		
		switch(direction) {
		case UP :
			tankUp();
			break;
		case DOWN :
			tankDown();
			break;
		case LEFT :
			tankLeft();
			break;
		case RIGHT :
			tankRight();
			break;
		}
		
		
	}
	
	
	/*
	 * �з�̹�˹���
	 */
	public void EnemyAttack() {
		Point p =  getEnemyHeadPoint();
		Random random = new Random();
		int rnum = random.nextInt(150);
		if(rnum < 5 ) {
			
			//��������ӵ����������ӵ��������С��1000ms
			if(attackCollDown) {
				
				EnemyBullrts enemyBullrts = new EnemyBullrts("/TankWarOld/bullets/EnemyBullets.png",p.x, p.y, this.GameTankWar, tankDirection,
						"/TankWarOld/bullets/EnemyBullets.png", "/TankWarOld/bullets/EnemyBullets.png", "/TankWarOld/bullets/EnemyBullets.png", "/TankWarOld/bullets/EnemyBullets.png");
				//��������ӵ������б���
				this.GameTankWar.bulletsList.add(enemyBullrts);
				
				//��ʼ�߳�
				new attackCD().start();
			}
		}
		
	}
	
	
	
	//̹��ͷ��������
	public Point getEnemyHeadPoint() {
		switch(tankDirection) {
		case UP :
			return new Point(X+tankWidth/2-14,Y);
		case DOWN :
			return new Point(X+tankWidth/2-14,Y+tankHeight);
		case LEFT :
			return new Point(X,Y+tankHeight/2-14);
		case RIGHT :
			return new Point(X+tankWidth,Y+tankHeight/2-14);
		default:
			return null;
		}
		
	}
	

	//�̳�tank��ķ���
	@Override
	public void paintSelf(Graphics g) {
		g.drawImage(img, X, Y, null);
	    if(!StartGameTankWar.Win || !StartGameTankWar.Defeat ) {
	    	EnemyTankMove();
	    }
		
	}
	
	
	@Override
	public Rectangle getRect() {
		
		return new Rectangle(X, Y, EnemyTankWidth, EnemyTankHeight);
		
	}
	
}





