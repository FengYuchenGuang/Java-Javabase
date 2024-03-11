package Generic_.Generic_info;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

/**
 * @author hxz
 */

/**
 * 定义 Employee 类
 * 1) 该类包含：private 成员变量 name,sal,birthday，其中 birthday 为 MyDate 类的对象；
 * 2) 为每一个属性定义 getter, setter 方法；
 * 3) 重写 toString 方法输出 name, sal, birthday
 * 4) MyDate 类包含: private 成员变量 month,day,year；并为每一个属性定义 getter, setter 方法；
 * 5) 创建该类的 3 个对象，并把这些对象放入 ArrayList 集合中（ArrayList 需使用泛型来定义），对集合中的元素进
 * 行排序，并遍历输出：
 * <p>
 * 排序方式： 调用 ArrayList 的 sort 方法 , * 传入 Comparator 对象[使用泛型]，先按照 name 排序，
 * 如果 name 相同，则按生日日期的先后排序。【即：定制排序】
 * 有一定难度 15min , 比较经典 泛型使用案例 GenericExercise02.java
 */
public class GenericExercise02 {
    public static void main(String[] args) {
        ArrayList<Employee02> employees = new ArrayList<>();
        employees.add(new Employee02("milan", 9000, 6,
                new MyDate(1990, 3, 22)));
        employees.add(new Employee02("hxz", 35000, 18,
                new MyDate(2001, 4, 26)));
        employees.add(new Employee02("jack", 18000, 38,
                new MyDate(1977, 8, 6)));
        employees.add(new Employee02("hsp", 380000, 48,
                new MyDate(1980, 2, 18)));
        employees.add(new Employee02("hsj", 120000, 36,
                new MyDate(1980, 5, 18)));
        employees.add(new Employee02("hsk", 240000, 29,
                new MyDate(1980, 5, 28)));
        employees.add(new Employee02("hsl", 28909990, 19,
                new MyDate(1980, 5, 28)));

        employees.sort(new Comparator<Employee02>() {
            @Override
            public int compare(Employee02 o1, Employee02 o2) {
                //按照姓名长度进行排序（从小到大）
                int len = o1.getName().length() - o2.getName().length();
                if (len > 0) {
                    return 1;
                } else if (len < 0) {
                    return -1;
                }

                //姓名长度相同后, 再按照出生年月日排序（从小到大）
                //相减大于0，说明年龄小的在后面，因此要调换，return 1
                int year = o1.getBrithday().getYear() - o2.getBrithday().getYear();
                int month = o1.getBrithday().getMonth() - o2.getBrithday().getMonth();
                int day = o1.getBrithday().getDay() - o2.getBrithday().getDay();
                if (year < 0) {
                    return 1;
                } else if (year > 0) {
                    return -1;
                } else if (month < 0) {
                    return 1;
                } else if (month > 0) {
                    return -1;
                } else if (day < 0) {
                    return 1;
                } else if (day > 0) {
                    return -1;
                }

                //姓名长度，出生日期都相同则不变
                return 0;
            }
        });

        System.out.println("employess = " + employees);

        System.out.println("=====遍历=====");
        Iterator<Employee02> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee02 next = iterator.next();
            System.out.println(next);
        }
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
        return Objects.hash(name, age, brithday.getYear(), brithday.getMonth(), brithday.getDay());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getBrithday() {
        return brithday;
    }

    public void setBrithday(MyDate brithday) {
        this.brithday = brithday;
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