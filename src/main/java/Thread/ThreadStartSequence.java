package Thread;

public class ThreadStartSequence  {
    public static void main(String[] args) {
        // идет создание 100 потоков, однако за создание потока отвечает ОС, соответственно, когда мы
        // вызываем метод start(), ОС просто делает себе заметку создать и запустить поток, а когда именно, мы не знаем
        // поэтому поток, который мы создали раньше мб запущен после более позднего потока. Что и демонстрирует этот пример
        for (int i = 0; i <100 ; i++) {
            Thread t = new Thread(() -> System.out.println(Thread.currentThread().getName()));
            t.setName("Thread "+i);
            t.start();
        }
    }
}
