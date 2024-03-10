package collect_.HomeWork;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author hxz
 * 1、HashMap类 实例化一个 Map类型的对象 m key(String) vaule(int)
 * 分别用于存储员工的姓名和工资，存入数据如下：
 * jack-650元
 * tom-1200元
 * smith-2900元
 * 2、将jack工资更改为2600元
 * 3、为所有员工加薪100元
 * 4、遍历集合中所有员工
 * 5、遍历集合中所有工资
 */
@SuppressWarnings("all")
public class HomeWork03 {
    public static void main(String[] args) {
        Map hashMap = new HashMap();

        hashMap.put("jack", 650);   //int -> Integer
        hashMap.put("tom", 1200);   //int -> Integer
        hashMap.put("smith", 2900); //int -> Integer

        System.out.println(hashMap);

        //2、将jack工资更改为2600元
        System.out.println("=====2、将jack工资更改为2600元=====");
        //replace 方法
        hashMap.replace("jack", 2600);
        //put 但key一致，则指修改值，而不是添加
//        hashMap.put("jack",2600);
        System.out.println(hashMap);

        //3、为所有员工加薪100元
        System.out.println("=====3、为所有员工加薪100元=====");
        Set keySet = hashMap.keySet();
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            hashMap.replace(next, ((Integer) hashMap.get(next) + 100));
        }
        System.out.println(hashMap);

        //4、遍历集合中所有员工
        System.out.println("=====4、遍历集合中所有员工=====");
        Set keySet1 = hashMap.keySet();
        for (Object staff : keySet) {
            System.out.println(staff);
        }

        //5、遍历集合中所有工资
        System.out.println("=====5、遍历集合中所有工资=====");
        Set keySet2 = hashMap.keySet();
        Iterator iterator2 = keySet.iterator();
        while (iterator2.hasNext()) {
            Object next = iterator2.next();
            System.out.println(hashMap.get(next));
        }

        //遍历 Entry
        System.out.println("=====遍历 Entry=====");
        Set entrySet = hashMap.entrySet();
        Iterator iterator3 = entrySet.iterator();
        while (iterator3.hasNext()) {
            Map.Entry entry =  (Map.Entry) iterator3.next();
            System.out.println(entry.getKey()+"--"+entry.getValue());
        }
    }
}


