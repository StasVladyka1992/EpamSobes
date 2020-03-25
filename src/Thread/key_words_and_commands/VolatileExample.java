package Thread.key_words_and_commands;

public class VolatileExample {
	/*Чтобы ускорить свою работу, процессор копирует самые часто используемые переменные из области памяти в свой кэш
	 * и все изменения с ними производит в этой быстрой памяти. А после – копирует обратно в «медленную» память.
	 * Медленная память все это время содержит старые(!) (неизмененные) значения переменных.
	 * Чтобы пофиксить эту проблему Было придумано специальное ключевое слово volatile.
	 * Использование этого слова перед переменной принудительно всегда читало и писало ее только в обычную (медленную)
	 * память.
	 *
	 * Есть странные ситуации, но онм могут быть связаны с тем, что несколько потоков зашли в sout, готовясь вывести
	 * значение на консоль, а в этот момент их прервали.
	*/
	private static volatile long counter = 1;

	public static void main(String[] args) {
		Runnable runnable1 = () -> {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(1000);
					System.out.println(counter);
				} catch (InterruptedException e) {
					/*NOP*/
				}

			}

		};

		Runnable runnable2 = () -> {
			for (int i = 0; i < 50; i++) {
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					/*NOP*/
				}

				long generated = (long) (Math.random() * 10);
				System.out.println("generated " + generated);
				counter = generated;
			}

		};

		for (int i = 0; i<10000; i++){
			Thread thread1 = new Thread(runnable1);
			thread1.start();
		}

		Thread thread2 = new Thread(runnable2);


		thread2.start();

	}
}
