package edu.neumont.cox.dentistoffice.model;

public class Payment {
	private double amount;
	private Patient patient;
	private Sources source;

	public Payment(double amount, Patient patient, Sources source) {
		this.setAmount(amount);
		this.setPatient(patient);
		this.setSource(source);
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Sources getSource() {
		return source;
	}

	public void setSource(Sources source) {
		this.source = source;
	}
	
	
}
