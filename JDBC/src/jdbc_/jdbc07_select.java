package jdbc_;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author hxz
 */
public class jdbc07_select {
    public static void main(String[] args) throws Exception{
        //通过 Properties 对象获取配置文件的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        //获取相关的值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        //1. 注册驱动
        Class.forName(driver);//建议写上

        //2. 得到连接
        Connection connection = DriverManager.getConnection(url, user, password);
        //3. 得到 Statement
        Statement statement = connection.createStatement();
        //4. 组织 SqL
        String sql = "select `name`, pwd from admin";
        //执行给定的 SQL 语句，该语句返回单个 ResultSet 对象
        ResultSet resultSet = statement.executeQuery(sql);

        //5. 使用 while 取出数据
        while (resultSet.next()) { // 让光标向后移动，如果没有更多行，则返回 false

            String name = resultSet.getString("name"); //通过列名来获取值, 推荐
            String pwd = resultSet.getString("pwd"); //通过列名来获取值, 推荐

            System.out.println(name + "\t\t\t" + pwd);
        }

        //6. 关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
