package studay.EventProcessing02.MoveTank;

import java.awt.*;

/**
 * @author hxz
 */
public abstract class Tank {
    protected int Px;
    protected int Py;
    protected Direction tankDirection = Direction.UP;
    protected int speed = 5;

    public Tank(int px, int py, Direction direction) {
        Px = px;
        Py = py;
        this.tankDirection = direction;
    }

    public Tank(int px, int py, Direction tankDirection, int speed) {
        Px = px;
        Py = py;
        this.tankDirection = tankDirection;
        this.speed = speed;
    }

    //��������
    public abstract void PaintSelf(Graphics g);

    /*
     * ̹���ƶ��ķ���
     */
    public void tankUp() {
        tankDirection = Direction.UP;
        Py -= speed;
//        if(!hitWall(X,Y-speed) && !moveToBorder(X,Y-speed)) {
//            this.Y -= speed;
//        }
    }

    public void tankDown() {
        tankDirection = Direction.DOWN;
        Py += speed;
    }

    public void tankLeft() {
        tankDirection = Direction.LEFT;
        Px -= speed;
    }

    public void tankRight() {
        tankDirection = Direction.RIGHT;
        Px += speed;
    }


    //��д����������̹��
    /**
     * @param x ̹�˵����Ͻ� x ����
     * @param y ̹�˵����Ͻ� y ����
     * @param g ����
     * @param direct ̹�˷����������ң�
     * @param type ̹������
     */
    public void drawTank(int x, int y, Graphics g, Direction direct, int type) {
        //���ݲ�ͬ����̹�ˣ����ò�ͬ��ɫ
        switch (type) {
            case 0: //���ǵ�̹��
                g.setColor(Color.cyan);
                break;
            case 1: //���˵�̹��
                g.setColor(Color.yellow);
                break;
        }

        //����̹�˷���������̹��
        switch (direct) {
            case UP: //��ʾ����
                g.fill3DRect(Px, Py, 10, 60, false);//����̹���������
                g.fill3DRect(Px + 30, Py, 10, 60, false);//����̹���ұ�����
                g.fill3DRect(Px + 10, Py + 10, 20, 40, false);//����̹�˸���
                g.fillOval(Px + 10, Py + 20, 20, 20);//����Բ�θ���
                g.drawLine(Px + 20, Py + 30, Px + 20, Py);//������Ͳ
                break;
            case RIGHT: //��ʾ����
                g.fill3DRect(Px, Py, 60, 10, false);//����̹���������
                g.fill3DRect(Px, Py+30, 60, 10, false);//����̹���ұ�����
                g.fill3DRect(Px + 10, Py + 10, 40, 20, false);//����̹�˸���
                g.fillOval(Px + 20, Py + 10, 20, 20);//����Բ�θ���
                g.drawLine(Px + 30, Py + 20, Px+60, Py+20);//������Ͳ
                break;
            case DOWN: //��ʾ����
                g.fill3DRect(Px, Py, 10, 60, false);//����̹���������
                g.fill3DRect(Px + 30, Py, 10, 60, false);//����̹���ұ�����
                g.fill3DRect(Px + 10, Py + 10, 20, 40, false);//����̹�˸���
                g.fillOval(Px + 10, Py + 20, 20, 20);//����Բ�θ���
                g.drawLine(Px + 20, Py + 30, Px + 20, Py+60);//������Ͳ
                break;
            case LEFT: //��ʾ����
                g.fill3DRect(Px, Py, 60, 10, false);//����̹���������
                g.fill3DRect(Px, Py+30, 60, 10, false);//����̹���ұ�����
                g.fill3DRect(Px + 10, Py + 10, 40, 20, false);//����̹�˸���
                g.fillOval(Px + 20, Py + 10, 20, 20);//����Բ�θ���
                g.drawLine(Px + 30, Py + 20, Px, Py+20);//������Ͳ
                break;
            default:
                System.out.println("��ʱû�д���");
        }
    }
}
