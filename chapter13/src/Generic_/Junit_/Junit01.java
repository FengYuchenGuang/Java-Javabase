package Generic_.Junit_;

import org.junit.jupiter.api.Test;

/**
 * @author hxz
 * 使用Junit
 * 作为单元测试工具，可以单独测试某个方法
 */
public class Junit01 {
    public static void main(String[] args) {
        //传统方式
//        new Junit01().m1();
//        new Junit01().m2();
//        new Junit01().m3();

        //使用Junit
        //加入@Test


    }
    @Test
    public void m1(){
        System.out.println("m1方法被调用...");
    }

    @Test
    public void m2(){
        System.out.println("m2方法被调用...");
    }

    @Test
    public void m3(){
        System.out.println("m3方法被调用...");
    }
}
