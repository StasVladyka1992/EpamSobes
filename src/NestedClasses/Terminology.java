package NestedClasses;

public class Terminology {
    //Вложенные классы - это максимально обширное понятие
    //Во вложенные классы включаются внутренние классы (т.е. не статические) и статические классы

    public static  void main(String[] args) {
        //обращение к вложенному статическому классу
        Outer.StaticNestedClass st = new Outer.StaticNestedClass();
        //обращение к внутреннему классу. Важно, объект создается через new Outer2(), т.к. требуется ссылка this
        Outer2.Inner2 in = new Outer2().new Inner2();
        Terminology t = new Terminology();
        
    }
}
