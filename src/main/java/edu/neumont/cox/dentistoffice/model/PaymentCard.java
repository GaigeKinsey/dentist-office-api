package edu.neumont.cox.dentistoffice.model;

import java.time.LocalDate;

public class PaymentCard {
	private CardNumber cardNumber;
	private LocalDate expireDate;
	private String name;
	private int cvv;
	private int zipCode;
	
	public PaymentCard(CardNumber cardNumber, LocalDate expireDate, String name, int cvv, int zipcode) {
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

	public LocalDate getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(LocalDate expireDate) {
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
