package Patterns.Builder;

/**
 * @project EpamSobes
 * author Stas Vladyka on 13.08.2019.
 */
public class Human {
    private String name;
    private String address;
    private int age;
    private int childrenNumber;

    public Human() {
    }

    public static class HumanBuilder {
        private Human human;

        public HumanBuilder() {
            human = new Human();
        }

        public HumanBuilder withName(String name) {
            this.human.name = name;
            return this;
        }

        public HumanBuilder withAge(int age) {
            this.human.age = age;
            return this;
        }

        public Human build() {
            return this.human;
        }

        //и т.д.
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;

        if (age != human.age) return false;
        if (childrenNumber != human.childrenNumber) return false;
        if (name != null ? !name.equals(human.name) : human.name != null) return false;
        return address.equals(human.address);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + address.hashCode();
        result = 31 * result + age;
        result = 31 * result + childrenNumber;
        return result;
    }
}

