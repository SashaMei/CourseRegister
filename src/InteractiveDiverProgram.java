

import java.util.ArrayList;
import java.util.Scanner;

public class InteractiveDiverProgram {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the Course Registration system for the following course.");
		CourseAL course = new CourseAL("Java 255", 5, 5);
	
		System.out.println(course);
		System.out.println("\nWhat action would you like to take? ");
		System.out.println("1 to add a student\n2 to drop a student\n3 to print the course\n4 to exit\n");
		int choose = Integer.parseInt(input.nextLine());
	
		while (choose != 4) {
			addDropPrint(choose, course);
			System.out.println("\nWhat action would you like to take? ");
			System.out.println("1 to add a student\n2 to drop a student\n3 to print the course\n4 to exit\n");
			choose = Integer.parseInt(input.nextLine());
		}
		System.out.println("Thank you for using the system. ");
		System.out.println(course);
	}

	public static void addDropPrint(int choose, CourseAL course) {

		Scanner input = new Scanner(System.in);
		switch (choose) {
		case 1:
			chooseAdd(getInformation(), course);
			break;
		case 2:
			chooseDrop(getInformation(), course);
			break;
		case 3:
			System.out.println(course + "\n");
			break;
		}
	}

	public static Student getInformation() {
		System.out.println("Enter the first name: ");
		String firstName = input.nextLine();
		System.out.println("Enter the last name: ");
		String lastName = input.nextLine();
		System.out.println("Enter the id name: ");
		String id = input.nextLine();
		System.out.println("Has the student paid tution? Enter y or n: ");
		String enterTution = input.nextLine();
		boolean payTution;
		if (enterTution.equalsIgnoreCase("y")) {
			payTution = true;
		} else {
			payTution = false;
		}
		Student student = new Student(firstName, lastName, id, payTution);
		return student;
	}

	
	public static void chooseAdd(Student student, CourseAL course) {
		boolean added = course.addStudent(student);
		System.out.println(student + (added ? " added successfully" : " not added"));
	}

	public static void chooseDrop(Student student, CourseAL course) {
		boolean dropped = course.dropStudent(student);
		System.out.println(student + (dropped ? " dropped successfully" : " not dropped"));
	}
}

	
