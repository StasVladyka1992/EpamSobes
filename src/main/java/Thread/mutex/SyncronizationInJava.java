package Thread.mutex;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.ReentrantLock;

/* TODO Отличия CAS, FAA от синхронизации в коде:
   Показывается, в чем различие между синхронизацией в коде и использовании lock-free алгоритмов:
   https://www.baeldung.com/java-atomic-variables
   Объясняется суть CAS и FAA - https://habr.com/ru/post/319036/

 * TODO МЬЮТЕКС, МОНИТОР, СЕМАФОР
 *
 * МЬЮТЕКС — это специальный объект для синхронизации потоков. Он «прикреплен» к каждому объекту в Java
 * Название «мьютекс» происходит от английского «MUTual EXclusion» — «взаимное исключение».
 * Задача мьютекса — обеспечить такой механизм, чтобы доступ к объекту в определенное время был только у одного потока.
 * У мютекса возможны только два состояния — «свободен» и «занят». Состоянием мютекса нельзя управлять напрямую.
 * Прямой доступ к нему есть только у JVM
 *
 * МОНИТОР - это доп. надстройка над мютексом, по сути, это невидимый кусок кода (барьер, монитор) образующийся после
 * компиляции, который предотвращает доступ к мьютексу.  Монитор в Java выражен с помощью слова synchronized
 *
 * СЕМАФОР - это средство для синхронизации доступа к какому-то ресурсу. Его особенность заключается в том, что при
 * создании механизма синхронизации он использует счетчик. Счетчик указывает нам, сколько потоков одновременно могут
 * получать доступ к общему ресурсу.
 * Создание семафора: Semaphore(int permits) - количество потоков, которые будут иметь одновременный доступ к ресурсу.
 * Класссический пример - задача о философах.
 * Semaphore sem = new Semaphore(2);
 * sem.acquire() - получить разрешение. В случае успеха счетчик уменьшается.
 * sem.release() - освобождает выданное разрешение и увеличивает счетчик разрешений.
 *
 * МЬЮТЕКС — это одноместный СЕМАФОР
 * Источник - https://javarush.ru/groups/posts/2174-v-chem-raznica-mezhdu-mjhjuteksom-monitorom-i-semaforom
 *
 * TODO LOCKS
 * В качестве альтернативы блоку synchronized можно использовать Lock API
 * Плюсы:
 * 1) we can have Lock API's lock() and unlock() operation in separate methods. if the lock isn't available a thread gets blocked until the lock is released
 * 2) we can achieve fairness within the Lock APIs by specifying the fairness property. It makes sure that longest waiting thread is given access to the lock
 * 3) the Lock API provides tryLock() method. The thread acquires lock only if it's available and not held by any other thread.
 * With synchronized a thread gets blocked if it can't get an access to the synchronized block.
 * 4) the Lock API provides a method lockInterruptibly() which can be used to interrupt the thread when it's waiting for the lock. With synchronized it can't be
 *
 * При использовании Lock всегда надо unlock указывать в finally, чтобы избежать DeadLock
 * Lock lock = ...;
 * lock.lock();
 *	try {
 *    // access to the shared resource
 *	} finally {
 *   	lock.unlock();
 *	}
 *
 * TODO Виды Lock:
 * ReentrantLock - стандартная реализация Lock интерфейса
 * ReentrantReadWriteLock - реализация ReadWriteLock интерфейса.
 * StampedLock - новая реализация, возвращющая long, который может быть, например,  в последствии переиспользован для того
 * чтобы перейти с более оптимистичной группировки на более пессимистичную
 *	1) создаем сначала ReadWriteLock lock = new ReentrantReadWriteLock();
 * 	2) выбираем нужный Lock, например  Lock writeLock = lock.writeLock();
 * StampedLock - из java 8. Пока глубоко не изучал
 * Подробнее:
 * http://java-online.ru/concurrent-locks.xhtml
 * https://www.baeldung.com/java-concurrent-locks#2-reentrantreadwritelock
 * https://dev.cheremin.info/2012/10/stampedlock.html
 *
 * TODO Condition:
 * Интерфейсное условие Condition в сочетании с блокировкой Lock позволяет заменить методы
 * монитора/мьютекса (wait, notify и notifyAll) объектом, управляющим ожиданием событий.
 * Условие Condition, иначе именуемое как очередь условия, предоставляет средство управления для одного потока,
 * чтобы приостановить его выполнение до тех пор, пока он не будет уведомлен другим потоком. Объект Condition связывают
 * с блокировкой. Чтобы получить Condition для блокировки Lock используют метод newCondition().
 *
 * ReentrantLock locker = new ReentrantLock();
 * Condition condition = locker.newCondition();
 *    Чтобы перевести поток в ожидание, если определенное условие не выполняется, то используется метод await :
   while (условие)
     condition.await();
 *
 * //TODO Reentrant
 * A lock is called reentrant if the thread that holds the lock can lock it again. This means that even if a thread
 * holds the lock it can lock it again. Consequently the thread must unlock it as many times as it
 * has locked it, in order to fully unlock the Reentrant lock for other threads.
 *
 * Lock contention -  occurs whenever one process or thread attempts to acquire a lock held by another
 * process or thread. The more fine-grained the available locks, the less likely one process/thread will request a lock held by the other.
  (For example, locking a row rather than the entire table, or locking a cell rather than the entire row.);
 *
 * Одним из интересных методов интерфейса Lock и его реализации ReentrantLock является запрос блокировки с возможностью
 * прерывания процесса ожидания. Т.е. если поток запрашивает блокировку методом lockInterruptibly() и не получает ее сразу же,
 * то переходит в процесс ожидания. Методом interrupt работу потока в процессе ожидания можно прервать.
 * Тогда ожидающий блокировки поток просыпается, и генерируется исключительная ситуация InterruptedException в потоке,
 * которы вызвал interrupt у ожидаюшего потока.
 * После этого попыток доступа к защищенному ресурсу (получения блокировок) не делается и освобождать блокировку не требуется.
 * см. http://java-online.ru/concurrent-locks.xhtml
 *
 * TODO СИНХРОНИЗАЦИЯ ЧЕРЕЗ СТАТИЧЕСКИЕ, НЕСТАТИЧЕСКИЕ МЕТОДЫ И через объект
 * Важно понимать, что при синхронизации ВСЕГДА будет использоваться ОБЪЕКТ с мьютексом, а так как любой объект содержит
 * мьютекс, то это может быть любой объект.
 *
 * 1) Статический метод
 * В этом случае объектом для синхронизации будет являться объект класса, т.е. объект, полученный с помощью Class getClass()
 * При этом блокируется не полный класс, а только участки с ключевым словом synchronized, использующие тот же объект
 *
 * 2) Не статический метод
 * В этом случае объектом с мьютексом является this.
 *
 * 3) Через любой другой объект - аналогично первым двум
 *
 * Подробнее: https://stackoverflow.com/questions/6367885/difference-between-synchronizing-a-static-method-and-a-non-static-method
 *
 * */
public class SyncronizationInJava {
	public static void main(String[] args) throws InterruptedException {
		SyncronizationInJava syncronizationInJava = new SyncronizationInJava();
		CommonRes commonRes = syncronizationInJava.new CommonRes();
		ReentrantLock lock = new ReentrantLock();
		for (int i = 0; i < 10; i++) {
			CallImpl1 callImpl1 = syncronizationInJava.new CallImpl1(commonRes, lock);
			FutureTask<String> futureTask = new FutureTask<>(callImpl1);
			Thread thread = new Thread(futureTask);
			thread.start();
		}
	}

	private class CommonRes {
		int a;
	}

	private class CallImpl1 implements Callable {
		private CommonRes commonRes;
		private ReentrantLock locker;

		public CallImpl1(CommonRes commonRes, ReentrantLock locker) {
			this.commonRes = commonRes;
			this.locker = locker;
		}

		@Override
		public String call() throws Exception {
			locker.lock();
			commonRes.a = ++commonRes.a;
			System.out.println(Thread.currentThread().getName() + " " + commonRes.a);
			Thread.sleep(100);
			locker.unlock();
			return "text";
		}
	}
}
