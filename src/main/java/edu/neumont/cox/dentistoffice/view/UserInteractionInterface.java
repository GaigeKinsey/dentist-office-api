package edu.neumont.cox.dentistoffice.view;

import java.util.List;

import edu.neumont.cox.dentistoffice.model.Patient;
import edu.neumont.cox.dentistoffice.model.Provider;
import edu.neumont.cox.dentistoffice.model.User;

public interface UserInteractionInterface {

	String adminPasswordChange();

	void noPermission();

	boolean checkPassword(String password);
	
	void passwordMismatch();
	
	void dentistOfficeGreeting();
	
	int dentistOfficeMenu();

	String getUsername();

	String getPassword();

	void invalidUser();
	
	int addSomeoneSubMenu();
	
	int removeSomeoneSubMenu();
	
	int reportsMenu();

	int userRoleChoice();

	String getFirstName();

	String getLastName();

	int getUniqueId();

	String getEmail();

	String getCompanyName();

	String getGroupId();

	String getMemberId();

	void insuranceProviderPrompt();

	void paymentCardPrompt();

	String getCardNumber();

	String getHolderName();

	int getCVV();

	int getZipCode();

	int getProviderType();

	int searchSubMenu();

	String createPassword();

	String getSearchFirstName();

	String getSearchLastName();

	String getSearchUsername();

	String getSearchCompanyName();
	
	int getUserSearchSelection(List<User> matchedUsers);

	int getPatientSearchSelection(List<Patient> matchedPatients);

	int getProviderSearchSelection(List<Provider> matchedProviders);

	String getPhoneNumberString();
	
	void invalidPhone();

	void invalidCard();
	
	void invalidExpireDate();

	int scheduleForPatients();

	String getExpireDate();
	
	int changeUserPassword();

	boolean changePasswordDecision();

	String changePassword();

	String getProcedureCode();

	String getProcedureDescription();

	Double getProcedureCost();
}
