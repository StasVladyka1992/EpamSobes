package Concurrency.key_words_and_commands;


/*
 * У каждого потока есть внутренний флаг (boolean), который:
 * - По умолчанию = false
 * - interrupt() устанавливает в true
 * - isInterrupted() проверяет, НЕ меняя флаг
 * - Thread.interrupted() проверяет И СБРАСЫВАЕТ в false
 */

//Interrupted exception выбрасывается только в состоянии WAITING или TIMED_WAITING
//Методы, требующие обработку этого исключения: wait, sleep, join. Исключение будет выброшено,
//если флаг interrupt у потока true.

import static java.lang.Thread.interrupted;

public class SleepExample {
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
