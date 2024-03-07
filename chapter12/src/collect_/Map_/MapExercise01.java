package collect_.Map_;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author hxz
 * 使用 HashMap 添加 3 个员工对象，要求
 * 键：员工 id
 * 值：员工对象
 * <p>
 * 并遍历显示工资>18000 的员工(遍历方式最少两种)
 * 员工类：姓名、工资、员工 id
 */
@SuppressWarnings("all")
public class MapExercise01 {
    public static void main(String[] args) {
        //完成代码
        Map hashMap = new HashMap();
        //添加对象
        hashMap.put(1, new Emp("jack", 300000, 1));
        hashMap.put(2, new Emp("tom", 21000, 2));
        hashMap.put(3, new Emp("milan", 12000, 3));
        hashMap.put(4, new Emp("mike", 14220, 4));
        hashMap.put(5, new Emp("hxz", 22050, 5));

        //遍历 2 种方式
        //并遍历显示工资>18000 的员工(遍历方式最少两种)
        //1. 使用 keySet -> 增强 for
        Set keySet = hashMap.keySet();
        System.out.println("====第一种遍历方式====");
        for (Object key : keySet) {
            //判断该key 下得到的 value 是否为 Emp类型
            if (hashMap.get(key) instanceof Emp) {
                //先获取 value
                Emp emp = (Emp) hashMap.get(key);
                if (emp.getSal() > 18000) {
                    System.out.println(emp);
                }
            }
        }

        //2. 使用 EntrySet -> 迭代器
        // 体现比较难的知识点
        // 慢慢品，越品越有味道.
        Set entrySet = hashMap.entrySet();
        System.out.println("======迭代器1======");
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();

            System.out.println(next);

        }
        //重新指向
        System.out.println("======迭代器2======");
        iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            //================只有先 向下转型为 拥有getKey() 和 getValue()方法的 Map.Entry================
            //================才能再将 value 中的 薪水信息提取================
            //================因为这里 iterator.next() 返回的是 Node<K,V> 类型================
            //================static class Node<K,V> implements Map.Entry<K,V>================
            //================因此需要先向下转型为 拥有getKey() 和 getValue()方法的 Map.Entry================
            Map.Entry entry = (Map.Entry) iterator.next();
            //通过 entry 取得 key 和 value
            Emp emp = (Emp) entry.getValue();
            if (emp.getSal() > 18000) {
                System.out.println(emp);
            }
        }

    }
}


class Emp {
    private String name;
    private double sal;
    private int id;

    public Emp(String name, double sal, int id) {
        this.name = name;
        this.sal = sal;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "员工 " + name + " sal= " + sal + " id= " + id;
    }
}
