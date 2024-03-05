package hxz.interface_;


public class Interface02 {
    public static void main(String[] args) {
        I02 i02 = new I02();
        i02.hi();
        i02.ok();
        i02.cry();
        System.out.println("====================");
        Inter02.cry1();

    }
}

class I02 implements Inter02{
    @Override
    public void hi() {
        System.out.println("I02 say hi...");
    }

    @Override
    public void cry() {
        System.out.println("I02 cry...");
    }

    public void mycry(){

    }

}