package hxz.Poly_.PolyParament;

public class PolyParameter {
    public static void main(String[] args) {
        Worker tom = new Worker("tom", 2500);
        Manager milan = new Manager("milan", 5000, 200000);
        PolyParameter ployParameter = new PolyParameter();
        ployParameter.showEmpAnnual(tom);
        ployParameter.showEmpAnnual(milan);

        ployParameter.testWork(tom);
        ployParameter.testWork(milan);
        "aaa".equals("aaaa");
    }

    //实现获取任何员工对象的年工资,并在 main 方法中调用该方法 [e.getAnnual()]
    public void showEmpAnnual(Employee e){
        System.out.println(e.getAnnual());
    }

    //添加一个方法，testWork,如果是普通员工，则调用 work 方法，如果是经理，则调用 manage 方法
    public void testWork(Employee e) {
        if (e instanceof Worker){
            ((Worker)e).work();
        }else if (e instanceof Manager){
            ((Manager)e).manage();
        }else{
            System.out.println("不做处理");
        }
    }
}
