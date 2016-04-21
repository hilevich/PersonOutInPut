package edu.cursor.personOutInPut.resourse;

import java.util.ArrayList;
import java.util.Scanner;

public class WorkWithPerson {
	/**
	 * Displays main menu text
	 */
	public void infoMenu() {
		System.out.println("1 - see the list of person ");
		System.out.println("2 - select Person and change data");
		System.out.println("3 - exit");
	}
	/**
	 * Displays Person's object menu text
	 */
	public void infoChangePerson() {
		System.out.println("1 - change name");
		System.out.println("2 - change surname");
		System.out.println("3 - change age");

	}

	/**
	 * Specifies whether the user wants to make changes
	 * 
	 * @return true if user wants to make changes
	 */
	public boolean someChange() {
		System.out.println("do u want make changes Y/N");
		boolean a = true;
		boolean flag = true;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while (flag) {
			String str = sc.nextLine();
			if (str.equalsIgnoreCase("y")) {
				a = true;
				flag = false;
			} else if (str.equalsIgnoreCase("n")) {
				a = false;
				flag = false;
			} else {
				System.out.println("invalid input");
				System.out.println("do u want make changes Y/N");
				a = false;
			}
		}
		return a;
	}
	/**
	 * Assign to Person fields values entered from the console
	 * 
	 * @return new Person object
	 */
	public Person getWithConsoleInfo() {
		System.out.println("Enter name");

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.println("Enter surname");
		String surname = sc.nextLine();
		return new Person(name, surname, 0, null);

	}

	/**
	 * Search index into an array of Person's objects
	 * 
	 * @param arrayListMainPerson
	 * @param nameSurnamePerson
	 * @return index of Person's objects array
	 */
	public int getIndexPerson(ArrayList<Person> arrayListMainPerson, Person nameSurnamePerson) {
		int index = -1, index1 = -1;
		for (Person person : arrayListMainPerson) {
			index1++;
			if ((person.getName().equalsIgnoreCase(nameSurnamePerson.getName()))
					&& (person.getSurname().equalsIgnoreCase(nameSurnamePerson.getSurname()))) {
				index = index1;
			}
		}
		if (index == -1) {
			System.out.println("Person not found");
		}
		return index;
	}

	/**
	 * Sets the name of a person
	 * 
	 * @return new person name
	 */
	public String setNameOfPerson() {
		System.out.println("enter new name");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		return name;
	}

	/**
	 * Sets the surname of a person
	 * 
	 * @return new person surname
	 */
	public String setSurnameOfPerson() {
		System.out.println("enter new surname");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String surname = sc.nextLine();
		return surname;
	}

	/**
	 * Sets the age of a person
	 * 
	 * @return new person age
	 */
	public int setAgeOfPerson() {
		System.out.println("enter new age");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		return age;
	}

}
