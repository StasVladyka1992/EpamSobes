package Concurrency.key_words_and_commands;

/*
Когда мы запускаем дочернюю нить, программа продолжает работать, даже если главная нить завершилась.
Java-машина не закрывает программу, пока есть хотя бы одна работающая нить. Однако если мы установим флаг setDaemon(true),
JVM прекратит работу, несмотря на наличие работающей нити
 */

public class DaemonExample {
	public static void main(String[] args) {
		Thread thread = new Thread(() -> {
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
			}
		});

		thread.setDaemon(true);
		thread.start();
	}
}
