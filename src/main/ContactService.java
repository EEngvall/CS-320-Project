package main;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.platform.engine.UniqueId;

public class ContactService {


	
	public String uniqueId;
	public int contactIdMaxLength = 10;
	List<Contact> contactList = new ArrayList<>();
	
	//Method to create new unique ID
	private String newUniqueId() {
		return uniqueId = UUID.randomUUID().toString().substring(
		               0, contactIdMaxLength);
	}
	
	//Method to add new contact
	public void addContact(String firstName, String lastName, String phoneNumber, String address) {
		Contact contact = new Contact(newUniqueId(), firstName, lastName, phoneNumber, address);
		contactList.add(contact);
	}
	
	//Method to remove contact by contact ID
	public void removeContact(String contactId) throws Exception {
		contactList.remove(findContactById(contactId));
	}
	
	//Method to find contact by contact ID.
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
	
	//Method to update the first name of the contact by contact ID.
	public void updateContactFirstName(String id, String newFirstName) throws Exception {
		findContactById(id).updateFirstName(newFirstName);
	}
	
	//Method to update the last name of the contact by contact ID.
	public void updateContactLastName(String id, String newLastName) throws Exception {
		findContactById(id).updateFirstName(newLastName);
	}
	
	//Method to update the phone number of the contact by contact ID.
	public void updateContactPhoneNumber(String id, String newPhoneNumber) throws Exception {
		findContactById(id).updateFirstName(newPhoneNumber);
	}
	
	//Method to update the address of the contact by contact ID.
	public void updateContactAddress(String id, String newAddress) throws Exception {
		findContactById(id).updateFirstName(newAddress);
	}
	
	
	
}
