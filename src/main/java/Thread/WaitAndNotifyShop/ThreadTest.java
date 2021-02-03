package Thread.WaitAndNotifyShop;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class ThreadTest implements Runnable, Serializable {
	private static final Object lockObject = new Object();

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " стартовала");
		synchronized (lockObject) {
			try {
				lockObject.wait(1000);
//				lockObject.notify();
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}

		System.out.println(Thread.currentThread().getName() + " остановилась");
	}


	public static void main(String[] args) {
		Integer [] ar = {1,2, 3};
		List<Integer> l = Arrays.asList(ar);

		for (int i = 0; i < 10; i++) {
			new Thread(new ThreadTest()).start();
		}
	}
}
