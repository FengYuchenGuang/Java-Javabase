package hxz.myLeaseOfHouses;

import java.util.Scanner;

public class HouseMethod {
    private Scanner scanner = new Scanner(System.in);
    //    private HouseInformation[] house = new HouseInformation[10];
    private HouseInformation[] house;
    private char exit;

    public HouseMethod() {

    }

    //新增房源
    public void AddHouse(String owner, long phone, String region, double rent, String state) {
        //house 为 null时
        if (house == null) {
            house = new HouseInformation[1];
            HouseInformation h = new HouseInformation(owner, phone, region, rent, state);
            house[0] = h;
            return;
        }

        //房屋信息不为空时
        int num = house.length;
        HouseInformation[] newhouse = new HouseInformation[num + 1];
        for (int i = 0; i < num + 1; i++) {
            if (i == num) {
                HouseInformation h = new HouseInformation(owner, phone, region, rent, state);
                newhouse[num] = h;

            } else {
                newhouse[i] = house[i];
            }
        }
        house = newhouse;
        newhouse = null;
    }


    //查找房屋
    public int findHouse(long id) {
        int num = house.length;

        for (int i = 0; i < num; i++) {
            if (id == house[i].getId()) {
                return i;
            }
        }
        return -1;
    }

    //删除房屋
    public void DeleteHouse(long id) {
        int num = house.length;
        int j = 0;
        HouseInformation[] newhouse = new HouseInformation[num - 1];
        for (int i = 0; i < num; i++) {
            if (house[i].getId() != id) {
                newhouse[j] = house[i];
                j++;
            }
        }
        house = newhouse;
        newhouse = null;
    }

    //修改房屋信息
    public void ModifyHouse(int num, String owner, long phone,
                            String region, double rent, String state) {
        house[num].setOwner(owner);
        house[num].setPhone(phone);
        house[num].setRegion(region);
        house[num].setRent(rent);
        house[num].setState(state);
    }

    //房屋列表
    public void showAllHouse() {
        System.out.println("==========房屋列表=========");
        if (house == null) {
            System.out.println("没有任何房屋信息。。。");
            return;
        }

        for (int i = 0; i < house.length; i++) {
            System.out.println(house[i].info());
        }

        System.out.println("==========房屋列表打印完毕=========");
    }

    //退出
    public boolean exit() {
        System.out.println("你确定要退出吗？y/n");
        //重复判断直到输入正确
        while (true) {
            exit = scanner.next().charAt(0);
            if (exit == 'y' || exit == 'n') {
                break;
            }
            System.out.println("请输入正确的 y/n ");
        }
        //再次判断
        if (exit == 'y') {
            System.out.println("欢迎再次使用本系统！");
            return false;
        } else if (exit == 'n') {
            return true;
        }
        return true;
    }

    //打印指定房屋信息
    public void printHouse(int num) {
        System.out.println(house[num].info());
    }

    public HouseInformation[] getHouse() {
        return house;
    }
}
