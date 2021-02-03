package Patterns.Adapter;

/**
 * Суть паттерна очень проста. У нас есть Client, который работает с определенным инферфейсом. И есть класс, который
 * имеет метод, использование которого надо адаптировать под клиент, который работает с другим интерфейсом. Реализовать
 * паттерн проектирования можно несколькими способами. Один из них через наследование, а второй через композицию
 */
public class AdapterApp {
	public static void main(String[] args) {
		AlternativeCurrencyDevice device = new AlternativeCurrencyDevice();
		device.turnOn();
	}
}
