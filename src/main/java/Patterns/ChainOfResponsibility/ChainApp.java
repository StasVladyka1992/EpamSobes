package Patterns.ChainOfResponsibility;

import static Patterns.ChainOfResponsibility.Level.DEBUG;
import static Patterns.ChainOfResponsibility.Level.ERROR;
import static Patterns.ChainOfResponsibility.Level.INFO;

/**
 * Суть паттерна очень простая. У нас есть наборы классов, каждый из которых имплементит интерфейс или
 * наследуется от абстрактного класса. Каждый класс переопределяет метод, и передает далее управление
 * по цепочке другому классу, если он существует, который является полем у данного.
 */
public class ChainApp {
	public static void main(String[] args) {
		FileLogger fileLogger = new FileLogger(DEBUG);
		fileLogger.setNextLogger(new ConsoleLogger(INFO));

		fileLogger.log("Сообщение", ERROR);
	}
}

class Level {
	public static final int ERROR = 1;
	public static final int DEBUG = 2;
	public static final int INFO = 3;
}

//делаем абстрактным классом, тчобы не повторялись поля
abstract class Logger {
	protected int priority;
	protected Logger nextLogger;

	public Logger(int priority) {
		this.priority = priority;
	}

	public void setNextLogger(Logger nextLogger) {
		this.nextLogger = nextLogger;
	}

	void log(String message, int priority) {
		if (priority <= this.priority) {
			writeMessage(message, priority);
		}

		if (nextLogger != null) {
			nextLogger.log(message, priority);
		}
	}

	abstract void writeMessage(String message, int priority);

}

class FileLogger extends Logger {
	public FileLogger(int priority) {
		super(priority);
	}

	@Override
	void writeMessage(String message, int priority) {
		System.out.println("File log:" + message);
	}
}

class ConsoleLogger extends Logger {
	public ConsoleLogger(int priority) {
		super(priority);
	}

	@Override
	void writeMessage(String message, int priority) {
		System.out.println("Console log:" + message);
	}
}
