package hxz.homeWork;

/**
 * @author hxz
 */
public class HomeWork05 {
    public static void main(String[] args) {
        new A05().f1();
    }
}

class A05{
    private int name = 159;

    public void f1(){
        class BB {
            private final String name = "hxz";

            public void show(){
                System.out.println("A05 类的 f1方法 内部类中 name = " +name);
                System.out.println("A05 类的 私有属性 name = " +A05.this.name);
            }
        }

        BB bb = new BB();

        bb.show();

    }
}
