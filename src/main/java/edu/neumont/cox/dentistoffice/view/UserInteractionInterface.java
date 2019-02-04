package edu.neumont.cox.dentistoffice.view;

public interface UserInteractionInterface {

	String adminPasswordChange();

	void noPermission();

	boolean checkPassword(String password);
	
	void passwordMismatch();
}
