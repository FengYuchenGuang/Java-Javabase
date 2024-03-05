package CommonClasses.HomeWork;

/**
 * @author hxz
 * 将 Huang Xu Zhen 改成 Zhen,Huang .X
 * Han Shun Ping 改成 Ping,Han .S
 * 1、加入检验机制判断输入是否正确（ 方法检测，throw）
 */
public class homework03 {
    public static void main(String[] args) {
        String name1 = "Huang Xu Zhen";
        String name2 = "Han Shun Ping";

        //判断是否可以改成简写
        try {
            determine(name1);
            String[] s1 = name1.split(" ");
            char[] chars1 = s1[1].toCharArray();

            //、拼接出新名字，应该用StringBuffer s1[2] + "," + s1[0] + " ." + chars1[0]
            //拼接方法一
//            StringBuffer rename1 = new StringBuffer(s1[2]).append(",").
//                    append(s1[0]).append(" .").append(chars1[0]);
            //拼接方法二
//            String rename1 = s1[2] + "," + s1[0] + " ." + chars1[0];
            //************  拼接方法三 ***************
//            String rename1 =String.format("%s,%s .%c",s1[2],s1[0],chars1[0]);
            // 如果不判断大写，将中间改成大写
            String rename1 =String.format("%s,%s .%c",s1[2],s1[0],s1[1].toUpperCase().charAt(0));

            System.out.println(rename1);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



    }

    public static void determine(String name) {
        if (name == null){
            throw new RuntimeException("姓名不能为空...");
        }

        if (name.split(" ").length != 3) {
            throw new RuntimeException("姓名长度不对...");
        }

        String[] s1 = name.split(" ");
        char[] chars = s1[1].toCharArray();
        if (!(chars[0] >= 'A' && chars[0] <= 'Z')) {
            throw new RuntimeException("没有大写...");
        }

    }
}
