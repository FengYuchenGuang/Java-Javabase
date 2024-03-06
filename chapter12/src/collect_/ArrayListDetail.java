package collect_;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author hxz
 * ArrayList
 * 1、可以放任何元素，包括 null ,并且多个
 * 2、ArrayList是由数组实现数据存储
 * 3、ArrayList基本等同于Vector
 * 但是ArrayList是线程不安全的（但执行效率高）
 * 在多线程情况下，不建议使用ArrayList
 * 4、满了会自动扩容。 1.5倍扩。
 *    如果初始无参ArrayList，那么为0
 *    此时添加内容时，先扩容到10
 */
public class ArrayListDetail {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(null);
        arrayList.add("hxz");
        arrayList.add(null);
        arrayList.add(1234);

        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println("obj = " + next);
        }
    }
}
