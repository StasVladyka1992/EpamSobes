package Thread.concurrency.executor_completion_service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import Thread.concurrency.executor_completion_service.util.MultiplyingTask;

//ExecutorCompletionService
//Let’s say you have 5 tasks, you submit it to the executors and you want to perform some operation as soon as task completes.
// Let’s also assume that the first task takes the longest time. If you use Executors in this case, when you call future.get() on the first task,
// get operation will be blocked and even though other tasks may have completed, you won’t be able to proceed further.
//To solve this issue, you can use ExecutorCompletionService.ExecutorCompletionService returns futures objects based on completion order,
// so whichever task executes first, will be returned first. You just need to call executorCompletionService.take() to get completed Future object.
public class ExecutionCompletionServiceExample {
	public static void main(String[] args) {
		MultiplyingTask multiplyingTask1 = new MultiplyingTask("Task 1", 10, 20, 2000l);
		MultiplyingTask multiplyingTask2 = new MultiplyingTask("Task 2", 30, 40, 4000l);
		MultiplyingTask multiplyingTask3 = new MultiplyingTask("Task 3", 40, 50, 3000l);
		MultiplyingTask multiplyingTask4 = new MultiplyingTask("Task 4", 50, 60, 1000l);

		ExecutorService executorService = Executors.newFixedThreadPool(4);
		CompletionService<Integer> executorCompletionService = new ExecutorCompletionService<>(executorService);
		List<Future<Integer>> futures = new ArrayList<Future<Integer>>();
		futures.add(executorCompletionService.submit(multiplyingTask1));
		futures.add(executorCompletionService.submit(multiplyingTask2));
		futures.add(executorCompletionService.submit(multiplyingTask3));
		futures.add(executorCompletionService.submit(multiplyingTask4));

		for (int i = 0; i < futures.size(); i++) {
			try {
				Integer result = executorCompletionService.take().get();
				System.out.println("Result: " + result);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		executorService.shutdown();
	}
}

