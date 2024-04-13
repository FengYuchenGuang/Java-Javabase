package jdbc_.transaction_;

import jdbc_.JDBCUtils;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author hxz
 * 演示 jdbc 中如何使用事务
 */
public class jdbc08 {
    //没有使用事务.
    @Test
    public void noTransaction() {
        //操作转账的业务
        //1. 得到连接
        Connection connection = null;
        //2. 组织一个 sql
        String sql = "update account set balance = balance - 100 where id = 1";
        String sql2 = "update account set balance = balance + 100 where id = 2";
        PreparedStatement preparedStatement = null;
        //3. 创建 PreparedStatement 对象
        try {
            connection = JDBCUtils.getConnection(); // 在默认情况下，connection 是默认自动提交
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate(); // 执行第 1 条 sql
            int i = 1 / 0; //抛出异常
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate(); // 执行第 3 条 sql
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }

    //事务来解决
    @Test
    public void useTransaction() {
        //操作转账的业务
        //1. 得到连接
        Connection connection = null;
        //2. 组织一个 sql
        String sql = "update account set balance = balance - 100 where id = 1";
        String sql2 = "update account set balance = balance + 100 where id = 2";
        PreparedStatement preparedStatement = null;
        //3. 创建 PreparedStatement 对象
        try {
            connection = JDBCUtils.getConnection(); // 在默认情况下，connection 是默认自动提交
            //将 connection 设置为不自动提交
            connection.setAutoCommit(false); //开启了事务
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate(); // 执行第 1 条 sql
            int i = 1 / 0; //抛出异常
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate(); // 执行第 3 条 sql
            //这里提交事务
            connection.commit();
        } catch (Exception e) {
            //这里我们可以进行回滚，即撤销执行的 SQL
            //默认回滚到事务开始的状态.
            System.out.println("执行发生了异常，撤销执行的 sql");
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
}
