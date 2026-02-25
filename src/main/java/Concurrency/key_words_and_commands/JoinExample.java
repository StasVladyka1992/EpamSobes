package Concurrency.key_words_and_commands;

public class JoinExample {
	/*
	Вызов метода join у созданной нити приводит к тому, что нить, ее создавшая, будет ждать ее завершения
	*/
	public static void main(String[] args) throws InterruptedException {
		Thread child = new Thread(() -> {
			System.out.println("I'm a child thread");
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				/*NOP*/
			}
		});

		child.start();
		child.join();

		System.out.println("I'm the end");
	}
}
