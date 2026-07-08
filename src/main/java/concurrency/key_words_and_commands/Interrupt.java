package concurrency.key_words_and_commands;


/*
 * У каждого потока есть внутренний флаг (boolean), который:
 * - По умолчанию = false
 * - interrupt() устанавливает в true
 * - isInterrupted() проверяет, НЕ меняя флаг
 * - Thread.interrupted() проверяет И СБРАСЫВАЕТ в false - главное его назначение СБРОС СТАТУСА ПРЕРЫВАНИЯ (для перезапуска потока это нужно)
	 Важно, если выбрасывается InterruptedException то, JVM автоматически сбрасывает флаг прерывания в false.
 */
//
//Interrupted exception выбрасывается только в состоянии WAITING или TIMED_WAITING
//Методы, требующие обработку этого исключения: wait, sleep, join. Исключение будет выброшено,
//если флаг interrupt у потока true.



//TODO socket исключение
//Socket I/O НЕ реагирует на InterruptedException
//Socket socket = new Socket("localhost", 8080);
//		InputStream in = socket.getInputStream();

// ❌ Не прервётся через interrupt()
// thread.interrupt() не поможет
//		int data = in.read();  // будет блокироваться вечно

// ✅ Решение: закрыть сокет из другого потока
//		thread.interrupt();
//		socket.close();  // вызовет IOException в read()


// Каналы NIO реагируют на прерывания правильно
//AsynchronousFileChannel channel = AsynchronousFileChannel.open(path);
//Future<Integer> future = channel.read(buffer, 0);

// Прерывание потока отменит операцию
//thread.interrupt();  // future.get() выбросит CancellationException


//TODO Золотое правило: Если вы перехватываете InterruptedException и не пробрасываете его дальше,
// обязательно вызовите Thread.currentThread().interrupt(), чтобы восстановить флаг для кода выше по стеку.


import static java.lang.Thread.interrupted;

public class Interrupt {
	public static void main(String[] args) {
		Thread thread = new Thread(()-> {
			System.out.println("Thread start");
			try{
				System.out.println(interrupted());
				Thread.sleep(2000);
			}
			catch (Exception e){
				System.out.println("exeption");
			}
		});

		thread.start();
		thread.interrupt();
	}
}
