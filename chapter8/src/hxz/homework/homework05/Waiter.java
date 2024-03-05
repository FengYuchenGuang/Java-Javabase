package hxz.homework.homework05;

public class Waiter extends Employee{
    public Waiter() {
    }

    public Waiter(String name, int age, double salary, int salMonth) {
        super(name, age, salary, salMonth);
    }

    @Override
    public double totalSalary() {
        return super.totalSalary();
    }

    public void printInfo() {
        System.out.println("服务员 " + getName() + " 的工资为：" + totalSalary());
    }
}
