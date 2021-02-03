package Algorythm.graph.searching.breadth_search;

/*
Поиск в ширину.

Поиск в ширину имеет такое название потому, что в процессе обхода мы идём вширь, т.е. перед тем как приступить к поиску
вершин на расстоянии k + 1, выполняется обход вершин на расстоянии k.

Он отвечает на вопросы:
1) Существует ли путь от узла A к узлу B?
2) Как выглядит кратчайший путь от узла A к B?

Суть примера в том, что ищется человек, котрый продает манго.
1) Создали map, который хранит человека и всех его знакомых
2) Создали очередь, куда будут помещяться люди, которых мы проверяем. Из очереди люди берутся с головы с удалением.
3) Если чел не продавец, то мы  помещаем всех его знакомых в список, а его в проверенных.
Сложность алгоритма - O(количество людей + количестов ребер)
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
Позволяет определить путь с минимальным количеством ребер, но не работает во взвешенных графах.
Алгоритм работы:
1) Создаем map, у которого ключ - Person, а value - list его знакомых.
2) Создается очередь, куда добавляются все знакомые того, которого мы сейчас проверяем. Важно, добавлять в очередь
только прямых знакомых человека, которого мы сейчас проверяем. Если проверяемый не тот, кого мы ищем, то удаляем
его из очереди и заносим в set уже проверенных чтобы исключить возможность зацикливания.
3) Проверка идет до тех пор, пока очередь не окажется пустой

Сложность O (количество ребер + количество людей) :
1) В самом крайнем случае мы пройдем по все ребрам, следовательно это O(количество ребер)
2) Добавление человека в список выполняется за O(1). А для всех людей - это O(n).

 */
public class BreadthSearch {
	public static void main(String[] args) {
		BreadthSearch object = new BreadthSearch();
		Map<Person, List<Person>> graph = object.createGraph();
		Person first = new Person("Stas", false);

		System.out.println(object.widthSearch(graph, first));
	}

	public Person widthSearch(Map<Person, List<Person>> graph, Person first) {
		List<Person> myFriends = graph.get(first);
		Deque<Person> queue = new LinkedList<>(myFriends);
		Set<Person> checked = new HashSet<>();

		while (queue.size() != 0) {
			Person person = queue.pollFirst();
			if (person.isMangoSeller()) {
				return person;
			}
			if (!checked.contains(person)) {
				queue.addAll(graph.get(person));
				checked.add(person);
			}
		}
		return null;
	}

	public Map<Person, List<Person>> createGraph() {
		Map<Person, List<Person>> graph = new HashMap<>();

		Person me = new Person("Stas", false);
		Person bob = new Person("Bob", false);
		Person alisa = new Person("Alice", false);
		Person clare = new Person("Clare", false);
		Person anuj = new Person("Anuj", true);
		Person peggie = new Person("Peggie", false);
		Person tom = new Person("Tom", false);
		Person johnny = new Person("Johnny", false);

		List<Person> myContacts = Arrays.asList(bob, alisa, clare);
		List<Person> bobContacts = Arrays.asList(anuj, peggie);
		List<Person> alisaContacts = Collections.singletonList(peggie);
		List<Person> clareContacts = Arrays.asList(tom, johnny);
		List<Person> emptyContacts = Collections.emptyList();

		graph.put(me, myContacts);
		graph.put(bob, bobContacts);
		graph.put(alisa, alisaContacts);
		graph.put(peggie, emptyContacts);
		graph.put(clare, clareContacts);
		graph.put(tom, emptyContacts);
		graph.put(johnny, emptyContacts);
		graph.put(anuj, emptyContacts);

		return graph;
	}
}
