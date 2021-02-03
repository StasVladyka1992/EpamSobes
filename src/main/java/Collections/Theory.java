package Collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
ArrayList - https://habr.com/en/post/128269/. Изначальный размер 10, увеличение происходит по формуле size/2*3+1
LinkedList - https://habr.com/en/post/127864/  - представитель двунаправленного списка.
HashMap - https://habr.com/en/post/128017/ - изначальная длина bucket - 16. Load factor - 0,75. При достижении количества
элементов равное capacity * loadFactor размер увеличивается в два раза.
LinkedHashMap - https://habr.com/en/post/129037/
TreeMap - http://www.quizful.net/post/Java-TreeMap
PriorityQueue - https://www.geeksforgeeks.org/priority-queue-class-in-java-2/
ArrayDeque - очередь без сортировки
https://stackoverflow.com/questions/47420638/time-complexity-of-java-priorityqueue-heap-insertion-of-n-elements.
PriorityQueue основан на куче. https://habr.com/ru/post/263765/
https://habr.com/ru/post/112222/
https://habr.com/ru/post/267389/
Также есть:
-EnumMap
-EnumSet
-Stack -
-Vector - обычный список, но с синхронизацией на каждый метод метод
-HashTable - синхронизированный hashmap



Иерархия коллекций - http://www.quizful.net/post/Java-Collections
Изменения в map c 8 java - http://sannystark.github.io/java/hashmap/2015/12/25/hashmap-java8.html
Кратко: Если количество элементов больше 8 в одном бакете - сбалансированное дерево. А до этого LinkedList
 */
public class Theory {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("1");

		LinkedList<String> linkedList = new LinkedList<>();
		linkedList.addFirst("Stas");

		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();

		// Adding items to the pQueue using add()
		pQueue.add(10);
		pQueue.add(20);
		pQueue.add(15);

		// Printing the top element and removing it
		// from the PriorityQueue container
		System.out.println(pQueue.poll());
		System.out.println(pQueue.poll());
		System.out.println(pQueue.poll());

		ArrayDeque<String> ar = new ArrayDeque<>();
	}
}
