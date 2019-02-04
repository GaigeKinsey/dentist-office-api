package edu.neumont.cox.dentistoffice.model;

import java.time.LocalDateTime;

public class Appointment {
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
