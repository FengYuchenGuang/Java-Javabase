package CommonClasses.WrapperClass;

/**
 * @author hxz
 * 三元运算符算一个整体，类型要一致
 */
public class WrapperClassExercise01 {
    public static void main(String[] args) {
        Object obj1 = true? new Integer(123):new Double(23.4);
        System.out.println(obj1);

        Object obj2;
        if (true){
            obj2 = new Integer(123);
        }else{
            obj2 = new Double(23.4);
        }
        System.out.println(obj2);//1

        Integer integer = new Integer("1233"); //构造器将String -> Integer

        System.out.println(integer);


    }
}
