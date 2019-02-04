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
	
	public boolean changePasswordForUser(User user) {
		boolean check = true;
		if (this.getRole() == UserRole.Administrative) {
			
		} else {
			check = false;
		}
		return check;
	}
	
	public boolean addUser(User user) {
		boolean check = true;
		if (this.getRole() == UserRole.Administrative) {
			
		} else {
			check = false;
		}
		return check;
	}
	
	public boolean removeUser(User user) {
		boolean check = true;
		if (this.getRole() == UserRole.Administrative) {
			
		} else {
			check = false;
		}
		return check;
	}
	
	public boolean changeRole(User user, UserRole role) {
		boolean check = true;
		if (this.getRole() == UserRole.Administrative) {
			
		} else {
			check = false;
		}
		return check;
	}
	
	public void changePassword(String password) {
		
	}
	
	public UserRole getRole() {
		return role;
	}
	
	public boolean setRole(UserRole role) {
		boolean check = true;
		if (this.getRole() == UserRole.Administrative) {
			this.role = role;
		} else {
			check = false;
		}
		return check;
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
