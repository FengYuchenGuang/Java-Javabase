package studay.TankWar04;

import java.awt.*;
import java.io.Serializable;

/**
 * @author hxz
 */
public abstract class GameObject implements Serializable {
    //界面
    protected TankWar04 MyPanel;
    boolean isAlive = true;

    //公共方法
    public abstract void PaintSelf(Graphics g);

    public abstract Rectangle GetBoundary();
}
