package test;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import main.ContactService;


public class ContactServiceTest {

	@Test
	public void AddNewContactTest() {
		ContactService service = new ContactService();
		service.addContact();
		//Print unique ID to screen to help verify randomness
		System.out.println(service.uniqueId);
		
		assertNotNull(service.uniqueId);
	}
}
