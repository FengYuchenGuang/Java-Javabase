package hxz.final_;


public class final01 {
    public static void main(String[] args) {
        // final 变量，只是该变量不能被修改，并不代表不能被继承
        D d = new D();
        System.out.println("D.nnn = " + D.nnn);
        System.out.println("d.nnn = " + d.nnn);

        E e = new E();
        //e.TAX_RATE = 0.09;
    }
}

//如果我们要求 A 类不能被其他类继承
//可以使用 final 修饰 A 类
//======== final 类 不能被继承=========
final class A {
}
//class B extends A {}  //错误！！！

class C {
    public final static int nnn = 66;

    //如果我们要求 hi 不能被子类重写
    //可以使用 final 修饰 hi 方法
    //======== final 方法 不能被重写=========
    public final void hi() {
    }  // final 不能被重写
}

class D extends C {
    // @Override
    // public void hi() {
    // System.out.println("重写了 C 类的 hi 方法.."); //不能被重写
    // }
}

//当不希望类的的某个属性的值被修改,可以用 final 修饰
//======== final 属性 不能被修改=========
class E {
    public final double TAX_RATE = 0.08;//常量
}

//当不希望某个局部变量被修改，可以使用 final 修饰
//======== final 局部变量 不能被修改=========
class F {
    public void cry() {
        //这时，NUM 也称为 局部常量
        final double NUM = 0.01;
        //NUM = 0.9;
        System.out.println("NUM=" + NUM);
    }
}