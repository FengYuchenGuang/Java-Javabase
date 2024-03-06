package collect_.List_;

import java.util.Iterator;
import java.util.Vector;

/**
 * @author hxz
 * Voctor
 * 1、 如果是无参构造器，那么默认容量为10，
 * 2、 如果满了，则两倍扩容
 * 3、如果设置容量，例如：8
 *    满了以后两倍扩容为16
 */
public class Vector01 {
    public static void main(String[] args) {
        //无参构造器
        Vector vector = new Vector();
//        Vector vector1 = new Vector(8);
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }

        vector.add(100);
        vector.add(200);
        vector.add(null);

        Iterator iterator = vector.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }

    }
}
