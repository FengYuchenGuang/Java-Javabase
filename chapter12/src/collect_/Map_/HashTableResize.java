package collect_.Map_;

import java.util.Hashtable;

/**
 * @author hxz
 * 扩容机制
 * 断点查看
 */
@SuppressWarnings("all")
public class HashTableResize {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("john", 100);//k-v
        hashtable.put("lucy", 100);
        hashtable.put("lic", 100);
        hashtable.put(4, 88);
        hashtable.put(5, 88);
        hashtable.put(6, 88);
        hashtable.put(7, 88);
        hashtable.put(8, 88);
        hashtable.put(9, 88);
        hashtable.put(10, 88);

    }
}
