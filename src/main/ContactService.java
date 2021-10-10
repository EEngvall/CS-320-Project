package main;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.platform.engine.UniqueId;

public class ContactService {

	private static ContactService reference = new ContactService();
	private final Map<String, Contact> contacts;
	
	 public ContactService() {
		 this.contacts = new HashMap<String, Contact>();
	 }
	 
		//Create a singleton Contact Service
	 public static ContactService getService() {
		 return reference;
	 }
	 
	 public boolean addContact(Contact contact) {
		 boolean isSuccess = false;
		 
		 if(!contacts.containsKey(contact.getContactID())) {
			 contacts.put(contact.getContactID(), contact);
			 isSuccess = true;
		 }
		 return isSuccess;
	 }
	 
	 public boolean deleteContact(String contactId) {
		 return contacts.remove(contactId) != null;
	 }
	 
	 public Contact getContact(String contactId) {
		 return contacts.get(contactId);
	 }
	
	
}
