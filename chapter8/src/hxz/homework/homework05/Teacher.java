package hxz.homework.homework05;

public class Teacher extends Employee {
    private double courseRemuneration;
    private int courseDay;

    public Teacher() {
    }

    public Teacher(String name, int age, double salary) {
        super(name, age, salary);
    }

    public Teacher(String name, int age, double salary, int salMonth, double courseRemuneration, int courseDay) {
        super(name, age, salary, salMonth);
        this.courseRemuneration = courseRemuneration;
        this.courseDay = courseDay;
    }

    public double getCourseRemuneration() {
        return courseRemuneration;
    }

    public void setCourseRemuneration(double courseRemuneration) {
        this.courseRemuneration = courseRemuneration;
    }

    public int getCourseDay() {
        return courseDay;
    }

    public void setCourseDay(int courseDay) {
        this.courseDay = courseDay;
    }

    @Override
    public double totalSalary() {
        return super.totalSalary() + courseDay * courseRemuneration;
    }

    public void printInfo(){
        System.out.println("教师 " + getName() + " 的工资为：" + totalSalary());
    }
}
