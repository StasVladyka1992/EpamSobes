public class Final {
    //Модификатор final

    //    Модификатор final используется для определения констант в качестве члена
    //    класса, локальной переменной или параметра метода. Методы, объявленные
    //    как final, нельзя замещать в подклассах. Для классов, объявленных со специ-
    //    фикатором final, нельзя создавать подклассы.

    //    Константа может быть объявлена как поле класса, но не проинициализирована.
    //    В этом случае она должна быть проинициализирована в логическом
    //    блоке класса, заключенном в {}, или конструкторе, но только в одном из ука-
    //    занных мест. Значение по умолчанию константа получить не может в отличие
    //    от переменных класса.
    //    Константы могут быть объявлены в методах как локальные или как параметры метода.
    //    В обоих случаях значения таких констант изменять нельзя.

    final int i;

    // инициализация final переменной в конструкторе, иначе будет ошибка компиляции
//    public Final(int i) {
//        this.i = i;
//    }
    // или в статическом/нестатическом блоке
    {
        i = 10;
    }

    public static void main(String[] args) {

    }

    //в параметры метода могут передаваться два типа переменных со значением final:
    // ссылки на объекты и примитивы. Если в качестве аргумента будет передана ссылка
    // на объект с модификатором final, то это означает то, что внутри этого метода мы не можем
    // в данную переменную (параметра) положить другой объект. Но мы можем менять состояние объекта
    public  static  String print(final String s){
    //s = "ffaf" // ошибка компиляции
    return  s;}

    //Слово final в применении к примитивным типам означает,
    // что мы не можем менять значение переменной в методе
    public static void printSeveralTimes(final int times){
        // times=10; - ошибка компиляции
    }

    public final void myMethod(){

    }
}
