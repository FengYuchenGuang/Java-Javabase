package AlgorithmOptimization;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author hxz
 * 马踏棋盘
 * 骑士周游问题
 * <p>
 * x 从左往右
 * y 从上向下
 */
public class HorseChessBoard {
    //定义属性
    private static int x = 6; // col 列
    private static int y = 6; // row 行
    private static int[][] chessBoard = new int[y][x]; //棋盘
    private static boolean[] visites = new boolean[x * y];//表示记录某个位置是否走过
    private static boolean finished = false; //是否遍历完棋盘


    public static void main(String[] args) {
        // 2 2 用时 31423 ms
        int row = 2;
        int col = 2;
        //测试
        long start = System.currentTimeMillis();
        traversalChessBoard(chessBoard, row - 1, col - 1, 1);
        long end = System.currentTimeMillis();
        System.out.println("遍历耗时 = " + (end - start) + " ms");

        //输出当前棋盘情况
        for (int[] rows : chessBoard) {
            for (int step : rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }

    }

    //编写最核心的算法，遍历棋盘，如果遍历成功，就把 finished 设为 真
    //并且将每一步记录到棋盘中
    private static void traversalChessBoard(int[][] chessBoard, int row, int col, int step) {
        //先把step记录到 chessBoard
        chessBoard[row][col] = step;
        //把这个位置设置为已访问
        visites[row * x + col] = true;
        //获取当前这个位置可以走的下一步有哪些
        ArrayList<Point> ps = next(new Point(col, row)); // col - x , row - y
        //遍历
        while (!ps.isEmpty()) {
            //去除数列中剩下位置中的第一个
            Point p = ps.remove(0);
            //判断该位置是否走过，如果没有走过就递归遍历
            if (!visites[p.y * x + p.x]) {
                //递归遍历
                traversalChessBoard(chessBoard, p.y, p.x, step + 1);
            }
        }
        //当退出循环后，看是否遍历成功
        //如果没有成功，就重置相应值，然后进行回溯
        if (step < x * y && !finished) {
            //重置
            chessBoard[row][col] = 0;
            visites[row * x + col] = false;
        } else {
            finished = true;
        }

    }


    //编写方法，可以获取到当前位置，可以走的下一个步的所有位置（point 表示 x,y）
    private static ArrayList<Point> next(Point curPoint) {
        //创建一个 ArrayList<Point>
        ArrayList<Point> points = new ArrayList<>();

        //创建一个Point 对象(位置) 准备放入到 points
        Point p1 = new Point();

        //判断是否可以走如下位置，可以走，就将该点(point) 放入points

        //判断是否可以走5位置 (没有判断该位置是否已经走过)
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
            points.add(new Point(p1)); //每次放都有 new 不然 每次放的点变化后 之前的点都会跟着变化
        }
        //判断是否可以走6位置
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
            points.add(new Point(p1)); //每次放都有 new 不然 每次放的点变化后 之前的点都会跟着变化
        }
        //判断是否可以走7位置
        if ((p1.x = curPoint.x + 1) < x && (p1.y = curPoint.y - 2) >= 0) {
            points.add(new Point(p1)); //每次放都有 new 不然 每次放的点变化后 之前的点都会跟着变化
        }
        //判断是否可以走0位置
        if ((p1.x = curPoint.x + 2) < x && (p1.y = curPoint.y - 1) >= 0) {
            points.add(new Point(p1)); //每次放都有 new 不然 每次放的点变化后 之前的点都会跟着变化
        }
        //判断是否可以走1位置
        if ((p1.x = curPoint.x + 2) < x && (p1.y = curPoint.y + 1) < y) {
            points.add(new Point(p1)); //每次放都有 new 不然 每次放的点变化后 之前的点都会跟着变化
        }
        //判断是否可以走2位置
        if ((p1.x = curPoint.x + 1) < x && (p1.y = curPoint.y + 2) < y) {
            points.add(new Point(p1)); //每次放都有 new 不然 每次放的点变化后 之前的点都会跟着变化
        }
        //判断是否可以走3位置
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < y) {
            points.add(new Point(p1)); //每次放都有 new 不然 每次放的点变化后 之前的点都会跟着变化
        }
        //判断是否可以走4位置
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < y) {
            points.add(new Point(p1)); //每次放都有 new 不然 每次放的点变化后 之前的点都会跟着变化
        }

        return points;
    }

}
