package edu.neumont.cox.dentistoffice.model;

/**
 * @author Chris and Gaige
 *
 */
public class Procedure extends Appointment{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;
	private String description;
	private double cost;
	
	/**
	 * 
	 */
	public Procedure() {}
	
	public Procedure(String code, String description, double cost) {
		this.setCode(code);
		this.setDescription(description);
		this.setCost(cost);
	}

	/**
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 */
	public void setCode(String code) {
		this.code = "D" + code;
	}

	/**
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param cost
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
}
