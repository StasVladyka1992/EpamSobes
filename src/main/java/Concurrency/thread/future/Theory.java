package Concurrency.thread.future;


//TODO История возникновения CompletableFuture.
//В java 5 появился интерфейс Future, который позволяет вернуть результат работы потока.
// Несмотря на существенный прогресс, у него имелись недостатки:

//1. Нет возможности зарегистрировать callback
//2. Нет способа комбинировать futures
//3. Нет обработки ошибок
//4. Блокирующий get()
//5. Нельзя отменить задачу чисто

//В java 8 появился CompletableFuture.
//В отличие от обычного Future, где поток ждет результат, CompletableFuture работает по принципу "регистрации колбэков":

//TODO Устройство CompletableFuture:
/*
 public class CompletableFuture<T> implements Future<T>, CompletionStage<T> {
    // Текущий результат (volatile для видимости между потоками)
    private volatile Object result;  // null если не завершен

    // Стек зависимых действий (Completion) - lock-free стек Treiber
    // Когда результат устанавливается, все Completion из стека запускаются
    private volatile Completion stack;  //TODO Completion extends ForkJoinTask<Void> implements Runnable, AsynchronousCompletionTask
}


TODO Создание CompletableFuture
public class WhenCompletionCreated {

    public static void main(String[] args) {
        CompletableFuture<String> future = new CompletableFuture<>();

        // КАЖДЫЙ вызов thenXXX создает новый Completion
        CompletableFuture<String> f2 = future.thenApply(s -> s.toUpperCase());
        // Здесь создается UniApply Completion

        CompletableFuture<Void> f3 = future.thenAccept(System.out::println);
        // Здесь создается UniAccept Completion

        CompletableFuture<Void> f4 = future.thenRun(() -> System.out.println("Done"));
        // Здесь создается UniRun Completion

        // Заглянем в стек future
        inspectStack(future);
    }

    private static void inspectStack(CompletableFuture<?> future) {
        try {
            Field stackField = CompletableFuture.class.getDeclaredField("stack");
            stackField.setAccessible(true);
            Object stack = stackField.get(future);

            System.out.println("Стек содержит:");
            while (stack != null) {
                System.out.println("  - " + stack.getClass().getSimpleName());
                Field nextField = stack.getClass().getDeclaredField("next");
                nextField.setAccessible(true);
                stack = nextField.get(stack);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Вывод:
// Стек содержит:
//   - UniRun
//   - UniAccept
//   - UniApply


TODO Завершение CompletableFuture
public class CompletionMechanism {

    // Как происходит завершение цепочки

    static class MyCompletableFuture<T> {
        private volatile Object result;
        private volatile Completion stack;

        // Метод complete вызывается для завершения future
        public boolean complete(T value) {
            // CAS - устанавливаем результат
            if (RESULT.compareAndSet(this, null, value)) {
                // Запускаем все зависимые Completion'ы
                postComplete();
                return true;
            }
            return false;
        }

        private void postComplete() {
            CompletableFuture<?> f = this;
            while (true) {
                Completion next = f.stack;
                if (next == null) break;

                // Удаляем из стека и запускаем, CAS
                if (STACK.compareAndSet(f, next, next.next)) {
                    next.run(); // Внутри run() этот Completion завершит следующий future
                }
            }
        }
    }

    // Как Completion завершает следующий future
    static class UniApply<T, V> extends Completion {
        CompletableFuture<T> dep;      // родительский future
        CompletableFuture<V> src;       // дочерний future (который нужно завершить)
        Function<? super T, ? extends V> fn;

        public void run() {
            T result = dep.result;  // берем результат родителя

            try {
                V applied = fn.apply(result);  // применяем функцию
                src.complete(applied);  // ЗАВЕРШАЕМ дочерний future!
            } catch (Throwable e) {
                src.completeExceptionally(e);
            }
        }
    }

}



//TODO Методы CompletableFuture:
--completedFuture (создание CompletableFuture)
--thenAccept
--thenRun
--thenCombine
--thenApply
--thenCompose
--handle
--whenComplete
--exceptionally

--supplyAsync/runAsync
--thenAcceptAsync
--thenRunAsync
--thenCombineAsync
--thenApplyAsync
--thenComposeAsync
--handleAsync
--whenCompleteAsync
--exceptionallyAsync

Разница в этих методах заключается в том, что методы без Async не меняют поток при выполнении, а методы с Async меняют, если это необходимо.
Поток берется из common pool (ForkJoinPool). Так же можно задавать свои пулы.

//TODO Future processing:
Это достаточно сложный процесс, который работает через механизм колбэков и цепочек. Существуют следующие сценарии:

1) TODO Завершение через ExecutionService (старый подход):

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(() -> {
            // Этот поток выполнит задачу и завершит Future
            return "result";
        });
        // Future будет завершен тем потоком, который выполнил задачу

2) TODO Завершение и создание ОДНИМ и тем же потоком:

        CompletableFuture<String> cf = new CompletableFuture<>();
        cf.complete("manual result");

3) TODO Завершение через механизм колбэков и цепочек.

        CompletableFuture.supplyAsync(() -> "Hello")
          .thenApply(s -> s + " World")
          .thenAccept(System.out::println);
*/



