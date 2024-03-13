package studay.EventProcessing.MoveTank;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * @author hxz
 */
public class EnemyTank extends Tank {
    int EnemyMoveTime = 0;
    int RandomMoveTime = 6;
    boolean moveCD_flag = false;

    public EnemyTank(int px, int py) {
        super(px, py, Direction.DOWN);
    }

    public EnemyTank(int px, int py,int speed) {
        super(px, py, Direction.DOWN,speed);
    }

    /*
     *������߳�ʵ��̹���ƶ�CD
     *��ȴʱ��δ���޷����������ӵ������������ӵ��ߣ�������ȴʱ�䣩
     */
    class moveCD extends Thread {
        @SuppressWarnings("deprecation")
        public void run() {
            moveCD_flag = true;
            //����200ms
            try {
                Thread.sleep(400);

            }catch (Exception e) {
                e.printStackTrace();

            }

            moveCD_flag = false;
            //��ֹ�߳�
//            this.stop();
            //���е�����߳���Ȼ��ֹ
        }
    }

    class attCD extends Thread {

    }

    private void moveEnemyTank() {
        if (moveCD_flag){
            return;
        }

        if (EnemyMoveTime > RandomMoveTime) {
            tankDirection = RandomEnemyDirection();
            RandomMoveTime = new Random().nextInt(5) + 5;
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

        //��ʼ�߳�
        new moveCD().start();
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

    @Override
    public void PaintSelf(Graphics g) {
//        System.out.println("EnemyTank direction = "+direction);
        drawTank(Px, Py, g, tankDirection, 1);
        moveEnemyTank();
    }


}
