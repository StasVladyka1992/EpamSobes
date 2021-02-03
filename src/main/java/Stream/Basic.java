package Stream;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Basic {
	//TODO https://www.youtube.com/watch?v=gTdXjRif_yo
	//методы для работы с потоками:
	//1) конвейерные - возвращают поток.
	//2) терминальные - возвращают другой объект, OptionalExamples, коллекции, примитивы, коллекции

	//Функциональные интерфейсы:
	//https://metanit.com/java/tutorial/9.3.php

	public static void main(String[] args) {
		Basic b = new Basic();
//        b.primitiveTypeStreams();
		b.streamExample();

		b.met();
	}

	private void simpleExample() {
		List<String> mList = Arrays.asList("adsa", "asfas", "asfas");
		mList.stream().filter(s -> s.startsWith("a"))
				.map(String::toUpperCase)
				.sorted()
				.forEach(System.out::println);

	}

	private void streamCreation() {
		//classic
		List<BigInteger> list1 = new ArrayList<>();
		Stream<BigInteger> st1 = list1.stream();

		//from given values
		Person p1 = new Person();
		Person p2 = new Person();
		Stream<Person> st2 = Stream.of(p1, p2);

		// from arrays
		Stream<Integer> st3 = Arrays.stream(new Integer[]{12, 13, 14});

		//from file (each string in file is a separate element)
		Path path = Paths.get("Sta.txt");
		try {
			Stream<String> st4 = Files.lines(path);
		} catch (IOException e) {
			e.printStackTrace();
		}

		//from string
		IntStream st5 = "fasfasfa".chars();

		//с помощью Stream.Builder
		Stream.builder().add("adas").add(new Integer(24)).add("dasdad").build();

		//parallel stream
		Stream<BigInteger> st6 = list1.parallelStream();

		//бесконечные потоки Stream.iterate
		//1,- начальное условие, n - выражение для генерации
		Stream<Integer> streamFromIterate = Stream.iterate(1, n -> n + 1);

		//бесконечные потоки Stream.generate(выражение генерации)
		Stream<Integer> streamFromGenerate = Stream.generate(() -> 2);
	}

	private void conveerMethods() {
		//Нововведения jdk.
		//Ofnullable для избежания null в Stream:
		//		collection.stream()
		//				.flatMap(s -> {
		//					Integer temp = map.get(s);
		//					return temp != null ? Stream.of(temp) : Stream.empty();
		//				})
		//				.collect(Collectors.toList());

//		collection.stream()
//				.flatMap(s -> Stream.ofNullable(map.get(s)))
//				.collect(Collectors.toList());

		//distinct - убирает дубликаты, сравнение по equals
		//sorted - сортирует значения в натуральном порядке. Также условие можно задавать с помощью Comparator
		//filter - записи фильтруются по условию
		//map - возвращает поток, состоящий из результатов преобразованных данной функцией к каждому элементу
		//limit - ограничивает выборку элементов
		//iterate - безгранично создает элементы стрима

		//flatMap
		//flatMapToInt    - похожи на map, при этом могут создававть несколько эл. из исходного
		//flatMapToDouble
		//flatMapToLong

		//mapToInt
		//mapToDouble - работают идентично методу map, но возвращают поток примитивных типов
		//mapToLon

		//peek - возвращает исходный поток,но применяет функцию к каждому эл-ту
		//takeWhile - c jdk 9
		//dropWhile - с jdk 9
	}

	private void terminalMethods() {
		//allMatch - возвращает true, если условие выполняется для каждого элемента потока или поток пустой
		//anyMatch - возвращает true, если условие верно хотя бы для одного элемента
		//noneMatch - возвращает true, если условие не выполнено ни для одного эл-та
		//collect - представление элементов потока в виде структуры данных, например коллекции
		//toArray - возвращает массив элементов

		//count - возвращает кол-во эл-ов
		//findAny - возвращает OptionalExamples, описывающий любой подходящий элемент, или пустой OptionalExamples, если поток пустой
		//findFirst - возвращает OptionalExamples, описывающий первый подходящий элемент, или пустой OptionalExamples, если поток пустой
		//forEach - применяет переданную функцию к каждому элементу. В параллельном потоке порядок выполнения не гарант.
		//forEachOrdered - то же самое, что forEach, но с сохранением порядка.
		//max - возвращает max, условие через Comparator
		//min - возвращает min, условие через Comparator
		//reduced - позволяет выполнить агрегирующую функцию и возвратить 1 результат

	}

	private void primitiveTypeStreams() {
		IntStream ist = Arrays.stream(new int[]{1, 25, 5});
		System.out.println(ist.average());
		DoubleStream dst = Arrays.stream(new double[]{1, 25, 5});

		//Уникальные для примитивов
		// average - терминальный метод
		// mapToObj- конвеерный метод, преобразует числовой поток в поток объектов
		// sum - возвращает сумму всех чисел
	}

	private void flatMapExample() {
		List<Child> children = Arrays.asList(new Child("Igor"), new Child("Masha"));

		Arrays.stream(new Person[]{new Person("Stas", 1),
				new Person("Vitya", 12, children),
				new Person("Vovka", 2, children),
				new Person("Max", 13, children)})
				.flatMap(p -> p.children.stream());

		List<Person> parent = Arrays.stream(new Person[]{new Person("Stas", 1),
				new Person("Vitya", 12, children),
				new Person("Vovka", 2, children),
				new Person("Max", 13, children)})
				.map(p -> {
					System.out.println(p);
					return p;
				}).collect(Collectors.toList());
		System.out.println(parent);
	}

	private void streamExample() {
		//Inside of some methods there if an opportunity to pass a lambda express,
		IntStream.range(1, 10).map((b) -> {
			int a = b * b;
			return a - b;
		}).forEach(System.out::println);

		Stream.of("c1", "c2", "c3")
				.map((s) -> s.substring(1))
				.mapToInt(Integer::parseInt)
				.max()
				.ifPresent(System.out::println);


		Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
				.filter(s -> {
					System.out.println("filter:" + s);
					return s.startsWith("a");
				}).map(s -> {
			System.out.println("map:" + s);
			return s.toUpperCase();
		})
				.forEach(s -> System.out.println("forEach:" + s));

	}

	private void repeatedStreamUsing() {
		//java don't allow to use the same stream twice, but you can do this
		//with stream supplier.
		Supplier<Stream<String>> streamSupplier = () -> Stream.of("dd2", "aa2", "bb1", "bb3")
				.filter(s -> s.startsWith("a"));

		streamSupplier.get().anyMatch(s -> true); //1st call
		streamSupplier.get().noneMatch(s -> true);//2nd call

	}

	public void met() {
		Map<String, List<String>> map = new HashMap<>();
		map.put("1", Arrays.asList("раз", "два"));
		map.put("3", Arrays.asList("три", "четыре"));

		List<String> strings = map.entrySet()
				.stream()
				.flatMap(stringListEntry -> stringListEntry.getValue().stream())
				.collect(Collectors.toList());
		System.out.println(strings);

		List<List<String>> strings2 = map.entrySet()
				.stream()
				.map(stringListEntry -> stringListEntry.getValue())
				.collect(Collectors.toList());
		System.out.println(strings2);


		List<List<String>> list3 = new ArrayList<>();
		list3.add(Arrays.asList("1", "2", "3"));
		list3.add(Arrays.asList("4", "5", "6"));
		System.out.println(list3.stream().flatMap(list -> list.stream()).collect(Collectors.toList()));

		Arrays.asList("1", "2", "3").stream().map(Integer::parseInt);
		Arrays.asList("1", "2", "3").stream().forEach(System.out::println);
		Arrays.asList("1", "2", "3").stream().map(String::toUpperCase);
	}


}
