package edu.cursor.personOutInPut.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.cursor.personOutInPut.resourse.InOutPutFile;
import edu.cursor.personOutInPut.resourse.Person;
import edu.cursor.personOutInPut.resourse.WorkWithPerson;

public class App {
	public static void main(String[] args) throws ClassNotFoundException, IOException {

		// BildFile bf = new BildFile();
		// bf.bildFile();

		boolean flag = true;
		Person newPerson;
		int indexOfPerson;
		InOutPutFile iopf = new InOutPutFile();
		ArrayList<Person> arrayListPerson = new ArrayList<Person>();

		arrayListPerson.addAll(iopf.getArrayListWihtFilePerson());

		WorkWithPerson wwp = new WorkWithPerson();

		wwp.infoMenu();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while (flag) {
			try {
				int key = sc.nextInt();
				if ((key >= 1) && (key <= 3)) {
					switch (key) {
					case 1: {
						System.out.println("you have chosen see the list of person");
						for (Person person : arrayListPerson) {
							System.out.println(person);
						}
						wwp.infoMenu();
						break;
					}
						// робив зміни !!!!!!!!!!!!!!!!!!!!
					case 2: {
						System.out.println("please select person");
						indexOfPerson = -1;
						newPerson = wwp.getWithConsoleInfo();
						indexOfPerson = wwp.getIndexPerson(arrayListPerson, newPerson);
						if (indexOfPerson != -1) {
							System.out.println("person is found");
						}
						if (indexOfPerson != -1) {

							boolean menu = wwp.someChange();
							while (menu) {
								int key1;
								wwp.infoChangePerson();
								@SuppressWarnings("resource")
								Scanner sc1 = new Scanner(System.in);
								key1 = sc1.nextInt();
								if ((key1 >= 1) && (key1 <= 3)) {
									switch (key1) {
									case 1: {
										System.out.println("change name");
										String name = wwp.setNameOfPerson();
										arrayListPerson.get(indexOfPerson).setName(name);
										menu = wwp.someChange();
										break;
									}
									case 2: {
										System.out.println("change surname");
										String surname = wwp.setSurnameOfPerson();
										arrayListPerson.get(indexOfPerson).setSurname(surname);
										menu = wwp.someChange();
										break;
									}
									case 3: {
										System.out.println("change age");
										int age = wwp.setAgeOfPerson();
										arrayListPerson.get(indexOfPerson).setAge(age);
										menu = wwp.someChange();
										break;
									}

									}
								} else {
									System.out.println("incorrect values");
								}
							}
						}
						wwp.infoMenu();
						break;
					}

					case 3: {
						iopf.sentArrayToFilePerson(arrayListPerson);
						System.out.println("exit");
						flag = false;
						break;
					}

					}
				} else {
					System.out.println("invalid in put");
				}

			} catch (Exception e) {
				System.out.println("Invalid in put, data is not save");
				flag = false;

			}
		}

	}
}
