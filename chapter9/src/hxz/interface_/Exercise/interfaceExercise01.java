package hxz.interface_.Exercise;

//接口与父类的变量可以重名，使用时需要明确指定
public class interfaceExercise01 {
    public static void main(String[] args) {
        new C().pX();
    }
}

interface A { // 1min 看看
    int x = 0;
} //想到 等价 public static final int x = 0;
class B {
    int x = 1;
} //普通属性

class C extends B implements A {
    public void pX() {
        //System.out.println(x); //错误，原因不明确
        //可以明确的指定 x
        //访问接口的 x 就使用 A.x
        //访问父类的 x 就使用 super.x
        System.out.println("接口的 x = "+A.x + "\n父类的 x = " + super.x);
    }
}