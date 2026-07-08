package interview;

import java.util.HashMap;
import java.util.Map;

public class LFUCache<K, V> {

    private static class Node<K, V> {
        K key;
        V value;
        int frequency;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.frequency = 0;
        }
    }

    private final int capacity;
    private final Map<K, Node<K, V>> map;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public V get(K key) {
        Node<K, V> node = map.get(key);
        if (node == null) return null;
        node.frequency++;
        return node.value;
    }

    public void put(K key, V value) {
        if (capacity <= 0) return;

        Node<K, V> node = map.get(key);

        if (node != null) {
            // Обновляем существующий
            node.value = value;
            node.frequency++;
        } else {
            // Если заполнен — удаляем самый редкий
            if (map.size() >= capacity) {
                removeLeastFrequent();
            }

            // Добавляем новый
            map.put(key, new Node<>(key, value));
        }
    }

    private void removeLeastFrequent() {
        Node<K, V> victim = null;
        int minFreq = Integer.MAX_VALUE;

        // Проходим по всем узлам и ищем минимальную частоту
        for (Node<K, V> node : map.values()) {
            if (node.frequency < minFreq) {
                minFreq = node.frequency;
                victim = node;
            }
        }

        if (victim != null) {
            map.remove(victim.key);
        }
    }
}
