package collect_.Set_;

/**
 * @author hxz
 * 自制一个 简单HashSet，了解结构
 * 数组+链表+红黑树
 */
@SuppressWarnings("all")
public class HashSet02_my {
    public static void main(String[] args) {
        //1.创建一个数组，数组类型为Node
        //2.有些人，将 Node[] 数组 称为 表 table
        Node[] table = new Node[8];
        //3.创建节点
        //通过断点查看创建过程
        Node jack = new Node("jack", null);

        table[2] = jack;
        Node jack1 = new Node("jack1", null);
        jack.next = jack1;//将jack1 挂载到 table[2] 中的链表上
        Node tom = new Node("tom", null);
        jack1.next = tom;

        System.out.println("table = " + table);


    }
}

//节点,存储数据 可以指向下一个节点形成 链表
class Node {
    public Object item;
    public Node next;

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node name = " + item;
    }
}
