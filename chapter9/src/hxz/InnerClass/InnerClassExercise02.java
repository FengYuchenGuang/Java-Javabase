package hxz.InnerClass;

public class InnerClassExercise02 {
    public static void main(String[] args) {
        /*
        1.有一个铃声接口 Bell，里面有个 ring 方法。(右图)
        2.有一个手机类 Cellphone，具有闹钟功能 alarmClock，参数是 Bell 类型(右图)
        3.测试手机类的闹钟功能，通过匿名内部类(对象)作为参数，打印：懒猪起床了
        4.再传入另一个匿名内部类(对象)，打印：小伙伴上课了
        */
        CellPhone cellPhone = new CellPhone();
        //老韩解读
        //1. 传递的是实现了 Bell 接口的匿名内部类 InnerClassExercise02$1
        //2. 重写了 ring
        //3. Bell bell = new Bell() {
        // @Override
        // public void ring() {
        // System.out.println("懒猪起床了");
        // }
        // }
        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });

        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课了");
            }
        });
    }
}

interface Bell{ //接口
    void ring();//方法
}

class CellPhone {//类

    public void alarmClock(Bell bell) {//形参是 Bell 接口类型
        System.out.println(bell.getClass());
        bell.ring();//动态绑定
    }
}
