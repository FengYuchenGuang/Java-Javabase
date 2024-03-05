package hxz.homework.homework05;

public class Worker extends Employee{
    public Worker() {
    }

    public Worker(String name, int age, double salary, int salMonth) {
        super(name, age, salary, salMonth);
    }

    @Override
    public double totalSalary() {
        return super.totalSalary();
    }

    public void printInfo() {
        System.out.println("工人 " + getName() + " 的工资为：" + totalSalary());
    }
}
