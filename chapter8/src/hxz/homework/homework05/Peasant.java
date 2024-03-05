package hxz.homework.homework05;

public class Peasant extends Employee {
    public Peasant() {
    }

    public Peasant(String name, int age, double salary, int salMonth) {
        super(name, age, salary, salMonth);
    }

    @Override
    public double totalSalary() {
        return super.totalSalary();
    }

    public void printInfo() {
        System.out.println("农民 " + getName() + " 的工资为：" + totalSalary());
    }
}
