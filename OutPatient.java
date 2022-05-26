package edu.seminolestate.managepatient;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/*
 * Author: Lisbeth Mennechey
 */

public class OutPatient extends Patient{

	private int visitNumber;
	private int clinicNumber;
	private LocalDate procedureDate;
	
	protected static final LocalDate DEFAULT_PROCEDURE_DATE = LocalDate.now();
	protected static final int DEFAULT_VISIT_NUMBER = Integer.MAX_VALUE;
	protected static final int DEFAULT_CLINIC_NUMBER= Integer.MAX_VALUE;
	
	public OutPatient (String newFirstName, String newLastName, int newPatientID, int newVisitNumber,
			int newClinicNumber, LocalDate newProcedureDate) {
		super(newFirstName, newLastName, newPatientID);
		this.visitNumber = newVisitNumber;
		this.clinicNumber = newClinicNumber;
		this.procedureDate = newProcedureDate; 
	}
	
	public OutPatient (String newFirstName, String newLastName, int newPatientID) {
		this(newFirstName, newLastName, newPatientID, DEFAULT_VISIT_NUMBER,
				DEFAULT_CLINIC_NUMBER, DEFAULT_PROCEDURE_DATE);
	}
	
	public int getVisitNumber() {
		return visitNumber;
	}
	
	public void setVisitNumber(int newVisitNumber) {
		if (newVisitNumber > 0)
			this.visitNumber = newVisitNumber;
	}
	
	public int getClinicNumber() {
		return clinicNumber;
	}
	
	public void setClinicNumber(int newClinicNumber) {
		if(newClinicNumber > 0)
			this.clinicNumber = newClinicNumber;
	}
	
	public LocalDate getProcedureDate() {
		return procedureDate;
	}
	
	public void setProcedureDate(LocalDate newProcedureDate) {
		if(newProcedureDate != null) 
			this.procedureDate = newProcedureDate;
	}
	
	@Override
	public int lengthOfStay() {
		int lengthOfStay = (int)ChronoUnit.DAYS.between(procedureDate, LocalDate.now());
		return lengthOfStay;
	}
	
	@Override
	public String toString() {
		return super.toString()+ " OutPatient [visitNumber = " + visitNumber + 
				", clinicNumber = " + clinicNumber + ", procedureDate = " + 
				procedureDate + "]";
	}
	
	
}
