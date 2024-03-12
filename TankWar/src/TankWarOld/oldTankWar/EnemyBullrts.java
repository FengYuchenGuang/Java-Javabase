package TankWarOld.oldTankWar;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;


public class EnemyBullrts extends Bullets1 {
	

	//尺寸
	public int EnemybulletsWidth = 39;
	public int EnemybulletsHeight = 39;
	
	//速度
	public int Enemybulletsspeed = 7;
	
	//方向
	public Direction EnemybulletsDirection = Direction.UP;
	

	public EnemyBullrts(String img, int x, int y, StartGameTankWar GameTankWar, Direction direction, String upImg,
			String downImg, String rightImg, String leftImg) {
		super(img, x, y, GameTankWar, direction, upImg, downImg, rightImg, leftImg);
		// TODO Auto-generated constructor stub
	}	
	
	
	/*
	 * 检测敌方子弹是否击中玩家坦克
	 */
	public void hitPlayer() {
		ArrayList<Tank> players = this.GameTankWar.playerList;
		for(Tank player : players) {
			if(this.getRect().intersects(player.getRect())) {
				this.GameTankWar.boomList.add(new Boom("",player.X-60,player.Y-60,this.GameTankWar));
				this.GameTankWar.playerList.remove(player);
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
	 * 坦克子弹的移动、检测是否触发其他方法
	 *   是在每次绘制坦克子弹后调用
	 */
	public void paintSelf(Graphics g) {
		g.drawImage(img, X, Y, null);
		//images.img_secelt.paintIcon(this, g, X,Y);
	    if(!StartGameTankWar.Win || !StartGameTankWar.Defeat ) {
			this.shoot();
			this.hitPlayer();
			this.hitWall();
			this.hitBase();
			this.moveToBorder(X,Y);
	    }

		
	}
	

	public Rectangle getRect() {
		
		return new Rectangle(X, Y, EnemybulletsWidth, EnemybulletsHeight);
		
	}
	
	

}
