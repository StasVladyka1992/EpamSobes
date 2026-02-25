package Collections.types;

// TODO LinkedList - https://habr.com/en/post/127864/  - представитель двунаправленного списка.

//LinkedList в Java реализует сразу три интерфейса:
//  - List - доступ по индексу, список
//  - Deque - двусторонняя очередь
//  - Queue - обычная очередь

//Algorithm complexity:
//O(n) for worst case scenario or O(1) - for last and first elements

//TODO PriorityQueue - очередь с приоритетом
//PriorityQueue основан на куче. Куча — двоичное дерево. А это значит, что каждый родительский элемент имеет два дочерних.
//И хотя мы называем эту структуру данных кучей, но выражается она через обычный массив. Существуют два вида куч: min-heap и max-heap.
//https://www.geeksforgeeks.org/difference-between-binary-search-tree-and-binary-heap/
//https://habr.com/ru/post/112222/
//https://habr.com/ru/post/267389/

//Элементы упорядочиваются по приоритету (Comparator/Comparable)
//На основе бинарной кучи (min-heap по умолчанию)
//Не разрешает null элементы

//Algorithmic complexity:
//offer(): O(log n)
//poll(): O(log n)

//peek(): O(1)
//remove(Object): O(n) (линейный поиск)

//TODO ArrayDeque — двусторонняя очередь на массиве
//ArrayDeque - a special kind of a growable array that allows us to add or remove an element from both sides.
//очередь без сортировки (arrayqueue нет) https://www.baeldung.com/java-array-deque

//Реализует Deque (двусторонняя очередь)
//На основе циклического массива
//Быстрее LinkedList для большинства операций
//Не разрешает null элементы
//При недостатке элементов удваивает размер

//Algorithmic complexity:
//Доступ по индексу: Нет прямого доступа, только через итератор
//Вставка/удаление начала/конца: O(1) амортизированно
//Итерация: O(n), очень быстро (массив в памяти последовательно)

import java.util.*;

public class QueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Random random = new Random(30);
        for (int i = 0; i < 10; i++) {
            //get random elem from [i,30]
            priorityQueue.offer(i + random.nextInt(30 - i));
        }
        System.out.println(priorityQueue);

        //выводится в порядке приоритета, т.е. в порядке СОРТИРОВКИ
        List<Integer> list = Arrays.asList(25, 255, 300, 302, 120, 912);
        priorityQueue = new PriorityQueue<>(list);
        System.out.println(priorityQueue);





        Queue<Integer> queue = new LinkedList<>();
        QueueExample queueExample = new QueueExample();
        Random rand = new Random(47);
        for (int i = 0; i <10 ; i++) {
            queue.offer(rand.nextInt(i+10));
        }
        queueExample.print(queue);

        Queue<Character> queue1 = new LinkedList<>();
        for (Character c:"Brontosaurus".toCharArray()) {
            queue1.offer(c);
        }
        queueExample.print(queue1);
    }

    public void print (Queue queue){
        while(queue.peek()!=null){
            System.out.print(queue.remove()+" ");
        }
        System.out.println();
    }
}
