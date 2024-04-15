package ManHanLou.utils;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author hxz
 */
public class TestUtils {

    @Test
    public void TestUtility() {
        //测试 Utility 工具类
        System.out.println("请输入一个整数：");
        int i = Utility.readInt();
        System.out.println("i = " + i);

    }

    @Test
    public void TestJDBCUtilsByDruid() throws SQLException {
        //测试 JDBCUtilsByDruid 工具类
        Connection connection = JDBCUtilsByDruid.getConnection();
        System.out.println(connection);

    }
}
