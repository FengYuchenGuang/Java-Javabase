package CommunicationSystem.Client.QQView;

import CommunicationSystem.Client.Service.UserClientService;
import CommunicationSystem.Utils.Utility;

/**
 * @author hxz
 * 客户端的菜单界面
 */
public class QQView {
    private boolean loop = true;//控制是否显示一级主菜单
    private String key = "";//检测键盘输入
    //用于登录服务器与注册
    private UserClientService userClientService = new UserClientService();

    public static void main(String[] args) {
        new QQView().mainView();
    }

    //显示主菜单
    private void mainView() {

        while (loop) {
            System.out.println("===========欢迎登录网络通信系统===========");
            System.out.println("\t\t1 登录系统");
            System.out.println("\t\t2 退出系统");

            System.out.print("请输入你的选择：");
            key = Utility.readString(1);

            //根据输入处理
            switch (key) {
                case "1":
                    System.out.print("请输入用户号：");
                    String userID = Utility.readString(20);
                    System.out.print("请输入密  码：");
                    String userPWD = Utility.readString(20);
                    if (userClientService.checkUserLogin(userID,userPWD)) {
                        //登录成功进入二级用户菜单
                        userView(userID);
                    } else {
                        System.out.println("账号或密码错误，请重新输入！！！");
                    }
                    break;
                case "2":
                    break;
                case "9":
                    loop = false;
                    break;

            }
        }
    }

    private void userView(String uid) {
        System.out.println("===========欢迎进入二级菜单 用户(" + uid + ")===========");
        while (loop){
            System.out.println("\n============网络通信系统二级菜单============");
            System.out.println("\t\t1 显示在线用户列表");
            System.out.println("\t\t2 群发消息");
            System.out.println("\t\t3 私聊消息");
            System.out.println("\t\t4 发送文件");
            System.out.println("\t\t9 退出系统");

            System.out.print("请输入你的选择：");
            key = Utility.readString(1);

            switch (key){
                case "1":
                    System.out.println("显示在线用户列表");
                    break;
                case "2":
                    System.out.println("群发消息");
                    break;
                case "3":
                    System.out.println("私聊消息");
                    break;
                case "4":
                    System.out.println("发送文件");
                    break;
                case "9":
                    System.out.println("退出系统");
                    loop = false;
                    //关闭用户连接

                    break;
            }
        }
    }


    private boolean UserLogin(String uid,String pwd) {
        //到服务端验证该用户是否合法
        if ("hxz".equals(uid) && "123456".equals(pwd)){
            //可以登录，返回true
            return true;
        }

        return false;
    }
}
