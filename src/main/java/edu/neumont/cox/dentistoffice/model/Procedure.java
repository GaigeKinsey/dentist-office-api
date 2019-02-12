package edu.neumont.cox.dentistoffice.model;

import java.io.Serializable;

/**
 * @author Chris and Gaige
 *
 */
public class Procedure implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;
	private String description;
	private double cost;

	/**
	 * Overloaded constructor for Procedure
	 * @param code
	 * @param description
	 * @param cost
	 */
	public Procedure(String code, String description, double cost) {
		this.setCode(code);
		this.setDescription(description);
		this.setCost(cost);
	}

	/**
	 * @return String code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * sets the code
	 * @param code
	 */
	public void setCode(String code) {
		this.code = "D" + code;
	}

	/**
	 * @return String description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * sets the description
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return double cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * sets the cost
	 * @param cost
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Procedure Code: " + this.getCode() + ", Description: " + this.getDescription() + ", Cost: "
				+ this.getCost();
	}
}
