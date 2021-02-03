package Patterns.Composite;

import java.util.ArrayList;
import java.util.List;

/**
 *Суть паттерна очень проста - это как бы матрешки.
 * Есть интерфейс Component - основной интерфейс, который имплементят все другие классы.
 * Далее есть интерфейс Node - это самый маленький кирпичик. И класс композит, который содержит все Node
 * Аналогия - чемодан и вещи!
 */
public class CompositeApp {
	public static void main(String[] args) {
		Component mobile = new Mobile();
		Component solederingIron = new SolderingIron();
		Box box = new Box();

		box.addComponent(mobile);
		box.addComponent(solederingIron);
		box.doSomething();

	}
}

interface Component{
	void doSomething();
}

class Mobile implements Component{
	@Override
	public void doSomething() {
		System.out.println("Call to parents");
	}
}

class SolderingIron implements  Component{
	@Override
	public void doSomething() {
		System.out.println("soldering");
	}
}

class Box implements Component{
	private List<Component> components = new ArrayList<>();

	void addComponent(Component component){
		components.add(component);
	}

	void removeComponent(Component component){
		components.remove(component);
	}

	@Override
	public void doSomething() {
	 components.stream().forEach(System.out::println);
	}
}