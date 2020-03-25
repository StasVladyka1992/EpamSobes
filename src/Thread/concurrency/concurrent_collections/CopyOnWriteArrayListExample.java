package Thread.concurrency.concurrent_collections;

import java.util.concurrent.CopyOnWriteArrayList;

/*
Пакет java.util.concurrent включает несколько потокобезопасных коллекций :
	CopyOnWriteArrayList - volatile ArrayList. При чтении список не блокируется, а вот при вставке, создается копия имеющегося
	списка с новым элементом. Синхронизации при вставке не происходит. Соответственно тут никогда не получишь ConcurrentModificationException
	UnsupportedOperationException при remove через итератор. Используется, когда операции вставки очень редки.

	1) ConcurrentHashMap -
		а) ConcurrentHashMap does not lock the Map while you are reading from it.
	 	Additionally, ConcurrentHashMap does not lock the entire Map when writing to it. It only locks the part of the
	 	Map that is being written to, internally.

	 	б) ConcurrentModificationException if the ConcurrentHashMap is changed while being iterated.
	 	The Iterator is not designed to be used by more than one thread though.

	3) CopyOnWriteArraySet -
	4) ConcurrentNavigableMap
		а) ConcurrentSkipListMap аналог TreeMap
	5) ConcurrentSkipListMap
	6) ConcurrentSkipListSet
*/
public class CopyOnWriteArrayListExample {
	public static void main(String[] args) {
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
	}


//	public static void main(String[] args) {
//		ConcurrentNavigableMap<String, String> map = new ConcurrentSkipListMap<>();
//		map.put("1", "one");
//		map.put("2", "two");
//		map.put("3", "three");
//
//		ConcurrentNavigableMap headMap = map.headMap("2");
//		headMap.keySet();
//
//		CopyOnWriteArraySet set = new CopyOnWriteArraySet();
//
//	}
}
