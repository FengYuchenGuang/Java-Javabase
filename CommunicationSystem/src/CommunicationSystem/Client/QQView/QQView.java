package CommunicationSystem.Client.QQView;

import CommunicationSystem.Client.Service.FileClientService;
import CommunicationSystem.Client.Service.MessageClientService;
import CommunicationSystem.Client.Service.UserClientService;
import CommunicationSystem.Utils.Utility;

/**
 * @author hxz
 * 客户端的菜单界面
 * <p>
 * 1、发送文件的时候出错了，报空指针异常。
 * 一定要注意谁发，就用谁的socket，谁收就用谁的socket
 *
 * 2、实现拓展功能
 *   2.1 实现离线留言
 *   2.2 实现离线发文件
 */
public class QQView {
    private boolean loop = true;//控制是否显示一级主菜单
    private String key = "";//检测键盘输入
    //用于登录服务器与注册
    private UserClientService userClientService = new UserClientService();
    //对象用户 私聊/群聊
    private MessageClientService messageClientService = new MessageClientService();
    // 发送文件
    private FileClientService fileClientService = new FileClientService();

    public static void main(String[] args) {
        new QQView().mainView();
        System.out.println("客户端退出系统...");
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
                    if (userClientService.checkUserLogin(userID, userPWD)) {
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
        String getUID;
        String content;
        System.out.println("===========欢迎进入二级菜单 用户(" + uid + ")===========");
        //登录以后先向服务器查找 是否有离线消息
        userClientService.getOfflineContent();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (loop) {
            System.out.println("\n============网络通信系统二级菜单============");
            System.out.println("\t\t1 显示在线用户列表");
            System.out.println("\t\t2 群发消息");
            System.out.println("\t\t3 私聊消息");
            System.out.println("\t\t4 发送文件");
            System.out.println("\t\t9 退出系统");

            System.out.print("请输入你的选择：");
            key = Utility.readString(1);

            switch (key) {
                case "1":
                    System.out.println("显示在线用户列表");
                    //使用一个方法，实现显示在线用户列表功能
                    //在 UserClientService 中实现所有面板方法
                    userClientService.getOnlineFriend();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case "2":
//                    System.out.println("群发消息");
                    System.out.print("请输入想对大家说的话：");
                    content = Utility.readString(100);
                    //调用一个方法，将消息封装成一个Message对象，发送给服务器
                    messageClientService.sendMessageToAll(uid, content);
                    break;
                case "3":
//                    System.out.println("私聊消息");
                    System.out.print("请输入您要私聊的用户(在线)：");
                    getUID = Utility.readString(20);
                    System.out.println("私聊消息：");
                    content = Utility.readString(100);
                    //编写一个方法，将消息发送给服务端
                    messageClientService.sendMessageToOne(uid, getUID, content);
                    break;
                case "4":
//                    System.out.println("发送文件");
                    System.out.print("请输入您想发送文件的用户(在线)：");
                    getUID = Utility.readString(20);
                    System.out.println("请输入发送文件的完整路径(形式 d:\\xx.jpg)：");
                    String src = Utility.readString(100);
                    System.out.println("请输入文件发送到对方的哪里，完整路径(形式 d:\\xx.jpg)：");
                    String dest = Utility.readString(100);
                    fileClientService.sendFileToOne(uid, getUID, src, dest);
                    break;
                case "9":
//                    System.out.println("退出系统");
                    loop = false;
                    //关闭用户连接
                    //调用一个方法，给服务器发送一个退出系统的 Message
                    userClientService.loginExit();
                    break;
            }
        }
    }


    private boolean UserLogin(String uid, String pwd) {
        //到服务端验证该用户是否合法
        if ("hxz".equals(uid) && "123456".equals(pwd)) {
            //可以登录，返回true
            return true;
        }

        return false;
    }
}
