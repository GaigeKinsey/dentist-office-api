package edu.neumont.cox.dentistoffice.controller;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.neumont.cox.dentistoffice.model.Appointment;
import edu.neumont.cox.dentistoffice.model.CardNumber;
import edu.neumont.cox.dentistoffice.model.Clinic;
import edu.neumont.cox.dentistoffice.model.InsuranceInfo;
import edu.neumont.cox.dentistoffice.model.Patient;
import edu.neumont.cox.dentistoffice.model.PaymentCard;
import edu.neumont.cox.dentistoffice.model.PhoneNumber;
import edu.neumont.cox.dentistoffice.model.Procedure;
import edu.neumont.cox.dentistoffice.model.Provider;
import edu.neumont.cox.dentistoffice.model.ProviderType;
import edu.neumont.cox.dentistoffice.model.User;
import edu.neumont.cox.dentistoffice.model.UserRole;
import edu.neumont.cox.dentistoffice.view.UserInteractionInterface;
import edu.neumont.cox.savabledatabase.SavableDatabase;

/**
 * @author Chris and Gaige
 *
 */
public class DentistController {
	private Clinic clinic = new Clinic();
	private SavableDatabase database = new SavableDatabase();
	private UserInteractionInterface userInteraction;
	private User currentUser;
	private Patient recentPatient;
	private Provider recentProvider;

	/**
	 * Constructor for the controller, an object that implements the UserInteractionInterface
	 * @param UI
	 */
	public DentistController(UserInteractionInterface UI) {
		this.userInteraction = UI;
	}

	/**
	 * Start of the program
	 */
	public void run() {
		try {
			database.load();
			clinic = (Clinic) database.get(0);
			login(false);
		} catch (ClassNotFoundException | IOException e) {
			clinic.addUser(
					new User("Administrator", "1234Password", "Administrative", "User", UserRole.Administrative));
			login(true);
		}
	}

	private void login(boolean startup) {
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
		if (startup) {
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
		}
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
			case 5:
				recordPayment();
				break;
			// Report
			case 6:
				generateReports();
				break;
			// User Settings
			case 7:
				userSettings();
				break;
			// Save
			case 8:
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
			try {
				selectedObject = matchedUsers.get(userSelection);
			} catch (NullPointerException npe) {
			}
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
			try {
				selectedObject = matchedPatients.get(patientSelection);
			} catch (NullPointerException npe) {
			}
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
			try {
				selectedObject = matchedProviders.get(providerSelection);
			} catch (NullPointerException npe) {
			}
		}

