package collect_.Map_;

import java.util.Properties;

/**
 * @author hxz
 * Properties 还可以用于 从 xxx.properties 文件中，加载数据到Properties对象，
 *   并进行读取和修改
 * 说明：Properties 文件通常作为配置文件，这个知识点在 IO流举例
 */
@SuppressWarnings("all")
public class Properties_ {
    public static void main(String[] args) {
        //老韩解读
        //1. Properties 继承 Hashtable
        //2. 可以通过 k-v 存放数据，当然 key 和 value 不能为 null
        //增加
        Properties properties = new Properties();
//        properties.put(null, "abc");//抛出 空指针异常
//        properties.put("abc", null); //抛出 空指针异常
        properties.put("john", 100);//k-v
        properties.put("lucy", 100);
        properties.put("lic", 100);
        properties.put("lic", 88);//如果有相同的 key ， value 被替换

        System.out.println("properties=" + properties);
    }
}
