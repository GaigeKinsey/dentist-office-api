package edu.neumont.cox.dentistoffice.controller;

import java.io.IOException;
import java.time.LocalDate;

import edu.neumont.cox.dentistoffice.model.Clinic;
import edu.neumont.cox.dentistoffice.model.InsuranceInfo;
import edu.neumont.cox.dentistoffice.model.Patient;
import edu.neumont.cox.dentistoffice.model.PaymentCard;
import edu.neumont.cox.dentistoffice.model.PhoneNumber;
import edu.neumont.cox.dentistoffice.model.Provider;
import edu.neumont.cox.dentistoffice.model.ProviderType;
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

			// Schedule an appointment
		case 2:

			// Add someone
		case 3:
			int addSelection = userInteraction.addSomeoneSubMenu();

			switch (addSelection) {
			// user
			case 1:
				if (currentUser.getRole() == UserRole.Administrative) {
					String username = userInteraction.getUsername();
					String password = userInteraction.getPassword();
					String firstName = userInteraction.getFirstName();
					String lastName = userInteraction.getLastName();
					UserRole role = null;

					int roleChoice = userInteraction.userRoleChoice();
					if (roleChoice == 1) {
						role = UserRole.Administrative;
					} else {
						role = UserRole.Standard;
					}

					clinic.addUser(new User(username, password, firstName, lastName, role));

					mainMenu();

				} else {
					userInteraction.noPermission();
					mainMenu();
				}

				// patient
			case 2:
				String firstName = userInteraction.getFirstName();
				String lastName = userInteraction.getLastName();
				int uniqueId = userInteraction.getUniqueId();
				String email = userInteraction.getEmail();
				
				PhoneNumber phone = new PhoneNumber();
				
				// Insurance Provider
				userInteraction.insuranceProviderPrompt();
				String companyName = userInteraction.getCompanyName();
				String groupId = userInteraction.getGroupId();
				String memberId = userInteraction.getMemberId();
				InsuranceInfo insurance = new InsuranceInfo(companyName, groupId, memberId);

				// Payment Card
				userInteraction.paymentCardPrompt();
				long cardNumber = userInteraction.getCardNumber();
		//Didn't mess with this part that much, just stubbed out the UI method
				LocalDate expireDate = userInteraction.getExpireDate();
				String holderName = userInteraction.getHolderName();
				int cvv = userInteraction.getCVV();
				int zipCode = userInteraction.getZipCode();
				PaymentCard card = new PaymentCard(cardNumber, expireDate, holderName, cvv, zipCode);
				
				//adds patient
				clinic.addPatient(new Patient(firstName, lastName, uniqueId, email, phone, insurance, card));

				mainMenu();
				// provider
			case 3:
				String proFirstName = userInteraction.getFirstName();
				String proLastName = userInteraction.getLastName();
				int proUniqueId = userInteraction.getUniqueId();
				String proEmail = userInteraction.getEmail();
				PhoneNumber proPhone = new PhoneNumber();
				
				ProviderType title = null;

				int roleChoice = userInteraction.getProviderType();
				if (roleChoice == 1) {
					title = ProviderType.Assistant;
				} else if(roleChoice == 2){
					title = ProviderType.Dentist;
				} else {
					title = ProviderType.Hygienist;
				}
				
				//addsProvider
				clinic.addProvider(new Provider(proFirstName, proLastName, proUniqueId, proEmail, proPhone, title));
				
				mainMenu();

			case 4:
				mainMenu();

			}
			// Remove someone
		case 4:

			int remSelection = userInteraction.removeSomeoneSubMenu();

			switch (remSelection) {
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

			// Report
		case 5:
			int repSelection = userInteraction.reportsMenu();

			switch (repSelection) {

			// production
			case 1:

				// Patient Balance
			case 2:

				// Collections
			case 3:

				// Main menu
			case 4:
				mainMenu();
			}

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
