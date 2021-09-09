import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ContactTest {

	@Test
	public void updateFirstNameTest() {
		Contact contact = new Contact();
		contact.updateFirstName("Erik");
		String output = contact.firstName;
		assertEquals("Erik", output);
	}
	
	@Test
	public void updateLastNameTest() {
		Contact contact = new Contact();
		contact.updateLastName("Engvall");
		String output = contact.lastName;
		assertEquals("Engvall", output);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void updateFirstNameLengthTest() {
		Contact contact = new Contact();
		contact.updateFirstName("Erikengvall");
		System.out.println(contact.firstName);

		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void updateLastNameLengthTest() {
		Contact contact = new Contact();
		contact.updateFirstName("Engvallerik");
		System.out.println(contact.lastName);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void updateFirstNameNullTest() {
		Contact contact = new Contact();
		contact.updateFirstName(null);
		System.out.println(contact.firstName);
		
	}
	
	@Test
	public void updatePhoneNumberLengthTest() {
		Contact contact = new Contact();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.updatePhoneNumber("01234567899");
		});
		System.out.println()
	}
		
}
