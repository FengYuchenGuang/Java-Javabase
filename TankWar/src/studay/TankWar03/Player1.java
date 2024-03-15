package studay.TankWar03;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author hxz
 */
public class Player1 extends Tank {
    int keyCode;
    boolean attackCollDown = false;

    public Player1(int px, int py, TankWar03 myPanel) {
        super(px, py, Direction.UP, myPanel);
    }

    public void attack() {
        if (!attackCollDown){
            MyPanel.shots.add(new Shot(Px, Py,tankDirection,BullrtSpeed,1,MyPanel));
            //冷却
            new attackCD().start();
        }
    }

    class  attackCD extends  Thread{
        @Override
        public void run() {
            //将攻击状态设置为冷却时间
            attackCollDown = true;

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //将攻击状态设置为冷却时间
            attackCollDown = false;
        }


    }


    public void movePlayer1() {
        switch (keyCode) {
            case KeyEvent.VK_UP:
                if (moveToBoundary()){
                    break;
                }
                tankUp();
                break;
            case KeyEvent.VK_DOWN:
                if (moveToBoundary()){
                    break;
                }
                tankDown();
                break;
            case KeyEvent.VK_LEFT:
                if (moveToBoundary()){
                    break;
                }
                tankLeft();
                break;
            case KeyEvent.VK_RIGHT:
                if (moveToBoundary()){
                    break;
                }
                tankRight();
                break;
            case KeyEvent.VK_SPACE:
                attack();
                break;
        }
    }

    public void keyPress(KeyEvent e) {
        keyCode = e.getKeyCode();
    }

    public void keyRelease(KeyEvent e) {
        keyCode = 666;
    }

    @Override
    public void PaintSelf(Graphics g) {
        if (!isAlive){
            return;
        }
        drawTank(Px, Py, g, tankDirection, 0);
        movePlayer1();
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
