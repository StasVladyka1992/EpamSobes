package Concurrency.concurrent_collections;

import java.util.concurrent.ConcurrentSkipListSet;

/*
Блокирующий алгоритм, но блокировки очень короткие и маленькие, при вставке или удалении
Отсортированная, эквивалент TreeSet
https://www.1024cores.net/home/parallel-computing/concurrent-skip-list
https://en.wikipedia.org/wiki/Skip_list
https://habr.com/ru/post/139870/ - суть в том, что есть несколько уровней (linkedList, но на каждом уровне ниже добавляются
доп. элементы.
 */
public class ConcurrentSkipListSetExample {
	public static void main(String[] args) {
		ConcurrentSkipListSet concurrentSkipListSet = new ConcurrentSkipListSet();
	}
}
