package collect_.Map_;

import java.util.Hashtable;

/**
 * @author hxz
 * HashMap 可以有 null
 * Hashtable 可以通过 k-v 存放数据，当然 key 和 value 不能为 null
 *
 * 简单说一下 HashTable 底层
 * 1、底层有 HashTable$Entry[] 默认初始化大小为11
 * 2、threshold 8 = 11 * 0.75
 *
 */
@SuppressWarnings("all")
public class HashTable01 {
    public static void main(String[] args) {
        //老韩解读
        //Hashtable 可以通过 k-v 存放数据，当然 key 和 value 不能为 null
        //增加
        Hashtable hashtable = new Hashtable();
//        hashtable.put(null, "abc");//抛出 空指针异常
//        hashtable.put("abc", null); //抛出 空指针异常
        hashtable.put("john", 100);//k-v
        hashtable.put("lucy", 100);
        hashtable.put("lic", 100);
        hashtable.put("lic", 88);//如果有相同的 key ， value 被替换

        System.out.println("hashtable=" + hashtable);


    }
}
