package edu.neumont.cox.dentistoffice.model;

public class Person extends Clinic{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	private int uniqueId;
	private String email;
	private PhoneNumber phone;
	
	public Person(String firstName, String lastName, int uniqueId, String email, PhoneNumber phone) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setUniqueId(uniqueId);
		this.setEmail(email);
		this.setPhone(phone);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PhoneNumber getPhone() {
		return phone;
	}

	public void setPhone(PhoneNumber phone) {
		this.phone = phone;
	}
	
	
}
