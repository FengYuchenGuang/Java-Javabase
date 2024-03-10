package collect_.Set_;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author hxz
 * 1、对于无参 TreeSet 集合还是无序的
 * 2、只有在初始化时，给 TreeSet设置一个比较器时，才会有序
 */
@SuppressWarnings("all")
public class TreeSet_ {
    public static void main(String[] args) {
        //老韩解读
        //1. 当我们使用无参构造器，创建 TreeSet 时，仍然是无序的
        //2. 老师希望添加的元素，按照字符串大小来排序
        //3. 使用 TreeSet 提供的一个构造器，可以传入一个比较器(匿名内部类)
        // 并指定排序规则

        //4. 简单看看源码
        //老韩解读
        /*
        1. 构造器把传入的比较器对象，赋给了 TreeSet 的底层的 TreeMap 的属性 this.comparator
            public TreeMap(Comparator<? super K> comparator) {
                this.comparator = comparator;
            }
        2. 在 调用 treeSet.add("tom"), 在底层会执行到

            if (cpr != null) {//cpr 就是我们的匿名内部类(对象)
                do {
                    parent = t;
                    //动态绑定到我们的匿名内部类(对象)compare
                    cmp = cpr.compare(key, t.key);
                    if (cmp < 0)
                    t = t.left;
                    else if (cmp > 0)
                    t = t.right;
                    else //如果相等，即返回 0,这个 Key 就没有加入
                    return t.setValue(value);
                } while (t != null);
            }
        */

        //对于无参 TreeSet 集合还是无序的
        // TreeSet treeSet = new TreeSet();

        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //下面 调用 String 的 compareTo 方法进行字符串大小比较
                //如果老韩要求加入的元素，按照长度大小排序
                //return ((String) o2).compareTo((String) o1);
                return ((String) o1).length() - ((String) o2).length();
            }
        });

        //添加数据.
        treeSet.add("jack");
        treeSet.add("tom");//3
        treeSet.add("sp");
        treeSet.add("a");
        treeSet.add("abc");//3 加不进去，里面的setVaule是指PREASENT

        System.out.println("treeSet=" + treeSet);
    }
}
