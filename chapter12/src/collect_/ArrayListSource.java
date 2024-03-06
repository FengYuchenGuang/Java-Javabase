package collect_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author hxz
 * ArrayList底层结构和源码分析
 *  通过断点查看
 *
 *  源码底层使用 Aarrays.copyof( 原数组 , int 扩多大)
 *     输入数组的内容还是保留
 */
public class ArrayListSource {
    public static void main(String[] args) {
        //使用无参构造器创建ArrayList对象
        ArrayList arrayList = new ArrayList();
//        ArrayList list = new ArrayList(8);

        //for循环添加数据
        for (int i = 1; i <= 15; i++) {
            arrayList.add(i);
        }

        arrayList.add(100);
        arrayList.add(200);
        arrayList.add(null);

        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }

    }
}
