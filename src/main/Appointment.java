package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Appointment {

	private String appointmentDescription;
	private String appointmentId;
	private String appointmentDate;
	private int APPOINTMENT_MAX_LENGTH = 50;
	Date currentDate = new Date();
	
	public Appointment(String appointmentId, String appointmentDescription, String appointmentDate) throws ParseException {
		boolean isValid = validateInput(appointmentId, 10);
		
		if (isValid) {
			this.appointmentId = appointmentId;
		}
		isValid = isValid && setAppointmentDate(appointmentDate);
		isValid = isValid && setAppointmentDescription(appointmentDescription);
		
		if(!isValid) {
			throw new IllegalArgumentException("Invalid input");
		}
	}
	
	public boolean setAppointmentDescription(String appointmentDescription) {
		boolean isValid = validateInput(appointmentDescription, APPOINTMENT_MAX_LENGTH);
		
		if(isValid) {
			this.appointmentDescription = appointmentDescription;
		}
		return isValid;
	}
	
	public boolean setAppointmentDate(String appointmentDate) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = simpleDateFormat.parse(appointmentDate);
		
		boolean isValid = currentDate.before(date);
		if(isValid) {
			this.appointmentDate = appointmentDate;
		}
		
		return isValid;
	}
	
	public String getAppointmentDescription() {
		return this.appointmentDescription;
	}
	
	public String getAppointmentId() {
		return this.appointmentId;
	}
	public String getAppointmentDate() {
		return this.appointmentDate;
	}
	private boolean validateInput(String item, int length) {
		return (item != null && item.length() <= length);
	}
	
}
