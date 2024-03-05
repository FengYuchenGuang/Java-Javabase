package hxz.homeWork;

/**
 * @author hxz
 * 抽象类回顾
 */
public class HomeWork03 {
    public static void main(String[] args) {
        DogH02 dogH02 = new DogH02();
        CatH02 catH02 = new CatH02();

        dogH02.shout();
        catH02.shout();

    }
}

abstract class AnimalH02{
    public abstract void shout();
}

class DogH02 extends AnimalH02{
    @Override
    public void shout() {
        System.out.println("小狗汪汪叫...");
    }
}

class CatH02 extends AnimalH02{
    @Override
    public void shout() {
        System.out.println("小猫喵喵叫...");
    }
}
