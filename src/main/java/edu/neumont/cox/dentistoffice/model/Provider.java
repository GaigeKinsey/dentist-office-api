package edu.neumont.cox.dentistoffice.model;

/**
 * @author Chris & Gaige
 *
 */
public class Provider extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ProviderType title;

	/**
	 * Overloaded constructor for Provider
	 * @param firstName
	 * @param lastName
	 * @param uniqueId
	 * @param email
	 * @param phone
	 * @param title
	 */
	public Provider(String firstName, String lastName, int uniqueId, String email, PhoneNumber phone,
			ProviderType title) {
		super(firstName, lastName, uniqueId, email, phone);
		this.setTitle(title);
	}

	/**
	 * @return
	 */
	public ProviderType getTitle() {
		return title;
	}

	/**
	 * @param title
	 */
	public void setTitle(ProviderType title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return super.toString() + ", Title: " + this.getTitle().toString();
	}

}
