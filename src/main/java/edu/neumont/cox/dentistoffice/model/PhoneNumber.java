package edu.neumont.cox.dentistoffice.model;

public class PhoneNumber extends Person{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int firstThree;
	private int secondThree;
	private int lastFour;
	
	/**
	 * @param firstThree
	 * @param secondThree
	 * @param lastFour
	 */
	public PhoneNumber(int firstThree, int secondThree, int lastFour) {
		this.setFirstThree(firstThree);
		this.setSecondThree(secondThree);
		this.setLastFour(lastFour);
	}

	/**
	 * @return
	 */
	public int getFirstThree() {
		return firstThree;
	}

	/**
	 * @param firstThree
	 */
	public void setFirstThree(int firstThree) {
		this.firstThree = firstThree;
	}

	/**
	 * @return
	 */
	public int getSecondThree() {
		return secondThree;
	}

	/**
	 * @param secondThree
	 */
	public void setSecondThree(int secondThree) {
		this.secondThree = secondThree;
	}

	/**
	 * @return
	 */
	public int getLastFour() {
		return lastFour;
	}

	/**
	 * @param lastFour
	 */
	public void setLastFour(int lastFour) {
		this.lastFour = lastFour;
	}
	
	@Override
	public String toString() {
		return "(" + firstThree + ") " + secondThree + "-" + lastFour;
	}
}
