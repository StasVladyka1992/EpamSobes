package Algorythm.graph.searching.breadth_search;

import java.util.Objects;

public class Person {
	private String name;
	private boolean mangoSeller;

	public Person(String name, boolean mangoSeller) {
		this.name = name;
		this.mangoSeller = mangoSeller;
	}

	public Person() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMangoSeller() {
		return mangoSeller;
	}

	public void setMangoSeller(boolean mangoSeller) {
		this.mangoSeller = mangoSeller;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		return mangoSeller == person.mangoSeller &&
				name.equals(person.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, mangoSeller);
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", mangoSeller=" + mangoSeller +
				'}';
	}
}
