package edu.neumont.cox.dentistoffice.model;

import java.io.Serializable;

public class PhoneNumber implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int firstThree;
	private int secondThree;
	private int lastFour;
	
	/**
	 * Overloaded constructor for PhoneNumber
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
	 * @return int of first three digits
	 */
	public int getFirstThree() {
		return firstThree;
	}

	/**
	 * sets the first three digits
	 * @param firstThree
	 */
	public void setFirstThree(int firstThree) {
		this.firstThree = firstThree;
	}

	/**
	 * @return int of second three digits
	 */
	public int getSecondThree() {
		return secondThree;
	}

	/**
	 * sets the second three digits
	 * @param secondThree
	 */
	public void setSecondThree(int secondThree) {
		this.secondThree = secondThree;
	}

	/**
	 * @return int of last four digits
	 */
	public int getLastFour() {
		return lastFour;
	}

	/**
	 * sets the last four digits
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
