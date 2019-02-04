package edu.neumont.cox.dentistoffice.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FutureAppointment extends Appointment{
	private Patient patient;
	private Map<Provider, List<Procedure>> proceduresByProvider = new HashMap<>();
//	private List<Provider> providers = new ArrayList<>();
//	private List<Procedure> procedures = new ArrayList<>();
	
	public FutureAppointment(LocalDateTime dateTime, Patient patient, Provider provider, List<Procedure> procedures) {
		super(dateTime);
		this.setPatient(patient);
		addProvider(provider, procedures);
//		this.setProviders(providers);
//		this.setProcedures(procedures);
	}

	public void addProvider(Provider provider, List<Procedure> procedures) {
		proceduresByProvider.put(provider, procedures);
	}
	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

//	public List<Provider> getProviders() {
//		return providers;
//	}
//
//	public void setProviders(List<Provider> providers) {
//		this.providers = providers;
//	}
//
//	public List<Procedure> getProcedures() {
//		return procedures;
//	}
//
//	public void setProcedures(List<Procedure> procedures) {
//		this.procedures = procedures;
//	}
}
