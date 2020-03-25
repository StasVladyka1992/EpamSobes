package Thread.concurrency.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import Thread.concurrency.executor.util.FetchDataFromFile;
import Thread.concurrency.executor.util.RejectTaskHandler;

public class ExecutorTypes {
	public static void main(String[] args) {
		//см документацию по этим классам
		//TODO Источник: https://java2blog.com/java-newcachedthreadpool-example/

		//this method returns an executor which is guaranteed to use the single thread.
		ExecutorService singleThread = Executors.newSingleThreadExecutor();

		//his method returns thread pool executor whose maximum size(let’s say n threads) is fixed.If all n threads are busy
		//performing the task and additional tasks are submitted, then they will have to be in the queue until thread is available.
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);

		//this method returns an unbounded thread pool. It doesn’t have maximum size but if it has less number of tasks,
		//then it will tear down unused thread. If thread has been unused for 1 mins(keepAliveTime), then it will tear it down.
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

		//this method returns a fixed size thread pool that can schedule commands to run after a given delay,
		//or to execute periodically.
		ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(4);

//      TODO customization.
//      Here we are going to create own ThreadPoolExecutor
//		corePoolSize: corePoolSize is the number of threads to keep in the pool, even if they are idle
//		MaximumPoolSize: the maximum number of threads to allow in the pool
//		keepAliveTime: When you have more threads already available than corePoolSize, then keepAliveTime is time upto which that thread will wait for task before terminating.
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

