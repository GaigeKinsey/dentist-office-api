package edu.neumont.cox.dentistoffice.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Chris and Gaige
 *
 */
public class Appointment extends Clinic {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Patient patient;
	private Map<Provider, List<Procedure>> procedures = new HashMap<>();
	private LocalDateTime dateTime;

	/**
	 * default constructor for Appointment
	 */
	public Appointment() {
	}

	/**
	 * overloaded constructor for Appointment
	 * 
	 * @param patient
	 * @param provider
	 * @param procedures
	 * @param dateTime
	 */
	public Appointment(Patient patient, Provider provider, List<Procedure> procedures, LocalDateTime dateTime) {
		this.setPatient(patient);
		this.addProcedures(provider, procedures);
		this.setDateTime(dateTime);
	}

	/**
	 * retrieves the patient object
	 * 
	 * @return patient
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * sets the new patient object to patient in Appointment
	 * 
	 * @param patient
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/**
	 * retrieves the hashMap of procedures
	 * 
	 * @return procedures
	 */
	public Map<Provider, List<Procedure>> getProcedures() {
		return procedures;
	}

	/**
	 * adds the procedures to the procedure hashMap
	 * 
	 * @param provider
	 * @param procedures
	 */
	public void addProcedures(Provider provider, List<Procedure> procedures) {
		this.procedures.put(provider, procedures);
	}

	/**
	 * sets the passed through hashMap to Appointments procedure hashMap
	 * 
	 * @param procedures
	 */
	public void setProcedures(Map<Provider, List<Procedure>> procedures) {
		this.procedures = procedures;
	}

	/**
	 * retrieves the localDateTime of Appointment
	 * 
	 * @return dateTime
	 */
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	/**
	 * sets the localDateTime to dateTime
	 * 
	 * @param dateTime
	 */
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * retrieves the time of the appointment in LocalDate format
	 * 
	 * @return a LocalDate of the appointment
	 */
	public LocalDate getDate() {
		return LocalDate.of(dateTime.getDayOfMonth(), dateTime.getMonthValue(), dateTime.getYear());
	}

	@Override
	public String toString() {
		return "Date/Time: " + this.getDateTime() + ", Patient: " + this.getPatient().getFirstName() + " "
				+ this.getPatient().getLastName() + ", Provider/Procedure: " + this.getProcedures().toString();
	}
}
