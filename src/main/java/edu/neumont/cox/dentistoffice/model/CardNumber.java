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
	
	/**
	 * Overloaded constructor for CardNumber
	 * @param numberOne
	 * @param numberTwo
	 * @param numberThree
	 * @param numberFour
	 */
	public CardNumber(int numberOne, int numberTwo, int numberThree, int numberFour) {
		this.setNumberOne(numberOne);
		this.setNumberTwo(numberTwo);
		this.setNumberThree(numberThree);
		this.setNumberFour(numberFour);
	}

	/**
	 * @return int representing the first 4 digits of the card
	 */
	public int getNumberOne() {
		return numberOne;
	}

	/**
	 * Sets the first 4 digits of the card
	 * @param numberOne
	 */
	public void setNumberOne(int numberOne) {
		this.numberOne = numberOne;
	}

	/**
	 * @return int representing the second 4 digits of the card
	 */
	public int getNumberTwo() {
		return numberTwo;
	}

	/**
	 * Sets the second 4 digits of the card
	 * @param numberTwo
	 */
	public void setNumberTwo(int numberTwo) {
		this.numberTwo = numberTwo;
	}

	/**
	 * @return int representing the third 4 digits of the card
	 */
	public int getNumberThree() {
		return numberThree;
	}

	/**
	 * Sets the third 4 digits of the card
	 * @param numberThree
	 */
	public void setNumberThree(int numberThree) {
		this.numberThree = numberThree;
	}

	/**
	 * @return int representing the last 4 digits of the card
	 */
	public int getNumberFour() {
		return numberFour;
	}

	/**
	 * Sets the last 4 digits of the card
	 * @param numberFour
	 */
	public void setNumberFour(int numberFour) {
		this.numberFour = numberFour;
	}
	
	@Override
	public String toString() {
		return numberOne + " " + numberTwo + " " + numberThree + " " + numberFour;
	}
}
