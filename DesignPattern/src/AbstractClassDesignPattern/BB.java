package AbstractClassDesignPattern;

public class BB extends Template{

    //这里也去，重写了 Template 的 job 方法
    @Override
    public void job() {
        long num = 0;
        for (long i = 1; i <= 80000; i++) {
            num *= i;
        }
    }
}
