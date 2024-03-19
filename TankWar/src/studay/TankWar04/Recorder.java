package studay.TankWar04;

import java.io.*;
import java.util.Vector;

/**
 * @author hxz
 * ��¼����ܳɼ������ļ�����
 */
public class Recorder {
    //�����������¼�ҷ����ٵз�̹������
    private static int num = 0;
    private static int life = 10;
    //����IO����
    private static BufferedWriter bw = null;
    private static BufferedReader rw = null;
    private static String recordFile = "src\\studay\\TankWar04\\myRecord.txt";

    public static void loadRecordInfo(TankWar04 myPanel) throws IOException {
        //�ж��ļ��Ƿ����
        if (!(new File(recordFile).exists())) {
           return;
        }
        rw = new BufferedReader(new FileReader(recordFile));
        num = Integer.valueOf(rw.readLine());
        life = Integer.valueOf(rw.readLine());
        String info;
        while ((info = rw.readLine()) != null) {
//            System.out.println(info);
            //x=y=speed=label
            String[] split = info.split("=");
            int x = Integer.valueOf(split[0]);
            int y = Integer.valueOf(split[1]);
            int speed = Integer.valueOf(split[2]);
            if (split[3].equals("0")) {//0�ҷ�
                myPanel.player1 = new Player1(x, y, myPanel);
            } else if (split[3].equals("1")) {//1�з�
                myPanel.enemyTankList.add(new EnemyTank(x, y, speed, myPanel));
            }
        }
        rw.close();
    }

    public static void writeRecordInfo(TankWar04 myPanel) throws IOException {
        bw = new BufferedWriter(new FileWriter(recordFile));
        String info;
        bw.write(num + "");
        bw.newLine();
        bw.write(life + "");
        bw.newLine();
        for (EnemyTank enemyTank : myPanel.enemyTankList) {
            info = enemyTank.getPx() + "=" + enemyTank.getPy()
                    + "=" + enemyTank.getSpeed() + "=1";
            bw.write(info);
            bw.newLine();
        }
        info = myPanel.player1.getPx() + "=" + myPanel.player1.getPy()
                + "=" + myPanel.player1.getSpeed() +"=0";
        bw.write(info);

        bw.close();
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
