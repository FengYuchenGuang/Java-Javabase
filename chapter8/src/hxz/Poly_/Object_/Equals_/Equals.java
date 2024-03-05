package hxz.Poly_.Object_.Equals_;

public class Equals {
    public static void main(String[] args) {
        Person person1 = new Person("jack", 10, '男');
        Person person2 = new Person("jack", 10, '男');
        System.out.println(person1.equals(person2));
    }
}
