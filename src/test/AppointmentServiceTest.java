package test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Appointment;
import main.AppointmentService;

class AppointmentServiceTest {

	private static AppointmentService appointmentService;
	
	@BeforeAll
	static void setUp() {
		appointmentService = AppointmentService.getService();
	}
	
	@Test
	void testAddAppointmentSuccess() throws ParseException {
		Appointment appointment = new Appointment("123456", "2022-10-01", "Appointment Description String");
		assertTrue(appointmentService.addAppointment(appointment));
		
		Appointment cachedAppointment = appointmentService.getAppointment(appointment.getAppointmentId());
		
		assertTrue(cachedAppointment != null);
		assertTrue(cachedAppointment.getAppointmentId().equals("123456"));
		assertTrue(cachedAppointment.getAppointmentDate().equals("2022-10-01"));
		assertTrue(cachedAppointment.getAppointmentDescription().equals("Appointment Description String"));	
	}
	
	@Test
	void testAddMultipleAppointmentsSuccess() throws ParseException {
		Appointment appointment1 = new Appointment("123456", "2022-10-01", "Appointment Description String");
		Appointment appointment2 = new Appointment("1234567", "2022-10-02", "Appointment Description String2");
		
		assertTrue(appointmentService.addAppointment(appointment1));
		Appointment cachedAppointment1 = appointmentService.getAppointment(appointment1.getAppointmentId());
		
		assertTrue(cachedAppointment1 != null);
		assertTrue(cachedAppointment1.getAppointmentId().equals("123456"));
		assertTrue(cachedAppointment1.getAppointmentDate().equals("2022-10-01"));
		assertTrue(cachedAppointment1.getAppointmentDescription().equals("Appointment Description String"));	
		
		assertTrue(appointmentService.addAppointment(appointment2));
		Appointment cachedAppointment2 = appointmentService.getAppointment(appointment1.getAppointmentId());
		
		assertTrue(cachedAppointment2 != null);
		assertTrue(cachedAppointment2.getAppointmentId().equals("1234567"));
		assertTrue(cachedAppointment2.getAppointmentDate().equals("2022-10-02"));
		assertTrue(cachedAppointment2.getAppointmentDescription().equals("Appointment Description String2"));
		
	}
	
	@Test
	void testAddAppoitnmentDuplicateIdFail() throws ParseException {
		Appointment appointment1 = new Appointment("123456", "2022-10-01", "Appointment Description String");
		Appointment appointment2 = new Appointment("123456", "2022-10-01", "Appointment Description String");


		assertTrue(appointmentService.addAppointment(appointment1));
		assertFalse(appointmentService.addAppointment(appointment2));
	}
	
	@Test
	void testGetAppointmentAndUpdateSuccess() throws ParseException {
		Appointment appointment = new Appointment("123456", "2022-10-01", "Appointment Description String");
		assertTrue(appointmentService.addAppointment(appointment));
		
		Appointment updatedAppointment = appointmentService.getAppointment(appointment.getAppointmentId());
		updatedAppointment.setAppointmentDate("2022-10-02");
		updatedAppointment.setAppointmentDescription("New Description");
		
		updatedAppointment = appointmentService.getAppointment(updatedAppointment.getAppointmentId());
		
		assertTrue(updatedAppointment.getAppointmentDescription().equals("New Description"));
		assertTrue(updatedAppointment.getAppointmentDate().equals("2022-10-02"));
	}
	
	@Test
	void testGetAppointmentAndDeleteSuccess() throws ParseException {
		Appointment appointment = new Appointment("123456", "2022-10-01", "Appointment Description String");
		
		assertTrue(appointmentService.addAppointment(appointment));
		
		appointment = appointmentService.getAppointment(appointment.getAppointmentId());
		assertTrue(appointment != null);
		
		assertTrue(appointmentService.deleteAppointment(appointment.getAppointmentId()));
		assertTrue(appointmentService.getAppointment(appointment.getAppointmentId()) == null);
	}
	
	@Test
	void testDeleteInvalidAppointmentFail() {
		String invalidAppointmentIdString = "123";
		
		assertFalse(appointmentService.deleteAppointment(invalidAppointmentIdString));
	}
	
	
}
