package Generic_.CustomGenerics;

import java.util.Arrays;

/**
 * @author hxz
 * 泛型的使用
 * 1、普通成员可以使用泛型（属性、方法）
 * 2、使用泛型的数组，不能初始化
 * 3、静态方法中不能使用类的泛型
 * 4、泛型类的类型，是在创建对象时确定的，（因为创建对象时，
 *   需要指定确定的类型）
 * 5、如果在创建对象时，没有指定类型，则默认为 Object
 */
@SuppressWarnings("all")
public class CustomGenerics01 {
    public static void main(String[] args) {
        System.out.println("=====1、普通成员可以使用泛型（属性、方法）=====");


        System.out.println("\n=====2、使用泛型的数组，不能初始化=====");
        System.out.println("  因为还没有确定类型时，不知道要分配多大的地址");

        System.out.println("\n=====3、静态方法中不能使用类的泛型=====");
        System.out.println("  因为静态是和类相关的，在类加载时，对象还没有创建");
        System.out.println("  所以，如果静态方法和静态属性使用了泛型，JVM 就无法完成初始化");

        System.out.println("\n==4、泛型类的类型，是在创建对象时确定的，（因为创建对象时，需要指定确定的类型）==");
        //T=Double, R=String, M=Integer
        Tiger<Double, String, Integer> g = new Tiger<>("john");
        g.setT(10.9); //OK
        //g.setT("yy"); //错误，类型不对
        System.out.println(g);

        System.out.println("\n=====5、如果在创建对象时，没有指定类型，则默认为 Object=====");
        Tiger g2 = new Tiger("john~~");//OK T=Object R=Object M=Object
        g2.setT("yy"); //OK ,因为 T=Object "yy"=String 是 Object 子类
        System.out.println("g2= " + g2);
    }
}

//老韩解读
//1. Tiger 后面泛型，所以我们把 Tiger 就称为自定义泛型类
//2, T, R, M 泛型的标识符, 一般是单个大写字母
//3. 泛型标识符可以有多个.
//4. 普通成员可以使用泛型 (属性、方法)
//5. 使用泛型的数组，不能初始化
//6. 静态方法中不能使用类的泛型
class Tiger<T, R, M> {
    String name;
    R r; //属性使用到泛型
    M m;
    T t;

    //因为数组在 new 不能确定 T 的类型，就无法在内存开空间
//    T[] ts = new T[8];
    T[] ts;

    public Tiger(String name) {
        this.name = name;
    }

    public Tiger(R r, M m, T t) {//构造器使用泛型
        this.r = r;
        this.m = m;
        this.t = t;
    }

    public Tiger(String name, R r, M m, T t) {//构造器使用泛型
        this.name = name;
        this.r = r;
        this.m = m;
        this.t = t;
    }
    //因为静态是和类相关的，在类加载时，对象还没有创建
    //所以，如果静态方法和静态属性使用了泛型，JVM 就无法完成初始化
//    static R r2;
//    public static void m1(M m) {
//
//    }

    //方法使用泛型
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {//方法使用到泛型
        this.r = r;
    }

    public M getM() {//返回类型可以使用泛型.
        return m;
    }

    public void setM(M m) {
        this.m = m;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "name='" + name + '\'' +
                ", r=" + r +
                ", m=" + m +
                ", t=" + t +
                ", ts=" + Arrays.toString(ts) +
                '}';
    }
}

