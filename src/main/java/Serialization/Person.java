package Serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * @project EpamSobes
 * author Stas Vladyka on 13.08.2019.
 */
public class Person implements Externalizable {
	private int age;
	private String firstName;
	private String lastName;
	private Adress adress;

	public Person(int age, String firstName, String lastName, Adress adress) {
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adress = adress;
	}

	public Person() {
	}

	@Override
	public String toString() {
		return "Person{" +
				"age=" + age +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", adress=" + adress +
				'}';
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(this.age);
		out.writeObject(this.firstName);
		out.writeObject(this.lastName);
		out.writeObject(this.adress);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.age = (int)in.readObject();
        this.firstName =(String) in.readObject();
        this.lastName = (String) in.readObject();
        this.adress = (Adress) in.readObject();
	}
}
