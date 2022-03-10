package Stream;

import java.util.Comparator;
import java.util.List;

public class Person {
    String name;
    int age;
    List<Child> children;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, List<Child> children) {
        this.name = name;
        this.age = age;
        this.children = children;
    }

    public Person() {
    }

    public Person(int age) {
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (getAge() != person.getAge()) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + getAge();
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Person p1 = new Person(1);
        Person p2 = new Person(2);
        Person p3 = new Person(3);

        System.out.println(List.of(p2, p3, p1).stream().max(Comparator.comparing(Person::getAge)).get());
        System.out.println(List.of(p3).stream().max(Comparator.comparing(Person::getAge)).get());


    }
}
