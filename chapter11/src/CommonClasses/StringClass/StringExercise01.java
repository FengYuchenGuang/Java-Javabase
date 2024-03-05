package CommonClasses.StringClass;

/**
 * @author hxz
 */
public class StringExercise01 {
    public static void main(String[] args) {
        //Test1
        System.out.println("============Test1===========");
        String a1 = "abc";
        String b1 = "abc";

        System.out.println(a1 == b1);
        System.out.println(a1.equals(b1));

        //Test2
        System.out.println("============Test2===========");
        String a2 = "abc";
        String b2 = new String("abc");

        System.out.println(a2 == b2);
        System.out.println(a2.equals(b2));

        System.out.println(a2 == b2.intern());
        System.out.println(b2 == b2.intern());


    }
}
