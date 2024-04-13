package jdbc_;

import org.junit.jupiter.api.Test;
import java.sql.*;

/**
 * @author hxz
 */
public class JDBCUtils_Use {
    @Test
    public void testSelect() {
        //1. 得到连接
        Connection connection = null; //下面获取
        //2. 组织一个 sql
        String sql = "select * from actor where id = ?";
//        String sql = "select * from actor where id = ?";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        //3. 创建 PreparedStatement 对象
        try {
            connection = JDBCUtils.getConnection();
            System.out.println(connection.getClass()); //com.mysql.jdbc.JDBC4Connection
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 4);//给?号赋值
            //执行, 得到结果集
            set = preparedStatement.executeQuery();
            //遍历该结果集
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");
                String sex = set.getString("sex");
                Date borndate = set.getDate("borndate");
                String phone = set.getString("phone");
                System.out.println(id + "\t" + name + "\t" + sex + "\t" + borndate + "\t" + phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.close(set, preparedStatement, connection);
        }
    }

    @Test
    public void testDML() {//insert , update, delete
        //1. 得到连接
        Connection connection = null;
        //2. 组织一个 sql
//        String sql = "update actor set name = ? where id = ?";
        String sql = "update actor set name = ? where id = ?";
        // 测试 delete 和 insert ,自己玩.
        PreparedStatement preparedStatement = null;
        //3. 创建 PreparedStatement 对象
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            //给占位符赋值
            preparedStatement.setString(1, "周星驰");
            preparedStatement.setInt(2, 4);
            //执行
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
}
