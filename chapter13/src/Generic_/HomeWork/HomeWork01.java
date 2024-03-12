package Generic_.HomeWork;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author hxz
 * 自定义泛型类 DAO<T>，其中定义一个Map成员变量，Map的键为String，
 * 值为T类型
 * 分别创建以下方法
 * 1、public void save(String id,T entity)：保存T类型对象到 Map成员变量中
 * 2、public T get(String id)：从 Map 中获取 id 对应的对象
 * 3、public void update(String id,T newentity)：
 * 替换 map 中 key为 id的内容，改为newentity对象
 * 4、public List<T> list()：返回 map中存放的所有 T 对象
 * 5、public void delete(String id)：删除指定 id 对象
 * <p>
 * 定义一个User类
 * 该类包括：private成员变量（int类型） id、age；（String类型）name
 * <p>
 * 创建DAO对象，分别调用 save、get、update、list、delete方法来操作User对象
 * <p>
 * 使用 Junit 单元测试类进行测试
 */
public class HomeWork01 {
    public static void main(String[] args) {

    }

    @Test
    public void testList() {
        DAO<User> dao = new DAO<>();
        User user1 = new User("hxz", 24, 1001);
        User user2 = new User("make", 18, 1002);
        User user3 = new User("hsp", 28, 1003);

        dao.save("001", user1);
        dao.save("002", user2);
        dao.save("003", user3);

        List<User> list = dao.list();
        System.out.println("list = " + list);

        //修改
        System.out.println("===update===");
        dao.update("003",new User("milan",99,1010));
        //重新导入list
        list = dao.list();
        System.out.println("list = " + list);

        //删除
        System.out.println("===delete===");
        dao.delete("002");
        //重新导入list
        list = dao.list();
        System.out.println("list = " + list);

    }
}

class DAO<T> {
    private Map<String, T> m = new HashMap<>();

    public void save(String id, T entity) {
        m.put(id, entity);
    }

    public T get(String id) {
        return m.get(id);
    }

    public void update(String id, T newentity) {
        m.replace(id, newentity);
    }

    //遍历map [k,v] 将map的所有vaule，封装到ArrayList返回即可
    public List<T> list() {
        //我自己写的
//        Collection<T> values = m.values();
//        List<T> list = (List<T>) values;
//        return list;

        //老师写的
        //创建 ArrayList
        List<T> list = new ArrayList<>();
        //遍历map 方法一
//        Collection<T> values = m.values();
//        Iterator<T> iterator = values.iterator();
//        while (iterator.hasNext()) {
//            T next = iterator.next();
//            list.add(next);
//        }
        //遍历map 方法二
        Set<String> strings = m.keySet();
        for (String key : strings) {
            list.add(m.get(key));
//            list.add(get(key)); //也可以这样写，直接调用DAO get
        }
        return list;
    }

    public void delete(String id) {
        m.remove(id);
    }
}

class User {
    private String name;
    private int age;
    private int id;

    public User(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
