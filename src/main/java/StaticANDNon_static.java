import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class StaticANDNon_static {
    // Статические блоки и статические переменные инициализируются в порядке объявления,
    // то же самое относится и к нестатическим блоками и переменным.
    // 1) сначала инициализируются по очереди static поля. Т.е. первым иниц. staticExample.
    // Это поле static и инициализ объектом, поэтому при создании объекта сразу же инициал. не статические поля и блоки.
    static StaticANDNon_static staticExample = new StaticANDNon_static();
    // 7) инициализация static переменных
    static int i = 4;
    static  int j = returnStaticInt();

    static int k = 3;

    // 3) инициализация нестатич. i
    int l = returnInt();
    // 9) инициализация static-блока
    static {
        System.out.println("static");
    }

    // 5) запуск нестатич. блока
    {
        System.out.println("clean");
    }
    // 8) запуск метода
    static int returnStaticInt(){
        System.out.println(i);
        System.out.println(k);
        System.out.println("return static int");
        return 1;
    }
    // 4) вызов метода
    int returnInt(){
        System.out.println("return int");
        return 2;
    }
    //2) Заходим в конструктор, но вторая строка не выполняется, т.к. для её выполнения требуется
// инициализ. не статичных переменных, которые потом будут использоваться объектом
    public StaticANDNon_static() {
        // 6) реализация конструктора;
        System.out.println("constructor");

    }

    public static void main(String[] args) {
        new StaticANDNon_static();
    }
}
