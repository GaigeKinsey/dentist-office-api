package edu.neumont.cox.dentistoffice.view;

import java.util.List;

import edu.neumont.cox.dentistoffice.model.Patient;
import edu.neumont.cox.dentistoffice.model.Provider;
import edu.neumont.cox.dentistoffice.model.User;

/**
 * @author Gaige & Chris
 *
 */
public interface UserInteractionInterface {

	
	/**
	 * @return
	 */
	String adminPasswordChange();

	/**
	 * 
	 */
	void noPermission();

	/**
	 * @param password
	 * @return
	 */
	boolean checkPassword(String password);
	
	/**
	 * 
	 */
	void passwordMismatch();
	
	/**
	 * 
	 */
	void dentistOfficeGreeting();
	
	/**
	 * @return
	 */
	int dentistOfficeMenu();

	/**
	 * @return
	 */
	String getUsername();

	/**
	 * @return
	 */
	String getPassword();

	/**
	 * 
	 */
	void invalidUser();
	
	/**
	 * @return
	 */
	int addSomeoneSubMenu();
	
	/**
	 * @return
	 */
	int removeSomeoneSubMenu();
	
	/**
	 * @return
	 */
	int reportsMenu();

	/**
	 * @return
	 */
	int userRoleChoice();

	/**
	 * @return
	 */
	String getFirstName();

	/**
	 * @return
	 */
	String getLastName();

	/**
	 * @return
	 */
	int getUniqueId();

	/**
	 * @return
	 */
	String getEmail();

	/**
	 * @return
	 */
	String getCompanyName();

	/**
	 * @return
	 */
	String getGroupId();

	/**
	 * @return
	 */
	String getMemberId();

	/**
	 * 
	 */
	void insuranceProviderPrompt();

	/**
	 * 
	 */
	void paymentCardPrompt();

	/**
	 * @return
	 */
	String getCardNumber();

	/**
	 * @return
	 */
	String getHolderName();

	/**
	 * @return
	 */
	int getCVV();

	/**
	 * @return
	 */
	int getZipCode();

	/**
	 * @return
	 */
	int getProviderType();

	/**
	 * @return
	 */
	int searchSubMenu();

	/**
	 * @return
	 */
	String createPassword();

	/**
	 * @return
	 */
	String getSearchFirstName();

	/**
	 * @return
	 */
	String getSearchLastName();

	/**
	 * @return
	 */
	String getSearchUsername();

	/**
	 * @return
	 */
	String getSearchCompanyName();
	
	/**
	 * @param matchedUsers
	 * @return
	 */
	int getUserSearchSelection(List<User> matchedUsers);

	/**
	 * @param matchedPatients
	 * @return
	 */
	int getPatientSearchSelection(List<Patient> matchedPatients);

	/**
	 * @param matchedProviders
	 * @return
	 */
	int getProviderSearchSelection(List<Provider> matchedProviders);

	/**
	 * @return
	 */
	String getPhoneNumberString();
	
	/**
	 * 
	 */
	void invalidPhone();

	/**
	 * 
	 */
	void invalidCard();
	
	/**
	 * 
	 */
	void invalidExpireDate();

	/**
	 * @return
	 */
	int scheduleForPatients();

	/**
	 * @return
	 */
	String getExpireDate();
	
	/**
	 * @return
	 */
	int changeUserPassword();

	/**
	 * @return
	 */
	boolean changePasswordDecision();

	/**
	 * @return
	 */
	String changePassword();

	/**
	 * @return
	 */
	String getProcedureCode();

	/**
	 * @return
	 */
	String getProcedureDescription();

	/**
	 * @return
	 */
	Double getProcedureCost();

	/**
	 * @return
	 */
	int scheduleForProviders();

	/**
	 * @return
	 */
	boolean addMoreProcedures();

	/**
	 * @return
	 */
	int getYear();

	/**
	 * @return
	 */
	int getMonth();

	/**
	 * @return
	 */
	int getDayOfMonth();

	/**
	 * @return
	 */
	int getHour();

	/**
	 * @return
	 */
	int getMinute();

	/**
	 * @return
	 */
	boolean addMoreProviders();

	/**
	 * 
	 */
	void notifySearchingProvider();

	/**
	 * 
	 */
	void notifySearchingPatient();

	/**
	 * 
	 */
	void invalidAppointmentDate();
}
