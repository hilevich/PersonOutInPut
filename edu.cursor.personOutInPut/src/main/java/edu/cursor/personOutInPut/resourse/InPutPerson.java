package edu.cursor.personOutInPut.resourse;

import java.util.Scanner;

public class InPutPerson {
	
	public Person getWithConsoleInfo(){
		System.out.println("Enter name");
	
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		
		System.out.println("Enter surname");
		String surname = sc.nextLine();
		
		return new Person(name, surname, 0, null);
	
	}
	
	
	
	
}
