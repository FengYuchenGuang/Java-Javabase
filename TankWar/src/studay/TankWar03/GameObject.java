package studay.TankWar03;

import java.awt.*;

/**
 * @author hxz
 */
public abstract class GameObject {
    //����
    protected TankWar03 MyPanel;

    //��������
    public abstract void PaintSelf(Graphics g);

    public abstract Rectangle GetBoundary();
}
