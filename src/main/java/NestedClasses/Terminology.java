package NestedClasses;

public class Terminology {
//    Локальные классы: https://docs.oracle.com/javase/tutorial/java/javaOO/localclasses.html
//    Aнонимные классы: https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html
//    Local vs Inner classes: https://stackoverflow.com/questions/10392725/what-is-the-difference-between-an-inner-class-and-a-local-inner-class-in-java/44062515

    //Внутренние классы - это максимально обширное понятие, которое включает (локальные, анонимные, внутренние нестатические
        // и вложенные (внутренние статические) классы.

    //Внутренние нестатические классы:
        //для создания объекта внтуреннего класса потребуется создать объект внешнего класса
        //имеют доступ к любым членам внешнего класса
        //внутрь скрыто передается ссылка на объект внешнего класса, от которого он был создан, которую можно получить
        //внутри их нельзя создавать статические переменные и методы
        //могут быть объявлены в интерфейсе
    //Вложенные классы:
        //вложенные классы не имеют доступа к НЕстатическим членам внешнего класса
        //не требуется объект внешнего класса для их создания
        //могут быть объявлены в интерфейсе
        //внутри них могут быть созданы как статические, так и нестатические методы и поля класса


    public static  void main(String[] args) {
        //обращение к вложенному статическому классу
        Outer.StaticNestedClass st = new Outer.StaticNestedClass();
        //обращение к внутреннему классу. Важно, объект создается через new Outer2(), т.к. требуется ссылка this
        Outer2.Inner2 in = new Outer2().new Inner2();
        Terminology t = new Terminology();

    }
}

interface MyInfer{
    static class NestClass{

    }

    class InnerClass{

    }
}
