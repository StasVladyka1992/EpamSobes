package Concurrency.concurrent_collections;

/*
Concurrent коллекции используют в многопоточных приложениях, потому что они неблокирующие. Неблокирующая коллекция -
не совсем корректный термин, потому что в некоторых коллекциях все-таки присутствуют локи, но они очень короткие.

Подробнее:
http://blog.yuriytkach.com/2013/09/concurrent-collections-java.html
алгоритмические сложности - https://www.baeldung.com/java-collections-complexity
*/
public class ConcurrentCollectionTheory {
     // TODO Collections.syncronizedList()
     // TODO Collections.syncronizedSet()
     // TODO Collections.syncronizedMap()
     // ******All methods are syncronized

     // TODO CopyOnWriteArrayList
     // TODO CopyOnWriteArraySet
     // (под капотом используется CopyOnWriteArrayList только без дубликатов)
     // CopyOnWriteArrayMap - НЕ СУЩЕСТВУЕТ, т.к. большинство операций - это вставка, в результате которых пришлось бы копировать целую коллекцию

     // TODO ConcurrentSkipListMap
     // TODO ConcurrentSkipListSet
     // ConcurrentSkipList - не существует, потому что сама идея SkipList основана на доступе по КЛЮЧУ, а не по ИНДЕКСУ.
}
