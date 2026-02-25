package Collections.util;

import Stream.Person;

import java.util.*;

public class CollectionUtilExample {
    static ArrayList <Integer> arrayList = new ArrayList<>();
    static ArrayList  arrayList2 = new ArrayList<>();

    static List <Integer> linkedList = new LinkedList<Integer>();
    static Set<String> setList = new HashSet<>();
    static Integer [] array = {1,2};
    static Map<String, Boolean> hashmap = new WeakHashMap<>();

    public static void main(String[] args) {
        // добавление элементов из массива в коллекцию
        Collections.addAll(arrayList, array);


        // копирование элементов из одного LIST в другой
        // ВАЖНО, размер коллекции, куда копируются элементы должен совпадать или быть больше, той коллекции
        // из которой идет копирование.

        Collections.addAll(arrayList2, new Integer [] {2, 8});
        Collections.copy(arrayList2, arrayList);
//        for (Integer i : arrayList2) {
//            System.out.println(i);
//        }

        // поиск максим./мин. элемента согласно обычному порядку.
        // можно также осуществлять поиск согласно компаратору
        System.out.println(Collections.max(arrayList));


        // возвращает Set, используя указанный Map
        // МНОГО НО : - value в Map м.б. только Boolean
        //            - не использовать с HashMap и ТreeMap
        //            - map должен быть пустой
        //            - Set теряет  свои значения
        setList.add("Stas");
        setList =  Collections.newSetFromMap(hashmap);
        for (String s:
             setList) {
            System.out.println(s);
        }

        // заменяет все указанные объекты листа на указанные
        Collections.replaceAll(arrayList2, "Stas", new Integer(2));

        // меняет порядок элементов в указанном List на противоположный
        //	reverseOrder() - returns a comparator that imposes the reverse of the natural ordering on a collection of objects that implement the Comparable interface.
        Collections.reverse(arrayList2);

        // перемешивает рандомно
        Collections.shuffle(arrayList2);

        // sort - сортировка в листах
        Collections.sort(arrayList2);

        // swap - поменять местами элементы в коллекции
        Collections.swap(arrayList2, 0, 1);

        //Collections are tied with arrays with two methods:
            //Array.asList(arrayName). In this case if something is add to array, it also added to CollectionExample
        Person[] personArray = new Person[3];
        personArray[0] = new Person("Appolon", 10);
        personArray[1] = new Person("Afrodita", 20);
        List<Person> persons = Arrays.asList(personArray);
        System.out.println("Before changes" +persons);
        personArray[2] = new Person("Aid", 30);
        System.out.println("After changes" + persons);
            //CollectionExample toArray - convert collection to array
        System.out.println(persons.toArray());
    }
}
