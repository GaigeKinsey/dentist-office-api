package edu.neumont.cox.dentistoffice.model;

public class Procedure {
	private String code;
	private String description;
	private double cost;
	
	public Procedure(String code, String description, double cost) {
		this.setCode(code);
		this.setDescription(description);
		this.setCost(cost);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
}
