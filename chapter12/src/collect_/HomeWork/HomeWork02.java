package collect_.HomeWork;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author hxz
 * 使用 ArrayList完成对 对象 Car{name,price}的各种操作
 * add
 * remove
 * contains
 * size
 * isEmpty
 * clear
 * addAll
 * conyainsAll
 * removeAll
 * 使用增强 for和迭代器来遍历所有car，需要重新 toString
 */
@SuppressWarnings("all")
public class HomeWork02 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();

        Car02 car1 = new Car02("宝马", 800000);
        Car02 car2 = new Car02("宾利", 1600000);
        Car02 car3 = new Car02("兰博基尼", 2800000);


        System.out.println("======add ======");
        arrayList.add(car1);
        arrayList.add(car2);
        arrayList.add(car3);

        System.out.println("cars = " + arrayList);

        System.out.println("======remove ======");
        arrayList.remove(car1);
        System.out.println("cars = " + arrayList);

        System.out.println("======contains ======");
        System.out.println("contains \"兰博基尼\" = " + arrayList.contains(car3));

        System.out.println("======size ======");
        System.out.println("size = " + arrayList.size());

        System.out.println("======isEmpty ======");
        System.out.println("isEmpty = "+arrayList.isEmpty());

        System.out.println("======clear ======");
//        arrayList.clear();
//        System.out.println("cars = " + arrayList);

        System.out.println("======addAll ======");
        ArrayList arrayList1 = new ArrayList();
        Car02 car4 = new Car02("比亚迪", 79000);
        Car02 car5 = new Car02("五菱宏光", 40000);
        arrayList1.add(car4);
        arrayList1.add(car5);
        arrayList.addAll(arrayList1);
        System.out.println("cars = " + arrayList);

        System.out.println("======containsAll ======");
        System.out.println("containsAll = "+arrayList.containsAll(arrayList1));

        System.out.println("======removeAll ======");
        arrayList.removeAll(arrayList1);
        System.out.println("cars = " + arrayList);

        System.out.println("======增强for ======");
        for (Object car:arrayList){
            if (car instanceof Car02){
                Car02 getcar = (Car02)car;
                System.out.println(getcar);
            }
        }

        System.out.println("======迭代器 ======");
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object car = iterator.next();
            System.out.println(car);
        }

    }
}

class Car02 {
    private String name;
    private double price;

    public Car02(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ", price=" + price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
