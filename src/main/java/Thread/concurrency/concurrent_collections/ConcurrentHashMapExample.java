package Thread.concurrency.concurrent_collections;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

//Хорошая статья с описанием: https://javagoal.com/concurrenthashmap-in-java/
/*
СoncurrentHashMap использует несколько сегментов, и данный класс нужно рассматривать как группу HashMap’ов.
Количество сегментов по умолчанию равно 16. Если пара key-value хранится в 10-ом сегменте,
то ConcurrentHashMap заблокирует, при необходимости, только 10-й сегмент, и не будет блокировать остальные 15.

Лучше задавать capacity initial, потому что если capacity будет слишком маленький то операция расширения
будет очень долгая и залочиться весь ConcurrentHashMap

ConcurrentHashMap -
	а) ConcurrentHashMap does not lock the Map while you are reading from it.
 	Additionally, ConcurrentHashMap does not lock the entire Map when writing to it. It only locks the part of the
 	Map that is being written to, internally.

 	б) ConcurrentModificationException if the ConcurrentHashMap is changed while being iterated.
 	The Iterator is not designed to be used by more than one thread though.
 */

public class ConcurrentHashMapExample {
	public static void main(String[] args) {

	}
}
