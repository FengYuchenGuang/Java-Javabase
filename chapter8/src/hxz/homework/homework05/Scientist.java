package hxz.homework.homework05;

public class Scientist extends Employee{
    private double bonus;

    public Scientist() {
    }

    public Scientist(String name, int age, double salary, int salMonth, double bonus) {
        super(name, age, salary, salMonth);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double totalSalary() {
        return super.totalSalary() + bonus;
    }

    public void printInfo() {
        System.out.println("科学家 " + getName() + " 的工资为：" + totalSalary());
    }
}
