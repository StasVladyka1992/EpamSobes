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
	элементов равное capacity * loadFactor размер увеличивается в два раза. Метод hash использует в качестве входного параметра
	значение метода hashcode() объект.  Хэш и ключ нового элемента поочередно сравниваются с хэшами и ключами элементов из списка
	и, при совпадении этих параметров, значение элемента перезаписывается.
	Коллизия в данном случае это ни когда хешкоды ключей одинаковые, а когда позиции корзины, вычисленные в том числе по хеш-коду, совпадают.
	if (e.hash == hash && (e.key == key || key.equals(e.key)))
	{
		V oldValue = e.value;
		e.value = value;

		return oldValue;
	}
LinkedHashMap - https://habr.com/en/post/129037/
TreeMap - http://www.quizful.net/post/Java-TreeMap - основан на красно-черном дереве отсортированном. Это двоичное дерево со своими ограничениями
WeakHashMap -
PriorityQueue - https://www.geeksforgeeks.org/priority-queue-class-in-java-2/.
PriorityBlockingQueue - блокирующая очередь.
ArrayDeque - a special kind of a growable array that allows us to add or remove an element from both sides.
	очередь без сортировки (arrayqueue нет) https://www.baeldung.com/java-array-deque
ArrayBlockingQueue - блокирующая очередь
https://stackoverflow.com/questions/47420638/time-complexity-of-java-priorityqueue-heap-insertion-of-n-elements.
EnumMap
EnumSet

Stack - наследник Vector, а значит синхронизированный, как и Vector. https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html
Vector - обычный список, но с синхронизацией на каждый метод метод https://www.geeksforgeeks.org/java-util-vector-class-java/
HashTable - синхронизированный hashmap

Отличия между heap и binary-search-tree.
1) Binary Search Tree does not allow duplicates, heap allows.
2) The BST is ordered, while Heap is not.
3) The heap is commonly represented as an array of numbers in computer memory.
4) For heap each node’s subtree has values that are less/greater than (depends on min-heap и max-heap) or equal to the root node (no matter where they stan - on the left or on the right)

PriorityQueue основан на куче. Куча — двоичное дерево. А это значит, что каждый родительский элемент имеет два дочерних.
И хотя мы называем эту структуру данных кучей, но выражается она через обычный массив. Существуют два вида куч: min-heap и max-heap.
https://www.geeksforgeeks.org/difference-between-binary-search-tree-and-binary-heap/
https://habr.com/ru/post/112222/
https://habr.com/ru/post/267389/

Иерархия коллекций - http://www.quizful.net/post/Java-Collections
Изменения в map c 8 java - http://sannystark.github.io/java/hashmap/2015/12/25/hashmap-java8.html (коснулись HashMap, LinkedHashMap, ConcurrentHashMap)
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
