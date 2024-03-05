package hxz.LeaseOfHouses.View;

import hxz.LeaseOfHouses.domain.HouseInformation;
import hxz.LeaseOfHouses.Method.HouseMethod;
import hxz.LeaseOfHouses.utils.Utility;

public class HouseView {
    private boolean flag = true;
    private char choice;
    private HouseMethod method = new HouseMethod();
    private HouseInformation[] houselist;

    public void MainView() {
        method.AddHouse("Sjjs", 555, "sss", 6000, "为出租");
        method.AddHouse("bbs", 123, "rtt", 56.25, "出租");

        do {
            System.out.println("\n-------------房屋出租系统-------------");
            System.out.println("\t\t\t1 新增房源");
            System.out.println("\t\t\t2 查找房屋");
            System.out.println("\t\t\t3 删除房屋");
            System.out.println("\t\t\t4 修改房屋信息");
            System.out.println("\t\t\t5 房屋列表");
            System.out.println("\t\t\t6 退   出");
            System.out.println("请选择（1~6）：");

            choice = Utility.readMenuSelection();
            switch (choice) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    deleteHouse();
                    break;
                case '4':
                    modifyHouse();
                    break;
                case '5':
                    listHouse();
                    break;
                case '6':
                    flag = exit();
                    break;
                default:
                    System.out.println("请重新输入正确的选择(1~6)");
                    break;

            }

        } while (flag);
    }

    private void addHouse() {
        System.out.println("\n--------------添加房屋信息--------------");
        System.out.print("姓名：");
        String name = Utility.readString(6);
        System.out.print("电话：");
        long phone = Utility.readLong();
        System.out.print("位置：");
        String region = Utility.readString(8);
        System.out.print("租金：");
        double rent = Utility.readDouble();
        System.out.print("状态：");
        String state = Utility.readString(3);

        method.AddHouse(name, phone, region, rent, state);
        System.out.println("--------------添加房屋成功--------------");
    }

    public void findHouse() {
        System.out.println("--------------查找房屋--------------");
        System.out.print("请输入您要查找的id:");
        long id = Utility.readLong();
        int num = method.FindHouse(id);

        if (num != -1) {
            method.printHouse(num);
            return;
        }

        System.out.println("您要查找的房屋信息不存在...");
    }

    public void deleteHouse() {
        System.out.println("--------------删除房屋--------------");
        System.out.print("请选择待删除房屋编号(-1 退出)：");
        long id = Utility.readLong(-1);

        if (id == -1) {
            return;
        }

        //查找id是否存在
        int num = method.FindHouse(id);
        if (num != -1) {
            System.out.println("请确认是否删除(Y/N)：请小心选择");
            char c = Utility.readConfirmSelection();

            //Y / N
            if (c == 'Y') {
                method.DeleteHouse(id);
                System.out.println("=======成功删除========");
            }

        } else {
            System.out.println("您要删除的房屋编号不存在...");
        }
    }

    public void modifyHouse() {
        System.out.println("--------------修改房屋信息--------------");
        System.out.print("请选择待修改房屋编号(-1 退出)：");
        long id = Utility.readLong(-1);

        if (id == -1) {
            System.out.println("-------------放弃修改房屋信息-------------");
            return;
        }

        //查找id是否存在
        int num = method.FindHouse(id);
        if (num != -1) {
            HouseInformation[] h = method.getHouse();
            String owner = h[num].getOwner();
            long phone = h[num].getPhone();
            String region = h[num].getRegion();
            double rent = h[num].getRent();
            String state = h[num].getState();

            System.out.print("姓名(" + owner + ")：");
            owner = Utility.readString(6,"default");

            System.out.print("电话(" + phone + ")：");
            phone = Utility.readLong(-10086);

            System.out.print("位置(" + region + ")：");
            region = Utility.readString(8,"default");

            System.out.print("租金(" + rent + ")：");
            rent = Utility.readDouble(-123.123);

            System.out.print("状态(" + state + ")：");
            state = Utility.readString(3,"default");

            //如果 回车 (返回默认值)则表示不修改该条信息

            method.ModifyHouse(num,owner,phone,region,rent,state);
            System.out.println("房屋信息修改完毕...");

        } else {
            System.out.println("您要修改的房屋编号不存在...");
        }
    }

    public void listHouse(){
        System.out.println("==========房屋列表=========");
        houselist = method.getHouse();
        if (houselist == null) {
            System.out.println("没有任何房屋信息。。。");
            return;
        }

        for (int i = 0; i < houselist.length; i++) {
            System.out.println(houselist[i].info());
        }

        System.out.println("==========房屋列表打印完毕=========");

    }

    public boolean exit(){
        System.out.println("你确定要退出吗？y/n");
        char exit = Utility.readConfirmSelection();

        //再次判断
        if (exit == 'Y') {
            System.out.println("欢迎再次使用本系统！");
            return false;
        } else if (exit == 'N') {
            return true;
        }
        return true;

        //改成使用现成封装好的
//        System.out.println("你确定要退出吗？y/n");
//        //重复判断直到输入正确
//        while (true) {
//            exit = scanner.next().charAt(0);
//            if (exit == 'y' || exit == 'n') {
//                break;
//            }
//            System.out.println("请输入正确的 y/n ");
//        }
//        //再次判断
//        if (exit == 'y') {
//            System.out.println("欢迎再次使用本系统！");
//            return false;
//        } else if (exit == 'n') {
//            return true;
//        }
//        return true;
    }

}
