package Generic_.Generic_info;

import java.util.ArrayList;

/**
 * @author hxz
 */
public class Generic02 {
    public static void main(String[] args) {
        //使用传统的方法来解决===> 使用泛型
        //老韩解读
        //1. 当我们 ArrayList<Dog> 表示存放到 ArrayList 集合中的元素是 Dog 类型 (细节后面说...)
        //2. 如果编译器发现添加的类型，不满足要求，就会报错
        //3. 在遍历的时候，可以直接取出 Dog 类型而不是 Object
        //4. public class ArrayList<E> {} E 称为泛型,那么 Dog->E
        ArrayList<Dog> arrayList = new ArrayList<Dog>();
        arrayList.add(new Dog("旺财", 10));
        arrayList.add(new Dog("发财", 1));
        arrayList.add(new Dog("小黄", 5));
        //假如我们的程序员，不小心，添加了一只猫
//        arrayList.add(new Cat("招财猫", 8));

        System.out.println("===使用泛型====");
        System.out.println("==== 可以直接取出Dog类型 =====");
        for (Dog dog : arrayList) {
            System.out.println(dog.getName() + "-" + dog.getAge());
        }
    }
}
