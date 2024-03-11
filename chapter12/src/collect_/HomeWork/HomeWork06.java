package collect_.HomeWork;

import java.util.HashSet;
import java.util.Objects;
import java.util.Vector;

/**
 * @author hxz
 * 查看下面代码，看看运行结果是什么
 * ！！！易错
 */
@SuppressWarnings("all")
public class HomeWork06 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        Person06 p1 = new Person06(1001,"AA");
        Person06 p2 = new Person06(1002,"BB");
        hashSet.add(p1);
        hashSet.add(p2);
        p1.name = "CC";
        System.out.println(hashSet);

        hashSet.add(new Person06(1001,"CC"));
        System.out.println(hashSet);
        hashSet.add(new Person06(1001,"AA"));
        System.out.println(hashSet);
    }
}

class Person06{
    public int id;
    public String name;

    public Person06(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person06 person06 = (Person06) o;
        return id == person06.id &&
                Objects.equals(name, person06.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Person06{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
