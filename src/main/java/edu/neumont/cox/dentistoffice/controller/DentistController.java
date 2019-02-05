package edu.neumont.cox.dentistoffice.controller;

import java.io.IOException;

import edu.neumont.cox.dentistoffice.model.Clinic;
import edu.neumont.cox.dentistoffice.model.User;
import edu.neumont.cox.dentistoffice.model.UserRole;
import edu.neumont.cox.dentistoffice.view.UserInteractionInterface;
import edu.neumont.cox.savabledatabase.SavableDatabase;

public class DentistController {
	private Clinic clinic = new Clinic();
	private SavableDatabase database = new SavableDatabase();
	private UserInteractionInterface userInteraction;
	private User currentUser;

	public DentistController(UserInteractionInterface UI) {
		this.userInteraction = UI;
	}

	public void run() {
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
//		List<User> users = clinic.getUsers();
		boolean checkUser = false;

		do {
			String username = userInteraction.getUsername();
			String password = userInteraction.getPassword();
			User user = clinic.getUsers().get(username);
			if (user.getPassword().equals(password)) {
				currentUser = user;
				checkUser = true;
			}

//			for (User user : users) {
//				if (user.getUsername().equals(username)) {
//					if (user.getPassword().equals(password)) {
//						currentUser = user;
//						checkUser = true;
//					}
//				}
//			}
			if (!checkUser) {
				userInteraction.invalidUser();
			}
		} while (!checkUser);
		mainMenu();
	}

	private void mainMenu() {
		userInteraction.dentistOfficeGreeting();
		int choice = userInteraction.dentistOfficeMenu();

		switch (choice) {
		
		// Search
		case 1:
			
		//Schedule an appointment
		case 2:	

		// Add someone
		case 3:
			int selection1 = userInteraction.addSomeoneSubMenu();

			switch (selection1) {
			case 1:
				if (currentUser.getRole() == UserRole.Administrative) {
					String username = userInteraction.getUsername();
					String password = userInteraction.getPassword();
					String firstName = userInteraction.getFirstName();
					String lastName = userInteraction.getLastName();
					UserRole role = null;
					
					int roleChoice = userInteraction.userRoleChoice();
					if(roleChoice == 1) {
						role = UserRole.Administrative;
					} else {
						role = UserRole.Standard;
					}
					
					clinic.addUser(new User(username, password, firstName, lastName, role));
					
				} else {
					userInteraction.noPermission();
					mainMenu();
				}

			case 2:
				
			case 3:	

			case 4:
				mainMenu();

			}
		// Remove someone	
		case 4:

			int selection2 = userInteraction.removeSomeoneSubMenu();

			switch (selection2) {
			case 1:
				if (currentUser.getRole() == UserRole.Administrative) {


				} else {
					userInteraction.noPermission();
					mainMenu();
				}

			case 2:
				
			case 3:		

			case 4:
				mainMenu();

			}
		
		//Report	
		case 5:	

		// Save
		case 6:
			database.add(clinic);
			try {
				database.save();
			} catch (IOException e) {
				e.printStackTrace();
			}
			database.clear();
		}
	}
}
