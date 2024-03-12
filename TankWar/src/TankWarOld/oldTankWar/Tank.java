package TankWarOld.oldTankWar;

import java.awt.*;
import java.util.ArrayList;


public abstract class Tank extends GameObject{
	//坦克的尺寸
	public int tankWidth = 60;
	public int tankHeight = 58;
	//坦克的速度
	public int speed = 7;
	//坦克的方向
	public Direction tankDirection = Direction.UP;
	
	//坦克四个方向的图片
	public String upImg;
	public String downImg;
	public String rightImg;
	public String leftImg;

	//定义玩家1与玩家2的四个运动方向 刚开始四个方向运动都为假，即不运动
	public boolean player1_up = false;
	public boolean player1_down = false;
	public boolean player1_left = false;
	public boolean player1_right = false;
	
	public boolean player2_up = false;
	public boolean player2_down = false;
	public boolean player2_left = false;
	public boolean player2_right = false;	
	
	
	//坦克攻击冷却状态 true时正在冷却，无法攻击
	public boolean attackCollDown1 = true;
	public boolean attackCollDown2 = true;
	
	//坦克攻击时间间隔 1000ms
	public int attackCoolDownTime1 = 1000;
	public int attackCoolDownTime2 = 1000;
	
	public Tank(String img, int x ,int y, StartGameTankWar GameTankWar, String upImg, 
			String downImg, String rightImg, String leftImg) {
		//继承父类
		super(img, x, y, GameTankWar);
		this.upImg = upImg;
		this.downImg = downImg;
		this.rightImg = rightImg;
		this.leftImg = leftImg;
		
		
	}
	
	//tank类的方法，直接继承父类
	@Override
	public abstract void paintSelf(Graphics g);
	@Override
	public abstract Rectangle getRect();
	
	
	/*
	 *添加新线程实现坦克攻击冷却时间的计算
	 *冷却时间未到无法继续发射子弹（方便后续添加道具，减少冷却时间） 
	 */
	class attackCD1 extends Thread {
		@SuppressWarnings("deprecation")
		public void run() {
			//将攻击状态设置为冷却时间
			attackCollDown1 = false;
			
			//休眠1s
			try {
				Thread.sleep(attackCoolDownTime1);
				
			}catch (Exception e) {
				e.printStackTrace();
				
			}

			//将将攻击的冷却状态解除
			attackCollDown1 = true;
			
			//终止线程
			this.stop();
			
		}
		
	}
	
	
	
	class attackCD2 extends Thread {
		@SuppressWarnings("deprecation")
		public void run() {
			//将攻击状态设置为冷却时间
			attackCollDown2 = false;
			
			//休眠1s
			try {
				Thread.sleep(attackCoolDownTime2);
				
			}catch (Exception e) {
				e.printStackTrace();
				
			}

			//将将攻击的冷却状态解除
			attackCollDown2 = true;
			
			//终止线程
			this.stop();
			
		}
		
	}
	
	
	/*
	 * 坦克移动的方法
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
	
	
	//坦克1发射子弹方法
	public void tankattack1() {
		if(attackCollDown1) {
			
			Point p = getHeadPoint();
			Bullets1 bullets1 = new Bullets1("/TankWarOld/bullets/bullets1_up.png",p.x, p.y, this.GameTankWar, tankDirection,
					"/TankWarOld/bullets/bullets1_up.png", "/TankWarOld/bullets/bullets1_down.png", "/TankWarOld/bullets/bullets1_left.png", "/TankWarOld/bullets/bullets1_right.png");
			//将发射的子弹放入列表中
			this.GameTankWar.bulletsList.add(bullets1);	
			
			//开始线程
			new attackCD1().start();
		}

	}
	
	
	//坦克2发射子弹方法
	public void tankattack2() {
		if(attackCollDown2) {
			
			Point p = getHeadPoint();
			Bullets1 bullets2 = new Bullets1("/TankWarOld/bullets/bullets2_up.png",p.x, p.y, this.GameTankWar, tankDirection,
					"/TankWarOld/bullets/bullets2_up.png", "/TankWarOld/bullets/bullets2_down.png", "/TankWarOld/bullets/bullets2_left.png", "/TankWarOld/bullets/bullets2_right.png");
			//将发射的子弹放入列表中
			this.GameTankWar.bulletsList.add(bullets2);
			
			//开始线程
			new attackCD2().start();
			
		}
	}

	
	
	//坦克头部的坐标
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
	
	
	//坦克撞墙检测（用下一次的坦克坐标进行检测）
	public boolean hitWall(int x, int y) {
		//如果撞墙返回true
		//围墙列表
		ArrayList<Wall> WallList = this.GameTankWar.wallList;
		//坦克下一步形成的矩形
		Rectangle next = new Rectangle(x,y,tankWidth,tankHeight);
		//遍历列表
		for(Wall wall : WallList) {
			if(next.intersects(wall.getRect())) {
				return true;
			}
			
		}
		return false;
	}
	
	
	//坦克是否出界检测（用下一次的坦克坐标进行检测）
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
	
	
	//选择对应的坦克方向图片
	public void setImg(String img) {
		
		this.img = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(img));
		
	}
	
	
}
