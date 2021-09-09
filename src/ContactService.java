import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {


	//Comment to create change for git
	public static int uniqueId = 0;
	List<Contact> contactList = new ArrayList<>();
	
	public void addContact() {
		Contact contact = new Contact();
		String contactIDString = Integer.toString(uniqueId);
		uniqueId++;
	}
	
	
	
}
