package hxz.Encapsulation;

//封装
public class encap01 {
    public static void main(String[] args) {
        Persion persion = new Persion();

        persion.setName("hxz");
        persion.setAge(24);
        int age = persion.getAge();

        System.out.println(persion.infoNameAge());
        Persion persion1 = new Persion("hsp",15,6000,"工程师");
        System.out.println(persion1.infoNameAge());


    }
}

class Persion {
    public String name;
    private int age;
    private double salary;
    private String job;

    public Persion() {
    }

    public Persion(String name) {
//        this.name = name;
        setName(name);
        this.name = getName();
    }

    public Persion(String name, int age, double salary, String job) {
//        this.name = name;
//        this.age = age;
//        this.salary = salary;
//        this.job = job;
        setName(name);
        setAge(age);
        setSalary(salary);
        setJob(job);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        //加入对名字的校验
        if (name.length() >= 2 && name.length() <= 6){
            this.name = name;
        }else{
            System.out.println("错误，请输入长度2~6之间的名字。");
            this.name = "张三";
        }

    }


    public void setAge(int age) {
        if (age <= 0 || age > 160) {
            System.out.println("设置的年龄不符合常理！请重新设置：（1~160）默认18岁");
            this.age = 18;
        } else {
            this.age = age;
        }
    }

    public int getAge() {
        return this.age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String infoNameAge() {
        return "信息为 name = " + this.name + " age = " + this.age;
    }
}
