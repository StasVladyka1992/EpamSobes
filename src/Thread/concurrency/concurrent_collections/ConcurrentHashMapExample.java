package Thread.concurrency.concurrent_collections;

import java.util.concurrent.ConcurrentHashMap;

/*
СoncurrentHashMap использует несколько сегментов, и данный класс нужно рассматривать как группу HashMap’ов.
Количество сегментов по умолчанию равно 16. Если пара key-value хранится в 10-ом сегменте,
то ConcurrentHashMap заблокирует, при необходимости, только 10-й сегмент, и не будет блокировать остальные 15.

Лучше задавать capacity initial, потому что если capacity будет слишком маленький то операция расширения
будет очень долгая и залочиться весь ConcurrentHashMap
 */
public class ConcurrentHashMapExample {
	public static void main(String[] args) {
		ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
	}
}
