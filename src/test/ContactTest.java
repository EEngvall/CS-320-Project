package test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import main.Contact;

public class ContactTest {
	private String contactId;
	private String firstName;
	private String firstNameLong;
	private String lastName;
	private String lastNameLong;
	private String phoneNumber;
	private String phoneNumberLong;
	private String address;
	private String addressLong;
	
	
	
	@BeforeEach
	void setUp() {
		contactId = "123456";
		firstName = "Erik";
		firstNameLong = "Erik0000000";
		lastName = "Engvall";
		lastNameLong = "Engvall0000";
		phoneNumber = "123456789";
		phoneNumberLong = "+1234567890";
		address = "2501 Marlee Dr";
		addressLong = " 2501 Marlee Dr is too long for this test";
		
		
	}

	@Test
	public void updateTest() {
		Contact contact = new Contact(contactId, firstName, lastName, phoneNumber, address);
		assertAll("Contact Update",
				() -> assertEquals(contactId, contact.getContactID()),
				() -> assertEquals(firstName, contact.getFirstName()),
				() -> assertEquals(lastName, contact.getLastName()),
				() -> assertEquals(phoneNumber, contact.getPhoneNumber()),
				() -> assertEquals(address, contact.getAddress()));
	}
	@Test
	public void updateNullTest() {
		Contact contact = new Contact();
		assertAll("Contact Null Update",
				() -> assertNull(contact.getContactID()),
				() -> assertNull(contact.getFirstName()),
				() -> assertNull(contact.getLastName()),
				() -> assertNull(contact.getPhoneNumber()),
				() -> assertNull(contact.getAddress()));
	}
	@Test
	public void updateLengthTest() {
		Contact contact = new Contact();
		assertAll("Contact Update Length",
				() -> assertThrows(IllegalArgumentException.class, () -> contact.updateFirstName(firstNameLong)),
				() -> assertThrows(IllegalArgumentException.class, () -> contact.updateLastName(lastNameLong)),
				() -> assertThrows(IllegalArgumentException.class, () -> contact.updatePhoneNumber(phoneNumberLong)),
				() -> assertThrows(IllegalArgumentException.class, () -> contact.updateAddress(addressLong))
				);
	}
		
}
