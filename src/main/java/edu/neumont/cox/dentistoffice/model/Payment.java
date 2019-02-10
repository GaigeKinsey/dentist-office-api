package edu.neumont.cox.dentistoffice.model;

/**
 * @author Chris and Gaige
 *
 */
public class Payment {
	private double amount;
	private Patient patient;
	private Sources source;

	/**
	 * @param amount
	 * @param patient
	 * @param source
	 */
	public Payment(double amount, Patient patient, Sources source) {
		this.setAmount(amount);
		this.setPatient(patient);
		this.setSource(source);
	}

	/**
	 * @return
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * @param patient
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/**
	 * @return
	 */
	public Sources getSource() {
		return source;
	}

	/**
	 * @param source
	 */
	public void setSource(Sources source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "Source: " + this.getSource().toString() + ", Amount: " + this.getAmount() + ", Patient: "
				+ this.getPatient().getFirstName() + " " + this.getPatient().getLastName();
	}

}
