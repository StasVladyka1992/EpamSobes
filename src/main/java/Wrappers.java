import org.w3c.dom.ls.LSOutput;

public class Wrappers {
    public static void main(String[] args) {
        //значения базовых типов хранятся в стеке и не являются объектами. Обертки примитивов - это
        // полноценные объекты! Классы-обертки хранятся в heap, наследуются от abstract class Number (кроме
        // Boolean и Character) и реализ. интерфейс Comparable

        //Классы-обертки м.б. преобразованы к примитивам с помощью типValue() или простым присвоением:

        //1) C помощью метода типValue:
        Integer i2 = new Integer("2");
        Character c2 = new Character('a');
        Float f2 =  new Float ("2");
        int i1 = new Integer("12").intValue();
        char c1 = new Character('b').charValue();
        boolean b1 = new Boolean( "boolean").booleanValue();

        //2) C помощью обычного присвоения:
        i1 = i2;
        c1 = c2;
        // Можно использовать преобраз. типов
        byte byt1 = (byte)(f2.floatValue());
        byt1 = (byte)(float)f2;

        //Преобразование строки к примитиву/обертке:
        int i3 = 0;
        i3 = Integer.parseInt("3"); //возвращает int
        i3 = Integer.valueOf("3"); //возвращает Integer
        i3 = Integer.decode("3"); // возвращает Integer;

        // Преобразование примитива к строке. P.S. у Double, Float, Byte, Short нету методов для преобразования к
        // Binary, Octal String. У Long есть
        String s1 = Integer.toString(2);
        s1 = Integer.toBinaryString(19);
        System.out.println("binary 2 = "+ s1);
        s1 = Integer.toOctalString(19);
        System.out.println("octal 2 = "+ s1);
        s1 = Integer.toHexString(19);
        System.out.println("hex 2 = "+ s1);
        s1 = Integer.toString(2);
        s1 = String.valueOf("2");

        //АВТОМАТИЧЕСКАЯ УПАКОВКА/РАСПАКОВКА ПРИМИТИВОВ В КЛАССЫ-ОБЕРТКИ (ресурсоемкий процесс!!!)

        //УПАКОВКА
        // данный функц. доступен с java 1.5. Но при автоупаковке требуется в нек. случаях явно указать тип литерала
        Float f1 =7f;
        //или
        f1=(float)7;

        //РАСПАКОВКА (т.е. нет необходимости писать new Integer ("2").intValue()
        float f3 = f1;


    }
}
