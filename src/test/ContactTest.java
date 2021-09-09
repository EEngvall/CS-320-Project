package test;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import Contact;

public class ContactTest {

	@Test
	public void updateFirstNameTest() {
		Contact contact = new Contact();
		contact.updateFirstName("Erik");
		String output = contact.getFirstName();
		assertEquals("Erik", output);
	}
	
	@Test
	public void updateLastNameTest() {
		Contact contact = new Contact();
		contact.updateLastName("Engvall");
		String output = contact.getLastName();
		assertEquals("Engvall", output);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void updateFirstNameLengthTest() {
		Contact contact = new Contact();
		contact.updateFirstName("Erikengvall");
		System.out.println(contact.getFirstName());

		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void updateLastNameLengthTest() {
		Contact contact = new Contact();
		contact.updateFirstName("Engvallerik");
		System.out.println(contact.getLastName());
		
	}
	
	@Test
	public void updateFirstNameNullTest() {
		Contact contact = new Contact();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.updateFirstName(null);
		});
	}
	
	@Test
	public void updatePhoneNumberLengthTest() {
		Contact contact = new Contact();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.updatePhoneNumber("01234567899");
		});
	}
		
}
