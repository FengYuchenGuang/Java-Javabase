package studay.TankWar03;

import java.awt.*;
import java.util.Random;

/**
 * @author hxz
 */
public class EnemyTank extends Tank {
    int EnemyMoveTime = 0;
    int RandomMoveTime = 6;
    boolean moveCD_flag = false;
    boolean attackCD_flag = false;

    public EnemyTank(int px, int py, TankWar03 myPanel) {
        super(px, py, Direction.DOWN,myPanel);
    }

    public EnemyTank(int px, int py, int speed, TankWar03 myPanel) {
        super(px, py, Direction.DOWN,speed,myPanel);
    }

    /*
     *添加新线程实现坦克移动CD
     *冷却时间未到无法继续移动
     */
    class moveCD extends Thread {
        @SuppressWarnings("deprecation")
        public void run() {
            moveCD_flag = true;
            //休眠200ms
            try {
                Thread.sleep(400);

            }catch (Exception e) {
                e.printStackTrace();

            }

            moveCD_flag = false;
            //终止线程
//            this.stop();
            //运行到这里，线程自然终止
        }
    }

    class attackCD extends Thread {
        @Override
        public void run() {
            attackCD_flag = true;
            //休眠200ms
            try {
                Thread.sleep(1000);

            }catch (Exception e) {
                e.printStackTrace();

            }

            attackCD_flag = false;
        }
    }

    private void moveEnemyTank() {
        if (moveCD_flag){
            return;
        }

        if (EnemyMoveTime > RandomMoveTime) {
            tankDirection = RandomEnemyDirection();
            RandomMoveTime = new Random().nextInt(10) + 5;
            EnemyMoveTime = 0;
        } else {
            EnemyMoveTime++;
        }

        switch (tankDirection) {
            case UP:
                tankUp();
                break;
            case DOWN:
                tankDown();
                break;
            case RIGHT:
                tankRight();
                break;
            case LEFT:
                tankLeft();
                break;
        }

        //开始线程
        new moveCD().start();
    }

    public void attack(){
        if (!attackCD_flag){
            MyPanel.shots.add(new Shot(Px, Py,tankDirection,BullrtSpeed,2,MyPanel));
            new attackCD().start();
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

    @Override
    public void PaintSelf(Graphics g) {
//        System.out.println("EnemyTank direction = "+direction);
        drawTank(Px, Py, g, tankDirection, 1);
        moveEnemyTank();
        attack();
    }

    @Override
    public Rectangle GetBoundary() {
        Rectangle rectangle;
        switch (tankDirection){
            case UP:
            case DOWN:
                rectangle = new Rectangle(Px, Py, width, height);
                break;
            case RIGHT:
            case LEFT:
                rectangle = new Rectangle(Px, Py, height, width);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + tankDirection);
        }
        return rectangle;
    }



}
