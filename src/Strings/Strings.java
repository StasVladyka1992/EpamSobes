package Strings;

import java.security.MessageDigest;
import java.text.ChoiceFormat;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Strings {
    public static void main(String[] args) {
        Integer i1 = 10;
        String s1 = String.valueOf(i1);
        String s2 = new String(new char[]{'S','t', 'a','s'});
        String s3 = String.join(" ", s2,s1);
        System.out.println(s3);

        s1 = "AB";
        s2 = "BD";
        System.out.println(s1.compareTo(s2));

        //замена одного символа на другой
        s1= s1.replace("A", "B");
        s2= s2.replace("B", "D");
        System.out.println(s1 + " " + s2);

        // TODO - регулярки
        Pattern pt = Pattern.compile("aa$");
        Matcher mc = pt.matcher("Stas waa walking in the streaa");
        while (mc.find()){
            System.out.println(mc.group());
        }

        // TODO -  Stringbuilder и StringBuffer.
        // StringBuilder не синхронизирован
        StringBuilder sb = new StringBuilder(s1);
        sb.append(Integer.toOctalString(100));
        System.out.println(sb.toString().trim().toLowerCase());


        // TODO - System.out.printf
        // Общий вид строки:
        // %[argument_index$][flags][width][.precision]conversion
        // % — специальный символ, обозначающий начало инструкций форматирования.
        //[argument_index$] — целое десятичное число, указывающее позицию аргумента в списке аргументов. Ссылка на первый аргумент "1$", ссылка на второй аргумент "2$" и т.д. Не является обязательной частью инструкции. Если позиция не задана, то аргументы должны находиться в том же порядке, что и ссылки на них в строке форматирования.
        //[flags] — специальные символы для форматирования. Например, флаг "+" означает, что числовое значение должно включать знак +, флаг "-" означает выравнивание результата по левому краю, флаг «,» устанавливает разделитель тысяч у целых чисел. Не является обязательной частью инструкции.
        //[width] — положительное целое десятичное число, которое определяет минимальное количество символов, которые будут выведены.  Не является обязательной частью инструкции.
        //[.precision] — не отрицательное целое десятичное число с точкой перед ним. Обычно используется для ограничения количества символов. Специфика поведения зависит от вида преобразования. Не является обязательной частью инструкции.
        //conversion — это символ, указывающий, как аргумент должен быть отформатирован. Например d для целых чисел, s для строк, f для чисел с плавающей точкой. Является обязательной частью инструкции.

            // TODO целое число
        System.out.printf("Выводим целое число %,7d%n",7894);
        // 7 - длина 7 символов, выравнивание по умолчанию по левому краю
        // ',' - разделение тысяч пробелом

            // TODO число с плавающей точкой
        System.out.printf("Число pi равно: %n%0$-10.4f", Math.PI);
        // f - число с плавающей точкой
        // .4 - 4 знака после запятой
        // 10 - длина 10 символов (если меньше десяти, то в данном случае пустые места ничем не заполняются)
        // '-' - выравнивание по левому краю
        // 0$ - нулевая позиция в массиве, из которого берутся значения

            // TODO текст
        System.out.printf("%n%-10.3s","Hello");
        // s - строка
        // .3 - первые 3 символа
        // 10 - длина строки 10 символов
        // '-' - выравнивание по левому краю

            //TODO Локализация
        System.out.printf(Locale.FRANCE,"%nЧисло с плавающей точкой %f",  Math.E);
        System.out.printf(Locale.US,"%nОбычное число  %,d", 10000000);
        System.out.printf(Locale.GERMANY,"%nОбычное число  %,d", 10000000);

        // TODO String.format
        // используется, если нет необходимости выводить заданную строку на экран и нужно только сохранить эту строку
        // использует те же принципы, что и souf
        System.out.printf("%n%-5s%-11s%-25s%-11s","Код", "За единиц","Валюты","Рублей РФ");
        System.out.println("\n----------------------------------------------------");
        System.out.printf(Locale.FRANCE,"%-5s%-11d%-25s%-11.4f%n","AUD",1,"Австралийский доллар",44.9883);
        System.out.printf(Locale.FRANCE,"%-5s%-11d%-25s%-11.4f%n","GBP",1,"Фунт стерлингов",86.8429);
        System.out.printf(Locale.FRANCE,"%-5s%,-11d%-25s%-11.4f%n","BYR",10000,"Белорусский рубль",39.7716);
        System.out.printf(Locale.FRANCE,"%-5s%,-11d%-25s%-11.4f%n","DKK",10,"Датская крона",84.9192);
        System.out.printf(Locale.FRANCE,"%-5s%,-11d%-25s%-11.4f%n","USD",1,"Доллар США",58.4643);
        System.out.printf(Locale.FRANCE,"%-5s%,-11d%-25s%-11.4f%n","EUR",1,"Eвро",63.3695);
        System.out.printf(Locale.FRANCE,"%-5s%,-11d%-25s%-11.4f%n","KZT",100,"Казахский тенге",31.4654);

        // TODO MessageFormat альтернатива для String.format
        //1 способ форматирования строки
        int planet = 7;
        String event = "a disturbance in the Force";
        String result = MessageFormat.format("At {0, time} on {0, date}, there was {1} on planet {2,number, integer}.", new Date(), event, planet);
        System.out.println(result);
        // 2 способ
        int filesCount =12;
        String diskName = "C";
        Object [] ar = {filesCount,diskName};
        MessageFormat messageFormat = new MessageFormat("The disk \"{1}\" contains {0} file(s).");
        String result2 = messageFormat.format(ar);
        System.out.println(result2);

        //использование ChoiceFormat
        MessageFormat form = new MessageFormat("Я могу {1} {0}.");
        int count =3;
        String excercise = "подтянуться";
        Object[] testargs = {count, excercise};
        double [] fileLimits= {0,2,5};
        String [] filePart = {"{0} раз", "{0} раза","{0} раз" };
        ChoiceFormat fileForm = new ChoiceFormat(fileLimits, filePart);
        form.setFormatByArgumentIndex(0,fileForm);
        System.out.println(form.format(testargs));

        // TODO Интернирование для строк и примитовов
        String s = new String("FF");
        String s0 = "FF";
        s= s.intern();
        System.out.println(s==s0);
        Integer a1 = 1;
        Integer a2 = 1;
        System.out.println(a1==a2);


    }
}
