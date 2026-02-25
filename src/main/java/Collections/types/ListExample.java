package Collections.types;


import Stream.Person;

import java.util.Arrays;
import java.util.LinkedList;

import static java.lang.System.out;

// TODO LinkedList - https://habr.com/en/post/127864/  - представитель двунаправленного списка.

//LinkedList в Java реализует сразу три интерфейса:
//  - List - доступ по индексу, список
//  - Deque - двусторонняя очередь
//  - Queue - обычная очередь

//Algorithm complexity:
//O(n) for worst case scenario or O(1) - for last and first elements

// TODO ArrayList - https://habr.com/en/post/128269/.

//Изначальный размер 10, увеличение происходит по формуле size/2*3+1
//O(n) for searching or O(1) for accessing element by id.

public class ListExample {
    public static void main(String[] args) {
        LinkedList<Person> people = new LinkedList<>(Arrays.asList(
                new Person("Stas", 1),
                new Person("Maks", 2),
                new Person("Vitya", 3),
                new Person("Andrew", 4),
                new Person("Slava", 5),
                new Person("Igor", 6)
        ));
        ListExample example = new ListExample();
        example.deleteElement(people);

    }

    public void getElementExample(LinkedList<Person> people) {
        //if list is empty throws exception
        out.println("print first: " + people.getFirst());
        out.println("print last: " + people.getLast());
        //retrieves head
        out.println("print peek: " + people.element());
        //if list is empty return null
        out.println("print peek: " + people.peekFirst());
        out.println("print peek: " + people.peekLast());
        out.println("peek: "+people.peek());
    }

    public void deleteElement(LinkedList<Person> people) {
        //if list is empty throws exception
        out.println("remove: " + people.remove());
        out.println("remove first: " + people.removeFirst());
        out.println("remove first: " + people.removeLast());
        //if list is empty return null
        out.println("poll: " + people.poll());
        out.println("poll first: " + people.pollFirst());
        out.println("poll last: " + people.pollLast());
    }

    public void addElement(LinkedList<Person> people) {
        //because of two interfaces offer and add method exists. Add from List, offer from Queue
        var addResult = people.add(new Person("Stas", 1)); //adds to the end
        people.addLast(new Person("Maks", 2)); //add to the end with void result
        people.addFirst( new Person("Slava", 5)); //add to the beginning with void result

        var offerResult = people.offer(new Person("Vitya", 3)); //adds to the end with boolean result
        people.offerLast(new Person("Andrew", 4));
        people.offerFirst(new Person("Igor", 6));
    }
}
