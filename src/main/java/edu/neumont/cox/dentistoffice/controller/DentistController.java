package edu.neumont.cox.dentistoffice.controller;

import java.io.IOException;
import java.util.List;

import edu.neumont.cox.dentistoffice.model.Clinic;
import edu.neumont.cox.dentistoffice.model.User;
import edu.neumont.cox.dentistoffice.model.UserRole;
import edu.neumont.cox.dentistoffice.view.UserInteractionInterface;
import edu.neumont.cox.savabledatabase.SavableDatabase;

public class DentistController {
	private Clinic clinic = new Clinic();
	private SavableDatabase database;
	private UserInteractionInterface userInteraction;
	private User currentUser;

	public DentistController(UserInteractionInterface UI) {
		this.userInteraction = UI;
	}

	public void run() {
		database = new SavableDatabase();
		try {
			database.load();
			clinic = (Clinic) database.get(0);
			login();
		} catch (ClassNotFoundException | IOException e) {
			firstLogin();
		}
	}

	private void firstLogin() {
		currentUser = new User("Administrator", "1234Password", "Administrative", "User", UserRole.Administrative);
		clinic.addUser(currentUser);
		String newPass = "";
		boolean valid = false;
		do {
			newPass = userInteraction.adminPasswordChange();
			valid = userInteraction.checkPassword(newPass);
			if (!valid) {
				userInteraction.passwordMismatch();
			}
		} while (!valid);
		currentUser.changePassword(newPass);
		mainMenu();
	}

	private void login() {
		List<User> users = clinic.getUsers();
		boolean checkUser = false;

		do {
			String username = userInteraction.getUsername();
			String password = userInteraction.getPassword();

			for (User user : users) {
				if (user.getUsername().equals(username)) {
					if (user.getPassword().equals(password)) {
						currentUser = user;
						checkUser = true;
					}
				}
			}
			if (!checkUser) {
				userInteraction.invalidUser();
			}
		} while (!checkUser);
	}

	private void mainMenu() {
		userInteraction.dentistOfficeGreeting();
		int choice = userInteraction.dentistOfficeMenu();
		
		switch (choice) {
		case 5:
			try {
				database.save();
			} catch (IOException e) {
				System.out.println("Shouldn't have happened.");
			}
		}
	}
}