import java.util.concurrent.*;

public class Theory {
    private static ExecutorService executor = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        futureExample();
        completableFutureExample();

        CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply(s -> s + " WORLD")
                .thenAccept(System.out::println);
    }

    private static void completableFutureExample() {

        // 1.TODO Асинхронное выполнение с лямбдами
        CompletableFuture<Void> future = CompletableFuture
                .supplyAsync(() -> "Hello")
                .thenApply(s -> s + " World")
                .thenApply(String::toUpperCase)
                .thenAccept(System.out::println);

        // 2.TODO Комбинирование futures
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "World");

        f1.thenCombine(f2, (s1, s2) -> s1 + " " + s2)
                .thenAccept(System.out::println);

        // 3.TODO Обработка ошибок
        CompletableFuture.supplyAsync(() -> {
                    if (Math.random() > 0.5) throw new RuntimeException("Error");
                    return "Success";
                })
                .exceptionally(ex -> "Fallback value")
                .thenAccept(System.out::println);

        // 4.TODO Ожидание нескольких futures
        CompletableFuture<Void> all = CompletableFuture.allOf(f1, f2);
        all.thenRun(() -> System.out.println("All completed"));


        //-------------------------------------------Java 9----------------------------
        CompletableFuture<String> stringFuture = CompletableFuture.supplyAsync(() -> "result");

        // 1. orTimeout - таймаут с исключением
        stringFuture.orTimeout(1, TimeUnit.SECONDS)
                .exceptionally(ex -> "Timeout occurred");

        // 2. completeOnTimeout - значение по умолчанию при таймауте
        stringFuture.completeOnTimeout("default", 1, TimeUnit.SECONDS)
                .thenAccept(System.out::println);

        // 3. copy - копия CompletableFuture
        CompletableFuture<String> copy = stringFuture.copy();

        // 4. defaultExecutor - получение дефолтного executor'а
        Executor executor = stringFuture.defaultExecutor();

        // 5. delayedExecutor - executor с задержкой
        Executor delayed = CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS);
        CompletableFuture.supplyAsync(() -> "delayed", delayed);


        //-------------------------------------------Java 12----------------------------
        // 1. Exceptionally with Function (Java 12)
        CompletableFuture.supplyAsync(() -> "data")
                .exceptionallyAsync(ex -> "recovery")  // асинхронное восстановление
                .thenAccept(System.out::println);

        // 2. CompletableFuture как Publisher для Reactive Streams
        CompletableFuture<String> future3 = CompletableFuture.completedFuture("data");

        // 3. Интеграция с Project Loom (Virtual Threads)
        // В Java 19+ CompletableFuture хорошо работает с виртуальными потоками
        CompletableFuture.supplyAsync(() -> {
            // Этот код может выполняться в виртуальном потоке
            return "heavyOperation()";
        });
    }

    private static void futureExample() {
        var callable = createCallable();
        var future = executor.submit(callable);
        getFutureResult(future);

        executor.shutdown();
    }

    private static Callable<String> createCallable() {
        return () -> {
            Thread.sleep(1000);
            return "Result from task";
        };
    }

    private static void getFutureResult(Future<String> future) {
        try {
            String result = future.get(); // TODO Блокировка!
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
