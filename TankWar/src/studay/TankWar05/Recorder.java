package studay.TankWar05;

import java.io.*;
import java.util.Vector;

/**
 * @author hxz
 * 记录玩家总成绩，和文件交互
 */
public class Recorder {
    //定义变量，记录我方击毁敌方坦克数量
    private static int num = 0;
    private static int life = 10;
    //定义IO对象
    private static BufferedWriter bw = null;
    private static BufferedReader rw = null;
    private static String recordFile = "src\\studay\\TankWar05\\myRecord.txt";

    private static Vector<SaveTank> nodes = new Vector<>();

    public static void loadRecordInfo(TankWar05 myPanel) throws IOException {
        //判断文件是否存在
        if (!(new File(recordFile).exists())) {
            return;
        }
        rw = new BufferedReader(new FileReader(recordFile));
        num = Integer.parseInt(rw.readLine());
        life = Integer.parseInt(rw.readLine());
        String info;
        while ((info = rw.readLine()) != null) {
//            System.out.println(info);
            //x=y=speed=direction=label
            String[] split = info.split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            int d = Integer.parseInt(split[2]);//0123上下左右
            Direction direction = getTankDirection(d);
            int speed = Integer.parseInt(split[3]);
            int label = Integer.parseInt(split[4]);

            SaveTank node = new SaveTank(x, y, direction, speed, label);
            nodes.add(node);

        }
        rw.close();
    }

    public static void writeRecordInfo(TankWar05 myPanel) throws IOException {
        bw = new BufferedWriter(new FileWriter(recordFile));
        String info;
        bw.write(num + "");
        bw.newLine();
        bw.write(life + "");
        bw.newLine();
        for (EnemyTank enemyTank : myPanel.enemyTankList) {
            info = enemyTank.getPx() + " " + enemyTank.getPy()
                    + " " + enemyTank.getTankDirection()
                    + " " + enemyTank.getSpeed() + " 1";
            bw.write(info);
            bw.newLine();
        }
        if (myPanel.player1 != null){
            info = myPanel.player1.getPx() + " " + myPanel.player1.getPy()
                    + " " + myPanel.player1.getTankDirection() + " "
                    + myPanel.player1.getSpeed() + " 0";
            bw.write(info);
        }

        bw.close();
    }

    public static String getRecordFile() {
        return recordFile;
    }

    public static Vector<SaveTank> getNodes() {
        return nodes;
    }

    public static Direction getTankDirection(int d) {
        if (d == 0) {
            return Direction.UP;
        } else if (d == 1) {
            return Direction.DOWN;
        } else if (d == 2) {
            return Direction.LEFT;
        } else {
            return Direction.RIGHT;
        }
    }


    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        Recorder.num = num;
    }

    public static int getLife() {
        return life;
    }

    public static void setLife(int life) {
        Recorder.life = life;
    }

    public static void addDestroyNum() {
        Recorder.num++;
    }

    public static void minusDeathsNum() {
        Recorder.life--;
    }
}
