package edu.neumont.cox.dentistoffice.model;

public class Patient extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private InsuranceInfo insurance;
	private PaymentCard paymentCard;

	public Patient(String firstName, String lastName, int uniqueId, String email, PhoneNumber phone,
			InsuranceInfo insurance, PaymentCard paymentCard) {
		super(firstName, lastName, uniqueId, email, phone);
		this.setInsurance(insurance);
		this.setPaymentCard(paymentCard);
	}

	public InsuranceInfo getInsurance() {
		return insurance;
	}

	public void setInsurance(InsuranceInfo insurance) {
		this.insurance = insurance;
	}

	public PaymentCard getPaymentCard() {
		return paymentCard;
	}

	public void setPaymentCard(PaymentCard paymentCard) {
		this.paymentCard = paymentCard;
	}

	@Override
	public String toString() {

		return super.toString() + ", Insurance Info: " + this.getInsurance().toString();
	}

}
