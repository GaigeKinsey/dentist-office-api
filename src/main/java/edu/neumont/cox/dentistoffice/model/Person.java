package edu.neumont.cox.dentistoffice.model;

public class Person extends Clinic {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String firstName;
	private String lastName;
	private int uniqueId;
	private String email;
	private PhoneNumber phone;
	
	/**
	 * Default constructor for Person
	 */
	public Person() {}

	/**
	 * Overloaded constructor for Person
	 * @param firstName
	 * @param lastName
	 * @param uniqueId
	 * @param email
	 * @param phone
	 */
	public Person(String firstName, String lastName, int uniqueId, String email, PhoneNumber phone) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setUniqueId(uniqueId);
		this.setEmail(email);
		this.setPhone(phone);
	}

	/**
	 * @return String firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * sets the firstName
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return String lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * sets the lastName
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return int uniqueId
	 */
	public int getUniqueId() {
		return uniqueId;
	}

	/**
	 * sets the uniqueId
	 * @param uniqueId
	 */
	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}

	/**
	 * @return String email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * sets the email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return PhoneNumber
	 */
	public PhoneNumber getPhone() {
		return phone;
	}

	/**
	 * sets the phoneNumber
	 * @param phone
	 */
	public void setPhone(PhoneNumber phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "First Name: " + this.getFirstName() + ", Last Name: " + this.getLastName() + ", Unique ID: "
				+ this.getUniqueId() + ", Email: " + this.getEmail() + ", Phone: " + this.getPhone();
	}

}
