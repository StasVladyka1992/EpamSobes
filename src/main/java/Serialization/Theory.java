package Serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @project EpamSobes
 * author Stas Vladyka on 13.08.2019.
 */
public class Theory {
	// Сущестует 2 способа сериализации: Serializable(интерфейс-маркер) и Externalizable (c двумя методами)
	// Особенности:
	// 1) при десериализации не вызывается конструктор
	// Теория: https://javarush.ru/groups/posts/2022-serializacija-i-deserializacija-v-java - общая инфа
	// https://javarush.ru/groups/posts/2023-znakomstvo-s-interfeysom-externalizable
	// https://www.geeksforgeeks.org/difference-between-serializable-and-externalizable-in-java-serialization/
	// Углубленная информация про сериализацию и десериализацию - http://www.skipy.ru/technics/serialization.html
	// https://www.geeksforgeeks.org/difference-between-serializable-and-externalizable-in-java-serialization/
	public static void main(String[] args) {
		Adress adress = new Adress("1", "2", "3");
		Person person = new Person(1, "S", "V", adress);

		try {
			FileOutputStream fos = new FileOutputStream("test.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(adress);

			FileInputStream fis = new FileInputStream("test.txt");
			ObjectInputStream obj = new ObjectInputStream(fis);
			Adress ad = (Adress) obj.readObject();
			System.out.println(ad);


			FileOutputStream fosE = new FileOutputStream("test.txt");
			ObjectOutputStream oosE = new ObjectOutputStream(fosE);
			oosE.writeObject(person);

			FileInputStream fisE = new FileInputStream("test.txt");
			ObjectInputStream objE = new ObjectInputStream(fisE);
			Person pers = (Person) objE.readObject();
			System.out.println(pers);

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
