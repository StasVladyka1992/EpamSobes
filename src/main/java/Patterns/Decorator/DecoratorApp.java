package Patterns.Decorator;

import java.sql.SQLOutput;

/**
 * Decorator - очень схож с Delegate. Но их отличие в том, что Delegate НЕ МЕНЯЕТ логику метода, просто вызывая метод
 * методы другого класса, а Decorator добавляет свою логику. Ну и можно создавать большие цепочки вызовов декораторов
 */
public class DecoratorApp {
	public static void main(String[] args) {
		Printer printer = new Printer();
		QuotesDecorator quotesDecorator = new QuotesDecorator(new BracketsDecorator(printer));
		quotesDecorator.print();
	}
}

interface PrinterInterface {
	void print();
}

class Printer implements PrinterInterface {

	@Override
	public void print() {
		System.out.print("Word");
	}
}

class QuotesDecorator implements PrinterInterface{
	private PrinterInterface printerInterface;

	public QuotesDecorator(PrinterInterface printerInterface) {
		this.printerInterface = printerInterface;
	}

	@Override
	public void print() {
		System.out.print("\"");
		printerInterface.print();
		System.out.print("\"");
	}
}


class BracketsDecorator implements PrinterInterface{
	private PrinterInterface printerInterface;

	public BracketsDecorator(PrinterInterface printerInterface) {
		this.printerInterface = printerInterface;
	}

	@Override
	public void print() {
		System.out.print("(");
		printerInterface.print();
		System.out.print(")");
	}
}
