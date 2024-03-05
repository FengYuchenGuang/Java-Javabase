package hxz.homeWork;

/**
 * @author hxz
 * 静态变量，静态方法回顾
 */
public class HomeWork02 {
    public static void main(String[] args) {
        System.out.println(Frock.getNextNum()); // 1000100
        System.out.println(Frock.getNextNum()); // 1000200

        Frock frock1 = new Frock();
        Frock frock2 = new Frock();
        Frock frock3 = new Frock();

        System.out.println(frock1.getSerialNumber());// 1000300
        System.out.println(frock2.getSerialNumber());// 1000400
        System.out.println(frock3.getSerialNumber());// 1000500

    }
}

class Frock {
    private static int currentNum = 1000000;
    private int serialNumber;

    public Frock() {
        serialNumber = getNextNum();
    }

    public static int getNextNum() {
        currentNum += 100;
        return currentNum;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }
}
