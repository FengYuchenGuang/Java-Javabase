package TankWarOld.oldTankWar;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;

public class Bullets1 extends GameObject {
	//尺寸
	public int bulletsWidth = 10;
	public int bulletsHeight = 10;
	
	//速度
	public int bulletsspeed = 10;
	
	//方向
	public Direction bulletsDirection = Direction.UP;
	
	//子弹四个方向的图片
	private String upImg;
	private String downImg;
	private String rightImg;
	private String leftImg;
	
	public Bullets1(String img, int x, int y, StartGameTankWar GameTankWar, Direction direction,String upImg,
			String downImg, String rightImg, String leftImg) {
		super(img, x, y, GameTankWar);
		this.bulletsDirection = direction;
		this.upImg = upImg;
		this.downImg = downImg;
		this.rightImg = rightImg;
		this.leftImg = leftImg;
		
	}
	
	public void bullets_up() {
		Y -= bulletsspeed;
		setImg(upImg);
	}
	
	public void bullets_down() {
		Y += bulletsspeed;
		setImg(downImg);
	}
	
	public void bullets_left() {
		X -= bulletsspeed;
		setImg(rightImg);
	}
	
	public void bullets_right() {
		X += bulletsspeed;
		setImg(leftImg);
	}
	
	public void shoot() {
		switch( bulletsDirection ) {
		case UP :
			bullets_up();
			break;
		case DOWN :
			bullets_down();
			break;
		case LEFT :
			bullets_left();
			break;
		case RIGHT :
			bullets_right();
			break;
		default:
			break;
		
		}
		
	}
	
	
	//选择对应的子弹方向图片
	public void setImg(String img) {
		
		this.img = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(img));
		
	}
	
	
	/*
	 * 检测我方子弹是否击中敌方坦克
	 */
	public void hitEnemyTank() {
		ArrayList<EnemyTank> EnemyTanks = this.GameTankWar.EnemyTankList;
		for(EnemyTank enemyTank : EnemyTanks) {
			if(this.getRect().intersects(enemyTank.getRect())) {
				this.GameTankWar.boomList.add(new Boom("",enemyTank.X-25,enemyTank.Y-14,this.GameTankWar));
				this.GameTankWar.EnemyTankList.remove(enemyTank);
				this.GameTankWar.removeList.add(this);
				break;
			}
			
		}
		
	}
	
	
	/*
	 * 子弹击中围墙的方法
	 */
	public void hitWall() {
		//围墙列表
		ArrayList<Wall> WallList = this.GameTankWar.wallList;
		//遍历列表
		for(Wall wall : WallList) {
			if(this.getRect().intersects(wall.getRect())) {
				wall.HP--;
				if(wall.HP == 0) {
					this.GameTankWar.wallList.remove(wall);			
				}
				this.GameTankWar.removeList.add(this);
				break;	
			}
			
		}
		
	}
	
	
	/*
	 * 子弹击中基地的方法
	 */
	public void hitBase() {
		//围墙列表
		ArrayList<Base> BaseList = this.GameTankWar.baseList;
		//遍历列表
		for(Base base : BaseList) {
			if(this.getRect().intersects(base.getRect())) {
				base.HP--;
				if(base.HP == 0) {
					this.GameTankWar.baseList.remove(base);			
				}
				this.GameTankWar.removeList.add(this);
				break;	
			}
			
		}
		
	}
	
	
	/*
	 * 子弹出界后清除
	 */
	//子弹是否出界检测
	public void moveToBorder(int x, int y) {
		if(x < 0 ) {
			this.GameTankWar.removeList.add(this);
		}else if(x+bulletsWidth > this.GameTankWar.getWidth()) {
			this.GameTankWar.removeList.add(this);
		}else if(y < 0) {
			this.GameTankWar.removeList.add(this);
		}else if(y + bulletsHeight > this.GameTankWar.getHeight()) {
			this.GameTankWar.removeList.add(this);
		}

	}
	
	
	@Override
	public void paintSelf(Graphics g) {
		g.drawImage(img, X, Y, null);
		//images.img_secelt.paintIcon(this, g, X,Y);
	    if(!StartGameTankWar.Win || !StartGameTankWar.Defeat ) {
			this.shoot();
			this.hitEnemyTank();
			this.hitWall();
			this.hitBase();
			this.moveToBorder(X,Y);
			
	    }

		
	}
	
	
	
	@Override
	public Rectangle getRect() {
		
		return new Rectangle(X, Y, bulletsWidth, bulletsHeight);
		
	}
	

}
