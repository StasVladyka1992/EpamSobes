package Concurrency.phaser;

/*
Phaser (фазер), как и CyclicBarrier, является реализацией шаблона синхронизации Барьер, но, в отличии от CyclicBarrier,
предоставляет больше гибкости. Этот класс позволяет синхронизировать потоки, представляющие отдельную фазу или стадию
выполнения общего действия. Как и CyclicBarrier, Phaser является точкой синхронизации, в которой встречаются потоки-участники.
Когда все стороны прибыли, Phaser переходит к следующей фазе и снова ожидает ее завершения.

Если сравнить Phaser и CyclicBarrier, то можно выделить следующие важные особенности Phaser:

    1) Каждая фаза (цикл синхронизации) имеет номер;
    2) Количество сторон-участников жестко не задано и может меняться: поток может регистрироваться в качестве участника и отменять свое участие;
    3) Участник не обязан ожидать, пока все остальные участники соберутся на барьере. Чтобы продолжить свою работу достаточно
    сообщить о своем прибытии;
    4) Случайные свидетели могут следить за активностью в барьере;
    5) Поток может и не быть стороной-участником барьера, чтобы ожидать его преодоления;
    6) У фазера нет опционального действия.

Подробнее: https://habr.com/ru/post/277669/
 */

import java.util.concurrent.Phaser;

public class PhaserExample {
	private static final Phaser START = new Phaser(8);
	private static final int trackLength = 500000;

	public static void main(String[] args) throws InterruptedException {
		for (int i = 1; i <= 5; i++) {
			new Thread(new Car(i, (int) (Math.random() * 100 + 50))).start();
			Thread.sleep(100);
		}

		while (START.getRegisteredParties() > 3) //Проверяем, собрались ли все автомобили
			Thread.sleep(100);                  //у стартовой прямой. Если нет, ждем 100ms

		Thread.sleep(100);
		System.out.println("На старт!");
		START.arriveAndDeregister();
		Thread.sleep(100);
		System.out.println("Внимание!");
		START.arriveAndDeregister();
		Thread.sleep(100);
		System.out.println("Марш!");
		START.arriveAndDeregister();
	}

	public static class Car implements Runnable {
		private int carNumber;
		private int carSpeed;

		public Car(int carNumber, int carSpeed) {
			this.carNumber = carNumber;
			this.carSpeed = carSpeed;
		}

		@Override
		public void run() {
			try {
				System.out.printf("Автомобиль №%d подъехал к стартовой прямой.\n", carNumber);
				START.arriveAndDeregister();
				START.awaitAdvance(0);
				Thread.sleep(trackLength / carSpeed);
				System.out.printf("Автомобиль №%d финишировал!\n", carNumber);
			} catch (InterruptedException e) {
			}
		}
	}
}

