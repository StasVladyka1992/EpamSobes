package Thread.key_words_and_commands;


//interrupt(), isInterrupted(), Thread.interrupted()
//Метод interrupt() — устанавливает флаг прерывания потока в true.
//Метод boolean isInterrupted() объекта потока возвращает состояние флага прерывания и оставляет этот флаг нетронутым.
//Статический метод boolean Thread.interrupted() — возвращает состояние флага и сбрасывает его к false. Т.е. он нужен для того
//чтобы сбросить interrupt на false

//Interrupted exception
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
