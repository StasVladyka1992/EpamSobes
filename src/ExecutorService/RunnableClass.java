package ExecutorService;

import java.util.concurrent.CountDownLatch;

public class RunnableClass extends Thread {
    private CountDownLatch countDownLatch;
    public int count = 5;

    public RunnableClass(String name) {
        this.setName(name);
        countDownLatch = new CountDownLatch(count);

    }

    public RunnableClass() {
    }

    @Override
    public void run() {
        for (; count >0 ; count--) {
            System.out.println(Thread.currentThread().getName()+ " "+count);
            countDownLatch.countDown();
        }

    }

}
