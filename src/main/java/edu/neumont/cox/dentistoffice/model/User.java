package edu.neumont.cox.dentistoffice.model;

/**
 * @author Chris
 *
 */
public class User extends Clinic{
	
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
	 * @param user
	 * @return
	 */
	public boolean changePasswordForUser(User user) {
		boolean check = true;
		if (this.getRole() == UserRole.Administrative) {
			
		} else {
			check = false;
		}
		return check;
	}
	
	/**
	 * @param user
	 * @return
	 */
	public boolean removeUser(User user) {
		boolean check = true;
		if (this.getRole() == UserRole.Administrative) {
			
		} else {
			check = false;
		}
		return check;
	}
	
	/**
	 * @param user
	 * @param role
	 * @return
	 */
	public boolean changeRole(User user, UserRole role) {
		boolean check = true;
		if (this.getRole() == UserRole.Administrative) {
			
		} else {
			check = false;
		}
		return check;
	}
	
	/**
	 * @param password
	 */
	public void changePassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return
	 */
	public UserRole getRole() {
		return role;
	}
	
	/**
	 * @param role
	 * @return
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
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
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
