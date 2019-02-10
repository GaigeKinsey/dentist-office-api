package edu.neumont.cox.dentistoffice.model;

import java.time.LocalDateTime;

public class Appointment extends Clinic{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private LocalDateTime dateTime;

	public Appointment(LocalDateTime dateTime) {
		this.setDateTime(dateTime);
	}
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
}
