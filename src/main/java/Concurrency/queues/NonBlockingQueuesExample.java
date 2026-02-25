package Concurrency.queues;

/*
*Неблокирующие очереди
Потокобезопасные и неблокирующие очереди на связанных узлах (linked nodes) реализуют интерфейс Queue и его наследника Deque.
*
* 1) ConcurrentLinkedQueue реализуют интерфейс Queue и формирует неблокирующую и ориентированную
* на многопоточное исполнение очередь. Размер очереди ConcurrentLinkedQueue не имеет ограничений. Имплементация очереди
* использует wait-free алгоритм от Michael & Scott, адаптированный для работы с garbage collector'ом.
* Данный алгоритм довольно эффективен и очень быстр, т.к. построен на CAS (Compare-And-Swap).

* 2) ConcurrentLinkedDeque реализует интерфейс Deque (Double ended queue), читается как «Deck». Данная реализация позволяет
* добавлять и получать элемента с обеих сторон очереди. Соответственно, класс поддерживает оба режима работы : FIFO (First In First Out)
* и LIFO (Last In First Out). ConcurrentLinkedDeque следует использовать в том случае, если необходимо реализовывать LIFO,
* поскольку за счет двунаправленности данный класс проигрывает по производительности очереди ConcurrentLinkedQueue.
* Описание с примером представлено здесь.
*
* Подробнее:
* http://java-online.ru/concurrent.xhtml#queues
 */

public class NonBlockingQueuesExample {
	public static void main(String[] args) {
	}


}
