package Generic_.CustomGenerics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hxz
 * 泛型方法的使用
 * 泛型方法，可以定义在普通类中, 也可以定义在泛型类中
 *
 * 泛型往往与重载一起使用
 * 泛型 形参个数相同，返回类型相同，但不同类型时（避免反复重载）
 * 重载 不同返回类型、不同个数的形参使用
 */
@SuppressWarnings("all")
public class CustomGenericMethods {
    public static void main(String[] args) {
        Car car = new Car();
        car.fly("宝马", 100);//当调用方法时，传入参数，编译器，就会确定类型
        System.out.println("=======");
        car.fly(300, 100.1);//当调用方法时，传入参数，编译器，就会确定类型

        //测试
        //T->String, R-> ArrayList
        Fish<String, ArrayList> fish = new Fish<>();
        fish.hello(new ArrayList(), 11.3f);
    }
}

//泛型方法，可以定义在普通类中, 也可以定义在泛型类中
class Car {//普通类

    public void run() {//普通方法
    }

    //说明 泛型方法
    //1. <T,R> 就是泛型
    //2. 是提供给 fly 使用的
    public <T, R> void fly(T t, R r) {//泛型方法
        System.out.println(t.getClass());//String
        System.out.println(r.getClass());//Integer
    }

    //说明 返回指定泛型的泛型方法
    //1. <T,R> 就是泛型
    //2. 是提供给 fly 使用的
    //
    //3. List<T> 返回 List类型，里面指定 T 类型数据
    public <T, R> List<T> flyss(T t, R r) {//泛型方法
        List<T> list = new ArrayList<>();
        System.out.println(t.getClass());//String
        System.out.println(r.getClass());//Integer

        return list;
    }
}

class Fish<T, R> {//泛型类

    public void run() {//普通方法
    }

    public <U, M> void eat(U u, M m) {//泛型方法
    }

    //说明
    //1. 下面 hi 方法不是泛型方法
    //2. 是 hi 方法使用了类声明的 泛型
    public void hi(T t) {
    }

    //泛型方法，可以使用类声明的泛型，也可以使用自己声明泛型
    public <K> void hello(R r, K k) {
        System.out.println(r.getClass());//ArrayList
        System.out.println(k.getClass());//Float
    }
}
