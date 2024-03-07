package collect_.Map_;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author hxz
 * Map 接口常用方法
 * 1. Map 与 Collection 并列存在。用于保存具有映射关系的数据:Key-Value(双列元素)
 * 2. Map 中的 key 和 value 可以是任何引用类型的数据，会封装到 HashMap$Node 对象中
 * 3. Map 中的 key 不允许重复，原因和 HashSet 一样，前面分析过源码.
 *    当有相同的 k , 就等价于替换.
 * 4. Map 中的 value 可以重复
 * 5. Map 的 key 可以为 null, value 也可以为 null ，注意 key 为 null 只能有一个，value 为 null ,可以多个
 * 6. 常用 String 类作为 Map 的 key
 * 7. key 和 value 之间存在单向一对一关系，即通过指定的 key 总能找到对应的 value
 *
 * 下面以 HashMap 演示 Map 接口常用方法
 * 因此才会无序（添加和取出顺序不一致）
 *
 * 调用entrySet() 创建 EntrySet，方便遍历 Map
 */
@SuppressWarnings("all")
public class Map01 {
    public static void main(String[] args) {
        //老韩解读 Map 接口实现类的特点, 使用实现类 HashMap
        //1. Map 与 Collection 并列存在。用于保存具有映射关系的数据:Key-Value(双列元素)
        //2. Map 中的 key 和 value 可以是任何引用类型的数据，会封装到 HashMap$Node 对象中
        //3. Map 中的 key 不允许重复，原因和 HashSet 一样，前面分析过源码.
        //4. Map 中的 value 可以重复
        //5. Map 的 key 可以为 null, value 也可以为 null ，注意 key 为 null
        // 只能有一个，value 为 null ,可以多个
        //6. 常用 String 类作为 Map 的 key
        //7. key 和 value 之间存在单向一对一关系，即通过指定的 key 总能找到对应的 value
        Map map = new HashMap();
        map.put("no1", "韩顺平");//k-v
        map.put("no2", "张无忌");//k-v
        map.put("no1", "张三丰");//当有相同的 k , 就等价于替换.
        map.put("no3", "张三丰");//k-v
        map.put(null, null); //k-v
        map.put(null, "abc"); //等价替换
        map.put("no4", null); //k-v
        map.put("no5", null); //k-v
        map.put(1, "赵敏");//k-v
        map.put(new Object(), "金毛狮王");//k-v

        // 通过 get 方法，传入 key ,会返回对应的 value
        System.out.println(map.get("no2"));//张无忌

        System.out.println("map=" + map);

        /*
        本来在你第一次调用了 entrySet() 方法之前 EntrySet应该为 null

        但是！！！你一debug情况就悄悄发生了变化！！！
        当你创建hashMap对象map的代码一走完，debugger为了显示 map 内容到代码后面（即 map: {} )，
        马上暗中调用map.toString() ，而hashMap的toString继承自父类AbstractMap，
        执行的第一句就调用了entrySet()！！这时entrySet真的还是null，就会new EntrySet，
        然后赋给entrySet。所以早在你写 map.entrySet()之前，entrySet()已经被debugger调用过，
        map的entrySet变量已不为null了。

        可以在 IDEA -> setting -> build,... -> Debugger -> Data views -> java
        中 将 Enable'toString()' object view 的勾选取消，这是重新执行断点，
        在调用 map.entrySet() 之前 EntrySet 为 null
         */
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
        System.out.println(map.toString());
        Set set1 = map.keySet();

    }
}
