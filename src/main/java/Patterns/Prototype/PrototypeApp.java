package Patterns.Prototype;

import javax.sound.sampled.Port;

/**
 * Суть шаблона, что объект должен уметь генерировать копию самого себя. (клонирование), как раз-таки этот интерфейс
 * и реализован в java
 * 1) Создается интерфейс Prototype c одним единственным интерфейсом copy
 */
public class PrototypeApp {
	public static void main(String[] args) {
		Composition composition = new Composition("my text");
		Composition composition1 = (Composition) composition.copy();
		composition.setText("change text");
		System.out.println(composition1.text);
	}
}

interface Prototype{
	Object copy();
}

class Composition implements Prototype {
	String text;

	public Composition(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public Object copy() {
		Composition copy = new Composition(this.getText());
		copy.setText(this.getText());
		return copy;
	}
}
