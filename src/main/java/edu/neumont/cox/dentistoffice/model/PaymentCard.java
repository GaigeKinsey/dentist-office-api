package edu.neumont.cox.dentistoffice.model;

import java.time.LocalDate;

public class PaymentCard {
	
	private long number;
	private LocalDate expireDate;
	private String name;
	private int cvv;
	private int zipCode;
	
	public PaymentCard(long number, LocalDate expireDate, String name, int cvv, int zipcode) {
		this.setNumber(number);
		this.setExpireDate(expireDate);
		this.setName(name);
		this.setCvv(cvv);
		this.setZipCode(zipcode);
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
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
