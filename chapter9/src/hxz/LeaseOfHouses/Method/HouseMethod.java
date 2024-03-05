package hxz.LeaseOfHouses.Method;

import hxz.LeaseOfHouses.domain.HouseInformation;


//相比我自己写的，这里将ID在房屋方法类中赋值，
// 确实，房屋信息类，只记载每个房屋的信息，无法统计总体信息数量
public class HouseMethod {
    //    private HouseInformation[] house = new HouseInformation[10];
    private HouseInformation[] house;
    private long idCounter = 0;


    public HouseMethod() {
        AddHouse("111", 267, "nihao", 12000, "三个字");
        AddHouse("222", 044, "buxing", 8999, "不行");
    }


    //新增房源
    public void AddHouse(String owner, long phone, String region, double rent, String state) {
        //赋予新ID 不重复
        long id = ++idCounter;

        //house 为 null时
        if (house == null) {
            house = new HouseInformation[1];
            HouseInformation h = new HouseInformation(id, owner, phone, region, rent, state);
            house[0] = h;
            return;
        }

        //房屋信息不为空时
        int num = house.length;
        HouseInformation[] newhouse = new HouseInformation[num + 1];
        for (int i = 0; i < num + 1; i++) {
            if (i == num) {
                HouseInformation h = new HouseInformation(id, owner, phone, region, rent, state);
                newhouse[num] = h;

            } else {
                newhouse[i] = house[i];
            }
        }
        house = newhouse;
        newhouse = null;
    }


    //查找房屋
    public int FindHouse(long id) {
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

        //如果 回车 (返回默认值)则表示不修改该条信息
        if (!"default".equals(owner)) {
            house[num].setOwner(owner);
        }

        if (phone != -10086) {
            house[num].setPhone(phone);
        }

        if (!"default".equals(region)) {
            house[num].setRegion(region);
        }

        if (rent != -123.123) {
            house[num].setRent(rent);
        }

        if (!"default".equals(state)) {
            house[num].setState(state);
        }
    }


    //打印指定房屋信息
    public void printHouse(int num) {
        System.out.println(house[num].info());
    }

    //返回房屋列表房屋列表
    public HouseInformation[] getHouse() {
        return house;
    }
}
