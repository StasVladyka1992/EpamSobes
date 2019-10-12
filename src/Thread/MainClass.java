package Thread;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainClass extends Thread {

    @Override
    public void run() {
        System.out.println("Я новая нить из класса MainClass "+ currentThread().getName());
    }

    public static void main(String[] args) throws  InterruptedException, ExecutionException {
    // объект, который мы будем передавать в качестве параметра в объекты Thread
        WithRunableInterface th = new WithRunableInterface();

        // 1 способ создания нитей
        Thread th1 = new Thread(th);
        th1.start();


        // использование join, чтобы главная нить дождалась завершения работы остальных нитей, которые она вызвала
        th1.join();

        // 2 способ создания нитей
        MainClass mc = new MainClass();
        mc.start();

        mc.join();
        // System.out.println("Я ГЛАВНАЯ нить из класса MainClass" + currentThread().getName());
        System.out.println("Работа счетчика завершена!");

        // 3 способ создания нитей Callable интерфейс
        ExecutorService  pool = Executors.newFixedThreadPool(2);
        Set<Future<String>> set = new HashSet<>();
        for (int i = 0; i <2 ; i++) {
            Future<String> result = pool.submit(new WithCallableInterface());
            System.out.println(result.get());
            set.add(result);
        }

        //Получить текущую нить
        Thread.currentThread().getState();

        //Создание потока-демона:
        MainClass thread2 = new MainClass();
        thread2.setDaemon(true);
        thread2.run();

    }


    //метод join:
    //Одна нить (побочный поток) может вызвать метод join() у другой нити(главный поток). В результате первый поток
    //(главный поток) приостанавливает свою работу и ждет окончания работы побочного потока
    // (у объекта которого был вызван метод join()).

    //wait, notify, notifyAll()
    //Методы должны вызываться на объекте-мониторе только из синхронизированного кода.
    //Поток, который вызывает эти методы должен владеть МЬЮТЕКСОМ, иначе будет выдано исключение java.lang.IllegalMonitorStateException.

    //Interrupted exception
    //Методы, требующие обработку этого исключения: wait, sleep, join. Исключение будет выброшено,
    // если флаг interrupt у потока true.


    //interrupt(), isInterrupted(), Thread.interrupted()
    //Метод interrupt() — устанавливает флаг прерывания потока.
    //Метод boolean isInterrupted() объекта потока возвращает состояние флага прерывания и оставляет этот флаг нетронутым.
    //Статический метод boolean Thread.interrupted() — возвращает состояние флага и сбрасывает его к false.

    //mutex и monitor
    //Mutex - это специальный объект для синхронизации потоков. Он «прикреплен» к каждому объекту в Java
    //Особенности mutex
        //1) возможны только два состояния — «свободен» и «занят».
        //2) состояниями нельзя управлять напрямую. В Java нет механизмов, которые позволили бы явно взять объект,
          // получить его мьютекс и присвоить ему нужный статус.
    //Monitor - это кусок кода, который, который блокирует доступ к объекту

    // syncronized - блокирует мютекс, что позволяюет с ним работать только одной нити  до тех пор,
    // пока эта нить не завершит свой код. После этого мютекс освобождается и с объектом может начать работать другая нить

    // syncronized (this) - блокирует мютекс у объекта
    // syncronized (Myclass.class) - блокирует мютекс у объекта, который отвечает за класс, в результате чего все операции с данным
    // классом совершаются только данной нитью

    // volatile - заставляет работать с объектом только напрямую из обычной памяти, без кэш-памяти.
    // yield - сообщает, что нить досрочно завершила работу в пределах выделенного ей кванта времени. гарантирует также,
    // что следующий квант будет полным, а не кусочком.

    //ThreadGroup
    //ThreadGroup представляет собой набор нитей,
    //которые так же могут содержать в себе другие группы потоков. Группа нитей образует дерево,
    //в котором каждая другая группа нитей имеет родителя (кроме исходной).
    //Поток имеет право доступа к данным из своей группы нитей, но не имеет такого доступа к другим группам или
    //к родительской группе потоков.



}
