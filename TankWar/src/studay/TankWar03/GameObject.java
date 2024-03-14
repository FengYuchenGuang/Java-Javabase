package studay.TankWar03;

import java.awt.*;

/**
 * @author hxz
 */
public abstract class GameObject {
    //界面
    protected TankWar03 MyPanel;

    //公共方法
    public abstract void PaintSelf(Graphics g);

    public abstract Rectangle GetBoundary();
}
