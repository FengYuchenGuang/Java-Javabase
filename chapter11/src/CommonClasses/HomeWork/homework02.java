package CommonClasses.HomeWork;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * @author hxz
 * 2、注册处理题
 * 2.1 输入用户名、密码、邮箱，如果输入信息正确，则提示注册成功
 * 否则生产异常对象
 * 要求：
 * 1、用户名长度为[2,3,4]
 * 2、密码长度为6，要求全部为数字 isDigital
 * 3、邮箱中包含@ 和. 并且@ 在. 的前面
 */
public class homework02 {
    public static void main(String[] args) {
        String name = null;
        String pwd = "123456";
        String email = "mike@163.com";
        try {
            System.out.println(userRegister(name,pwd,email));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String userRegister(String name, String pwd, String email) {
        //前置：不能为空
        if (!(name != null && pwd != null && email!=null)){
            throw new RuntimeException("参数不能为空...");
        }

        //1、用户名长度为[2,3,4]
        int userLength = name.length();
        if (!(userLength >= 2 && userLength <= 4)) {
            throw new RuntimeException("用户名长度不正确...");
        }

        //2、密码长度为6，要求全部为数字 新方法isDigital
        if (pwd.length() != 6) {
            throw new RuntimeException("密码长度应为6...");
        }
        MyisDigital(pwd);

//        if (!(pwd.length() == 6 && isDigital(pwd))){
//            throw new RuntimeException("密码长度为6，要求全部为数字");
//        }

        //3、邮箱中包含@ 和. 并且@ 在. 的前面
        int special1 = email.indexOf('@');
        int special2 = email.indexOf('.');
        if (!(special1 >0&&special2>special1)){
            throw  new RuntimeException("邮箱中应包含@ 和. 并且@ 在. 的前面");
        }

        return "注册成功...";
    }

    public static boolean MyisDigital(String pwd) {
        try {
            int p = Integer.parseInt(pwd);
        } catch (NumberFormatException e) {
            throw new RuntimeException("密码不全为数字...");
        }
        return true;
    }

    public static boolean isDigital(String pwd) {
        char[] chars = pwd.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                return false;
            }
        }
        return true;
    }
}
