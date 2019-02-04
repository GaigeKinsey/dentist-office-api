package edu.neumont.cox.dentistoffice.controller;

import java.io.IOException;

import edu.neumont.cox.dentistoffice.model.Clinic;
import edu.neumont.cox.dentistoffice.model.User;
import edu.neumont.cox.dentistoffice.model.UserRole;
import edu.neumont.cox.dentistoffice.view.UserInteractionInterface;
import edu.neumont.kinsey.savabledatabase.SavableDatabase;

public class DentistController {
	Clinic clinic = new Clinic();
	UserInteractionInterface userInteraction;
	User currentUser;
	
	public DentistController(UserInteractionInterface UI) {
		this.userInteraction = UI;
	}
	
	public void run() {
		SavableDatabase database = new SavableDatabase();
		try {
			database.load();
			clinic = (Clinic) database.get(0);
			login();
		} catch (ClassNotFoundException | IOException e) {
			firstLogin();
		}
	}

	private void firstLogin() {
		currentUser = new User("Administrator", "1234Password", UserRole.Administrative);
		clinic.addUser(currentUser);
		String newPass = userInteraction.adminPasswordChange();
		currentUser.changePassword(newPass);
	}

	private void login() {
		
	}
	
	private void mainMenu() {
		
	}
}
