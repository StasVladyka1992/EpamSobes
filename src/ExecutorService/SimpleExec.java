package ExecutorService;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleExec {
    //В многопоточный пакет concurrent для управления потоками включено средство, называемое сервисом исполнения ExecutorService.
    // Данное средство служит альтернативой классу Thread, предназначенному для управления потоками.
    // В основу сервиса исполнения положен интерфейс Executor, в котором определен один метод : void execute(Runnable thread);

    //При вызове метода execute исполняется поток thread. То есть, метод execute запускает указанный поток на исполнение.
    // Следующий код показывает, как вместо обычного старта потока Thread.start()
    // можно запустить поток с использованием сервиса исполнения :

    public static void main(String[] args) {
        RunnableClass rc1 = new RunnableClass("Нить1");
        rc1.start();

        // альтернативный способ запуска нити
        // создается объект класса, использующего интерфейс ExecutorService

        // несмотря на присвоение имени, нить все равно переименовывается
        RunnableClass rc2 = new RunnableClass("Нить2");
        RunnableClass rc3 = new RunnableClass("Нить3");
        RunnableClass rc4 = new RunnableClass("Нить4");
        RunnableClass rc5 = new RunnableClass("Нить5");
        RunnableClass rc6 = new RunnableClass("Нить6");

        ExecutorService es = Executors.newFixedThreadPool(2);

        // отправка задания на выполнение пулу нитей.
        es.execute(rc2);
        es.execute(rc3);
        es.execute(rc4);
        es.execute(rc5);
        es.execute(rc6);

        // после выполнения всех заданий работа пула прекращается
        es.shutdown();

    }


}