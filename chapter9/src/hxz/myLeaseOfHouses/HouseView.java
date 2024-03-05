package hxz.myLeaseOfHouses;

import hxz.myLeaseOfHouses.utils.Utility;
import hxz.myLeaseOfHouses.HouseMethod;

public class HouseView {
    private boolean flag = true;
    private char choice;
    private HouseMethod method = new HouseMethod();

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
                    AddHouse();
                    break;
                case '2':
                    FindHouse();
                    break;
                case '3':
                    deleteHouse();
                    break;
                case '4':
                    modifyHouse();
                    break;
                case '5':
                    method.showAllHouse();
                    break;
                case '6':
                    flag = method.exit();
                    break;
                default:
                    System.out.println("请重新输入正确的选择(1~6)");
                    break;

            }

        } while (flag);
    }

    private void AddHouse() {
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

    public void FindHouse() {
        System.out.println("--------------查找房屋--------------");
        System.out.print("请输入您要查找的id:");
        long id = Utility.readLong();
        int num = method.findHouse(id);

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
        int num = method.findHouse(id);
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
            return;
        }

        //查找id是否存在
        int num = method.findHouse(id);
        if (num != -1) {
            HouseInformation[] h = method.getHouse();
            String owner = h[num].getOwner();
            long phone = h[num].getPhone();
            String region = h[num].getRegion();
            double rent = h[num].getRent();
            String state = h[num].getState();

            System.out.print("姓名(" + owner + ")：");
            owner = Utility.readString(6);

            System.out.print("电话(" + phone + ")：");
            phone = Utility.readLong();

            System.out.print("位置(" + region + ")：");
            region = Utility.readString(8);

            System.out.print("租金(" + rent + ")：");
            rent = Utility.readDouble();

            System.out.print("状态(" + state + ")：");
            state = Utility.readString(3);

            method.ModifyHouse(num,owner,phone,region,rent,state);
            System.out.println("房屋信息修改完毕...");

        } else {
            System.out.println("您要修改的房屋编号不存在...");
        }
    }
}
