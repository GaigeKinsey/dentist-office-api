package edu.neumont.cox.dentistoffice.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

//	Map<LocalDateTime, Appointment> appointment = new HashMap<>();

	Map<String, User> users = new HashMap<>();
	Map<String, Provider> providers = new HashMap<>();
	Map<String, Patient> patients = new HashMap<>();

	/**
	 * retrieves the list of payments
	 * 
	 * @return payments
	 */
	public List<Payment> getPayments() {
		return payments;
	}

	/**
	 * sets the new list of payments to the payments Array List
	 * 
	 * @param payments
	 */
	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	/**
	 * retrieves the list of Appointments
	 * 
	 * @return appointments
	 */
	public List<Appointment> getAppointments() {
		return appointments;
	}

	/**
	 * sets the new list of appointments to the appointments Array List
	 * 
	 * @param appointments
	 */
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	/**
	 * retrieves the hashMap of Users
	 * 
	 * @return users
	 */
	public Map<String, User> getUsers() {
		return users;
	}

	/**
	 * sets the new hashMap of users
	 * 
	 * @param users
	 */
	public void setUsers(Map<String, User> users) {
		this.users = users;
	}

	/**
	 * retrieves the hashMap of providers
	 * 
	 * @return providers
	 */
	public Map<String, Provider> getProviders() {
		return providers;
	}

	/**
	 * sets the new hashMap of providers
	 * 
	 * @param providers
	 */
	public void setProviders(Map<String, Provider> providers) {
		this.providers = providers;
	}

	/**
	 * retrieves the hashMap of Patients
	 * 
	 * @return patients
	 */
	public Map<String, Patient> getPatients() {
		return patients;
	}

	/**
	 * sets the new hashMap of patients
	 * 
	 * @param patients
	 */
	public void setPatients(Map<String, Patient> patients) {
		this.patients = patients;
	}

	/**
	 * adds the User that is passed through to the hashMap
	 * 
	 * @param user
	 */
	public void addUser(User user) {
		this.users.put(user.getUsername(), user);
	}

	/**
	 * adds the Patient that is passed through to the hashMap
	 * 
	 * @param patient
	 */
	public void addPatient(Patient patient) {
		this.patients.put(patient.getLastName(), patient);
	}

	/**
	 * adds the Provider that is passed through to the hashMap
	 * 
	 * @param provider
	 */
	public void addProvider(Provider provider) {
		this.providers.put(provider.getLastName(), provider);
	}

	// Reports - idk if you wanna go about it this way??
	// Haven't thought this all the way through - I have void for now
	/**
	 * prints out the production report based on the criteria set by the user
	 * 
	 * @param startDate
	 * @param endDate
	 * @param groupBy
	 */
	public void productionReport(LocalDateTime startDate, LocalDateTime endDate, boolean groupBy) {

		//total charges for the entire month(s)
		if (groupBy) {

		} else {
			//total charges for each day(s)
			
		}
		
		
	}

	/**
	 * prints out the patient balance report based on the criteria set by the user
	 * 
	 * @param sort
	 */
	public void patientBalanceReport(boolean sortBy) {

		//Largest patient balance to smallest balance
		if(sortBy) {
			
		} else {
			//sorts balance by name
			
		}
	}

	/**
	 * prints out the collections report based on the criteria set by the user
	 * 
	 * @param startDate
	 * @param endDate
	 * @param groupBy
	 */
	public void collectionsReport(LocalDateTime startDate, LocalDateTime endDate, boolean groupBy) {

		//total money collected for the given month(s)
		if (groupBy) {

		} else {
			//total money collected for the given day(s)
		}
		
	}

}
