package edu.neumont.cox.dentistoffice.view;

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
}
