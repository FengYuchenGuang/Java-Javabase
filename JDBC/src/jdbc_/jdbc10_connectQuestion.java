package jdbc_;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

/**
 * @author hxz
 */
public class jdbc10_connectQuestion {
    //代码 连接 mysql 5000 次
    @Test
    public void testCon() {
        //看看连接-关闭 connection 会耗用多久
        long start = System.currentTimeMillis();
        System.out.println("开始连接.....");
        for (int i = 0; i < 5000; i++) {
            //使用传统的 jdbc 方式，得到连接
            Connection connection = JDBCUtils.getConnection();
            //做一些工作，比如得到 PreparedStatement ，发送 sql
            //..........
            // 关闭
            JDBCUtils.close(null, null, connection);
        }
        long end = System.currentTimeMillis();
        System.out.println("传统方式 5000 次 耗时=" + (end - start));//传统方式 5000 次 耗时=3101
    }
}
