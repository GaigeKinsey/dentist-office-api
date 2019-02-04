package edu.neumont.cox.dentistoffice.model;

public class User {
	private String username;
	private String password;
	private UserRole role;
	

	public User(String username, String password, UserRole role) {
		this.setUsername(username);
		this.setPassword(password);
		this.role = role;
	}
	
	public void changePasswordForUser(User user) {
		if (this.getRole() == UserRole.Administrative) {
			
		} else {
			
		}
	}
	
	public void addUser(User user) {
		if (this.getRole() == UserRole.Administrative) {
			
		} else {
			
		}
	}
	
	public void removeUser(User user) {
		if (this.getRole() == UserRole.Administrative) {
			
		} else {
			
		}
	}
	
	public void changeRole(User user, UserRole role) {
		if (this.getRole() == UserRole.Administrative) {
			
		} else {

		}
	}
	
	public void changePassword(String password) {
		
	}
	
	public UserRole getRole() {
		return role;
	}
	
	public void setRole(UserRole role) {
		if (this.getRole() == UserRole.Administrative) {
			this.role = role;
		} else {
			
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
