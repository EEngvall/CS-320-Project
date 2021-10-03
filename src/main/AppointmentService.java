package main;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {

	private static AppointmentService reference = new AppointmentService();
	private final Map<String, Appointment> appointmentList;
	
	AppointmentService() {
		this.appointmentList = new HashMap<String, Appointment>();
	}
	
	public static AppointmentService getService() {
		return reference;
	}
	
	public boolean addAppointment(Appointment appointment) {
		boolean isSuccess = false;
		
		if(!appointmentList.containsKey(appointment.getAppointmentId())) {
			appointmentList.put(appointment.getAppointmentId(), appointment);
			isSuccess = true;
		}
		return isSuccess;
	}
	
	public boolean deleteAppointment(String appointmentId) {
		return appointmentList.remove(appointmentId) != null;
	}
	
	public Appointment getAppointment(String appointmentId) {
		return appointmentList.get(appointmentId);
	}
	
}
