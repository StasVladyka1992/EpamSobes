package Thread.thread_group;

import java.util.concurrent.ExecutionException;


//ThreadGroup представляет собой набор нитей,
//которые так же могут содержать в себе другие группы потоков. Группа нитей образует дерево,
//в котором каждая другая группа нитей имеет родителя (кроме исходной).
//Поток имеет право доступа к данным из своей группы нитей, но не имеет такого доступа к другим группам или
// к родительской группе потоков. ThreadGroup позволяет работать с группами нитей как единым целым.
public class ThreadGroupExample {

	public static void main(String[] args) {
		ThreadGroup group = new ThreadGroup("group1");

		Thread thread1 = new Thread(group, () -> {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		Thread thread2 = new Thread(group, () -> {
			System.out.println(Thread.currentThread().getName());
		});
		Thread thread3 = new Thread(group, () -> {
			System.out.println(Thread.currentThread().getName());
		});

		thread1.start();
		thread2.start();
		thread3.start();

		group.destroy();
		System.out.println(group.isDestroyed());

	}
}
