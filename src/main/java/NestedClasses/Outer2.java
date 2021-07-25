package NestedClasses;

//рассмотрение внутреннего класса на примере вложенного класса)
public class Outer2 {
    private int outterPrivateObjectField;
    private static int outterPrivateStaticField;

    private void outterPrivateNONStaticPrint() {}

    private static void outterPrivateStaticPrint() {}

    public static void main(String[] args) {
        //Доступ к элементам внутреннего класса возможен из внешнего класса при условии создания объекта внешнего класса
        //т.к. Inner класс напоминает поле экземпляра класса, которому нужна ссылка this. Этой ссылкой служит создаваемый
        //объект внешнего класса
        Inner inner = new Outer2().new Inner();
        //для final static полей нет необходимости создавать объект внешнего класса, поэтому обратиться к ним можно
        System.out.println(Inner.innerStaticField);
        inner.innerPrivatePrint();

    }
    //внутренний класс может иметь любой модификатор доступа,а вот ЛОКАЛЬНЫЙ КЛАСС МОДИФИКАТОРОВ доступа класса не имеет
    //вообще
    private class Inner {

        //внутренние классы не могут иметь СТАТИЧЕСКИХ  методов и переменных(КРОМЕ final static для переменных).
        //Кстати, этот означает, что метода main в них быть не может)))
        private final static int innerStaticField =10;
//        private  static void  print(){} - error
        private void innerPrivatePrint(){
            //внутренний класс может обращаться к любым переменным и методам внешнего класса
            outterPrivateObjectField = 2;
            outterPrivateStaticField =2;
            outterPrivateNONStaticPrint();
            outterPrivateStaticPrint();
            //ссылка на объект внешнего класса.
            Outer2.this.outterPrivateObjectField=2;
        }
    }

    class Inner2 extends Inner{}
}
// внутренний класс может быть производным от других классов
// внутренние классы могут реализовывать интерфейсы
// внутренние классы могут быть базовыми (в пределах внешнего класса):
    //class Outer3 extends Outer2.Inner { } вне внешнего класса приведет к ошибке компиляции,
    //однако такой же синтаксис внутри внешнего класса ошибок не вызовет
// внутренний класс может быть объявлен внутри метода или логического блока внешнего класса, тогда видимость класса
// будет регулироваться видимостью того блока, в котором он объявлен. Внутренний класс будет сохранять доступ
// ко ВСЕМ полям внешнего класса, объявленным в текущем блоке кода.
