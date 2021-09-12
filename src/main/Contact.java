package main;

public class Contact {

	//Comments
	private String contactId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	private int CONTACT_ID_LENGTH = 10;
	private int CONTACT_FIRST_NAME_LENGTH = 10;
	private int CONTACT_LAST_NAME_LENGTH = 10;
	private int CONTACT_PHONE_LENGTH = 10;
	private int CONTACT_ADDRESS_LENGTH =30;
	

	public Contact() {}
	public Contact(String contactId) {
		this.contactId = contactId;
		this.firstName = null;
		this.lastName = null;
		this.phoneNumber = null;
		this.address = null;
	}
	public Contact(String contactId, String firstName) {
		this.contactId = contactId;
		updateFirstName(firstName);
		this.lastName = null;
		this.phoneNumber = null;
		this.address = null;
	}
	public Contact(String contactId, String firstName, String lastName) {
		this.contactId = contactId;
		updateFirstName(firstName);
		updateLastName(lastName);
		this.phoneNumber = null;
		this.address = null;
	}
	public Contact(String contactId, String firstName, String lastName, String phoneNumber) {
		this.contactId = contactId;
		updateFirstName(firstName);
		updateLastName(lastName);
		updatePhoneNumber(phoneNumber);
		this.address = null;
	}
	public Contact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
		this.contactId = contactId;
		updateFirstName(firstName);
		updateLastName(lastName);
		updatePhoneNumber(phoneNumber);
		updateAddress(address);
	}
		
	
	public void createContactId(String contactId) {
		if(contactId == null || contactId.length() > CONTACT_ID_LENGTH) {
			throw new IllegalArgumentException("Contact ID can not be empty or greater than " + CONTACT_ID_LENGTH + " characters.");
		}
			this.contactId = contactId;
	}
	
	
	public String getContactID() {
		return contactId;
	}
	public void updateFirstName(String firstName) {
		if (firstName == null || firstName.length() > CONTACT_FIRST_NAME_LENGTH) {
			throw new IllegalArgumentException("Contact first name can not be empty or greater than " + CONTACT_FIRST_NAME_LENGTH + " characters.");
		} 
			this.firstName = firstName;
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void updateLastName(String lastName) {
		if (lastName == null || lastName.length() > CONTACT_LAST_NAME_LENGTH) {
			throw new IllegalArgumentException("Contact last name can not be empty or greater than " + CONTACT_LAST_NAME_LENGTH + " characters.");
		} 
			this.lastName = lastName;
		
	}
	public String getLastName() {
		return lastName;
	}
	public void updatePhoneNumber(String phoneNumber) {
		if (phoneNumber == null || phoneNumber.length() > CONTACT_PHONE_LENGTH) {
			throw new IllegalArgumentException("Contact phone number can not be empty or greater than " + CONTACT_PHONE_LENGTH + " characters.");		} 
			this.phoneNumber = phoneNumber;
		
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void updateAddress(String address) {
		if (address == null || address.length() > CONTACT_ADDRESS_LENGTH) {
			throw new IllegalArgumentException("Contact address can not be empty or greater than " + CONTACT_ADDRESS_LENGTH + " characters.");		} 
			this.address = address;
		
	}
	public String getAddress() {
		return address;
	}
	
}
