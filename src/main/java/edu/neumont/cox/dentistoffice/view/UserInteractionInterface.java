package edu.neumont.cox.dentistoffice.view;

import java.time.LocalDate;

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

	long getCardNumber();

	LocalDate getExpireDate();

	String getHolderName();

	int getCVV();

	int getZipCode();

	int getProviderType();

	int searchSubMenu();

	String createPassword();
}
