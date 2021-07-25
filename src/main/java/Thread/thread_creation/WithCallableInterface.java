package Thread.thread_creation;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//При работе многопоточного приложения часто необходимо получение от потока результата его деятельности
//в виде некоторого объекта. Эту задачу можно решить с использованием интерфейсов Callable<V> и Future<V>.
//Совместное использование двух реализаций данных интерфейсов позволяет получить результат в виде некоторого объекта.
//Данный способ создания потоков появился в java 1.5

//Интерфейс Future также, как и интерфейс Callable, использует Generic'и. Методы интерфейса можно использовать
//для проверки завершения работы потока, ожидания завершения и получения результата. Результат выполнения может
//быть получен методом get, если поток завершил работу. Прервать выполнения задачи можно методом cancel.
//Дополнительные методы позволяют определить завершение задачи : нормальное или прерванное.
//Если задача завершена, то прервать ее уже невозможно. Для старта выполнения задания пулом потоков используется объект
//Future и метод submit();

public class WithCallableInterface implements Callable<String> {
	@Override
	public String call() throws Exception {
		System.out.println("I'm new thread");
		Thread.sleep(20000);
		return "my callble thread";
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		//Первый способ
//        Callable <String> callable = () -> {
//            return "Hello, World!";
//        };

		//Второй способ
		Callable<String> callable = new WithCallableInterface();
		FutureTask<String> stringFuture = new FutureTask<>(callable);
		Thread thread = new Thread(stringFuture);
		thread.start();
		System.out.println("Result: " + stringFuture.get());

//		c java 1.8 появился интерфейс CompletableFuture:
//		https://blog.knoldus.com/future-vs-completablefuture-1/
//		https://www.baeldung.com/java-completablefuture
//		Future не позволял докрутить определенную логику обработки, а требовалось проверять isDone или ждать get, например:
//	    stringFuture.doSmth( res -> ...). CompletableFuture позволяет.


	}



}
