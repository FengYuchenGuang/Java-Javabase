package collect_.Set_;

import java.util.LinkedHashSet;
import java.util.Objects;
/**
 * @author hxz
 * LinkedHashSet
 * 1、添加数据与取出数据顺序一致，有序、但不能重复
 * 2、LinkedHashSet 底层维护的是 LinkedHashMap
 * 3、底层结构是 数组table + 双向链表
 * 4、第一次添加时，数组扩容到16，存放节点是 LinkedHashMap$Entry
 * 5、数组是 HashMap$Node[] 存放元素/数据是 LinkedHashMap$Entry
 *
 * 断点查看源码
 */
@SuppressWarnings("All")
public class LinkedHashSetSource_Exercise {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new Car("奥拓", 1000));//OK
        linkedHashSet.add(new Car("奥迪", 300000));//OK
        linkedHashSet.add(new Car("法拉利", 10000000));//OK
        linkedHashSet.add(new Car("奥迪", 300000));//加入不了
        linkedHashSet.add(new Car("保时捷", 70000000));//OK
        linkedHashSet.add(new Car("奥迪", 345000));//加入不了

        System.out.println("linkedHashSet=" + linkedHashSet);
    }
}

/**
 * Car 类(属性:name,price)， 如果 name 和 price 一样，
 * 则认为是相同元素，就不能添加。 5min
 */
class Car {
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
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

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    //重写 equals 方法 和 hashCode
    //当 name 和 price 相同时， 就返回相同的 hashCode 值, equals 返回 t
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.price, price) == 0 &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

}
