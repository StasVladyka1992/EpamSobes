package Collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*

Concurrent collections
PriorityBlockingQueue - блокирующая очередь.
ArrayBlockingQueue - блокирующая очередь
https://stackoverflow.com/questions/47420638/time-complexity-of-java-priorityqueue-heap-insertion-of-n-elements.
Stack - наследник Vector, а значит синхронизированный, как и Vector. https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html
Vector - обычный список, но с синхронизацией на каждый метод метод https://www.geeksforgeeks.org/java-util-vector-class-java/
HashTable - синхронизированный hashmap

Отличия между heap и binary-search-tree.
1) Binary Search Tree does not allow duplicates, heap allows.
2) The BST is ordered, while Heap is not.
3) The heap is commonly represented as an array of numbers in computer memory.
4) For heap each node’s subtree has values that are less/greater than (depends on min-heap и max-heap) or equal to the root node (no matter where they stan - on the left or on the right)


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
