package edu.cursor.personOutInPut.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;


//import edu.cursor.personOutInPut.resourse.BildFile;
import edu.cursor.personOutInPut.resourse.InPutPerson;
import edu.cursor.personOutInPut.resourse.Person;

public class App {
	public static void main(String[] args) throws IOException, ClassNotFoundException  {
		InPutPerson ipp = new InPutPerson();
		Person fromConsole = (Person)ipp.getWithConsoleInfo();

//		BildFile bf = new BildFile();
//		bf.bildFile();
		
		
		boolean flag = false;
		InputStream is = new FileInputStream("Person.txt");
		ObjectInputStream ois = new ObjectInputStream(is);

		int iv = ois.readInt();

		for (int i = 0; i < iv; i++) {
			Person fromFile = (Person) ois.readObject();
			
			if((fromFile.getName().equalsIgnoreCase(fromConsole.getName()))&&(fromFile.getSurname().equalsIgnoreCase(fromConsole.getSurname()))){
			System.out.println(fromFile);
			System.out.println(i);
			flag = true;
			}
			
			
		}
		
		if(!flag){
			System.out.println("person not found");
		}
		ois.close();
		is.close();
		
	}
}
