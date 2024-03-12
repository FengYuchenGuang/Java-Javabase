package TankWarOld.oldTankWar;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;


public class EnemyTank extends Tank {
	//敌方坦克的长宽
	public int EnemyTankWidth;
	public int EnemyTankHeight;
	
	//定义移动时间
	int EnemyMoveTime = 0;

	Direction direction = Direction.UP;
	
	//坦克攻击冷却状态 true时正在冷却，无法攻击
	public boolean attackCollDown = true;

	//坦克攻击时间间隔 1000ms
	public int attackCoolDownTime = 1000;
	
	public EnemyTank(String img, int x, int y, StartGameTankWar GameTankWar, String upImg, String downImg,
			String rightImg, String leftImg, int EnemyTankWidth, int EnemyTankHeight) {
		super(img, x, y, GameTankWar, upImg, downImg, rightImg, leftImg);
		this.EnemyTankWidth = EnemyTankWidth;
		this.EnemyTankHeight = EnemyTankHeight;
		
	}
	
	
	/*
	 *添加新线程实现坦克攻击冷却时间的计算
	 *冷却时间未到无法继续发射子弹（方便后续添加道具，减少冷却时间） 
	 */
	class attackCD extends Thread {
		@SuppressWarnings("deprecation")
		public void run() {
			//将攻击状态设置为冷却时间
			attackCollDown = false;
			
			//休眠1s
			try {
				Thread.sleep(attackCoolDownTime);
				
			}catch (Exception e) {
				e.printStackTrace();
				
			}

			//将将攻击的冷却状态解除
			attackCollDown = true;
			
			//终止线程
			this.stop();
			
		}
		
	}
			
	
	//获取随机变量
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
	 * 敌方坦克方向变化与移动
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
	 * 敌方坦克攻击
	 */
	public void EnemyAttack() {
		Point p =  getEnemyHeadPoint();
		Random random = new Random();
		int rnum = random.nextInt(150);
		if(rnum < 5 ) {
			
			//随机发射子弹，但两个子弹间隔不能小于1000ms
			if(attackCollDown) {
				
				EnemyBullrts enemyBullrts = new EnemyBullrts("/TankWarOld/bullets/EnemyBullets.png",p.x, p.y, this.GameTankWar, tankDirection,
						"/TankWarOld/bullets/EnemyBullets.png", "/TankWarOld/bullets/EnemyBullets.png", "/TankWarOld/bullets/EnemyBullets.png", "/TankWarOld/bullets/EnemyBullets.png");
				//将发射的子弹放入列表中
				this.GameTankWar.bulletsList.add(enemyBullrts);
				
				//开始线程
				new attackCD().start();
			}
		}
		
	}
	
	
	
	//坦克头部的坐标
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
	

	//继承tank类的方法
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





