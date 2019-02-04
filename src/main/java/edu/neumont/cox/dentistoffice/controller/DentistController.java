package edu.neumont.cox.dentistoffice.controller;

import java.io.IOException;

import edu.neumont.cox.dentistoffice.model.Clinic;
import edu.neumont.cox.dentistoffice.model.User;
import edu.neumont.cox.dentistoffice.view.UserInteractionInterface;
import edu.neumont.dazley.savabledatabase.SavableDatabase;

public class DentistController {
	Clinic clinic;
	UserInteractionInterface userInteraction;
	
	public DentistController(UserInteractionInterface UI) {
		this.userInteraction = UI;
	}
	
	public void run() {
		SavableDatabase database = new SavableDatabase();
		try {
			database.load();
			clinic = (Clinic) database.get(0);
		} catch (ClassNotFoundException | IOException e) {
			firstLogin();
		}
		login();
	}

	private void firstLogin() {
		clinic.addUser(new User("Administrator", "1234Password"));
		String newPass = userInteraction.adminPasswordChange();
	}

	private void login() {
		
	}
}
