package hxz.Enumeration_;

/**
 * @author hxz
 */
public class enum01 {
    public static void main(String[] args) {
        System.out.println(Season.AUTUMN);
        System.out.println(Season.SPRING);

        System.out.println(Season.WINTER.getName());
        System.out.println(Season.SUMMER.getName());
    }
}

//演示自定义枚举实现
class Season {//类
    private String name;
    private String desc;//描述
    //定义了四个对象, 固定.
    public static final Season SPRING = new Season("春天", "温暖");
    public static final Season WINTER = new Season("冬天", "寒冷");
    public static final Season AUTUMN = new Season("秋天", "凉爽");
    public static final Season SUMMER = new Season("夏天", "炎热");

    //1. 将构造器私有化,目的防止 直接 new
    //2. 去掉 setXxx 方法, 防止属性被修
    //3. 在 Season 内部，直接创建固定的对象
    //4. 优化，可以加入 final 修饰符
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
    public String getName() {
        return name;
    }
    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}