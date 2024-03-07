package collect_.Set_;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author hxz
 * Set 接口
 * 1、无序（添加和取出顺序不一致），没有索引
 * 2、不允许重复元素，所以也最多包含一个null
 * 3、Set接口也是 Collection的子接口因此常用方法和Collection一样
 *
 * 下面以 HashSet 演示Set接口的常用方法
 */
public class Set_Interface_for {
    public static void main(String[] args) {
        //老韩解读
        //1. 以 Set 接口的实现类 HashSet 来讲解 Set 接口的方法
        //2. set 接口的实现类的对象(Set 接口对象), 不能存放重复的元素, 可以添加一个 null
        //3. set 接口对象存放数据是无序(即添加的顺序和取出的顺序不一致)
        //4. 注意：取出的顺序的顺序虽然不是添加的顺序，但是他的固定.
        Set set = new HashSet();
        set.add("john");
        set.add("lucy");
        set.add("john");//重复
        set.add("jack");
        set.add("hsp");
        set.add("mary");
        set.add(null);//
        set.add(null);//再次添加 null
        for(int i = 0; i <10;i ++) {
            System.out.println("set=" + set);
        }

        //遍历
        // 与List中的三种遍历方式对比，Set只有两种 ListFor_tiqu.java
        //方式 1： 使用迭代
        System.out.println("=====使用迭代器====");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println("obj=" + obj);
        }
        set.remove(null);

        //方式 2: 增强 for
        System.out.println("=====增强 for====");
        for (Object o : set) {
            System.out.println("o=" + o);
        }

        //set 接口对象，不能通过索引来获取
    }
}
