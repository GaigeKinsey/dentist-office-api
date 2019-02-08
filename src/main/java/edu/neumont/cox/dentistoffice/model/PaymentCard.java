package edu.neumont.cox.dentistoffice.model;

public class PaymentCard extends Person{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CardNumber cardNumber;
	private String expireDate;
	private String name;
	private int cvv;
	private int zipCode;
	
	public PaymentCard() {}
	
	public PaymentCard(CardNumber cardNumber, String expireDate, String name, int cvv, int zipcode) {
		this.setCardNumber(cardNumber);
		this.setExpireDate(expireDate);
		this.setName(name);
		this.setCvv(cvv);
		this.setZipCode(zipcode);
	}
	
	public CardNumber getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(CardNumber cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
}
