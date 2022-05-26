package edu.seminolestate.managepatient;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Author: Lisbeth Mennechey
 * Program allows user to add an inpatient or outpatient, and view all patients  
 */

public class ManagePatient {

	//Constants for possible user inputs
	public static final int ADD_INPATIENT = 1;
	public static final int ADD_OUTPATIENT = 2;
	public static final int LIST_ALL_PATIENTS = 3;
	public static final int EXIT = 4;
	public static final String INVALID_VALUE = "Invalid value. Enter a value 1-4";
	public static final String EXIT_MESSAGE = "Thank you for using patient management!";
	
	
	public static void main(String[] args) {
		
		ArrayList<Patient> somePatients = new ArrayList<Patient>();
		
		int userInput = 0;
		Scanner input = new Scanner(System.in);
		
		do {
			userInput = getUserAction(input);
			
			switch(userInput) {
			
			case ADD_INPATIENT:
				addInPatient(input, somePatients);
				break;
			
			case ADD_OUTPATIENT: 
				addOutPatient(input, somePatients);
				break;
			
			case LIST_ALL_PATIENTS:
				displayInfo(somePatients);
				break;
				
			case EXIT:
				System.out.println(EXIT_MESSAGE);
				break;

			default:
				System.out.println(INVALID_VALUE);
			}
		}
		while (userInput != EXIT);
	}
	
	//Display menu and obtain user action requested
	public static int getUserAction (Scanner input) {
		
		System.out.println("1. Add Inpatient");
		System.out.println("2. Add Outpatient");
		System.out.println("3. List all patients");
		System.out.println("4. Exit");
		
		int userAction = input.nextInt();
		input.nextLine();
		return userAction;
	}
	
	//obtain patient information and add inpatient to array list
	public static void addInPatient(Scanner input, ArrayList<Patient> somePatients) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyy");
		LocalDate dateReleased = null;
		
		System.out.print("Enter the first name: ");
		String firstName = input.nextLine();
		
		System.out.print("Enter the last name: ");
		String lastName = input.nextLine();
		
		System.out.print("Enter the patient ID: ");
		int patientID = input.nextInt();
		
		input.nextLine();
		
		System.out.print("Enter the date admitted (mm/dd/yyyy): ");
		String tempDate = input.nextLine();
		LocalDate dateAdmitted = LocalDate.parse(tempDate, formatter);	
		
		System.out.print("Has the patient been released? (y/n) ");
		String userIsReleased = input.nextLine();
		
		if (userIsReleased.indexOf('y') >= 0) {
			System.out.print("Enter the date released (mm/dd/yyyy): ");
			String tempDateReleased = input.nextLine();
			dateReleased = LocalDate.parse(tempDateReleased, formatter);	
		}
		
		System.out.print("Enter the room number: ");
		int roomNumber = input.nextInt();
			
		somePatients.add(new InPatient(firstName, lastName, patientID, dateAdmitted, dateReleased, roomNumber));
	} 
	
	//obtain patient information and add outpatient to array list
	public static void addOutPatient (Scanner input, ArrayList<Patient> somePatients) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyy");
		
		System.out.print("Enter the first name: ");
		String firstName = input.nextLine();
		
		System.out.print("Enter the last name: ");
		String lastName = input.nextLine();
		
		System.out.print("Enter the patient ID: ");
		int patientId = input.nextInt();
		
		input.nextLine();
		
		System.out.print("Enter the vist number: ");
		int visitNumber = input.nextInt();
		
		System.out.print("Enter the clinic number: ");
		int clinicNumber = input.nextInt();
		
		input.nextLine();
		
		System.out.print("Enter the procedure date (mm/dd/yyyy): ");
		String tempDate = input.nextLine();
		LocalDate procedureDate = LocalDate.parse(tempDate, formatter);
		
		somePatients.add(new OutPatient(firstName, lastName, patientId, visitNumber, clinicNumber, procedureDate));
	}
	
	//display patients and their length of stay
	public static void displayInfo(ArrayList<Patient> somePatients) {
		
		for (Patient patient: somePatients) {
			System.out.println(patient.toString());
			System.out.println("The length of stay is " + patient.lengthOfStay() + " days.\n");
		}
	}
}