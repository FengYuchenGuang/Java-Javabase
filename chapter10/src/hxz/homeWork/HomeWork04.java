package hxz.homeWork;

//匿名内部类是在方法中的

/**
 * @author hxz
 * 接口，匿名内部类回顾
 */
public class HomeWork04 {
    public static void main(String[] args) {
        new CellPhone().testWork01(1, 3);

        CellPhone cellPhone = new CellPhone();

        cellPhone.testWork02(new work() {
            @Override
            public int calculate(int n1, int n2) {
                return n1 + n2;
            }
        }, 2, 4);
    }
}

interface work {
    public int calculate(int n1, int n2);
}

//我自己写的，不对
//class CellPhone implements work{
//
//    @Override
//    public void calculate(int n1,int n2) {
//        System.out.println("CellPhone 正在计算...");
//    }
//
//    public void testWork(){
//        calculate();
//    }
//
//}

class CellPhone {

    //我写的
    public void testWork01(int num1, int num2) {

        int cal = new work() {
            @Override
            public int calculate(int n1, int n2) {
                return n1 + n2;
            }
        }.calculate(num1, num2);

        System.out.println("CellPhone 计算结果为 = " + cal);
    }

    //hsp
    public void testWork02(work w, int num1, int num2) {

        int cal = w.calculate(num1, num2);

        System.out.println("CellPhone 计算结果为 = " + cal);
    }
}