package TankWarOld.oldTankWar;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;


public class EnemyBullrts extends Bullets1 {
	

	//�ߴ�
	public int EnemybulletsWidth = 39;
	public int EnemybulletsHeight = 39;
	
	//�ٶ�
	public int Enemybulletsspeed = 7;
	
	//����
	public Direction EnemybulletsDirection = Direction.UP;
	

	public EnemyBullrts(String img, int x, int y, StartGameTankWar GameTankWar, Direction direction, String upImg,
			String downImg, String rightImg, String leftImg) {
		super(img, x, y, GameTankWar, direction, upImg, downImg, rightImg, leftImg);
		// TODO Auto-generated constructor stub
	}	
	
	
	/*
	 * ���з��ӵ��Ƿ�������̹��
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
	 * �ӵ�����Χǽ�ķ���
	 */
	public void hitWall() {
		//Χǽ�б�
		ArrayList<Wall> WallList = this.GameTankWar.wallList;
		//�����б�
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
	 * �ӵ����л��صķ���
	 */
	public void hitBase() {
		//Χǽ�б�
		ArrayList<Base> BaseList = this.GameTankWar.baseList;
		//�����б�
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
	 * ̹���ӵ����ƶ�������Ƿ񴥷���������
	 *   ����ÿ�λ���̹���ӵ������
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
