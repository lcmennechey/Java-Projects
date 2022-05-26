package edu.seminolestate.managepatient;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/*
 * Author: Lisbeth Mennechey
 */

public class InPatient extends Patient {
	private LocalDate dateAdmitted; 
	private LocalDate dateReleased;
	private int roomNumber;
	
	protected static final LocalDate DEFAULT_DATE_ADMITTED = LocalDate.now();
	protected static final LocalDate DEFAULT_DATE_RELEASED = null;
	protected static final int DEFAULT_ROOM_NUMBER = Integer.MAX_VALUE;
	
	
	public InPatient (String newFirstName, String newLastName, int newPatientID,
			LocalDate newDateAdmitted, LocalDate newDateReleased, int newRoomNumber) {
			super(newFirstName, newLastName, newPatientID);
			this.dateAdmitted = newDateAdmitted;
			this.dateReleased = newDateReleased;
			this.roomNumber = newRoomNumber;
	}
	
	public InPatient (String newFirstName, String newLastName, int newPatientID) {
		this(newFirstName, newLastName, newPatientID, DEFAULT_DATE_ADMITTED, 
				DEFAULT_DATE_RELEASED, DEFAULT_ROOM_NUMBER);
	}

	public LocalDate getDateAdmitted() {
		return dateAdmitted;
	}

	public void setDateAdmitted(LocalDate newDateAdmitted) {
		if(newDateAdmitted != null)
			this.dateAdmitted = newDateAdmitted;
	}

	public LocalDate getDateReleased() {
		return dateReleased;
	}

	public void setDateReleased(LocalDate newDateReleased) {
		this.dateReleased = newDateReleased;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int newRoomNumber) {
		if(newRoomNumber > 0)
			this.roomNumber = newRoomNumber;
	}
	
	@Override
	public int lengthOfStay() {
		int lengthOfStay;
			if (dateReleased !=null) {
				lengthOfStay = (int)ChronoUnit.DAYS.between(dateAdmitted, dateReleased);
			} else {
				lengthOfStay = (int)ChronoUnit.DAYS.between(dateAdmitted, LocalDate.now());
			}
		return lengthOfStay;
		
	}
	@Override
	public String toString() {
		return super.toString() + " InPatient [dateAdmitted = " + dateAdmitted + 
				", dateReleased = " + dateReleased + ", roomNumber = " + roomNumber
				+ "]";
	}
}
