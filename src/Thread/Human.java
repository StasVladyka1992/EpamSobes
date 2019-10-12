package Thread;

import Enum.EnumType;

import java.util.Objects;

public class Human {
    private int age;
    private String name;
    private EnumType enumType = EnumType.Thirhday;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return age == human.age &&
                Objects.equals(name, human.name) &&
                enumType == human.enumType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, enumType);
    }


    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            Thread t1 = new Thread(()->{ System.out.println("Привет, Stas, я поток");});
            t1.start();
        }


    }

}
