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

}

