package collect_.List_;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author hxz
 * 使用 LinkedList
 * LinkedList_CRUD 增删改查
 */
public class LinkedList_Method {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        // add 添加
        System.out.println("=========add 添加=========");
        for (int i = 0; i < 4; i++) {
            linkedList.add(i);
        }
        linkedList.add("jack");
        System.out.println("linkedList = " + linkedList);

        // remove 删除
        System.out.println("=========remove 删除=========");
        linkedList.remove(); //默认删除第一个节点  0 删除   //1 2 3 jack
        System.out.println("linkedList = " + linkedList);
        linkedList.remove(2) ; // 删除第三个元素 从0 开始  //1 2 jack
        System.out.println("linkedList = " + linkedList);

        // set 修改
        System.out.println("=========set 修改=========");
        linkedList.set(1,"tom");
        System.out.println("linkedList = " + linkedList);

        // get 提取 查找第几个元素
        System.out.println("=========get 提取=========");
        System.out.println("得到 = "+linkedList.get(2));

        //迭代器遍历
        System.out.println("=========迭代器遍历=========");
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }
}
