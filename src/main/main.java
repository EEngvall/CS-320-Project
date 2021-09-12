package main;

public class main {

	public static void main(String[] args) {
		
		//Main method for visual reference of output and variable values.
		ContactService service = new ContactService();
		Contact contact = new Contact("123456789", "Erik", "Engvall", "2094177238", "2501 Marlee Dr");
		System.out.println("Contact ID: " + contact.getContactID());
		System.out.println("First Name: " + contact.getFirstName());
		System.out.println("Last Name: " + contact.getLastName());
		System.out.println("Phone Number: " + contact.getPhoneNumber());
		System.out.println("Address: " + contact.getAddress());
	}

}
