package collect_.List_;

import java.util.LinkedList;

/**
 * @author hxz
 * 链表 LinkedList
 * 1、LinkedList 底层维护的是一个双向链表
 * 具有双端队列的特点
 * 2、可以添加任意元素，包括 null 可重复
 * 3、LinkedList 线程不安全，没有实现同步
 *
 * LinkedList 底层结构
 * 1、底层维护的是一个双向链表
 * 2、维护了两个属性 first和 last 分别指向首节点和尾节点
 * 3、每个节点(Node对象)，里面又维护了prev、next、item三个属性
 * 其中通过 prev指向前一个，next指向下一个。最终实现双向链表
 * 4、LinkedList 元素的删除与添加不是通过数组完成的，相对效率较高。
 *
 * 下面模拟一个简单的双向链表 (自己编写 )
 */
public class LinkedList01 {
    public static void main(String[] args) {
        Node jack = new Node("jack");
        Node tom = new Node("tom");
        Node make = new Node("make");
        Node hxz = new Node("hxz");

        //连接四个节点，形成双向链表
        jack.next = tom;
        tom.next = make;
        make.next = hxz;
        hxz.prev = make;
        make.prev = tom;
        tom.prev = jack;

        Node first = jack;//让first引用指向jack，就是双向链表的头节点
        Node last = hxz;//让last引用指向hxz，就是双向链表的尾节点

        //演示从头到尾遍历
        System.out.println("=====演示从头到尾遍历=====");
        First_Last(first);

        //演示从尾到头遍历
        System.out.println("=====演示从尾到头遍历=====");
        Last_First(last);

        //链表添加一个数据
        //在 tom 和 mike 之间添加一个 "张飞"
        Node addName = new Node("张飞");
        tom.next=addName;
        addName.next=make;
        make.prev=addName;
        addName.prev=tom;

        //重新打印
        System.out.println("=====添加数据完成=====");
        //演示从头到尾遍历
        System.out.println("=====演示从头到尾遍历=====");
        First_Last(first);

        //演示从尾到头遍历
        System.out.println("\n=====演示从尾到头遍历=====");
        Last_First(last);


        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 10; i++) {

        }

    }

    public static void First_Last(Node first){
        while (true) {
            if (first == null) {
                break;
            }
            //输出信息
            System.out.println(first);
            first = first.next;
        }
    }

    public static void Last_First(Node last){
        while (true) {
            if (last == null) {
                break;
            }
            //输出信息
            System.out.println(last);
            last = last.prev;
        }
    }
}

//Node类 其中一个Node对象表示双向链表的一个节点
class Node {
    public Object item;
    public Node next;
    public Node prev;

    public Node(Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Node name = " + item;
    }
}