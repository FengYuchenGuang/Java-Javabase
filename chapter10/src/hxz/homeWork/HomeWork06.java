package hxz.homeWork;

/**
 * @author hxz
 * 唐僧赶路交通工具
 * 马始终是同一匹马
 * 船每次得到新的
 * <p>
 * 使用工厂，可以增加程序拓展性
 * 3、添加 飞机 过火焰山
 * 代码改动非常少
 */
public class HomeWork06 {
    public static void main(String[] args) {
        Vehicles06 vehicle = new Factory06().getVehicles("赶路");
        Person06 person1 = new Person06("唐僧", vehicle);
        //化为一句话
        Person06 person2 = new Person06("朱八戒", new Factory06().getVehicles("2"));
        Person06 person3 = new Person06("孙悟空", new Factory06().getVehicles(2));
        Person06 person4 = new Person06("唐僧2", new Factory06().getVehicles(1));
        Person06 person5 = new Person06("孙悟空2", new Factory06().getVehicles(2));

        person1.show();
        person2.show();
        person3.show();
        person4.show();
        person5.show();

        //
        System.out.println("=========不断赶路=========");
        person1.common();
        person1.passRiver();
        person1.common();
        person1.passRiver();
        person1.passRiver();
        person1.passRiver();
        person1.fly();
        person1.common();
        person1.passRiver();
        person1.fly();
        person1.fly();
        person1.common();
        person1.common();
        person1.common();
        person1.passRiver();

    }
}

interface work06 {
    public void work();
}

abstract class Vehicles06 implements work06 {
}

class Horse06 extends Vehicles06 {
    @Override
    public void work() {
        System.out.println(" 骑马 正常赶路...");
    }
}

class Boat06 extends Vehicles06 {
    @Override
    public void work() {
        System.out.println(" 坐船 准备过河...");
    }
}

class Plane06 extends Vehicles06 {
    @Override
    public void work() {
        System.out.println(" 飞机 过火焰山...");
    }
}

class Person06 {
    private String name;
    private Vehicles06 tool;

    public Person06(String name, Vehicles06 tool) {
        this.name = name;
        this.tool = tool;
    }

    public void show() {
        if (tool == null) {
            System.out.println(name + " 没想好用什么交通工具...");
            return;
        }

        if (tool instanceof Horse06) {
            System.out.print(name);
            ((Horse06) tool).work();
            System.out.println("使用工具：" + tool);
        } else if (tool instanceof Boat06) {
            System.out.print(name);
            ((Boat06) tool).work();
            System.out.println("使用工具：" + tool);
        }else if (tool instanceof Plane06) {
            System.out.print(name);
            ((Plane06) tool).work();
            System.out.println("使用工具：" + tool);
        }
    }

    public void passRiver() {
        if (!(tool instanceof Boat06)) {
            Boat06 boat = Factory06.getBoat();
            System.out.print(name);
            boat.work();
            System.out.println("使用工具：" + boat);
            return;
        }
        System.out.print(name);
        ((Boat06) tool).work();
        System.out.println("使用工具：" + tool);
    }

    public void common() {
        if (!(tool instanceof Horse06)) {
            Horse06 horse = Factory06.getHorse();
            System.out.print(name);
            horse.work();
            System.out.println("使用工具：" + horse);
            return;
        }
        System.out.print(name);
        ((Horse06) tool).work();
        System.out.println("使用工具：" + tool);
    }

    public void fly() {
        if (!(tool instanceof Plane06)) {
            Plane06 plane = Factory06.getPlane();
            System.out.print(name);
            plane.work();
            System.out.println("使用工具：" + plane);
            return;
        }
        System.out.print(name);
        ((Plane06) tool).work();
        System.out.println("使用工具：" + tool);
    }


}

//交通工具工厂类，用于获取交通工具Horse06、Boat06
class Factory06 {
    //马始终是同一匹马
    private static Horse06 HORSE = new Horse06();


    //有两种判断方式
    //1、字符串 "赶路" 和 "过河"
    //2、int   1  2
    public Vehicles06 getVehicles(String str) {
        if ("赶路".equals(str)) {
            return HORSE;
        } else if ("过河".equals(str)) {
            return getBoat();
        } else if ("过火焰山".equals(str)) {
            return getPlane();
        }

        return null;
    }

    public Vehicles06 getVehicles(int num) {
        if (num == 1) {
            return HORSE;
        } else if (num == 2) {
            return getBoat();
        } else if (num == 3) {
            return getPlane();
        }

        return null;
    }

    public static Horse06 getHorse() {
        return HORSE;
    }

    public static Boat06 getBoat() {
        return new Boat06();
    }

    public static Plane06 getPlane() {
        return new Plane06();
    }
}
