package edu.neumont.cox.dentistoffice.view;

import java.util.List;

import edu.neumont.cox.dentistoffice.model.Appointment;
import edu.neumont.cox.dentistoffice.model.Patient;
import edu.neumont.cox.dentistoffice.model.Provider;
import edu.neumont.cox.dentistoffice.model.User;

/**
 * @author Gaige & Chris
 *
 */
public interface UserInteractionInterface {

	/**
	 * Gets the password to be changed to for the Admin on first login
	 * @return the password they enter
	 */
	String adminPasswordChange();

	/**
	 * Notifies the user they do not have permission to do an action
	 */
	void noPermission();

	/**
	 * Used to prompt for re-entering of password, and checking to see if it matches the original
	 * @param password
	 * @return a boolean representing whether the passwords matches, true if they do, false if not
	 */
	boolean checkPassword(String password);

	/**
	 * Used to notify the user that their passwords did not match
	 */
	void passwordMismatch();

	/**
	 * Welcome message for the program
	 */
	void dentistOfficeGreeting();

	/**
	 * Displays the main menu of the dentist office
	 * @return an int representing the user's choice
	 */
	int dentistOfficeMenu();

	/**
	 * Prompts user for their user name
	 * @return a String of their response
	 */
	String getUsername();

	/**
	 * Used when creating a password, makes sure they match
	 * @return the password after matching verification
	 */
	String getPassword();

	/**
	 * Notifies the User that the password or user name they entered doesn't not match
	 */
	void invalidUser();

	/**
	 * Displays the menu for adding someone
	 * @return an int representing the user's choice
	 */
	int addSomeoneSubMenu();

	/**
	 * Displays the menu for removing someone
	 * @return an int representing the user's choice
	 */
	int removeSomeoneSubMenu();

	/**
	 * Displays the menu for generating reports
	 * @return an int representing the user's choice
	 */
	int reportsMenu();

	/**
	 * Displays the menu for choosing the user type
	 * @return an int representing the user's choice
	 */
	int userRoleChoice();

	/**
	 * Prompts the user for a first name
	 * @return a String of their response
	 */
	String getFirstName();

	/**
	 * Prompts user for a last name
	 * @return a String of their response
	 */
	String getLastName();

	/**
	 * Prompts the user for a unique ID
	 * @return an int representing the ID number
	 */
	int getUniqueId();

	/**
	 * Prompts the user for an email
	 * @return a String representing the email
	 */
	String getEmail();

	/**
	 * Prompts the user for a company name
	 * @return a String representing the company name
	 */
	String getCompanyName();

	/**
	 * Prompts the user for a group ID
	 * @return a String representing the group ID
	 */
	String getGroupId();

	/**
	 * Prompts the user for a member ID
	 * @return a String representing the member ID;
	 */
	String getMemberId();

	/**
	 * Used to tell the user they are going to enter the insurance provider info
	 */
	void insuranceProviderPrompt();

	/**
	 * Used to tell the user they are going to enter the payment card info
	 */
	void paymentCardPrompt();

	/**
	 * Prompts the user for their card number
	 * @return a String representing the card number
	 */
	String getCardNumber();

	/**
	 * Prompts the user for a card holder name
	 * @return a String representing the card holder's name
	 */
	String getHolderName();

	/**
	 * Prompts the user for a CVV number
	 * @return an int representing the CVV number
	 */
	int getCVV();

	/**
	 * Prompts the user for a zip code
	 * @return an int representing the zip code
	 */
	int getZipCode();

	/**
	 * Prompts the user for a provider type
	 * @return an int representing the user's choice
	 */
	int getProviderType();

	/**
	 * Displays the search menu
	 * @return an int representing the user's choice
	 */
	int searchSubMenu();

	/**
	 * Used to have the user enter in a password twice to confirm it
	 * @return a String of the verified password
	 */
	String createPassword();

	/**
	 * Prompts user for a first name, this field can be blank
	 * @return a String of their response
	 */
	String getSearchFirstName();

	/**
	 * Prompts user for a last name, this field can be blank
	 * @return a String of their response
	 */
	String getSearchLastName();

	/**
	 * Prompts the user for a user name, this field can be blank
	 * @return a String of their response
	 */
	String getSearchUsername();

	/**
	 * Prompts the user for a company name, this field can be blank
	 * @return a String representing the company name
	 */
	String getSearchCompanyName();

	/**
	 * Displays all the users that match the search criteria
	 * @param matchedUsers
	 * @return an int representing the user they select
	 */
	int getUserSearchSelection(List<User> matchedUsers);

	/**
	 * Displays all the patients that match the search criteria
	 * @param matchedPatients
	 * @return an int representing the patient they select
	 */
	int getPatientSearchSelection(List<Patient> matchedPatients);

