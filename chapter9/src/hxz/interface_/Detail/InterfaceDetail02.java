package hxz.interface_.Detail;

public class InterfaceDetail02 {
    public static void main(String[] args) {
        //老韩证明 接口中的属性,是 public static final
        System.out.println(IB.n1);//说明 n1 就是 static
        //IB.n1 = 30; 说明 n1 是 final
    }
}
//1、一个类同时可以实现多个接口
class Pig implements IB,IC {
    @Override
    public void hi() {
    }
    @Override
    public void say() {
    }
}

//2、接口中的属性,只能是 final 的，而且是 public static final 修饰符
//   接口中的属性为常量，不能修改
interface IB {

    int n1 = 10; //等价 public static final int n1 = 10;
    void hi();
}

interface IC {
    void say();
}

//3、接口不能继承其它的类,但是可以继承多个别的接口
interface ID extends IB,IC {
}

//4、接口的修饰符 只能是 public 和默认，这点和类的修饰符是一样的
interface IE{}



