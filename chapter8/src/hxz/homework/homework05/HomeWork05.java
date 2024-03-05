package hxz.homework.homework05;

public class HomeWork05 {
    public static void main(String[] args) {
        Worker worker = new Worker("大壮", 23, 6000, 13);
        Waiter waiter = new Waiter("小芳", 18, 5000, 13);
        Peasant peasant = new Peasant("老汉", 60, 2000, 10);
        Teacher teacher = new Teacher("孔乙己", 48, 8000);
        Scientist scientist = new Scientist("诺贝尔", 26, 50000, 16, 100000);

        worker.printInfo();
        waiter.printInfo();
        peasant.printInfo();
        teacher.setSalMonth(14);
        teacher.setCourseDay(200);
        teacher.setCourseRemuneration(30);
        teacher.printInfo();
        scientist.printInfo();

    }
}
