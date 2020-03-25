package Thread.thread_creation;

public class WithOnlyThread extends Thread {
	@Override
	public void run() {
		System.out.println("Hi from thread");
	}

	public static void main(String[] args) {
		//переопределить в классе метод run
		WithOnlyThread withOnlyThread = new WithOnlyThread();
		withOnlyThread.start();

		//через лямбду
		Runnable runnable = () -> {
			System.out.println("hi");
		};
		Thread thread = new Thread(runnable);
		thread.start();

		//eще короче через лямбду
		Thread t = new Thread(() -> System.out.println(Thread.currentThread().getName()));
		t.start();
	}
}
