package Arrays;

import java.util.*;
import java.util.Arrays;

public class ArraysClass {
    static  float [] floats = {2.5f,3.5f, 35.8f};
    public static void main(String[] args) {
        // перевод массива в List
        // возвращает переменную типа List, а не ArrayList, т.е. потенциально возвращаемое значение может быть больше обычного ArrayList
        // Cписок формируется на основе массива. Массив при этом используется для внутреннего представления списка.
        // Таким образом сохраняется связь между списком и исходным массивом:
        //изменения в массиве отразятся на списке и на оборот - изменения списка - на массиве.
        List <Integer> list = Arrays.asList(new Integer[]{1,3,45,6});







        // копирование массива и создание нового с установкой значений в ноль, если длина создаваемого массива больше,
        // того, с которого копируют
        // аналогично работает метод copyOfRange
        float [] newFloats = Arrays.copyOf(floats, 10);
        for (float a:
             newFloats) {
            System.out.println(a);
        }

        // equals and deepEquals
        // using equals works fine in single dimensional array but
        // it will fail if we are testing multi dimensional array.
        // To properly handle the equality test of multi dimensional array, the deepEquals method works like a charm.

        /*TODO: важно, метод toArray () возвращет тип Object, который не может быть передан другим типам данных.
        однако можно указать тип массива в скобочках, к которому будут приводиться данные. Тогда не потребуется даже
        // расширение либо сужение типов. */
        Integer [] arrayFromList = list.toArray(new Integer[list.size()]);
        Integer [] array = {1,3,45,6};
        System.out.println(Arrays.equals(array, arrayFromList));


        /*fillHashSet - Assigns the specified value to each element of the specified array */
        Arrays.fill(array, 2);
        System.out.println(Arrays.toString(array));

        /*sort.
         При обычной сортировке используется метод compareTo.
         Если сортируем с помощью компаратора, то нужно использовать переопределять метод compare интерфейса Сomparator
         - может иметь компаратор*/
        Battery [] batteries = new Battery[]{
                new Battery(10_000, "Panasonic", 1),
                new Battery(10_000, "Philips", 2),
                new Battery(3_000, "Duracell", 3),
                new Battery(5_000, "Varta", 3),
        };
        Comparator<Battery> comparator = new Comparator<Battery>() {
            @Override
            public int compare(Battery o1, Battery o2) {
                return o1.capacity-o2.capacity;
            }
        };

        Arrays.sort(batteries);
        for (Battery b :batteries) {
            System.out.println(b);
        }

        Arrays.sort(batteries, comparator);
        for (Battery b:batteries) {
            System.out.println(b);
        }

    }
}
