package interview;

import java.util.LinkedHashMap;
import java.util.Map;

//Суть: очередь в магазине: кто дольше всех стоит, тот и выходит
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);  // true = порядок доступа
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}
//  Параметр accessOrder в конструкторе LinkedHashMap определяет,
//  в каком порядке будут перебираться элементы при итерации (например, в entrySet()).
//  TODO accessOrder = false (Элементы хранятся в том порядке, в котором они были добавлены.)

// before get(B)
//┌───┐    ┌───┐    ┌───┐
//│ A │ ⇄  │ B │ ⇄  │ C │
//└───┘    └───┘    └───┘
//  ↑        ↑        ↑
// head    (B)      tail

// after get(B)
//┌───┐    ┌───┐    ┌───┐
//│ A │ ⇄  │ B │ ⇄  │ C │
//└───┘    └───┘    └───┘
//  ↑        ↑        ↑
// head    (B)      tail


//  TODO accessOrder = true (Элементы переупорядочиваются при каждом чтении (get) или обновлении (put с существующим ключом))
//  Самый недавно использованный элемент перемещается в конец очереди.
//  Самый давно не использованный элемент оказывается в начале.

// before get(B)
//┌───┐    ┌───┐    ┌───┐
//│ A │ ⇄  │ B │ ⇄  │ C │
//└───┘    └───┘    └───┘
//  ↑        ↑        ↑
// head    (B)      tail

// after get(B)
//┌───┐    ┌───┐    ┌───┐
//│ A │ ⇄  │ C │ ⇄  │ B │
//└───┘    └───┘    └───┘
//  ↑        ↑        ↑
// head              tail


//  Этот метод — встроенный механизм LinkedHashMap, который позволяет автоматически удалять самые старые элементы.
//  По умолчанию он всегда возвращает false, то есть ничего не удаляется
//  removeEldestEntry возвращается тогда, когда произошел put нового элемента. т.е. при размере в 10 элементов
//  и при добавлении 11, size станет 11, потому вызовется removeEldestEntry и удалит элемент, вернув size к 10.


// LinkedHashMap с accessOrder=true работает так:

//cache.get(key) {
// 1. Находит элемент по ключу (HashMap O(1))
// 2. Удаляет его из текущей позиции в списке
// 3. Добавляет в КОНЕЦ списка (как самый свежий)
// 4. Возвращает значение
//}

//cache.put(key, value) {
// 1. Если ключ существует - обновляет и перемещает в конец
// 2. Если новый - добавляет в конец
// 3. Если size > capacity - удаляет ГОЛОВУ (самый старый)
//}
