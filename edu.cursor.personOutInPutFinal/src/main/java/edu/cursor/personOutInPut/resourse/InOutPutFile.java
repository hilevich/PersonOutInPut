package edu.cursor.personOutInPut.resourse;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class InOutPutFile {
	/**
	 * Get array list with from person.txt
	 * @return array list with Person objects
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Person> getArrayListWihtFilePerson() throws IOException, ClassNotFoundException {

		ArrayList<Person> arrayPerson = new ArrayList<Person>();
		InputStream is = new FileInputStream("Person.txt");
		ObjectInputStream ois = new ObjectInputStream(is);

		int iv = ois.readInt();

		for (int i = 0; i < iv; i++) {
			Person fromFile = (Person) ois.readObject();
			arrayPerson.add(fromFile);
		}
		ois.close();
		is.close();

		return arrayPerson;

	}

	/**
	 * Sent array of Person's objects to file Person.txt
	 * @param listPerson array of Person's objects
	 * @throws IOException
	 */
	public void sentArrayToFilePerson(ArrayList<Person> listPerson) throws IOException {
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
