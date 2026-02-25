package Concurrency.countdown_latch;

import java.util.concurrent.CountDownLatch;

/*
CountDownLatch (замок с обратным отсчетом) предоставляет возможность любому количеству потоков в блоке кода ожидать
до тех пор, пока не завершится определенное количество операций, выполняющихся в других потоках, перед тем как они
будут «отпущены», чтобы продолжить свою деятельность. В конструктор CountDownLatch (CountDownLatch(int count))
обязательно передается количество операций, которое должно быть выполнено, чтобы замок «отпустил» заблокированные потоки.
Уменьшение счетчика производится за счет команды countDown(). Блокировка за счет await(); Позволяет отпускать все потоки
одновременно

Блокировка потоков снимается с помощью счётчика: любой действующий поток, при выполнении определенной операции уменьшает
значение счётчика. Когда счётчик достигает 0, все ожидающие потоки разблокируются и продолжают выполняться
(примером CountDownLatch из жизни может служить сбор экскурсионной группы: пока не наберется определенное количество
человек, экскурсия не начнется).
*/
public class CountDownLatchExample {
	private static final CountDownLatch START = new CountDownLatch(8);
	//Условная длина гоночной трассы
	private static final int trackLength = 500000;

	public static void main(String[] args) throws InterruptedException {
		for (int i = 1; i <= 5; i++) {
			new Thread(new Car(i, (int) (Math.random() * 100 + 50))).start();
		}

		while (START.getCount() > 3) { //Проверяем, собрались ли все автомобили
			Thread.sleep(100);              //у стартовой прямой. Если нет, ждем 100ms
		}

		Thread.sleep(1000);
		System.out.println("На старт!");
		START.countDown();//Команда дана, уменьшаем счетчик на 1
		Thread.sleep(1000);
		System.out.println("Внимание!");
		START.countDown();//Команда дана, уменьшаем счетчик на 1
		Thread.sleep(1000);
		System.out.println("Марш!");
		START.countDown();//Команда дана, уменьшаем счетчик на 1
		//счетчик становится равным нулю, и все ожидающие потоки
		//одновременно разблокируются
	}

	public static class Car implements Runnable {
		private int carNumber;
		private int carSpeed;//считаем, что скорость автомобиля постоянная

		public Car(int carNumber, int carSpeed) {
			this.carNumber = carNumber;
			this.carSpeed = carSpeed;
		}

		@Override
		public void run() {
			try {
				System.out.printf("Автомобиль №%d подъехал к стартовой прямой.\n", carNumber);
				//Автомобиль подъехал к стартовой прямой - условие выполнено
				//уменьшаем счетчик на 1
				START.countDown();
				//метод await() блокирует поток, вызвавший его, до тех пор, пока
				//счетчик CountDownLatch не станет равен 0
				START.await();
				Thread.sleep(trackLength / carSpeed);//ждем пока проедет трассу
				System.out.printf("Автомобиль №%d финишировал!\n", carNumber);
			} catch (InterruptedException e) {
			}
		}
	}
}
