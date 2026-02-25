package Collections.types;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

// HashSet
// Algorithmic complexity: O(n) for worst case scenario or O(1). The same as HashMap

// EnumSet
// TreeSet
// LinkedHashSet
public class SetExample {
	public static void main(String[] args) {
		SetExample setExample = new SetExample();
		Set<Integer> set = new HashSet<>();
		setExample.fillHashSet(set);
		//TODO - очень интересный вывод, т.к. Set не сортирует элементы. Так происходит вероятнее всего потому, что
		//hashcode числа в текущей версии java - есть само число.
		System.out.println(set);

		//сохраняет порядок вставки
		Set<Integer> set2 = new LinkedHashSet<>();
		setExample.fillLinkedHashSet(set2);
		System.out.println(set2);

		//сортирует элементы
		Set<Integer> set3 = new TreeSet<>();
		setExample.fillTreeSet(set3);
		System.out.println(set3);

		setExample.setOperations();

	}

	public void fillHashSet(Set<Integer> set) {
		Random random = new Random(47);
		for (int i = 0; i < 100; i++) {
			//if element  already exists - put nothing
			Integer newElem = random.nextInt(30) + 1;
			set.add(newElem);
		}
	}

	public void fillLinkedHashSet(Set<Integer> set) {
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			//if element  already exists - put nothing
			set.add(random.nextInt(30) + 1);
		}
	}

	public void fillTreeSet(Set<Integer> set) {
		//sort elements. store elements in black-red binary tree
		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			//if element  already exists - put nothing
			set.add(random.nextInt(100) + 1);
		}
	}

	public void setOperations() {
		//contains method
		Set<String> set1 = new HashSet<>();
		Collections.addAll(set1, "A B C D E F G H I J K L".split(" "));
		set1.add("M");
		System.out.println("set contains H: " + set1.contains("H"));
		System.out.println("set contains N: " + set1.contains("N"));

		//containsAll method
		Set<String> set2 = new HashSet<>();
		Collections.addAll(set2, "H I J K L".split(" "));
		System.out.println("set2 in set1: " + set1.containsAll(set2));
	}

}
