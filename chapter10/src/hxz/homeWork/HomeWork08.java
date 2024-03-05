package hxz.homeWork;

/**
 * @author hxz
 * 枚举
 * 在switc语法中使用枚举
 */
public class HomeWork08 {
    public static void main(String[] args) {
        Color08.RED.showColor();
        Color08.BLUE.showColor();
        Color08.BLACK.showColor();
        Color08.YELLOW.showColor();
        Color08.GREEN.showColor();


        //使用switch语法
        Color08 red = Color08.RED;
        red.showColor();

        System.out.println("======switch语法 使用枚举类=======");
        switch (red){
            case RED:
                System.out.println("匹配到红色...");
                break;
            case BLUE:
                System.out.println("匹配到蓝色...");
                break;
            case YELLOW:
                System.out.println("匹配到黄色...");
                break;
            default:
                System.out.println("没有匹配到颜色...");
                break;
        }


    }
}

enum Color08 implements myinterface08 {
    RED(255, 0, 0), BLUE(0, 0, 255),
    BLACK(0, 0, 0), YELLOW(255, 255, 0),
    GREEN(0, 255, 0);
    private int redValue;
    private int greenValue;
    private int blueValue;

    private Color08(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void showColor() {
        System.out.println("颜色：" + name() + "  " +
                "对应数值为 (" + redValue + "," +
                greenValue + "," + blueValue + ")");
    }
}

interface myinterface08 {
    void showColor();
}