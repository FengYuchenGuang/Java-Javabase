package hxz.abstract_.AbstractClassDesignPattern;

public class Abtract01 {
    public static void main(String[] args) {
        AA aa = new AA();
        aa.calculateTime(); //这里还是需要有良好的 OOP 基础，对多态
        BB bb = new BB();
        bb.calculateTime();
    }
}
