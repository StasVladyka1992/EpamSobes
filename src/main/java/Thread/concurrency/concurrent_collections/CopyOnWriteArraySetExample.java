package Thread.concurrency.concurrent_collections;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArraySet;

//CopyOnWriteArraySet is a Set that uses an internal CopyOnWriteArrayList for all of its operations. Схема работы итератора такая же
//It is introduced in JDK 1.5, we can say that it is thread-safe version of Set. Внутри сидит CopyOnWriteArrayList и
//используется synchronized блок при добавлении элементов, чтобы избежать повторений.
public class CopyOnWriteArraySetExample {
	public static void main(String[] args) {
		CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>(Arrays.asList("1","2","3"));
	}
}
