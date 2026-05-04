package concurrency.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import concurrency.executor.util.FetchDataFromFile;
import concurrency.executor.util.RejectTaskHandler;

//TODO - расписать подробнее, какие очереди используются под капотом.

public class ExecutorTypes {
	public static void main(String[] args) {
		//см документацию по этим классам
		//TODO Источник: https://java2blog.com/java-newcachedthreadpool-example/

//		ExecutorService (интерфейс)
//    ├── ThreadPoolExecutor (основная реализация)
//    │   ├── FixedThreadPool
//    │   ├── CachedThreadPool
//    │   ├── SingleThreadExecutor
//    │   └── ScheduledThreadPool
//    ├── ForkJoinPool (особый вид, work stealing)
//    └── ThreadPoolExecutor с кастомными параметрами


//		Если задачи                                             → Использовать
//─────────────────────────────────────────────────────────────────────
//		CPU-интенсивные (редко блокируются)                     → FixedThreadPool(N_CPU)
//		I/O-интенсивные (часто блокируются)                     → FixedThreadPool(N_CPU * 2)
//		Много маленьких задач                                   → CachedThreadPool
//		Нужен порядок (потокобезопасность)                      → SingleThreadExecutor
//		Периодические/отложенные задачи                         → ScheduledThreadPool
//		Рекурсивные задачи (ForkJoin)                           → WorkStealingPool
//		Смешанный режим (разные типы задач)                     → Custom ThreadPoolExecutor


		//this method returns an executor which is guaranteed to use the single thread.
		ExecutorService singleThread = Executors.newSingleThreadExecutor();

		//his method returns thread pool executor whose maximum size(let’s say n threads) is fixed.If all n threads are busy
		//performing the task and additional tasks are submitted, then they will have to be in the queue until thread is available.
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);

/*
=== Тест 1: Короткие задачи (10ms) ===
		FixedPool: 1000 задач по 10ms заняло ~1200ms
		Создано потоков: 10
		CachedPool: 1000 задач по 10ms заняло ~1100ms
		Создано потоков: ~50  (потоки переиспользуются)

=== Тест 2: Длинные задачи (100ms) ===
		FixedPool: 1000 задач по 100ms заняло ~10000ms
		Создано потоков: 10
		CachedPool: 1000 задач по 100ms заняло ~10000ms
		Создано потоков: 1000  (каждая задача в своем потоке!)
*/

		//this method returns an unbounded thread pool. It doesn’t have maximum size but if it has less number of tasks,
		//then it will tear down unused thread. If thread has been unused for 1 mins(keepAliveTime), then it will tear it down.
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

/*
//TODO -  Cached thread pool work algorithm:

		Временная линия:
═══════════════════════════════════════════════════════════════════

		1. Подается задача A:
   ├─ Свободных потоков? Нет
   ├─ SynchronousQueue.offer() → false (нет ждущих потоков)
   └─ Создается Thread #1 → выполняет задачу A

		2. Подается задача B (пока A выполняется):
   ├─ Свободных потоков? Нет (Thread #1 занят)
   ├─ SynchronousQueue.offer() → false
   └─ Создается Thread #2 → выполняет задачу B

		3. Подается задача C (пока A и B выполняются):
   ├─ Свободных потоков? Нет
   ├─ SynchronousQueue.offer() → false
   └─ Создается Thread #3 → выполняет задачу C

		4. Задача A завершилась, поток #1 освободился:
   ├─ Поток вызывает workQueue.take() (ждет новую задачу)
   └─ Теперь есть ждущий поток!

				5. Подается задача D:
   ├─ SynchronousQueue.offer(command) → true (поток #1 ждет!)
   ├─ Поток #1 получает задачу D
   └─ НОВЫЙ поток НЕ создается! (переиспользовали Thread #1)

		6. Прошло 60 секунд без задач:
   └─ Потоки #1, #2, #3 умирают (keepAliveTime истек)

//TODO WHY NOT TO USE FOR SMALL TASKS

public class WhyNotForLargeTasks {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();

        // ПЛОХО: 1000 "больших" задач (каждая по 1 секунде)
        for (int i = 0; i < 1000; i++) {
            final int taskId = i;
            pool.submit(() -> {
                try {
                    // Имитация долгой работы
                    Thread.sleep(1000);
                    System.out.println("Задача " + taskId + " выполнена");
                } catch (InterruptedException e) {}
            });
        }

        // Что произойдет?
        // 1. Первые 1000 задач создадут 1000 потоков (потому что все заняты)
        // 2. ОС не может эффективно планировать 1000 потоков
        // 3. Контекстные переключения уничтожат производительность
        // 4. Возможен OutOfMemoryError (каждый поток требует ~1MB стека)
        // 5. Приложение зависнет или упадет
    }
}






*/

		//this method returns a fixed size thread pool that can schedule commands to run after a given delay,
		//or to execute periodically.
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(4);

//      TODO customization.
//      Here we are going to create own ThreadPoolExecutor
//		corePoolSize: corePoolSize is the number of threads to keep in the pool, even if they are idle
//		MaximumPoolSize: the maximum number of threads to allow in the pool
//		keepAliveTime: When you have more threads already available than corePoolSize, then keepAliveTime is time up to
//		which that thread will wait for task before terminating.
//		unit: time unit is for keepAliveTime
//		workQueue: workQueue is the BlockingQueue which holds the tasks before execution.
//		threadFactory: Factory which is used to create a new Thread.
//		handler : RejectedExecutionHandler which is used in case execution is block or queue is full. Lets create a RejectedExecutionHandler for handling rejected task.

		// Wait queue is used to store waiting task
		BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(4);

		// Thread factory to create new threads
		ThreadFactory threadFactory = Executors.defaultThreadFactory();

		// Rejection handler in case task get rejected
		RejectTaskHandler rth = new RejectTaskHandler();

		// ThreadPoolExecutor constructor to create its instance
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2,
				10L, TimeUnit.MILLISECONDS, queue, threadFactory, rth);

		//If you notice here File 7, File 8, File 9 and File 10 got rejected. Lets understand why they got rejected.
		//Max pool size in ThreadPoolExecutor’s Constructor is 2, so when we submitted 10 tasks to thread pool, 2 threads
		//got created and started processing 2 tasks and 4 tasks got queued in LinkedBlockingQueue,
		//so once LinkedBlockingQueue became full, rest tasks got rejected.
		for (int i = 1; i <= 10; i++) {
			FetchDataFromFile fdff = new FetchDataFromFile("File " + i);
			System.out.println("A new file has been added to read : " + fdff.getFileName());
			// Submitting task to executor
			threadPoolExecutor.execute(fdff);
		}

		threadPoolExecutor.shutdown();
	}
}

