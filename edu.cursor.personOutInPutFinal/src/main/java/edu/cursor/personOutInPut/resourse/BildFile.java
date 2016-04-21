package edu.cursor.personOutInPut.resourse;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class BildFile {
	/**
	 * Bild file data in file Person.txt
	 * @throws IOException
	 */
	public void bildFile() throws IOException{
		ArrayList<Person> listPerson = new ArrayList<Person>();
		Person p1 = new Person("Yura", "Hilevich", 25, "male");
		Person p2 = new Person("Vasya", "Savelev", 26, "male");
		Person p3 = new Person("Romko", "Koziy", 24, "male");
		Person p4 = new Person("Snijana", "kovalik", 20, "female");
		Person p5 = new Person("Sergiy", "Hilevich", 21, "male");
		Person p6 = new Person("Andrew", "Druk", 30, "male");
		Person p7 = new Person("Stepan", "Poltorak", 45, "male");
		Person p8 = new Person("Vasyl", "kojan", 31, "male");
		Person p9 = new Person("Ira", "Dusan", 25, "female");
		listPerson.add(p1);
		listPerson.add(p2);
		listPerson.add(p3);
		listPerson.add(p4);
		listPerson.add(p5);
		listPerson.add(p6);
		listPerson.add(p7);
		listPerson.add(p8);
		listPerson.add(p9);
		
		
		OutputStream os = new FileOutputStream("Person.txt");
		ObjectOutputStream oos = new ObjectOutputStream(os);

		oos.writeInt(listPerson.size());

		for (Person person : listPerson) {
			oos.writeObject(person);
		}

		oos.close();
		os.close();
	
	}
}
