package Collections.types;

//TODO HashMap - https://habr.com/en/post/128017/

// - изначальное кол-во bucket - 16. Load factor - 0,75. При достижении количества
// элементов равное capacity * loadFactor размер увеличивается в два раза. элементы перераспределяются по новым корзинам.
// null ключ возможен (только 1)

// - метод hash использует в качестве входного параметра значение метода hashcode() объект.
// Хэш и ключ нового элемента поочередно сравниваются с хэшами и ключами
// элементов из списка и, при совпадении этих параметров, значение элемента перезаписывается.

// - Коллизия в данном случае это ни когда хешкоды ключей одинаковые, а когда позиции корзины,
// вычисленные в том числе по хеш-коду, совпадают после вычисления индекса hash % capacity:
// int hash = key.hashCode();
// int index = hash % array.length;
// Массив размером 16 (0-15 индексов)
// key1.hashCode() = 17 → 17 % 16 = 1 → корзина 1
// key2.hashCode() = 33 → 33 % 16 = 1 → корзина 1

//if (e.hash == hash && (e.key == key || key.equals(e.key)))
//        {
// V oldValue = e.value;
// e.value = value;
//
//		return oldValue;
//	}

// java 8 optiization:
// - При малом количестве элементов в корзине (< 8) — связанный список
// При 8+ элементах в корзине — преобразуется в красно-черное дерево (TreeBin)
// При уменьшении до 6 элементов — обратно в список

// Algorithmic complexity:
// Поиск элемента: O(1) в лучшем случае,
// O(n) в худшем (все элементы в одной корзине)



//TODO TreeMap - http://www.quizful.net/post/Java-TreeMap - основан на красно-черном отсортированном дереве.

//Упорядоченность: элементы автоматически сортируются по ключам
//Структура: самобалансирующееся бинарное красно-черное дерево поиска
//Производительность: O(log n) для основных операций
//Порядок: либо натуральный (Comparable), либо через Comparator
//null невозможен

//Inner structure:
//static final class Entry<K,V> implements Map.Entry<K,V> {
//    K key;
//    V value;
//    Entry<K,V> left;    // Левый потомок
//    Entry<K,V> right;   // Правый потомок
//    Entry<K,V> parent;  // Родитель
//    boolean color = BLACK; // Цвет узла (красный/черный)
//}

//Red-black tree attributes:
//Красно-черное дерево свойства:
//Каждый узел — красный или черный
//Корень — всегда черный
//Все листья (NIL) — черные
//Красный узел имеет только черных потомков
//Все пути от узла до листьев содержат одинаковое количество черных узлов



//TODO LinkedHashMap - https://habr.com/en/post/129037/ HashMap + Двусвязный список для сохранения порядка итерации.

// Наследует HashMap.Node, добавляет ссылки
// static class Entry<K,V> extends HashMap.Node<K,V> {
//    Entry<K,V> before, after; // Ссылки для двусвязного списка
// }
// Голова и хвост списка
// transient LinkedHashMap.Entry<K,V> head; // Самый старый
// transient LinkedHashMap.Entry<K,V> tail; // Самый новый

//null ключ возможен (только 1)
//LRU cache
//LinkedHashMap<String, Integer> cache = new LinkedHashMap<>(16, 0.75f, true) {
//    @Override
//    protected boolean removeEldestEntry(Map.Entry eldest) {
//        return size() > 100; // Храним только 100 самых свежих записей
//    }
//};

//Algorythm complexity:
//Все операции: O(1) (как у HashMap + небольшие накладные расходы)
//Память: больше чем HashMap (две доп. ссылки на entry)
//Итерация: быстрее чем HashMap (по связному списку)



// TODO WeakHashMap - HashMap, где ключи хранятся как слабые ссылки (WeakReference).

//Ключи могут быть автоматически удалены сборщиком мусора (GC), если на них нет сильных ссылок.
//WeakHashMap<Key, Value> map = new WeakHashMap<>();

//Key key = new Key(); // Сильная ссылка
//map.put(key, "value");
//key = null; // Теперь только слабая ссылка в WeakHashMap
//System.gc(); // После GC entry удалится из мапы автоматически



// TODO EnumMap - map where keys are enum values.

public class MapExample {

}
