package collect_.HomeWork;

import java.util.TreeSet;

/**
 * @author hxz
 * 如果运行以下代码，会不会报异常
 * 会报异常，
 * TreeSet要对每次传进的对象的 key 进行比较判断是否相同，
 * 因此，要将 key 转化为
 * (Comparable<? super K>) k1
 * Comparable<? super K> k = (Comparable<? super K>) key;
 * 因此传进的 key 对象必须要实现 Comparable 接口
 */
@SuppressWarnings("all")
public class HomeWork05 {
    public static void main(String[] args) {
        //如果运行以下代码，会不会报异常
        TreeSet treeSet = new TreeSet();
        //实现 Comparable 接口
        treeSet.add(new Person05_2());
        //未实现 Comparable 接口，会报异常
        treeSet.add(new Person05_1());
    }
}

class Person05_1 {

}

//不会报异常 要实现 Comparable 接口
// 重写 compareTo 方法
class Person05_2 implements Comparable {
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
