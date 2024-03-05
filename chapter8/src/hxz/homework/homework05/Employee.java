package hxz.homework.homework05;

//一个员工类，用于打印全年员工工资
public class Employee {
    private String name;
    private int age;
    //每月工资
    private double salary;
    private int salMonth = 12;

    public Employee() {
    }

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Employee(String name, int age, double salary, int salMonth) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.salMonth = salMonth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getSalMonth() {
        return salMonth;
    }

    public void setSalMonth(int salMonth) {
        this.salMonth = salMonth;
    }

    //计算基础工资
    public double totalSalary(){
        return salary * salMonth;
    }
}
