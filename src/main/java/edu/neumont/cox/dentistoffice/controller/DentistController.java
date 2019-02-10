package edu.neumont.cox.dentistoffice.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.neumont.cox.dentistoffice.model.CardNumber;
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
		boolean checkUser = false;

		do {
			String username = userInteraction.getUsername();
			String password = userInteraction.getPassword();
			User user = clinic.getUsers().get(username);
			try {

				if (user.getPassword().equals(password)) {
					currentUser = user;
					checkUser = true;
				}

				if (!checkUser) {
					userInteraction.invalidUser();
				}
			} catch (NullPointerException npe) {
				userInteraction.invalidUser();
			}
		} while (!checkUser);
		mainMenu();
	}

	private void mainMenu() {
		userInteraction.dentistOfficeGreeting();
		boolean isRunning = true;
		do {
			int choice = userInteraction.dentistOfficeMenu();
			switch (choice) {
			case 0:
				isRunning = false;
				break;
			// Search
			case 1:
				searchMenu();
				break;
			// Schedule an appointment
			case 2:
				scheduleAppointment();
				break;
			// Add someone
			case 3:
				addSomeone();
				break;
			// Remove someone
			case 4:
				removeSomeone();
				break;
			// Report
			case 5:
				generateReports();
				break;
			// User Settings
			case 6: 
				userSettings();
				break;
			// Save
			case 7:
				database.add(clinic);
				try {
					database.save();
				} catch (IOException e) {
					e.printStackTrace();
				}
				database.clear();
				break;
			default:
				System.out.println("This shouldn't have happened");
				break;
			}
		} while (isRunning);
	}

	private void searchMenu() {
		int searchSelection = userInteraction.searchSubMenu();
		if (searchSelection != 0) {
			search(searchSelection);
		}
	}

	private Clinic search(int value) {
		Clinic selectedObject = null;
		switch (value) {
		// users
		case 1:
			selectedObject = searchUser();
			break;
		// Patients
		case 2:
			selectedObject = searchPatient();
			break;
		// Providers
		case 3:
			selectedObject = searchProvider();
			break;
			
		case 4:
			selectedObject = searchApointment();
			break;
		}
		return selectedObject;
	}

	private Clinic searchUser() {
		Clinic selectedObject = null;

		String firstName = userInteraction.getSearchFirstName();
		String lastName = userInteraction.getSearchLastName();
		String username = userInteraction.getSearchUsername();
		List<User> matchedUsers = meetsUserSearch(firstName, lastName, username);
		int userSelection = userInteraction.getUserSearchSelection(matchedUsers) - 1;
		if (userSelection >= 0) {
			selectedObject = matchedUsers.get(userSelection);
		}

		return selectedObject;
	}

	private Clinic searchPatient() {
		Clinic selectedObject = null;

		String firstName = userInteraction.getSearchFirstName();
		String lastName = userInteraction.getSearchLastName();
		String companyName = userInteraction.getSearchCompanyName();

		List<Patient> matchedPatients = meetsPatientSearch(firstName, lastName, companyName);
		int patientSelection = userInteraction.getPatientSearchSelection(matchedPatients) - 1;
		if (patientSelection >= 0) {
			selectedObject = matchedPatients.get(patientSelection);
		}

		return selectedObject;
	}

	private Clinic searchProvider() {
		Clinic selectedObject = null;

		String firstName = userInteraction.getSearchFirstName();
		String lastName = userInteraction.getSearchLastName();

		ProviderType title = null;

		int roleChoice = userInteraction.getProviderType();
		if (roleChoice == 1) {
			title = ProviderType.Assistant;
		} else if (roleChoice == 2) {
			title = ProviderType.Dentist;
		} else if (roleChoice == 3) {
			title = ProviderType.Hygienist;
		}

		List<Provider> matchedProviders = meetsProviderSearch(firstName, lastName, title);
		int providerSelection = userInteraction.getProviderSearchSelection(matchedProviders) - 1;
		if (providerSelection >= 0) {
			selectedObject = matchedProviders.get(providerSelection);
		}

		return selectedObject;
	}
	
	private Clinic searchApointment() {
		// TODO Auto-generated method stub
		return null;
	}

	// User - meetSearch
	private List<User> meetsUserSearch(String firstName, String lastName, String username) {
		List<User> matchedUsers = new ArrayList<>();
		for (User user : clinic.getUsers().values()) {
			if (user.getFirstName().startsWith(firstName) && user.getLastName().startsWith(lastName)
					&& user.getUsername().startsWith(username)) {
				matchedUsers.add(user);
			}
		}
		return matchedUsers;
	}

	// patient - meetSearch
	private List<Patient> meetsPatientSearch(String firstName, String lastName, String companyName) {
		List<Patient> matchedPatients = new ArrayList<>();
		for (Patient patient : clinic.getPatients().values()) {
			if (patient.getFirstName().startsWith(firstName) && patient.getLastName().startsWith(lastName)
					&& patient.getInsurance().getCompanyName().startsWith(companyName)) {
				matchedPatients.add(patient);
			}
		}
		return matchedPatients;
	}

	// provider - meetSearch
	private List<Provider> meetsProviderSearch(String firstName, String lastName, ProviderType title) {
		List<Provider> matchedProviders = new ArrayList<>();
		for (Provider provider : clinic.getProviders().values()) {
			if (provider.getFirstName().startsWith(firstName) && provider.getLastName().startsWith(lastName)
					&& provider.getTitle().toString().startsWith(title.toString())) {
				matchedProviders.add(provider);
			}
		}
		return matchedProviders;
	}
	
	private void scheduleAppointment() {
		int choice = userInteraction.scheduleForPatients();

		switch (choice) {
		case 1:
			addPatient();
			addAppointment();
		case 2:
			addAppointment();
			
		}
	}

	private void addAppointment() {
		// TODO Auto-generated method stub
		Patient patient = (Patient) search(2);
		
	}

	private void addSomeone() {
		int addSelection = userInteraction.addSomeoneSubMenu();
		if (addSelection != 0) {

			switch (addSelection) {
			// user
			case 1:
				addUser();
				break;
			// patient
			case 2:
				addPatient();
				break;
			// provider
			case 3:
				addProvider();
				break;
			}
		}
	}

	private void addUser() {
		if (currentUser.getRole() == UserRole.Administrative) {
			// We get the names for each option, might as well get them once here.
			String firstName = userInteraction.getFirstName();
			String lastName = userInteraction.getLastName();
			String username = userInteraction.getUsername();
			String password = userInteraction.createPassword();
			UserRole role = null;

			int roleChoice = userInteraction.userRoleChoice();
			if (roleChoice == 1) {
				role = UserRole.Administrative;
			} else {
				role = UserRole.Standard;
			}

			clinic.addUser(new User(username, password, firstName, lastName, role));
		} else {
			userInteraction.noPermission();
		}
	}

	private void addPatient() {
		// We get the names for each option, might as well get them once here.
		String firstName = userInteraction.getFirstName();
		String lastName = userInteraction.getLastName();
		int uniqueId = userInteraction.getUniqueId();
		String email = userInteraction.getEmail();

		PhoneNumber phone = getPhoneNumber();

		// Insurance Provider
		userInteraction.insuranceProviderPrompt();
		String companyName = userInteraction.getCompanyName();
		String groupId = userInteraction.getGroupId();
		String memberId = userInteraction.getMemberId();
		InsuranceInfo insurance = new InsuranceInfo(companyName, groupId, memberId);

		// Payment Card
		userInteraction.paymentCardPrompt();
		CardNumber cardNumber = getCardNumber();
		// Didn't mess with this part that much, just stubbed out the UI method
		String expireDate = getExpireDate();
		String holderName = userInteraction.getHolderName();
		int cvv = userInteraction.getCVV();
		int zipCode = userInteraction.getZipCode();
		PaymentCard card = new PaymentCard(cardNumber, expireDate, holderName, cvv, zipCode);

		// adds patient
		clinic.addPatient(new Patient(firstName, lastName, uniqueId, email, phone, insurance, card));
	}

	private void addProvider() {
		// We get the names for each option, might as well get them once here.
		String firstName = userInteraction.getFirstName();
		String lastName = userInteraction.getLastName();
		int uniqueId = userInteraction.getUniqueId();
		String email = userInteraction.getEmail();
		PhoneNumber phone = getPhoneNumber();

		ProviderType title = null;

		int roleChoice = userInteraction.getProviderType();
		if (roleChoice == 1) {
			title = ProviderType.Assistant;
		} else if (roleChoice == 2) {
			title = ProviderType.Dentist;
		} else {
			title = ProviderType.Hygienist;
		}

		// addsProvider
		clinic.addProvider(new Provider(firstName, lastName, uniqueId, email, phone, title));
	}

	private void removeSomeone() {
		int remSelection = userInteraction.removeSomeoneSubMenu();

		switch (remSelection) {
		case 1:
			// users
			if (currentUser.getRole() == UserRole.Administrative) {
				User user = (User) search(1);
				clinic.getUsers().remove(user.getUsername());
			} else {
				userInteraction.noPermission();
			}
			break;
		// patient
		case 2:
			Patient patient = (Patient) search(2);
			clinic.getPatients().remove(patient.getLastName());
			break;
		// provider
		case 3:
			Provider provider = (Provider) search(3);
			clinic.getProviders().remove(provider.getLastName());
			break;
		}
	}

	private PhoneNumber getPhoneNumber() {
		boolean valid = false;
		int firstThreeDigits = 0;
		int secondThreeDigits = 0;
		int lastFourDigits = 0;
		do {
			String rawNumber = userInteraction.getPhoneNumberString();
			if (rawNumber.length() == 10) {
				try {
					firstThreeDigits = Integer.parseInt(rawNumber.substring(0, 3));
					secondThreeDigits = Integer.parseInt(rawNumber.substring(3, 6));
					lastFourDigits = Integer.parseInt(rawNumber.substring(6, 10));
					valid = true;
				} catch (NumberFormatException nfe) {
					userInteraction.invalidPhone();
				}
			} else {
				userInteraction.invalidPhone();
			}
		} while (!valid);

		return new PhoneNumber(firstThreeDigits, secondThreeDigits, lastFourDigits);
	}

	private CardNumber getCardNumber() {
		boolean valid = false;
		int numberOne = 0;
		int numberTwo = 0;
		int numberThree = 0;
		int numberFour = 0;
		do {
			String rawCardNumber = userInteraction.getCardNumber();
			if (rawCardNumber.length() == 16) {
				try {
					numberOne = Integer.parseInt(rawCardNumber.substring(0, 4));
					numberTwo = Integer.parseInt(rawCardNumber.substring(4, 8));
					numberThree = Integer.parseInt(rawCardNumber.substring(8, 12));
					numberFour = Integer.parseInt(rawCardNumber.substring(12, 16));
					valid = true;
				} catch (NumberFormatException nfe) {
					userInteraction.invalidCard();
				}
			} else {
				userInteraction.invalidCard();
			}
		} while (!valid);
		return new CardNumber(numberOne, numberTwo, numberThree, numberFour);
	}

	private String getExpireDate() {
		String rawExpireDate = "";
		boolean valid = false;
		do {
			rawExpireDate = userInteraction.getExpireDate();
			if (rawExpireDate.matches("^(0[1-9]|1[0-2])/[0-9][0-9]$")) {
				valid = true;
			} else {
				userInteraction.invalidExpireDate();
			}
		} while (!valid);

		return rawExpireDate;
	}

	private void generateReports() {
		int repSelection = userInteraction.reportsMenu();
		if (repSelection != 0) {
			switch (repSelection) {

			// production
			case 1:

				break;
			// Patient Balance
			case 2:

				break;
			// Collections
			case 3:

				break;
			}
		}
	}
	
	private void userSettings() {
		if(currentUser.getRole().equals(UserRole.Administrative)) {
			adminUserSettings();
		} else {
			standardUserSettings();
		}
	}

	private void standardUserSettings() {
		boolean choice = userInteraction.changePasswordDecision();
		
		if(choice) {
			changePassword();
		}
		
	}

	private void adminUserSettings() {
		int option = userInteraction.changeUserPassword();
		
		switch(option) {
		//Change admin password
		case 1:
			changePassword();
			break;
		//Change another user's password	
		case 2:
			User user = (User) search(1);
			String newPass = "";
			boolean valid = false;
			do {
				newPass = userInteraction.changePassword();
				valid = userInteraction.checkPassword(newPass);
				if (!valid) {
					userInteraction.passwordMismatch();
				}
			} while (!valid);
			user.changePassword(newPass);
			break;
			
			//nullpointer doesn't exit back to main menu when selecting 0 
		}		
	}
	
	private void changePassword() {
		String newPass = "";
		boolean valid = false;
		do {
			newPass = userInteraction.changePassword();
			valid = userInteraction.checkPassword(newPass);
			if (!valid) {
				userInteraction.passwordMismatch();
			}
		} while (!valid);
		currentUser.changePassword(newPass);	
	}

}
