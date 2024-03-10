package collect_.HomeWork;

import java.util.TreeSet;

/**
 * @author hxz
 * HashSet -> HashMap 分别如何实现去重的
 * TreeSet -> TreeMap 分别如何实现去重的
 *
 * 1、HashSet（即 HashMap）的去重机制：hashCode()+equals(),
 *    底层先通过存入对象，进行运算得到一个hash值，通过hash值，得到对应的索引
 *  如果发现索引对应所在位置，没有存入数据，则直接存放。
 *  如果有数据，就进行equals() （可重写，程序员决定）比较【遍历比较】，
 *    如果比较后不相同就加入，否则不加入
 * 2、TreeSet（即 TreeMap）的去重机制：如果你传入了一个 Comparator 匿名对象比较器，
 *    就使用实现的 compare 去比较，如果方法返回0，则认为是相同元素/数据，就不添加。
 *   如果没有传入一个Comparator匿名对象，则以你添加的对象(key 内容对象)，
 *   实现的 Comparator 接口的 compareTo去重
 */
@SuppressWarnings("all")
public class HomeWork04_QuChong {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        treeSet.add("hsp");
        treeSet.add("hxz");
        treeSet.add("tom");
        treeSet.add("king");
        treeSet.add("hxz");

        System.out.println(treeSet);
    }
}
