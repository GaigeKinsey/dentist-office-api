package edu.neumont.cox.dentistoffice.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Appointment extends Clinic{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Patient patient;
	private Map<Provider, List<Procedure>> procedures = new HashMap<>();
	private LocalDateTime dateTime;
	
	public Appointment() {}

	public Appointment(Patient patient, Provider provider, List<Procedure> procedures, LocalDateTime dateTime) {
		this.setPatient(patient);
		this.addProcedures(provider, procedures);
		this.setDateTime(dateTime);
	}
	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Map<Provider, List<Procedure>> getProcedures() {
		return procedures;
	}
	
	public void addProcedures(Provider provider, List<Procedure> procedures) {
		this.procedures.put(provider, procedures);
	}

	public void setProcedures(Map<Provider, List<Procedure>> procedures) {
		this.procedures = procedures;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
}
