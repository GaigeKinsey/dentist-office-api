package edu.neumont.cox.dentistoffice.model;

/**
 * @author Chris and Gaige
 *
 */
public class Patient extends Person implements Comparable<Patient> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private InsuranceInfo insurance;
	private PaymentCard paymentCard;
	
	private Double balanceDue = 0d;
	private Double totalCharges = 0d;

	/**
	 * Overloaded constructor for Patient
	 * @param firstName
	 * @param lastName
	 * @param uniqueId
	 * @param email
	 * @param phone
	 * @param insurance
	 * @param paymentCard
	 */
	public Patient(String firstName, String lastName, int uniqueId, String email, PhoneNumber phone,
			InsuranceInfo insurance, PaymentCard paymentCard) {
		super(firstName, lastName, uniqueId, email, phone);
		this.setInsurance(insurance);
		this.setPaymentCard(paymentCard);
	}

	/**
	 * @return InsuranceInfo
	 */
	public InsuranceInfo getInsurance() {
		return insurance;
	}

	/**
	 * sets the InsuranceInfo
	 * @param insurance
	 */
	public void setInsurance(InsuranceInfo insurance) {
		this.insurance = insurance;
	}

	/**
	 * @return PaymentCard
	 */
	public PaymentCard getPaymentCard() {
		return paymentCard;
	}

	/**
	 * sets the PaymentCard
	 * @param paymentCard
	 */
	public void setPaymentCard(PaymentCard paymentCard) {
		this.paymentCard = paymentCard;
	}
	
	/**
	 * @return balanceDue
	 */
	public Double getBalanceDue() {
		return balanceDue;
	}

	/**
	 * sets the balanceDue
	 * @param balanceDue
	 */
	public void setBalanceDue(Double balanceDue) {
		this.balanceDue = balanceDue;
	}

	/**
	 * @return totalCharges
	 */
	public Double getTotalCharges() {
		return totalCharges;
	}

	/**
	 * sets the total charges
	 * @param totalCharges
	 */
	public void setTotalCharges(Double totalCharges) {
		this.totalCharges = totalCharges;
	}
	
	/**
	 * @return String of the last name, first name, and balanceDue for the patient
	 */
	public String getPatientWithBalance() {
		return "Balance due for " + this.getLastName() + ", " + this.getFirstName() + ": " + this.getBalanceDue();
	}

	@Override
	public String toString() {
		return super.toString() + ", " + this.getInsurance().toString();
	}

	@Override
	public int compareTo(Patient patient) {
		return this.getLastName().compareTo(patient.getLastName());
	}
}
