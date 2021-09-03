import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {


	//Comment to create change for git
	String uniqueId;
	List<Contact> contactList = new ArrayList<>();
	
	uniqueId = UUID.randomUUID().toString();
	System.out.println(uniqueId);
	
}
