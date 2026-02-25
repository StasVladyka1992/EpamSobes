package Concurrency.thread.creation;

import java.util.concurrent.*;

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

public class CallableInterface implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("I'm new thread");
        Thread.sleep(2000);
        return "my callable thread";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //TODO ============== TRADITIONAL FUTURE (Java 5+) ==============
        System.out.println("=== TRADITIONAL FUTURE EXAMPLE ===");

        //Первый способ (лямбда)
        Callable<String> callableLambda = () -> "Hello, World!";

        //Второй способ (реализация интерфейса)
        Callable<String> callable = new CallableInterface();
        FutureTask<String> stringFuture = new FutureTask<>(callable);
        Thread thread = new Thread(stringFuture);
        thread.start();

        // Проблема Future: get() блокирует поток до получения результата
        System.out.println("Result from FutureTask: " + stringFuture.get());






        //TODO ============== COMPLETABLE FUTURE (Java 8+) ==============
        System.out.println("\n=== COMPLETABLE FUTURE EXAMPLES ===");

        // 1. TODO Простой запуск асинхронной задачи
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Future1, main task: " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Result from CompletableFuture";
        });

        // Не блокируем поток, добавляем callback
        future1.thenAcceptAsync(result -> {
            System.out.println("Future1: " + Thread.currentThread().getName());
            System.out.println("Callback result: " + result);
        }).get();
//
//        // 2. TODO Цепочка асинхронных операций
        CompletableFuture.supplyAsync(() -> {
            System.out.println("Stage 1: Fetching user data...");
            return "user_123";
        }).thenApply(userId -> {
            System.out.println("Stage 2: Fetching orders for " + userId);
            return "orders for " + userId;
        }).thenApply(orders -> {
            System.out.println("Stage 3: Processing " + orders);
            return orders.toUpperCase();
        }).thenAccept(finalResult -> {
            System.out.println("Final result: " + finalResult);
        });
//
//        // 3. TODO Комбинирование нескольких асинхронных задач
        CompletableFuture<String> userFuture = CompletableFuture.supplyAsync(() -> {
            sleep(1);
            return "John Doe";
        });

        CompletableFuture<Integer> ageFuture = CompletableFuture.supplyAsync(() -> {
            sleep(1);
            return 30;
        });

        // Объединяем результаты двух futures
        userFuture.thenCombine(ageFuture, (user, age) ->
                user + " is " + age + " years old"
        ).thenAccept(combined ->
                System.out.println("Combined result: " + combined)
        );
//
//        // 4. TODO Обработка ошибок
        CompletableFuture.supplyAsync(() -> {
            if (Math.random() > 0.5) {
                throw new RuntimeException("Something went wrong!");
            }
            return "Success!";
        }).thenApply(result -> {
            System.out.println("Processing: " + result);
            return result;
        }).exceptionally(throwable -> {
            System.out.println("Error occurred: " + throwable.getMessage());
            return "Default value";
        }).thenAccept(finalResult ->
                System.out.println("Final after error handling: " + finalResult)
        );
//
//        // 5. TODO Параллельное выполнение нескольких задач и ожидание всех
        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> {
            sleep(2);
            return "Task 1 completed";
        });

        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> {
            sleep(1);
            return "Task 2 completed";
        });

        CompletableFuture<String> task3 = CompletableFuture.supplyAsync(() -> {
            sleep(3);
            return "Task 3 completed";
        });
//
//        // Ждем завершения всех задач
//        CompletableFuture.allOf(task1, task2, task3)
//                .thenRun(() -> System.out.println("All tasks completed!"))
//                .join(); // join() аналогичен get(), но не бросает checked exceptions
//
//        // Получаем результаты каждой задачи
//        System.out.println(task1.getNow("not done")); // getNow возвращает результат или default
//        System.out.println(task2.getNow("not done"));
//        System.out.println(task3.getNow("not done"));
//
//        // 6. TODO Future vs CompletableFuture - сравнение
        System.out.println("\n=== FUTURE vs COMPLETABLEFUTURE ===");

        // Future - нужно явно проверять и ждать
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            Thread.sleep(1000);
            return "Future result";
        });
        new Thread(futureTask).start();

        // Блокирующее ожидание

        while (!futureTask.isDone()) {
            System.out.println("Future: Still waiting...");
            Thread.sleep(200);
        }
        System.out.println("Future result: " + futureTask.get());

        // CompletableFuture - асинхронные колбэки без блокировки
        CompletableFuture.supplyAsync(() -> {
            sleep(1);
            return "CompletableFuture result";
        }).thenApply(r -> {
            System.out.println("CompletableFuture: Processing result...");
            return r.toUpperCase();
        }).thenAccept(r ->
                System.out.println("CompletableFuture final: " + r)
        );

        // Даем время на выполнение всех асинхронных операций
        Thread.sleep(5000);
    }

    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
