
public class Contact {

	//Comments
	String contactId;
	String firstName;
	String lastName;
	String phoneNumber;
	String address;
	private int CONTACT_ID_LENGTH = 10;
	private int CONTACT_FIRST_NAME_LENGTH = 10;
	private int CONTACT_LAST_NAME_LENGTH = 10;
	private int CONTACT_PHONE_LENGTH = 10;
	private int CONTACT_ADDRESS_LENGTH =30;
	

	
	protected void updateContactId(String contactId) {
		if(contactId == null) {
			throw new IllegalArgumentException("Contact ID can not be empty.");
		} else if (contactId.length() > CONTACT_ID_LENGTH) {
			throw new IllegalArgumentException("Contact ID can not be longer than " + CONTACT_ID_LENGTH + " characters.");
		} else {
			this.contactId = contactId;
		}
	}
	protected void updateFirstName(String firstName) {
		if (firstName == null) {
			throw new IllegalArgumentException("First name can not be empty");
		} else if (firstName.length() > CONTACT_FIRST_NAME_LENGTH) {
			throw new IllegalArgumentException("First name can not be longer than " + CONTACT_FIRST_NAME_LENGTH + "characters.");
		} else {
			this.firstName = firstName;
		}
	}

	protected void updateLastName(String lastName) {
		if (lastName == null) {
			throw new IllegalArgumentException("Last name can not be null");
		} else if (lastName.length() > CONTACT_LAST_NAME_LENGTH) {
			throw new IllegalArgumentException("Last name can not be more than " + CONTACT_LAST_NAME_LENGTH + " characters.");
		} else {
			this.lastName = lastName;
		}
	}

	protected void updatePhoneNumber(String phoneNumber) {
		if (phoneNumber == null) {
			throw new IllegalArgumentException("Phone number can not be empty");
		} else if (phoneNumber.length() > CONTACT_PHONE_LENGTH) {
			throw new IllegalArgumentException("Phone number can not be more than " + CONTACT_PHONE_LENGTH + " digits.");
		} else {
			this.phoneNumber = phoneNumber;
		}
	}

	protected void updateAddress(String address) {
		if (address == null) {
			throw new IllegalArgumentException("Address can not be empty");
		} else if (address.length() > CONTACT_ADDRESS_LENGTH) {
			throw new IllegalArgumentException("Address can not be more than " + CONTACT_ADDRESS_LENGTH + " characters.");
		} else {
			this.address = address;
		}
	}
}
