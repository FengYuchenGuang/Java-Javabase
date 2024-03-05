package hxz.Override_.exercise;

//编写一个 Student 类，继承 Person 类，增加 id、score 属性/private，
// 以及构造器，定义 say 方法(返回自我介绍的信息)
public class Student extends Person{
    private int id;
    private double score;

    public Student(String name, int age, int id, double score) {
        super(name, age);
        this.id = id;
        this.score = score;
    }

    //say
    public String say() { //这里体现 super 的一个好处，代码复用.
        return super.say() + " id=" + id + " score=" + score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
