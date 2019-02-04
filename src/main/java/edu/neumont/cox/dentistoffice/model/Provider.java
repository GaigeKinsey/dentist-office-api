package edu.neumont.cox.dentistoffice.model;

public class Provider extends Person{

	private ProviderType title;
	
	public Provider(String firstName, String lastName, int uniqueId, String email, PhoneNumber phone, ProviderType title) {
		super(firstName, lastName, uniqueId, email, phone);
		this.setTitle(title);
	}

	public ProviderType getTitle() {
		return title;
	}

	public void setTitle(ProviderType title) {
		this.title = title;
	}
	
}
