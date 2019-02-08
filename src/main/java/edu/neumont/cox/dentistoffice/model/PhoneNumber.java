package edu.neumont.cox.dentistoffice.model;

public class PhoneNumber extends Person{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int firstThree;
	private int secondThree;
	private int lastFour;
	
	public PhoneNumber(int firstThree, int secondThree, int lastFour) {
		this.setFirstThree(firstThree);
		this.setSecondThree(secondThree);
		this.setLastFour(lastFour);
	}

	public int getFirstThree() {
		return firstThree;
	}

	public void setFirstThree(int firstThree) {
		this.firstThree = firstThree;
	}

	public int getSecondThree() {
		return secondThree;
	}

	public void setSecondThree(int secondThree) {
		this.secondThree = secondThree;
	}

	public int getLastFour() {
		return lastFour;
	}

	public void setLastFour(int lastFour) {
		this.lastFour = lastFour;
	}
	
	@Override
	public String toString() {
		return "(" + firstThree + ") " + secondThree + "-" + lastFour;
	}
}
