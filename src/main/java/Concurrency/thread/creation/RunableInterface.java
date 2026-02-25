package Concurrency.thread.creation;

// существует 2 способа создания нитей.
//  - Первый: имплементировать классом интерфейс Runnable в классе, а затем передать объект этого класса в качестве параметра
//    в конструктор Thread

//  - Унаследовать от Thread и переопределить метод run класса Thread, т.к. этот класс имплементирует интерфейс Runnable
//  - Использовать анонимный класс


public class RunableInterface implements Runnable {
    @Override
    public void run() {
        System.out.println("Я новая нить "+ Thread.currentThread().getName());
        for (int i = 10; i >= 0 ; i--) {
            System.out.println("Обратный отсчет: "+ i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        Thread thread = new Thread(new RunableInterface());
        thread.start();
    }
}
