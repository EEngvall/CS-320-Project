package main;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contact contact = new Contact();
		String name = "ErikEngv";
		contact.updateFirstName(name);
		System.out.println(contact.getFirstName());
		System.out.println(contact.getFirstName().length());
	}

}