	/**
	 * Displays all the providers that match the search criteria
	 * @param matchedProviders
	 * @return an int representing the provider they select
	 */
	int getProviderSearchSelection(List<Provider> matchedProviders);

	/**
	 * Prompts the user for a phone number
	 * @return a String representing the phone number
	 */
	String getPhoneNumberString();

	/**
	 * Displays a message telling the user the phone number was invalid
	 */
	void invalidPhone();

	/**
	 * Displays a message telling the user their card was invalid
	 */
	void invalidCard();

	/**
	 * Displays a message telling the user their expiration date was invalid
	 */
	void invalidExpireDate();

	/**
	 * Displays the menu asking whether the appointment is for new or existing patients
	 * @return an int representing the user's choice
	 */
	int scheduleForPatients();

	/**
	 * Prompts the user for an expiration date
	 * @return a String representing the expiration date
	 */
	String getExpireDate();

	/**
	 * Prompts the user asking if they want to change their or another user's password
	 * @return an int representing the user's choice
	 */
	int changeUserPassword();

	/**
	 * Prompts the user asking if they want to change their password
	 * @return a boolean, true if they do, false if not
	 */
	boolean changePasswordDecision();

	/**
	 * Prompts the user for their new password
	 * @return a String representing their password
	 */
	String changePassword();

	/**
	 * Prompts the user for a procedure code
	 * @return a String representing the procedure code
	 */
	String getProcedureCode();

	/**
	 * Prompts the user for a procedure description
	 * @return a String representing the procedure description
	 */
	String getProcedureDescription();

	/**
	 * Prompts the user for the cost of the procedure
	 * @return a Double representing the cost
	 */
	Double getProcedureCost();

	/**
	 * Displays the menu asking whether the appointment is for new or existing providers
	 * @return an int representing their choice
	 */
	int scheduleForProviders();

	/**
	 * Asks the user if they want to add more procedures
	 * @return boolean that is true if they want to add more, false if not
	 */
	boolean addMoreProcedures();

	/**
	 * Prompts the user for a year
	 * @return an int representing the year
	 */
	int getYear();

	/**
	 * Prompts the user for a month
	 * @return an int representing the month
	 */
	int getMonth();

	/**
	 * Prompts the user for a day of the month
	 * @param month
	 * @return an int representing the day of the month
	 */
	int getDayOfMonth(int month);

	/**
	 * Prompts the user for an hour
	 * @return an int representing the hour
	 */
	int getHour();

	/**
	 * Prompts the user for a minute
	 * @return an int representing the minute
	 */
	int getMinute();

	/**
	 * Asks the user if they want to add another provider
	 * @return a boolean that is true if they want to add more, and false if not
	 */
	boolean addMoreProviders();

	/**
	 * Tells the user they are searching for providers
	 */
	void notifySearchingProvider();

	/**
	 * Tells the user they are searching for patients
	 */
	void notifySearchingPatient();

	/**
	 * Notifies the user their appointment date is invalid
	 */
	void invalidAppointmentDate();

	/**
	 * Displays all the appointments that match the appointment search criteria
	 * @param matchedAppointments
	 * @return an int representing the user's chose appointment
	 */
	int getAppointmentSearchSelection(List<Appointment> matchedAppointments);

	/**
	 * Prompts the user for a start date
	 */
	void askForStartDate();

	/**
	 * Prompts the user for an end date
	 */
	void askForEndDate();

	/**
	 * Asks the user if they want to group reports by month or day
	 * @return a boolean that is true if month, and false if day
	 */
	boolean groupBySelection();

	/**
	 * Asks the user if they want to sort by largest to smallest, or by name
	 * @return a boolean that is true if largest to smallest, and false if by name
	 */
	boolean sortBySelection();

	/**
	 * Prints out the total charges between the given dates
	 * @param i
	 * @param total
	 */
	void printGroup(int i, int total, boolean groupBy);

	/**
	 * Prompts user for procedure code, this can be empty
	 * @return String representing the procedure code
	 */
	String getSearchProcedureCode();

	/**
	 * Notifies user they did not select a patient
	 */
	void notifyNoPatient();

	/**
	 * Notifies user they did not select a provider
	 */
	void notifyNoProvider();

	/**
	 * Asks user if they want to search for a specific patient
	 * @return boolean true if they do, false if not
	 */
	boolean searchForPatient();

	/**
	 * Asks user if they want to search for a specific provider
	 * @return boolean true if they do, false if not
	 */
	boolean searchForProvider();

	/**
	 * Tells the user they are going to search for an appointment they want to charge to the patient
	 */
	void askForPatient();

	/**
	 * Tells the user that the patient payment record failed
	 */
	void recordPaymentFailed();

	/**
	 * Prints out the patients in order by their sort
	 * @param patients
	 */
	void printSort(List<Patient> patients);
	
}
