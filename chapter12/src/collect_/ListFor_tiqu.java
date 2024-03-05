package collect_;

import java.util.*;
/**
 * @author hxz
 * List 接口的实现子类 Vector LinkedList ArrayList
 *      都可以用以下三种遍历方法
 */
public class ListFor_tiqu {
    public static void main(String[] args) {
        //List 接口的实现子类 Vector LinkedList ArrayList
        // 都可以用以下三种遍历方法

        //List list = new ArrayList()
        //List list = new Vector();
        List list = new LinkedList();
        list.add("jack");
        list.add("tom");
        list.add("鱼香肉丝");
        list.add("北京烤鸭子");

        //遍历
        //1. 迭代器
        System.out.println("=====迭代器=====");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }

        //2. 增强 for
        System.out.println("=====增强 for=====");
        for (Object o : list) {
            System.out.println("o=" + o);
        }

        //3. 使用普通 for
        System.out.println("=====普通 for====");
        for (int i = 0; i < list.size(); i++){
            System.out.println("对象=" + list.get(i));
        }

    }
}
