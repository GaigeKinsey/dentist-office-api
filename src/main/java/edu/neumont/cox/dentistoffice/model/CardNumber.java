package edu.neumont.cox.dentistoffice.model;

public class CardNumber extends PaymentCard{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int numberOne;
	private int numberTwo;
	private int numberThree;
	private int numberFour;
	
	public CardNumber(int numberOne, int numberTwo, int numberThree, int numberFour) {
		this.setNumberOne(numberOne);
		this.setNumberTwo(numberTwo);
		this.setNumberThree(numberThree);
		this.setNumberFour(numberFour);
	}

	public int getNumberOne() {
		return numberOne;
	}

	public void setNumberOne(int numberOne) {
		this.numberOne = numberOne;
	}

	public int getNumberTwo() {
		return numberTwo;
	}

	public void setNumberTwo(int numberTwo) {
		this.numberTwo = numberTwo;
	}

	public int getNumberThree() {
		return numberThree;
	}

	public void setNumberThree(int numberThree) {
		this.numberThree = numberThree;
	}

	public int getNumberFour() {
		return numberFour;
	}

	public void setNumberFour(int numberFour) {
		this.numberFour = numberFour;
	}
	
	@Override
	public String toString() {
		return numberOne + " " + numberTwo + " " + numberThree + " " + numberFour;
	}
}
