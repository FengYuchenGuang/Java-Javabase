package studay.TankWar05;

import java.awt.*;

/**
 * @author hxz
 */
public abstract class GameObject {
    //界面
    protected TankWar05 MyPanel;
    boolean isAlive = true;

    //公共方法
    public abstract void PaintSelf(Graphics g);

    public abstract Rectangle GetBoundary();
}
