package test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.Appointment;

class AppointmentTest {

	@Test
	void testCreateAppointment() throws ParseException {
		Appointment appointment = new Appointment("123456", "2022-10-01", "Appointment Description String");
		
		assertTrue(appointment != null);
		assertTrue(appointment.getAppointmentId().equals("123456"));
		assertTrue(appointment.getAppointmentDate().equals("2022-10-01"));
		assertTrue(appointment.getAppointmentDescription().equals("Appointment Description String"));
	}

	@Test
	void testCreateAppointmentIdFails() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345678901", "2022-10-01", "Appointment Description String");
		});
	}
	
	@Test
	void testCreateAppointmentDescriptionFails() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("123456789", "2022-10-01", "This description is too long to be used as an appointment description and thus will fail during creation");
		});
	}
	
	@Test
	void testUpdateAppointmentSuccess() throws ParseException {
		Appointment appointment = new Appointment("123456", "2022-10-01", "Appointment Description String");
		
		appointment.setAppointmentDate("2022-10-02");
		appointment.setAppointmentDescription("New Appointment Description String");
		
		assertTrue(appointment.getAppointmentDate().equals("2022-10-02"));
		assertTrue(appointment.getAppointmentDescription().equals("New Appointment Description String"));
	}
	
	@Test
	void testUpdateAppointmentDateFails() throws ParseException {
		Appointment appointment = new Appointment("123456", "2022-10-01", "Appointment Description String");
		assertFalse(appointment.setAppointmentDate("2021-10-01"));
	}
	
	@Test
	void testUpdateAppointmentDescriptionFails() throws ParseException {
		Appointment appointment = new Appointment("123456", "2022-10-01", "Appointment Description String");
		assertFalse(appointment.setAppointmentDescription("This description is too long to be used as an appointment description and thus will fail during creation"));
	}
}
