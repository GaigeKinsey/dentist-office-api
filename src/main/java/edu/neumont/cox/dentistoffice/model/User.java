package edu.neumont.cox.dentistoffice.model;

import java.io.Serializable;

/**
 * @author Chris and Gaige
 *
 */
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private UserRole role;
	

	/**
	 * Overloaded Constructor for User
	 * @param username
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param role
	 */
	public User(String username, String password, String firstName, String lastName, UserRole role) {
		this.setUsername(username);
		this.setPassword(password);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.role = role;
	}
	
	/**
	 * sets the user's password
	 * @param password
	 */
	public void changePassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return UserRole role
	 */
	public UserRole getRole() {
		return role;
	}
	
	/**
	 * sets the user role
	 * @param role
	 * @return boolean true if completed, false if invalid permission
	 */
	public boolean setRole(UserRole role) {
		boolean check = true;
		if (this.getRole() == UserRole.Administrative) {
			this.role = role;
		} else {
			check = false;
		}
		return check;
	}

	/**
	 * @return String username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * sets the username
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return String password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * sets the password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return String firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * sets the first name
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
	 * sets the last name
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "First Name: " + this.getFirstName() + " Last Name: " + this.getLastName() + " Username: " + this.getUsername();
	}
}
