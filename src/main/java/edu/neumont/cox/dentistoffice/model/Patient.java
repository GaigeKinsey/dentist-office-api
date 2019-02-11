package edu.neumont.cox.dentistoffice.model;

/**
 * @author Chris and Gaige
 *
 */
public class Patient extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private InsuranceInfo insurance;
	private PaymentCard paymentCard;

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
	 * @return
	 */
	public InsuranceInfo getInsurance() {
		return insurance;
	}

	/**
	 * @param insurance
	 */
	public void setInsurance(InsuranceInfo insurance) {
		this.insurance = insurance;
	}

	/**
	 * @return
	 */
	public PaymentCard getPaymentCard() {
		return paymentCard;
	}

	/**
	 * @param paymentCard
	 */
	public void setPaymentCard(PaymentCard paymentCard) {
		this.paymentCard = paymentCard;
	}

	@Override
	public String toString() {

		return super.toString() + ", " + this.getInsurance().toString();
	}

}
