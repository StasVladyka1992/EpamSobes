package Concurrency.key_words_and_commands;

//wait, notify, notifyAll()
//Методы должны вызываться на ОБЪЕКТЕ-МОНИТОРЕ только из СИНХРОНИЗИРОВАННОГО кода.
//Поток, который вызывает эти методы, должен владеть МЬЮТЕКСОМ, иначе будет выдано исключение java.lang.IllegalMonitorStateException.

//TODO WAIT(механизм работы):
//освободит мьютекс и переведет нить в состояние WAITING or TIME_WAITING. Иногда нити могут сами просыпаться, поэтому
//wait крутить лучше в цикле. Также лучше использовать notifyAll, если не гонимся сильно за оптимизацией

// TODO NOTIFY(механизм работы):
// notify используется для пробуждения нитей, которые уснули с помощью метода wait. Спящие нити не позволят программе
// завершится
// Как только текущая нить выйдет из блока synchronized, одна из проснувшихся нитей захватит мютекс и продолжит свою работу.
// Когда она освободит мютекс, другая проснувшаяся нить захватит мютекс и т.д.
public class WaitAndNotifyExample {
	private static final Object lockObject = new Object();
	private static volatile int counter = 0;

	public static void main(String[] args) {
		WaitAndNotifyExample waitAndNotifyExample = new WaitAndNotifyExample();
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(waitAndNotifyExample.new RunnableImpl());
			thread.start();
		}
	}

	private class RunnableImpl implements Runnable {
		@Override
		public void run() {
			try {
				synchronized (lockObject) {
					System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState());
					Thread.sleep(1000);
					counter++;
					if(counter == 5){
						lockObject.notifyAll();
					}
//					else {
						lockObject.wait();
//					}
					System.out.println("mutex released");

				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
