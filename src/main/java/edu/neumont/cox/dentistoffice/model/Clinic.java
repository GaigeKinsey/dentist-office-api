package edu.neumont.cox.dentistoffice.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Clinic implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Payment> payments = new ArrayList<>();
	private List<Appointment> appointments = new ArrayList<>();

	Map<String, User> users = new HashMap<>();
	Map<String, Provider> providers = new HashMap<>();
	Map<String, Patient> patients = new HashMap<>();

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public Map<String, User> getUsers() {
		return users;
	}

	public void setUsers(Map<String, User> users) {
		this.users = users;
	}

	public Map<String, Provider> getProviders() {
		return providers;
	}

	public void setProviders(Map<String, Provider> providers) {
		this.providers = providers;
	}

	public Map<String, Patient> getPatients() {
		return patients;
	}

	public void setPatients(Map<String, Patient> patients) {
		this.patients = patients;
	}

	public void addUser(User user) {
		this.users.put(user.getUsername(), user);
	}

	public void addPatient(Patient patient) {
		this.patients.put(patient.getLastName(), patient);
	}

	public void addProvider(Provider provider) {
		this.providers.put(provider.getLastName(), provider);
	}

	public List<Appointment> getFutureAppointments() {
		return null;
	}

	public List<Appointment> getPastAppointments() {
		return null;
	}

	public void receivePayment(Payment payment) {

	}

	public double getAccountBalance(int patientId) {
		return 0;
	}

	// Reports - idk if you wanna go about it this way??
	// Haven't thought this all the way through - I have void for now
	public void productionReport(LocalDate startDate, LocalDate endDate, boolean groupBy) {

	}

	public void patientBalanceReport(boolean sort) {

	}

	public void collectionsReport(LocalDate startDate, LocalDate endDate, boolean groupBy) {

	}

}
