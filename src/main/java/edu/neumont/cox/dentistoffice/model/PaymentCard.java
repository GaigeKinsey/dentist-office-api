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
	
	/**
	 * 
	 */
	public PaymentCard() {}
	
	/**
	 * @param cardNumber
	 * @param expireDate
	 * @param name
	 * @param cvv
	 * @param zipcode
	 */
	public PaymentCard(CardNumber cardNumber, String expireDate, String name, int cvv, int zipcode) {
		this.setCardNumber(cardNumber);
		this.setExpireDate(expireDate);
		this.setName(name);
		this.setCvv(cvv);
		this.setZipCode(zipcode);
	}
	
	/**
	 * @return
	 */
	public CardNumber getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber
	 */
	public void setCardNumber(CardNumber cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * @return
	 */
	public String getExpireDate() {
		return expireDate;
	}

	/**
	 * @param expireDate
	 */
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return
	 */
	public int getCvv() {
		return cvv;
	}

	/**
	 * @param cvv
	 */
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	/**
	 * @return
	 */
	public int getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode
	 */
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
}
