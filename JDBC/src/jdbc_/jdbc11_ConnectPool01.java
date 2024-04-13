package jdbc_;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author hxz
 * c3p0 连接池的使用
 * xml加载文件
 * XML中特殊符号转义实体
 * 转义实体   符号      符号名称
 * &lt;      <        小于号
 * &gt;      >        大于号
 * &amp;     &          与
 * &apos;    '        单引号
 * &quot;    "        双引号
 */
public class jdbc11_ConnectPool01 {
    //方式 1： 相关参数，在程序中指定 user, url , password 等
    @Test
    public void testC3P0_01() throws Exception {
        //1. 创建一个数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        //2. 通过配置文件 mysql.properties 获取相关连接的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        //读取相关的属性值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        //给数据源 comboPooledDataSource 设置相关的参数
        //注意：连接管理是由 comboPooledDataSource 来管理
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        //设置初始化连接数
        comboPooledDataSource.setInitialPoolSize(10);
        //最大连接数
        comboPooledDataSource.setMaxPoolSize(50);
        //测试连接池的效率, 测试对 mysql 5000 次操作
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            //这个方法就是从 DataSource 接口实现的
            Connection connection = comboPooledDataSource.getConnection();
//            System.out.println("连接 OK");
            connection.close();
        }
        long end = System.currentTimeMillis();
        //c3p0 5000 连接 mysql 耗时=189
        System.out.println("c3p0 5000 连接 mysql 耗时=" + (end - start));
    }

    //第二种方式 使用配置文件模板来完成
    //1. 将 c3p0 提供的 c3p0-config.xml 拷贝到 src 目录下
    //2. 该文件指定了连接数据库和连接池的相关参数
    @Test
    public void testC3P0_02() throws SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("hxzPool");
        //测试 5000 次连接 mysql
        long start = System.currentTimeMillis();
        System.out.println("开始执行....");
        for (int i = 0; i < 500000; i++) {
            Connection connection = comboPooledDataSource.getConnection();
            //System.out.println("连接 OK~");
            connection.close();
        }
        long end = System.currentTimeMillis();
        //c3p0 的第二种方式(5000) 耗时=207
        System.out.println("c3p0 的第二种方式(500000) 耗时=" + (end - start));//1005
    }
}
