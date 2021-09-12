package main;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.platform.engine.UniqueId;

public class ContactService {


	//Comment to create change for git
	public String uniqueId;
	List<Contact> contactList = new ArrayList<>();
	
	private String newUniqueId() {
		return uniqueId = UUID.randomUUID().toString().substring(
		               0, 10);
	}
	
	
	public void addContact() {
		Contact contact = new Contact(newUniqueId());
		contactList.add(contact);
	}
	
	
	
}
