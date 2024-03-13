package studay.EventProcessing.MoveTank;

/**
 * @author hxz
 * 本次自己写时遇到的问题
 * 1、重绘时，上一个坦克还在，要先清空上一张图，然后重绘
 * 2、移动时有延迟，  检查后发现是因为 EnemyTank 没有添加线程
 *    在进行 EnemyTank 的移动冷却时，检测到按键按下，无法反应
 * 3、本方法实现运动的思路是，在窗体 start() 上 每50ms重绘一次，
 *    50ms期间检测到的按键，鼠标、等一系列操作，都会在重绘每一个对象的过程中，
 *    进行修改。
 *    因此，在主线程的50ms休眠过程中的操作会延后,或者检测到，但是因为延迟后操作取消
 *    因此，对于监听事件，每次检测到事件发生，进行改变后，就要进行repaint
 * 4、明白了新建线程的作用
 *    新线程执行 run()方法中的代码，主程序-主线程继续执行，不会阻塞
 */
public class MoveTank {
    public static void main(String[] args) {
        LoadTankMove loadTankMove = new LoadTankMove();
        loadTankMove.start();
    }
}


