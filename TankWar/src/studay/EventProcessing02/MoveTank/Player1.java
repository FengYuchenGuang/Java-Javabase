package studay.EventProcessing02.MoveTank;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author hxz
 */
public class Player1 extends Tank{
    int keyCode;

    public Player1(int px, int py) {
        super(px, py, Direction.UP);
    }


    public void movePlayer1(){
        switch (keyCode){
            case KeyEvent.VK_UP:
                tankUp();
                break;
            case KeyEvent.VK_DOWN:
                tankDown();
                break;
            case KeyEvent.VK_LEFT:
                tankLeft();
                break;
            case KeyEvent.VK_RIGHT:
                tankRight();
                break;
        }
    }

    public void keyPress(KeyEvent e){
        keyCode = e.getKeyCode();
    }

    public void keyRelease(KeyEvent e){
        keyCode = 666;
    }

    @Override
    public void PaintSelf(Graphics g) {
        drawTank(Px,Py,g,tankDirection,0);
        movePlayer1();
    }
}
