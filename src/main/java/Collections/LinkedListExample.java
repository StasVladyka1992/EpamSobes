package Collections;


import Stream.Person;

import java.util.Arrays;
import java.util.LinkedList;

import static java.lang.System.out;


/**
 * @project EpamSobes
 * author Stas Vladyka on 20.07.2019.
 */
public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<Person> people = new LinkedList<>(Arrays.asList(
                new Person("Stas", 1),
                new Person("Maks", 2),
                new Person("Vitya", 3),
                new Person("Andrew", 4),
                new Person("Slava", 5),
                new Person("Igor", 6)
        ));
        LinkedListExample example = new LinkedListExample();
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
        //TODO adds to the end
        //return nothing
        people.addLast(new Person("Maks", 2));
        //return boolean
        people.offer(new Person("Vitya", 3));
        people.offerLast(new Person("Andrew", 4));
        people.add(new Person("Stas", 1));


        //TODO adds to the start
        //return nothing
        people.addFirst( new Person("Slava", 5));
        //return boolean
        people.offerFirst(new Person("Igor", 6));
    }


}
