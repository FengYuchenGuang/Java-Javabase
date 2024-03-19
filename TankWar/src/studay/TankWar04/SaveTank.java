package studay.TankWar04;

/**
 * @author hxz
 */
public class SaveTank {
    private int x;
    private int y;
    private Direction direction;
    private int speed;
    private int label;

    public SaveTank(int x, int y, Direction direction, int speed, int label) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.speed = speed;
        this.label = label;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
