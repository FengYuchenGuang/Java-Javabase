package jdbc_;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author hxz
 * 这是第一个 Jdbc 程序，完成简单操作
 */
public class jdbc01 {
    public static void main(String[] args) throws SQLException {

        //前置工作： 在项目下创建一个文件夹比如 libs
        // 将 mysql.jar 拷贝到该目录下，点击 add to project ..加入到项目中
        //1. 注册驱动
        Driver driver = new Driver(); //创建 driver 对象
        //2. 得到连接
        // 老师解读
        //(1) jdbc:mysql:// 规定好表示协议，通过 jdbc 的方式连接 mysql
        //(2) localhost 主机，可以是 ip 地址
        //(3) 3306 表示 mysql 监听的端口
        //(4) hsp_db03 连接到 mysql dbms 的哪个数据库
        //(5) mysql 的连接本质就是前面学过的 socket 连接
//        String url = "jdbc:mysql://localhost:3306/hsp_db03";
        //添加 ?useSSL=false 避免出现警告
        /*
            4月10日星期三15:07:58 CST 2024警告：
            不建议在没有服务器身份验证的情况下建立SSL连接。
            根据MySQL 5.5.45+、5.6.26+和5.7.6+的要求，
            如果没有设置显式选项，则默认情况下必须建立SSL连接。
            为了符合不使用SSL的现有应用程序，verifyServerCertificate属性设置为“false”。
            您需要通过设置useSSL=false来显式禁用SSL，
            或者设置useSSL=true并为服务器证书验证提供信任存储。
         */
        String url = "jdbc:mysql://localhost:3306/hsp_db03?useSSL=false";
        //将 用户名和密码放入到 Properties 对象
        Properties properties = new Properties();
        //说明 user 和 password 是规定好，后面的值根据实际情况写
        properties.setProperty("user", "root");// 用户
        properties.setProperty("password", "hxz"); //密码
        Connection connect = driver.connect(url, properties);

        //3. 执行 sql
        String sql = "insert into actor values(null, '刘德华', '男', '1970-11-11', '110')";
//        String sql = "update actor set name='周星驰' where id = 1";
//        String sql = "delete from actor where id = 1";
        //statement 用于执行静态 SQL 语句并返回其生成的结果的对象
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql); // 如果是 dml 语句，返回的就是影响行数
        System.out.println(rows > 0 ? "成功" : "失败");
        System.out.println("受影响行数 = " + rows);

        //4. 关闭连接资源
        statement.close();
        connect.close();
    }
}
