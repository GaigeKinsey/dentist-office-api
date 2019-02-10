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
	 * @return
	 */
	public int getNumberOne() {
		return numberOne;
	}

	/**
	 * @param numberOne
	 */
	public void setNumberOne(int numberOne) {
		this.numberOne = numberOne;
	}

	/**
	 * @return
	 */
	public int getNumberTwo() {
		return numberTwo;
	}

	/**
	 * @param numberTwo
	 */
	public void setNumberTwo(int numberTwo) {
		this.numberTwo = numberTwo;
	}

	/**
	 * @return
	 */
	public int getNumberThree() {
		return numberThree;
	}

	/**
	 * @param numberThree
	 */
	public void setNumberThree(int numberThree) {
		this.numberThree = numberThree;
	}

	/**
	 * @return
	 */
	public int getNumberFour() {
		return numberFour;
	}

	/**
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
