package Thread.mutex;

/*
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
*
* TODO LOCKS
* В качестве альтернативы блоку synchronized можно использовать Lock API
* Плюсы:
* 1) we can have Lock API's lock() and unlock() operation in separate methods
* 2) we can achieve fairness within the Lock APIs by specifying the fairness property. It makes sure that longest waiting thread is given access to the lock
* 3) the Lock API provides tryLock() method. The thread acquires lock only if it's available and not held by any other thread. With synchronized a thread gets blocked if it can't get an access to the synchronized block.
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
* Виды
* ReentrantLock - стандартная реализация Lock интерфейса
* ReentrantReadWriteLock - реализация ReadWriteLock интерфейса.
*	1) создаем сначала ReadWriteLock lock = new ReentrantReadWriteLock();
* 	2) выбираем нужный Lock, например  Lock writeLock = lock.writeLock();
* StampedLock - из java 8. Пока глубоко не изучал
* Подробнее: https://www.baeldung.com/java-concurrent-locks#2-reentrantreadwritelock
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

}
