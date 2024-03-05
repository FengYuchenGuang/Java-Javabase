package Projects.hxz.ZeroMoneyPass;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainMenu extends User {
    Scanner scanner = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("#.00");
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    boolean flag = true;
    String choice;
    char exit;
    private MoneyDetail mdetail = new MoneyDetail();
    private double balance; //余额

    public MainMenu() {
    }

    public MainMenu(String name, double balance) {
        super(name);
        this.balance = balance;
    }

    public MainMenu(String name, long id, long password, double balance) {
        super(name, id, password);
        this.balance = balance;
    }

    //零钱通菜单
    public void ChangePassMenu() {

        do{
            System.out.println("\n============零钱通菜单============");
            System.out.println("          1 零钱通明细");
            System.out.println("          2 收益入账");
            System.out.println("          3 支出");
            System.out.println("          4 退出");
            System.out.println("请选择1~4：");
            choice = scanner.next();
            switch (choice) {
                case "1":
                    this.showDetail();
                    break;
                case "2":
                    this.inCome();
                    break;
                case "3":
                    this.payOut();
                    break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.println("选择有误，请重新选择");

            }

        }while (flag);
    }

    //显示明细
    public void showDetail() {
        System.out.println("用户：" + super.getName() + "您好，您的账单明细如下：");
        mdetail.showDetail();
    }

    //收入
    public void inCome() {
        System.out.println("请输入收入类型：");
        String str = scanner.next();
        System.out.println("收入金额：");
        double num = scanner.nextDouble();
        //判断收入是否合理

        LocalDateTime dateTime = LocalDateTime.now(); // get the current date and time
        String time = dateTime.format(formatter);
        System.out.println("账单添加成功，添加时间为：" + time);
        balance += num;

        //将这次信息添加进账单明细中
        mdetail.addDetail(mdetail.informationIntegration(str, num, time, balance));
    }

    //支出
    public void payOut() {
        System.out.println("请输入支出类型：");
        String str = scanner.next();
        System.out.println("支出金额：");
        double num = scanner.nextDouble();

        if (balance < num) {
            System.out.println("支出金额超出余额！！！无法支付");
        } else {
            LocalDateTime dateTime = LocalDateTime.now(); // get the current date and time
            String time = dateTime.format(formatter);
            System.out.println("账单添加成功，添加时间为：" + time);
            balance -= num;

            //将这次信息添加进账单明细中
            mdetail.addDetail(mdetail.informationIntegration(str, num, time, balance));
        }
    }

    public void exit(){
        //字符串形式要用 equals
        //尽量一段代码实现一个小功能，不要混在一起
        System.out.println("你确定要退出吗？y/n");
//        while (true){
//            exit = scanner.next().charAt(0);
//            if (exit == 'y') {
//                System.out.println("欢迎再次使用本系统！");
//                flag = false;
//                break;
//            } else if (exit == 'n') {
//                flag = true;
//                break;
//            } else {
//                System.out.println("请输入正确的 y/n ");
//            }
//        }
        //重复判断直到输入正确
        while (true){
            exit = scanner.next().charAt(0);
            if (exit == 'y' || exit == 'n'){
                break;
            }
            System.out.println("请输入正确的 y/n ");
        }
        //再次判断
        if (exit == 'y') {
            System.out.println("欢迎再次使用本系统！");
            flag = false;
        } else if (exit == 'n') {
            flag = true;
        }
        return;
    }
}
