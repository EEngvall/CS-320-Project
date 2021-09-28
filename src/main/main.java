package main;

import java.text.ParseException;

public class main {

	public static void main(String[] args) throws ParseException {
		
		/**Main method for visual reference of output and variable values.
		ContactService service = new ContactService();
		service.addContact("Erik", "Engvall", "2094177238", "2501 Marlee Dr");
		String newContactIdString = service.contactList.get(0).getContactID();
		System.out.println(service.contactList.get(0).getContactID());
		System.out.println(service.contactList.get(0).getFirstName());
		System.out.println(service.contactList.get(0).getLastName());
		System.out.println(service.contactList.get(0).getPhoneNumber());
		System.out.println(service.contactList.get(0).getAddress());
		try {
			System.out.println(service.findContactById(newContactIdString).getFirstName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			service.updateContactFirstName(newContactIdString, "Amber");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			System.out.println(service.findContactById(newContactIdString).getFirstName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
**/
		
		Appointment newAppointment = new Appointment("12345","Appointment Description", "2020-10-01");
		
		System.out.println(newAppointment.getAppointmentDate());
	}

}
