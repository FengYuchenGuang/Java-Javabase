package hxz.Exception_;

/**
 * @author hxz
 * 编写应用程序，接受命令行的两个参数（整数），计算两数相除
 * 要求使用cal(int n1,int n2) 方法
 * 对数据格式不正确，缺少命令行参数，除0 进行异常处理
 */
public class Exercise01 {
    public static void main(String[] args) {

        try {
            //先验证输入的 args 参数个数是否正确
            if (args.length != 2) {// 可能有 ArrayIndexOutOfBoundsException
                throw new ArrayIndexOutOfBoundsException("参数个数不对！！！");
            }

            //先把接收到的参数转成整数
            int n1 = Integer.parseInt(args[0]);// 可能有 NumberFormatException
            int n2 = Integer.parseInt(args[1]);

            //进行计算
            double res = cal(n1,n2); // 可能有 ArithmeticException
            System.out.println(n1 + " / " + n2 + " 计算结果为 " + res);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("异常类型为：" + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("参数格式不正确，需要输入整数");
        }catch (ArithmeticException e) {
            System.out.println("出现了除0异常");
        }


    }

    public static double cal(int n1, int n2) {
        return n1 / n2;
    }

}
