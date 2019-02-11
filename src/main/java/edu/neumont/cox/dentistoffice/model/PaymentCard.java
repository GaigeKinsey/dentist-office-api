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
	 * Default constructor for PaymentCard
	 */
	public PaymentCard() {}
	
	/**
	 * Overloaded constructor for PaymentCard
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
	 * @return CardNumber
	 */
	public CardNumber getCardNumber() {
		return cardNumber;
	}

	/**
	 * sets the CardNumber
	 * @param cardNumber
	 */
	public void setCardNumber(CardNumber cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * @return String of ExpireDate
	 */
	public String getExpireDate() {
		return expireDate;
	}

	/**
	 * sets the ExpireDate
	 * @param expireDate
	 */
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	/**
	 * @return String of payment card name
	 */
	public String getName() {
		return name;
	}

	/**
	 * sets the payment card name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return int of the cvv
	 */
	public int getCvv() {
		return cvv;
	}

	/**
	 * sets the cvv
	 * @param cvv
	 */
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	/**
	 * @return int of the zip code
	 */
	public int getZipCode() {
		return zipCode;
	}

	/**
	 * sets the zip code
	 * @param zipCode
	 */
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
}
