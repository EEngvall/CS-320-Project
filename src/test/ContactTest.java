package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Contact;

public class ContactTest {
	public String contactId;
	private String firstName;
	public String firstNameLong;
	public String lastName;
	public String lastNameLong;
	public String phoneNumber;
	public String phoneNumberLong;
	public String address;
	public String addressLong;
	
	
	
	@BeforeEach
	public void setUp() {
		contactId = "123456";
		firstName = "Erik";
		firstNameLong = "Erik0000000";
		lastName = "Engvall";
		lastNameLong = "Engvall00000";
		phoneNumber = "1234567890";
		phoneNumberLong = "+1234567890";
		address = "2501 Marlee Dr";
		addressLong = " 2501 Marlee Dr is too long for this test";
		System.out.println("Setting up...");
		
	}

	//Test for equality with given set up variables
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
	
	//Test for confirmation of null variables before any setup. 
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
	
	//Test for invalid length of First Name input
	@Test
	public void updateFirstNameLengthTest() {
		Contact contact = new Contact();
		assertThrows(IllegalArgumentException.class, () -> contact.updateFirstName(firstNameLong));
	}
	
	//Test for invalid length of Last name input. 
	@Test
	public void updateLastNameLengthTest() {
		Contact contact = new Contact();
		assertThrows(IllegalArgumentException.class, () -> contact.updateLastName(lastNameLong));
	}
	
	//Test for invalid length of phone number input
	@Test
	public void updatePhoneNumberLengthTest() {
		Contact contact = new Contact();
		assertThrows(IllegalArgumentException.class, () -> contact.updatePhoneNumber(phoneNumberLong));
	}
	
	//Test for invalid length of address input.
	@Test
	public void updateAddressLengthTest() {
		Contact contact = new Contact();
		assertThrows(IllegalArgumentException.class, () -> contact.updateAddress(addressLong));
		
	}
		
	
		
}
