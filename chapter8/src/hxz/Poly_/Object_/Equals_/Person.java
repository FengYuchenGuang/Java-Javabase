package hxz.Poly_.Object_.Equals_;

import java.util.Objects;

public class Person {
    private String name;
    private int age;
    private char sex;

    public Person() {
    }

    public Person(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Person) {
            Person person =(Person)o;
            return age == person.age &&
                    sex == person.sex &&
                    Objects.equals(name, person.name);
        }
        return false;
    }

}
