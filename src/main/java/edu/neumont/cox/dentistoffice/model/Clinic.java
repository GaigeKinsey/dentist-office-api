package edu.neumont.cox.dentistoffice.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Chris & Gaige
 *
 */
public class Clinic implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private List<Payment> payments = new ArrayList<>();
	
	private List<Appointment> appointments = new ArrayList<>();

	Map<String, User> users = new HashMap<>();
	Map<String, Provider> providers = new HashMap<>();
	Map<String, Patient> patients = new HashMap<>();

	/**
	 * @return
	 */
	public List<Payment> getPayments() {
		return payments;
	}

	/**
	 * @param payments
	 */
	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	/**
	 * @return
	 */
	public List<Appointment> getAppointments() {
		return appointments;
	}

	/**
	 * @param appointments
	 */
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	/**
	 * @return
	 */
	public Map<String, User> getUsers() {
		return users;
	}

	/**
	 * @param users
	 */
	public void setUsers(Map<String, User> users) {
		this.users = users;
	}

	/**
	 * @return
	 */
	public Map<String, Provider> getProviders() {
		return providers;
	}

	/**
	 * @param providers
	 */
	public void setProviders(Map<String, Provider> providers) {
		this.providers = providers;
	}

	/**
	 * @return
	 */
	public Map<String, Patient> getPatients() {
		return patients;
	}

	/**
	 * @param patients
	 */
	public void setPatients(Map<String, Patient> patients) {
		this.patients = patients;
	}

	/**
	 * @param user
	 */
	public void addUser(User user) {
		this.users.put(user.getUsername(), user);
	}

	/**
	 * @param patient
	 */
	public void addPatient(Patient patient) {
		this.patients.put(patient.getLastName(), patient);
	}

	/**
	 * @param provider
	 */
	public void addProvider(Provider provider) {
		this.providers.put(provider.getLastName(), provider);
	}

	// Reports - idk if you wanna go about it this way??
	// Haven't thought this all the way through - I have void for now
	/**
	 * @param startDate
	 * @param endDate
	 * @param groupBy
	 */
	public void productionReport(LocalDate startDate, LocalDate endDate, boolean groupBy) {

	}

	/**
	 * @param sort
	 */
	public void patientBalanceReport(boolean sort) {

	}

	/**
	 * @param startDate
	 * @param endDate
	 * @param groupBy
	 */
	public void collectionsReport(LocalDate startDate, LocalDate endDate, boolean groupBy) {

	}

}
