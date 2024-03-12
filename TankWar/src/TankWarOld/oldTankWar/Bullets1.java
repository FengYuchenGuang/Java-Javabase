package TankWarOld.oldTankWar;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;

public class Bullets1 extends GameObject {
	//�ߴ�
	public int bulletsWidth = 10;
	public int bulletsHeight = 10;
	
	//�ٶ�
	public int bulletsspeed = 10;
	
	//����
	public Direction bulletsDirection = Direction.UP;
	
	//�ӵ��ĸ������ͼƬ
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
	
	
	//ѡ���Ӧ���ӵ�����ͼƬ
	public void setImg(String img) {
		
		this.img = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(img));
		
	}
	
	
	/*
	 * ����ҷ��ӵ��Ƿ���ез�̹��
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
	 * �ӵ���������
	 */
	//�ӵ��Ƿ������
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
