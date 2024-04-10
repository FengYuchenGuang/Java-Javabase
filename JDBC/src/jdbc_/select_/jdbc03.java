package jdbc_.select_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author hxz
 * 演示 select 语句返回 ResultSet ,并取出
 */
public class jdbc03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
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
        String sql = "select id, name , sex, borndate from actor";
        //执行给定的 SQL 语句，该语句返回单个 ResultSet 对象
        /*
        +----+-----------+-----+---------------------+
        | id | name | sex | borndate |
        +----+-----------+-----+---------------------+-------+
        | 4 | 刘德华 | 男 | 1970-12-12 00:00:00 |
        | 5 | jack | 男 | 1990-11-11 00:00:00 |
        +----+-----------+-----+---------------------+-------+
        */

        /*
        老韩阅读 debug 代码 resultSet 对象的结构
        */
        ResultSet resultSet = statement.executeQuery(sql);

        //5. 使用 while 取出数据
        while (resultSet.next()) { // 让光标向后移动，如果没有更多行，则返回 false
//            int id = resultSet.getInt(1); //获取该行的第 1 列
//            String name = resultSet.getString(2);//获取该行的第 2 列
//            String sex = resultSet.getString(3);
//            Date date = resultSet.getDate(4);

            int id = resultSet.getInt("id"); //通过列名来获取值, 推荐
            String name = resultSet.getString("name"); //通过列名来获取值, 推荐
            String sex = resultSet.getString("sex"); //通过列名来获取值, 推荐
            //这里 Date 是 java.sql.Date
            Date date = resultSet.getDate("borndate"); //通过列名来获取值, 推荐
            System.out.println(id + "\t" + name + "\t" + sex + "\t" + date);
        }

        //6. 关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
