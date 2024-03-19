package studay.TankWar04;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.Vector;

/**
 * @author hxz
 */
public class Player1 extends Tank implements Serializable {
    int keyCode;
    boolean attackCollDown = false;
    Vector<Shot> shots = new Vector<>();

    public Player1(int px, int py, TankWar04 myPanel) {
        super(px, py, Direction.UP, myPanel);
    }

    public void attack() {
        if (!attackCollDown) {
            shots.add(new Shot(Px, Py, tankDirection, BullrtSpeed, 1, MyPanel));
            //冷却
            new attackCD().start();
        }
    }

    class attackCD extends Thread {
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
                tankDirection = Direction.UP;
                if (!IfOverlap(this, TankLabel.Player, Px, Py - speed,Direction.UP)) {
                    tankUp();
                }
                break;
            case KeyEvent.VK_DOWN:
                tankDirection = Direction.DOWN;
                if (!IfOverlap(this, TankLabel.Player, Px, Py + speed,Direction.DOWN)) {
                    tankDown();
                }
                break;
            case KeyEvent.VK_LEFT:
                tankDirection = Direction.LEFT;
                if (!IfOverlap(this, TankLabel.Player, Px - speed, Py,Direction.LEFT)) {
                    tankLeft();
                }
                break;
            case KeyEvent.VK_RIGHT:
                tankDirection = Direction.RIGHT;
                if (!IfOverlap(this, TankLabel.Player, Px + speed, Py,Direction.RIGHT)) {
                    tankRight();
                }
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

    //检测是否有需要移除的子弹
    private void removeShots() {
        Vector<Shot> removeShots = new Vector<>();
        for (Shot s : this.shots) {
            if (!(s.isAlive())) {
                removeShots.add(s);
            }
        }
        this.shots.removeAll(removeShots);
    }

    @Override
    public void PaintSelf(Graphics g) {
        if (!isAlive) {
            return;
        }
        drawTank(Px, Py, g, tankDirection, TankLabel.Player);
        movePlayer1();
        removeShots();
    }

    @Override
    public Rectangle GetBoundary() {
        Rectangle rectangle;
        switch (tankDirection) {
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