		return selectedObject;
	}

	private Clinic searchApointment() {
		Clinic selectedObject = null;

		userInteraction.askForStartDate();
		LocalDateTime startDateTime = setDateTime();
		userInteraction.askForEndDate();
		LocalDateTime endDateTime = setDateTime();
		Patient patient = null;
		if (userInteraction.searchForPatient()) {
			userInteraction.notifySearchingPatient();
			boolean patientSelected = false;
			do {
				try {
					patient = (Patient) searchPatient();
					patientSelected = true;
				} catch (NullPointerException npe) {
				}
			} while (!patientSelected);
		}
		Provider provider = null;
		if (userInteraction.searchForProvider()) {
			userInteraction.notifySearchingProvider();
			boolean providerSelected = false;
			do {
				try {
					provider = (Provider) searchProvider();
					providerSelected = true;
				} catch (NullPointerException npe) {
				}
			} while (!providerSelected);
		}
		String procedureCode = userInteraction.getSearchProcedureCode();

		List<Appointment> matchedAppointments = meetsAppointmentSearch(startDateTime, endDateTime, patient, provider,
				procedureCode);
		int providerSelection = userInteraction.getAppointmentSearchSelection(matchedAppointments) - 1;
		if (providerSelection >= 0) {
			try {
				selectedObject = matchedAppointments.get(providerSelection);
			} catch (NullPointerException npe) {
			}
		}

		return selectedObject;
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

	private List<Appointment> meetsAppointmentSearch(LocalDateTime startDateTime, LocalDateTime endDateTime,
			Patient patient, Provider provider, String procedureCode) {
		List<Appointment> matchedAppointment = new ArrayList<>();
		for (Appointment appointment : clinic.getAppointments()) {
			if (appointment.getDateTime().isAfter(startDateTime) && appointment.getDateTime().isBefore(endDateTime)
					&& checkForPatient(appointment, patient) && checkForProvider(appointment, provider)
					&& procedureCodeMatches(procedureCode, appointment)) {
				matchedAppointment.add(appointment);
			}
		}
		return matchedAppointment;
	}

	private boolean checkForProvider(Appointment appointment, Provider provider) {
		boolean matches = false;
		if (provider == null) {
			matches = true;
		} else {
			if (appointment.getProviders().containsValue(provider)) {
				matches = true;
			}
		}
		return matches;
	}

	private boolean checkForPatient(Appointment appointment, Patient patient) {
		boolean matches = false;
		if (patient == null) {
			matches = true;
		} else {
			if (appointment.getPatients().containsValue(patient)) {
				matches = true;
			}
		}
		return matches;
	}

	private boolean procedureCodeMatches(String procedureCode, Appointment appointment) {
		boolean matches = false;
		if (procedureCode == null || procedureCode.isEmpty()) {
			matches = true;
		} else {
			for (List<Procedure> procedures : appointment.getProcedures().values()) {
				for (Procedure procedure : procedures) {
					if (procedure.getCode().startsWith("D" + procedureCode)) {
						matches = true;
					}
				}
			}
		}
		return matches;
	}

	private void scheduleAppointment() {
		// Get the patient
		int patientChoice = userInteraction.scheduleForPatients();
		Double totalCost = 0.0d;
		if (patientChoice != 0) {
			Patient patient = null;
			if (patientChoice == 1) {
				addPatient();
				patient = recentPatient;
			} else {
				userInteraction.notifySearchingPatient();
				do {
					patient = (Patient) searchPatient();
					if (patient == null) {
						userInteraction.notifyNoPatient();
					}
				} while (patient == null);
			}
			boolean addingProviders = false;
			do {
				// Get the provider
				Provider provider = null;
				int providerChoice = userInteraction.scheduleForProviders();
				if (providerChoice == 1) {
					addProvider();
					provider = recentProvider;
				} else {
					userInteraction.notifySearchingProvider();
					do {
						provider = (Provider) searchProvider();
						if (provider == null) {
							userInteraction.notifyNoProvider();
						}
					} while (provider == null);
				}
				// Get the procedures
				List<Procedure> procedures = new ArrayList<>();
				boolean addingProcedures = true;
				do {
					String code = userInteraction.getProcedureCode();
					String description = userInteraction.getProcedureDescription();
					Double cost = userInteraction.getProcedureCost();
					totalCost += cost;
					procedures.add(new Procedure(code, description, cost));
					addingProcedures = userInteraction.addMoreProcedures();
				} while (addingProcedures);
				// Get time
				LocalDateTime dateTime = null;
				boolean validTime = false;
				do {
					int year = userInteraction.getYear();
					int month = userInteraction.getMonth();
					int dayOfMonth = userInteraction.getDayOfMonth(month);
					int hour = userInteraction.getHour();
					int minute = userInteraction.getMinute();
					try {
						dateTime = LocalDateTime.of(year, month, dayOfMonth, hour, minute);
						validTime = true;
					} catch (DateTimeException dte) {
						userInteraction.invalidAppointmentDate();
					}
				} while (!validTime);
				clinic.getAppointments().add(new Appointment(patient, provider, procedures, dateTime));
				patient.setBalanceDue(patient.getBalanceDue() + totalCost);
				addingProviders = userInteraction.addMoreProviders();
			} while (addingProviders);
		}
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
		recentPatient = new Patient(firstName, lastName, uniqueId, email, phone, insurance, card);
		clinic.addPatient(recentPatient);
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
		recentProvider = new Provider(firstName, lastName, uniqueId, email, phone, title);
		clinic.addProvider(recentProvider);
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

	private void recordPayment() {
		userInteraction.askForPatient();
		try {
			Patient patient = (Patient) search(2);
			patient.setTotalCharges(patient.getBalanceDue() + patient.getTotalCharges());
			patient.setBalanceDue(0.0d);
		} catch (NullPointerException npe) {
			userInteraction.recordPaymentFailed();
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
				productionReport();
				break;
			// Patient Balance
			case 2:
				patientBalanceReport();
				break;
			// Collections
			case 3:
				collectionReport();
				break;
			}
		}
	}

	private void productionReport() {
		userInteraction.askForStartDate();
		LocalDate startDate = setDate();
		userInteraction.askForEndDate();
		LocalDate endDate = setDate();
		boolean groupBy = userInteraction.groupBySelection();

		productionReport(startDate, endDate, groupBy);

	}

	private void patientBalanceReport() {
		boolean sortBy = userInteraction.sortBySelection();

		patientBalanceReport(sortBy);
	}

	private void collectionReport() {
		userInteraction.askForStartDate();
		LocalDate startDate = setDate();
		userInteraction.askForEndDate();
		LocalDate endDate = setDate();
		boolean groupBy = userInteraction.groupBySelection();

		collectionsReport(startDate, endDate, groupBy);
	}

	private void userSettings() {
		if (currentUser.getRole().equals(UserRole.Administrative)) {
			adminUserSettings();
		} else {
			standardUserSettings();
		}
	}

	private void standardUserSettings() {
		boolean choice = userInteraction.changePasswordDecision();

		if (choice) {
			changePassword();
		}

	}

	private void adminUserSettings() {
		int option = userInteraction.changeUserPassword();

		switch (option) {
		// Change admin password
		case 1:
			changePassword();
			break;
		// Change another user's password
		case 2:
			User user = (User) search(1);
			if (user != null) {
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
			}
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

	private LocalDateTime setDateTime() {

		LocalDateTime setDate = null;

		int year = userInteraction.getYear();
		int month = userInteraction.getMonth();
		int dayOfMonth = userInteraction.getDayOfMonth(month);
		int hour = userInteraction.getHour();
		int minute = userInteraction.getMinute();

		setDate = LocalDateTime.of(year, month, dayOfMonth, hour, minute);

		return setDate;
	}

	private LocalDate setDate() {

		LocalDate setDate = null;

		int year = userInteraction.getYear();
		int month = userInteraction.getMonth();
		int dayOfMonth = userInteraction.getDayOfMonth(month);

		setDate = LocalDate.of(year, month, dayOfMonth);

		return setDate;
	}

	private void productionReport(LocalDate startDate, LocalDate endDate, boolean groupBy) {
		List<Appointment> matchedAppointments = new ArrayList<>();
		for (Appointment appointment : clinic.getAppointments()) {
			if (appointment.getDate().isAfter(startDate) && appointment.getDate().isBefore(endDate)) {
				matchedAppointments.add(appointment);
			}
		}

		// total charges for the entire month(s)
		if (groupBy) {
			for (int i = 1; i <= 12; i++) {
				boolean matched = false;
				double total = 0;
				for (Appointment appointment : matchedAppointments) {
					if (appointment.getDate().getMonthValue() == i) {
						matched = true;
						for (List<Procedure> procedures : appointment.getProcedures().values()) {
							for (Procedure procedure : procedures) {
								total += procedure.getCost();
							}
						}
					}
				}
				if (matched) {
					userInteraction.printGroup(i, total, groupBy);
				}
			}
		} else {
			// total charges for each day(s)
			for (int i = 1; i <= 31; i++) {
				boolean matched = false;
				int total = 0;
				for (Appointment appointment : clinic.getAppointments()) {
					if (appointment.getDate().getDayOfMonth() == i) {
						matched = true;
						for (List<Procedure> procedures : appointment.getProcedures().values()) {
							for (Procedure procedure : procedures) {
								total += procedure.getCost();
							}
						}
					}
				}
				if (matched) {
					userInteraction.printGroup(i, total, groupBy);
				}
			}
		}
	}

	private void patientBalanceReport(boolean sortBy) {
		// Turn the patients into an arraylist
		List<Patient> patients = new ArrayList<>();
		for (Patient patient : clinic.getPatients().values()) {
			patients.add(patient);
		}
		
		if (sortBy) {
			// Largest patient balance to smallest balance
			Patient tempPatient;
			// This will loop until all patients have a larger balance than the patient directly in front of it
			for (int i = 0; i < patients.size() - 1; i++) {
				// If the current patient has a smaller balance than the one in front of it, then swap them
				if (patients.get(i).getBalanceDue() < patients.get(i + 1).getBalanceDue()) {
					tempPatient = patients.get(i);
					patients.set(i, patients.get(i + 1));
					patients.set(i + 1, tempPatient);
					// After swapping, restart the loop
					i = -1;
				}
			}
			userInteraction.printSort(patients);
		} else {
			// sorts balance by name
			Collections.sort(patients);
			userInteraction.printSort(patients);
		}
	}

	private void collectionsReport(LocalDate startDate, LocalDate endDate, boolean groupBy) {
		List<Appointment> matchedAppointments = new ArrayList<>();
		for (Appointment appointment : clinic.getAppointments()) {
			if (appointment.getDate().isAfter(startDate) && appointment.getDate().isBefore(endDate)) {
				matchedAppointments.add(appointment);
			}
		}

		// total charges for the entire month(s)
		if (groupBy) {
			for (int i = 1; i <= 12; i++) {
				boolean matched = false;
				int total = 0;
				for (Appointment appointment : matchedAppointments) {
					if (appointment.getDateTime().getMonthValue() == i) {
						if (appointment.getPatient().getTotalCharges() > 0) {
							total += appointment.getPatient().getTotalCharges();
							matched = true;
						}
					}
				}
				if (matched) {
					userInteraction.printGroup(i, total, groupBy);
				}
			}
		} else {
			// total charges for each day(s)
			for (int i = 1; i <= 31; i++) {
				boolean matched = false;
				int total = 0;
				for (Appointment appointment : matchedAppointments) {
					if (appointment.getDateTime().getDayOfMonth() == i) {
						if (appointment.getPatient().getTotalCharges() > 0) {
							total += appointment.getPatient().getTotalCharges();
							matched = true;
						}
					}
				}
				if (matched) {
					userInteraction.printGroup(i, total, groupBy);
				}
			}
		}
	}
}
