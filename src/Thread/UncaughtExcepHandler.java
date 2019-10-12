package Thread;

public class UncaughtExcepHandler implements Runnable {
    public static void main(String[] args) {
    Thread t = new Thread(new UncaughtExcepHandler());
    // если исключение выкинется в другой нити, то мы о нем никак не узнаем
    // для его перехвата используется UncaughtExceptionHandler.
    // который создается с помощью абстрактного класса.
    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = new Thread.UncaughtExceptionHandler() {
        @Override

       // переопределил метод так, чтобы он выводил инфу о том, где было выкинуто исключение
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("Исключение обработано");
            e.printStackTrace();
        }
    };
    t.setUncaughtExceptionHandler(uncaughtExceptionHandler);
    t.start();



    Thread t2 = new Thread(new UncaughtExcepHandler());
    t2.setUncaughtExceptionHandler(uncaughtExceptionHandler);

    }



    @Override
    public void run() {
        throw new ArithmeticException();
    }

}
