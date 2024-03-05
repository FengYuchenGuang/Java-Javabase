package hxz.homeWork;

/**
 * @author hxz
 * 体现类与类内部关系的案例 类(内部类【成员内部类】)
 */
public class HomeWork07 {
    public static void main(String[] args) {
        Car07 car1 = new Car07(60);
        Car07 car2 = new Car07(-20);
        Car07 car3 = new Car07(30);

        car1.getAir().runflow();
        car2.getAir().runflow();
        car3.getAir().runflow();
    }
}

class Car07{
    private double temperature;

    public Car07(double temperature) {
        this.temperature = temperature;
    }

    class Air{
        public void runflow(){
            if (temperature > 40.0){
                System.out.println("空调开始工作，吹冷风...");
            }else if (temperature < 0.0){
                System.out.println("空调开始工作，吹热风...");
            }else{
                System.out.println("温度正常，空调不工作...");
            }
        }
    }

    public Air getAir(){
        return new Air();
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
