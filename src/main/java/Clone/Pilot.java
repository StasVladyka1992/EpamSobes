package Clone;

public class Pilot implements Cloneable {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Pilot pilot = new Pilot();
		pilot.setName("Igor");
		pilot.setAge(20);
		return pilot;
	}

	@Override
	public String toString() {
		return "Pilot{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
