package test;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import main.Contact;
import main.ContactService;




public class ContactServiceTest {
		
		private ContactService contactService;
		
		@BeforeEach
		void setup() {
			contactService = new ContactService();
		}
		
		@Test
		void testAddContactSuccess() {
			Contact contact = new Contact("123456", "Erik", "Amber", "2094177238", "2501 Marlee Dr");	
			assertTrue(contactService.addContact(contact));
			
			Contact getContact = contactService.getContact("123456");
			
			assertTrue(getContact.getContactID().contentEquals(contact.getContactID()));
			assertTrue(getContact.getFirstName().contentEquals(contact.getFirstName()));
			assertTrue(getContact.getLastName().contentEquals(contact.getLastName()));
			assertTrue(getContact.getAddress().contentEquals(contact.getAddress()));
			assertTrue(getContact.getPhoneNumber().contentEquals(contact.getPhoneNumber()));
		}
		
		@Test
		void testAddMultipleContactsSuccess() {
			Contact contact1 = new Contact("123458", "Erik", "Amber", "2094177238", "2501 Marlee Dr");
			Contact contact2 = new Contact("123459", "Amber", "Erik", "2094177238", "2501 Marlee Dr");
			
			assertTrue(contactService.addContact(contact1));
			assertTrue(contactService.addContact(contact2));

		}
		
		@Test
		void testAddContactDuplicateIdFail() {
			Contact contact1 = new Contact("123457", "Erik", "Amber", "2094177238", "2501 Marlee Dr");
			Contact contact2 = new Contact("123457", "Amber", "Erik", "2094177238", "2501 Marlee Dr");
			
			assertTrue(contactService.addContact(contact1));
			assertFalse(contactService.addContact(contact2));

		}
		
		@Test
		void testGetContactAndUpdateSuccess() {
			Contact contact1 = new Contact("1234", "Erik", "Amber", "2094177238", "2501 Marlee Dr");

			assertTrue(contactService.addContact(contact1));
			Contact updateContact = contactService.getContact(contact1.getContactID());
			
			updateContact.updatePhoneNumber("9421231234");
			updateContact = contactService.getContact(updateContact.getContactID());
			assertTrue(updateContact.getPhoneNumber().equals("9421231234"));
			
		}
		
		@Test
		void testGetContactAndDeleteSuccess() {
			Contact contact1 = new Contact("12", "Erik", "Amber", "2094177238", "2501 Marlee Dr");

			assertTrue(contactService.addContact(contact1));
			
			Contact contact2 = contactService.getContact(contact1.getContactID());
			assertTrue(contactService.deleteContact(contact2.getContactID()));

			assertTrue(contactService.getContact(contact2.getContactID()) == null);
			
		}
		
		@Test
		void testDeleteInvalidContactFail() {
			String invalidContactId = "1";

			assertFalse(contactService.deleteContact(invalidContactId));
		}
}
