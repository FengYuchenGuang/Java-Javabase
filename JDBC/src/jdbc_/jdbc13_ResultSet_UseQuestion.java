package jdbc_;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author hxz
 */
public class jdbc13_ResultSet_UseQuestion {
    //使用老师的土方法来解决 ResultSet =封装=> Arraylist
    @Test
//    public ArrayList<Actor> testSelectToArrayList() {
    public void testSelectToArrayList() {
        System.out.println("使用 druid 方式完成");
        //1. 得到连接
        Connection connection = null;
        //2. 组织一个 sql
        String sql = "select * from actor where id >= ?";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        ArrayList<Actor> list = new ArrayList<>();//创建 ArrayList 对象,存放 actor 对象
        //3. 创建 PreparedStatement 对象
        try {
            connection = JDBCUtilsByDruid.getConnection();
            System.out.println(connection.getClass());//运行类型 com.alibaba.druid.pool.DruidPooledConnection
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);//给?号赋值
            //执行, 得到结果集
            set = preparedStatement.executeQuery();
            //遍历该结果集
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");//getName()
                String sex = set.getString("sex");//getSex()
                Date borndate = set.getDate("borndate");
                String phone = set.getString("phone");
                //把得到的 resultset 的记录，封装到 Actor 对象，放入到 list 集合
                list.add(new Actor(id, name, sex, borndate, phone));
            }
            System.out.println("list 集合数据=" + list);
            for(Actor actor : list) {
                System.out.println("id=" + actor.getId() + "\t" + actor.getName() + "\t" +
                        actor.getSex() + "\t" + actor.getBorndate() + "\t" + actor.getPhone());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtilsByDruid.close(set, preparedStatement, connection);
        }
        //因为 ArrayList 和 connection 没有任何关联，所以该集合可以复用.
//        return list;
    }
}


class Actor{
    private int id;
    private String name;
    private String sex;
    private Date borndate;
    private String phone;

    public Actor() {
    }

    public Actor(int id, String name, String sex, Date borndate, String phone) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.borndate = borndate;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBorndate() {
        return borndate;
    }

    public void setBorndate(Date borndate) {
        this.borndate = borndate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
