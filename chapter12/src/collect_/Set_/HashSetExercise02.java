package collect_.Set_;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author hxz
 */
public class HashSetExercise02 {
    public static void main(String[] args) {
        /**
         定义一个 Employee 类，该类包含：private 成员属性 name,sal,age,birthday 要求:
         创建 3 个 Employee 对象放入 HashSet 中
         当 name 、age 和 birthday 的值相同时，认为是相同员工, 不能添加到 HashSet 集合中
         */
        HashSet hashSet = new HashSet();
        hashSet.add(new Employee02("milan", 3000,18,
                new MyDate(2001,4,26)));//ok
        hashSet.add(new Employee02("smith", 6000,28,
                new MyDate(2000,6,12)));//ok
        hashSet.add(new Employee02("milan", 3000,18,
                new MyDate(2001,4,26)));//加入不成功.

        // 回答,加入了几个? 2 个
        System.out.println("hashSet=" + hashSet);


    }
}

class Employee02 {
    private String name;
    private double sal;
    private int age;
    private MyDate brithday;

    public Employee02(String name, double sal, int age, MyDate brithday) {
        this.name = name;
        this.sal = sal;
        this.age = age;
        this.brithday = brithday;
    }

    public String showBri() {
        return name + " " + brithday.Bri();
    }

    @Override
    public String toString() {
        return "Employee02{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", age=" + age +
                ", brithday=" + brithday.Bri() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee02 that = (Employee02) o;
        return age == that.age &&
                Objects.equals(name, that.name) &&
                brithday.getYear() == that.brithday.getYear() &&
                brithday.getMonth() == that.brithday.getMonth() &&
                brithday.getDay() == that.brithday.getDay();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age,brithday.getYear(),brithday.getMonth(),brithday.getDay());
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String Bri() {
        return "生日是：" + year + "年" + month + "月" + day + "日";
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
