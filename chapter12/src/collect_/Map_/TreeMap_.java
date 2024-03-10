package collect_.Map_;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author hxz
 * 使用默认的构造器，创建 TreeMap, 是无序的(也没有排序
 */
@SuppressWarnings("all")
public class TreeMap_ {
    public static void main(String[] args) {
        //使用默认的构造器，创建 TreeMap, 是无序的(也没有排序)
        /*
        老韩要求：按照传入的 k(String) 的大小进行排序
        */

        // TreeMap treeMap = new TreeMap();
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //按照传入的 k(String) 的大小进行排序
                //按照 K(String) 的长度大小排序
                //return ((String) o2).compareTo((String) o1);
                return ((String) o2).length() - ((String) o1).length();
            }
        });
        treeMap.put("jack", "杰克");
        treeMap.put("tom", "汤姆");
        treeMap.put("kristina", "克瑞斯提诺");
        treeMap.put("smith", "斯密斯");
        treeMap.put("hsp", "韩顺平");//加入不了(但会替换vaule值)

        System.out.println("treemap=" + treeMap);
    }
}
