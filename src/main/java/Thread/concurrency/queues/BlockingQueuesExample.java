package Thread.concurrency.queues;

/*
 * The Java BlockingQueue interface, java.util.concurrent.BlockingQueue, represents a queue which is thread
 * safe to put elements into, and take elements out of from. In other words, multiple threads can be inserting
 * and taking elements concurrently from a Java BlockingQueue, without any concurrency issues arising.
 * Блокирующие очереди реализуют интерфейсы BlockingQueue, BlockingDeque, TransferQueue
 *
 * Доступные имплементации:
 * 1) ArrayBlockingQueue - не может расширяться, размер указывается при создании.
 * 2) DelayQueue - очередь, в которую могут быть помещены элементы, имплементирующие интерфейс Delayed. В этой очереди
 * 	 элементы будут отсортированы исходя из значений, полученных через метод getDelay(). Если значение отрицательное,
 * 	 элемент может быть взят из очереди, в противном случае нет.
 * 3) PriorityBlockingQueue  - The PriorityBlockingQueue is an unbounded concurrent queue. It uses the same ordering rules
 * 	 as the java.util.PriorityQueue class. You cannot insert null into this queue.
 * 4) LinkedBlockingQueue - The LinkedBlockingQueue keeps the elements internally in a linked structure (linked nodes).
 *    This linked structure can optionally have an upper bound if desired. If no upper bound is specified,
 *    Integer.MAX_VALUE is used as the upper bound. У соединенных на узлах очереди обычно более высокая пропускная способность,
 *    чем у основанной на массиве очереди, но менее предсказуемая производительность в большинстве многопоточных приложений.
 * 5) LinkedBlockingDeque — двунаправленная очередь на связанных узлах;
 * 6) SynchronousQueue - The SynchronousQueue is a queue that can only contain a single element internally. A thread inseting an element
 *    into the queue is blocked until another thread takes that element from the queue. Likewise, if a thread tries to take
 *    an element and no element is currently present, that thread is blocked until a thread insert an element into the queue.
 * 	  Синхронная очередь не имеет внутренней емкости, даже в один элемент. Это синхронная очередь в отличие от ArrayBlockingQueue,
 *	  куда элементы кладутся и поток не ждет, когда кто-то заберет его таск. В этой очереди поток блокируется и ждет, когда
 * 	  когда другой поток его заберет, т.е. все приосходит СИНХРОННО!
 * 7) LinkedTransferQueue - В отличие от реализации очередей интерфейса BlockingQueue, где потоки могут быть блокированы при чтении,
 * 	  если очередь пустая, либо при записи, если очередь полная, очереди интерфейса TransferQueue блокируют поток записи до тех пор,
 * 	  пока другой поток не извлечет элемент. Для этого следует использовать метод transfer.
 *
 * Подробнее: http://tutorials.jenkov.com/java-util-concurrent/blockingqueue.html
 * 			  http://java-online.ru/concurrent.xhtml#queues
 */

import java.util.concurrent.SynchronousQueue;

public class BlockingQueuesExample {
	public static void main(String[] args) {

	}



}
