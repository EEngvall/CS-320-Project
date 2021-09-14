package main;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.platform.engine.UniqueId;

public class ContactService {


	//Comment to create change for git
	public String uniqueId;
	public int contactIdMaxLength = 10;
	List<Contact> contactList = new ArrayList<>();
	
	private String newUniqueId() {
		return uniqueId = UUID.randomUUID().toString().substring(
		               0, contactIdMaxLength);
	}
	
	
	public void addContact(String firstName, String lastName, String phoneNumber, String address) {
		Contact contact = new Contact(newUniqueId(), firstName, lastName, phoneNumber, address);
		contactList.add(contact);
	}
	public void removeContact(String contactId) throws Exception {
		contactList.remove(findContactById(contactId));
	}
	
	public Contact findContactById(String contactId) throws Exception {
		int index = 0;
		while (index < contactList.size()) {
			if (contactId.equals(contactList.get(index).getContactID())) {
				return contactList.get(index);
			}
			index++;
		}
		throw new Exception("Contact ID not found");
	}
	
	public void updateContactFirstName(String id, String newFirstName) throws Exception {
		findContactById(id).updateFirstName(newFirstName);
	}
	
	public void updateContactLastName(String id, String newLastName) throws Exception {
		findContactById(id).updateFirstName(newLastName);
	}
	public void updateContactPhoneNumber(String id, String newPhoneNumber) throws Exception {
		findContactById(id).updateFirstName(newPhoneNumber);
	}
	public void updateContactAddress(String id, String newAddress) throws Exception {
		findContactById(id).updateFirstName(newAddress);
	}
	
	
	
}
