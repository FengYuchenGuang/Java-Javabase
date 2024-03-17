package Properties_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author hxz
 * 读取 Properties 文件
 */
public class Properties01 {
    public static void main(String[] args) throws IOException {
        String fileName1 = "src\\mysql.properties";
        String fileName2 = "src/mysql.properties";
        //读取 mysql.properties 文件，并得到 ip, user 和 pwd
        BufferedReader br = new BufferedReader(new FileReader(fileName2));
        String line = "";
        while ((line = br.readLine()) != null) { //循环读取
//            System.out.println("=====全部打印=====");
//            System.out.println(line);

//            System.out.println("=====分开打印=====");
//            String[] split1 = line.split("=");
//            System.out.println(split1[0] + "值是: " + split1[1]);

//            System.out.println("=====寻找指定值=====");
            String[] split2 = line.split("=");
            //如果我们要求指定的 ip 值
            if("ip".equals(split2[0])) {
                System.out.println(split2[0] + "值是: " + split2[1]);
            }

            //如果我们要求指定的 user 值
            if("user".equals(split2[0])) {
                System.out.println(split2[0] + "值是: " + split2[1]);
            }

            //如果我们要求指定的 pwd 值
            if("pwd".equals(split2[0])) {
                System.out.println(split2[0] + "值是: " + split2[1]);
            }
        }
        br.close();
    }
}
