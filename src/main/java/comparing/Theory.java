package comparing;


/*
Документация Java рекомендует: compareTo() и equals() должны быть консистентны.

Если a.compareTo(b) == 0, то желательно, чтобы a.equals(b) == true.
Нарушение этого правила не ломает компиляцию, но может привести к неожиданному
поведению в TreeSet, TreeMap и других коллекциях, использующих сравнение.

public class BigDecimalViolation implements Comparable<BigDecimal> {
    // new BigDecimal("2.0") и new BigDecimal("2.00")
    // compareTo() вернёт 0 (они равны по значению)
    // equals() вернёт false (у них разная точность)
}
Если положить оба в HashSet → будут два элемента.
Если положить оба в TreeSet → будет один (потому что TreeSet использует compareTo()).

*/


public class Theory {

}
