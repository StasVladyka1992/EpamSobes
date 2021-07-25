package Collections;

import Clone.Pilot;
import Stream.Person;

import java.util.*;

/**
 * @project EpamSobes
 * author Stas Vladyka on 20.07.2019.
 */
public class CollectionExample {
    public static void main(String[] args) {

        new TreeSet<>();
        CollectionExample example = new CollectionExample();
        example.addReturnsForList();
        example.addReturnsForSet();
        example.addGroupOfElements();
        example.printContainers();
        example.differenceBetweenToArray();
        example.isEmpty();

        List<String> strList = new ArrayList<>();
        strList.add("Java");
        strList.add("Python");
        strList.add("Android");

        //начиная с 11 джавы
        String[] strArray = strList.toArray(size -> new String[size]);
        System.out.println(Arrays.toString(strArray));

    }

    public void addReturnsForList() {
        Collection<String> collection = new ArrayList<>();
        System.out.println(collection.add("Stas"));
        System.out.println(collection.add("Maks"));
        System.out.println(collection.add("Maks"));
        collection.stream().forEach(System.out::println);
    }

    public void addReturnsForSet() {
        //Duplicate element isn't added to collection at. The previous one remains in the collection
        Collection<Person> collection = new HashSet<>();
        Person person1 = new Person("stas", 1000120124);
        System.out.println("person 1: " + person1);
        Person person2 = new Person("stas", 1000120124);
        System.out.println("person 2: " + person2);
        System.out.println(collection.add(person1));
        System.out.println(collection.add(person2));
        collection.stream().forEach(System.out::println);
    }

    public void addGroupOfElements() {
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = {6, 7, 8, 9};
        //вызов на коллекции. Если бы в коллекцию добавлялось несколько классов-наследников общего класса,
        // то без явного указания типа была бы ошибка, т.к. компилятор пытается угадать тип первому аргументу.
        //Этот прием называется явным указанием аргумента типа
        collection.addAll(Arrays.<Integer>asList(moreInts));

        //с помощью класса Collections. Работает значительно быстрее, но коллекицию так не создать. В этом методе такой
        //ошибки, как с Collection.addAll ошибки не возникнет
        Collections.addAll(collection, 11, 12, 13, 14);
    }

    public void printContainers() {
        System.out.println("array list: " + fill(new ArrayList<>()));
        System.out.println("linked list: " + fill(new LinkedList<>()));
        System.out.println("hash set: " + fill(new HashSet<>()));
        System.out.println("tree set: " + fill(new TreeSet<>()));
        System.out.println("linked hash set: " + fill(new LinkedHashSet<>()));
        System.out.println("hash map: " + fill(new HashMap<>()));
        System.out.println("tree map: " + fill(new TreeMap<>()));
        System.out.println("linked hash map: " + fill(new LinkedHashMap<>()));
    }

    private Map fill(Map<String, String> map) {
        map.put("крыса", "Анфиса");
        map.put("кошка", "Мурка");
        map.put("собака", "Шарик");
        //when puts element with the same key, the previous VALUE is substituted with new one
        map.put("собака", "Бобик");
        return map;
    }

    private Collection fill(Collection<String> collection) {
        collection.addAll(Arrays.asList("крыса", "кошка", "собака", "собака"));
        return collection;
    }

    private void differenceBetweenToArray(){
        List <String> list  = Arrays.asList("крыса", "кошка", "собака", "собака");
        //all elements of array are objects
        Object [] objects = list.toArray();
        //all elements of array are Strings
        String [] strings = list.toArray(new String[0]);
    }

    private void isEmpty(){
        List <String> list  = Arrays.asList("крыса", "кошка", "собака", "собака");
        System.out.println(list.isEmpty());
        System.out.println(new ArrayList<>().isEmpty());
    }
}
