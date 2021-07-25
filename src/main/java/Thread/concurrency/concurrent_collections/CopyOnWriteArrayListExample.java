package Thread.concurrency.concurrent_collections;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/*
Хорошее описание работы: https://javagoal.com/copyonwritearraylist-in-java/
Пакет java.util.concurrent включает несколько потокобезопасных коллекций :
	CopyOnWriteArrayList - volatile ArrayList. При чтении список не блокируется, а вот при вставке или удалении, создается копия имеющегося
	списка с новым элементом. Синхронизации при вставке не происходит. Тут никогда не получишь ConcurrentModificationException
	UnsupportedOperationException при remove через итератор. Используется, когда операции вставки очень редки.
*/
public class CopyOnWriteArrayListExample {
	public static void main(String[] args) {
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()){
			//не поддерживается
			iter.remove();
		}
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
