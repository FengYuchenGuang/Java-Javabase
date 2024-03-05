package hxz.Poly_.Object_.toString_;

public class toString_ {
    public static void main(String[] args) {
        Monster monster = new Monster("小妖怪","巡山",12300);

        System.out.println(monster.toString() + " hashcode=" + monster.hashCode());
        System.out.println("==当直接输出一个对象时，toString 方法会被默认的调用==");
        System.out.println(monster); //等价 monster.toStrin
    }
}
