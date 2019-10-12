package Stream;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Stas", 150),
                new Person("Maks", 300),
                new Person("Vitya", 50)
        );
        Main main = new Main();
        main.collectorsExample(persons);
    }

    private void collectorsExample(List<Person> persons) {
        //group by age
        Map<Integer, List<Person>> group = Stream
                .of(new Person("Appolon", 10), new Person("Afrodita", 20))
                .collect(Collectors.groupingBy(p -> p.age));
        System.out.println(group);

        List<Person> filtered = persons.stream()
                .filter(p -> p.name.startsWith("S"))
                .collect(Collectors.toList());
        System.out.println(filtered);

        //averagingInt
        Double averageAge = persons.stream()
                .collect(Collectors.averagingInt(p -> p.age));
        System.out.println(averageAge);

        //statistics about stream))
        IntSummaryStatistics ageSummary = persons
                .stream()
                .collect(Collectors.summarizingInt(p -> {
                    System.out.println(p.name);
                    return p.age;
                }));
        int maxFromStatistics = ageSummary.getMax();
        System.out.println(ageSummary);

        //joining
        String phrase = persons.stream()
                .filter(p -> p.age >= 18)
                .map(p -> p.name)
                .collect(Collectors.joining(" и ", "в Германии", "совершеннолетние"));
        System.out.println(phrase);

        Map<Integer, String> map = persons.stream()
                .collect(Collectors.toMap(
                        //key
                        p -> p.age,
                        //value
                        p -> p.name,
                        (name1, name2) -> name1 + ":" + name2));
        System.out.println(map);

        //build own Collector
        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> new StringJoiner(" | "),  //supplier
                        (j, p) -> j.add(p.name.toUpperCase()),    //accumulator
                        StringJoiner::merge,                    //combiner
                        StringJoiner::toString                  //finisher
                );

        String result = persons.stream().collect(personNameCollector);
        System.out.println(result);

        //prints the oldest person
        Arrays.asList(new Person("Stas", 150),
                new Person("Maks", 300),
                //Maks has the same age
                new Person("Vitya", 300)).stream()
                .reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2).ifPresent(System.out::println);
        //creates a new Person
        Arrays.asList(new Person("Stas", 150),
                new Person("Maks", 300),
                //Maks has the same age
                new Person("Vitya", 300)).stream()
                .reduce(new Person("", 0), (p1, p2) -> {
                    p1.age += p2.age;
                    p1.name += p2.name;
                    return p1;
                });
//    .ifPresent(System.out::println);

    }

//    Function
//    Supplier
//    Consumer

}
