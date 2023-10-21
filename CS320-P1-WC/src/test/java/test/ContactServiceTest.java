package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.Contact;
import service.ContactService;

public class ContactServiceTest {
	
	//initializes class level ContaccService Object
	ContactService cServ = new ContactService();

	@Test
	void addContactTest() {
		Contact contact = new Contact("1", "firstName", "lastName", "1234567890", "address");
		Contact contact2 = new Contact("1", "firstName", "lastName", "1234567890", "address");
		//adds contact by unique id
		assertTrue(cServ.addContact(contact).get("1").equals(contact));
		//does not add contact by non-unique id
		assertEquals(contact, cServ.addContact(contact2).get("1"));
	}
	
	@Test
	void deleteContactTest() {
		Contact contact = new Contact("1", "firstName", "lastName", "1234567890", "address");
		cServ.addContact(contact);
		//deletes contact by id
		assertEquals(null, cServ.deleteContact("1").get("1"));
	}
	
	@Test
	void updateContactTest() {
		Contact contact = new Contact("1", "firstName", "lastName", "1234567890", "address");
		Contact contact2 = new Contact("1", "firstName2", "lastName2", "1234567890", "address2");
		cServ.addContact(contact);
		//updates contact by id
		assertEquals(contact2, cServ.updateContact(contact2).get("1"));	
	}
	
	@Test
	void unmodifiableTest() {
		Contact contact = new Contact("1", "firstName", "lastName", "1234567890", "address");
		//initialize exception objects from service methods
		Exception addException = assertThrows(UnsupportedOperationException.class, () -> {
			cServ.addContact(contact).clear();
		});
		Exception deleteException = assertThrows(UnsupportedOperationException.class, () -> {
			cServ.deleteContact("1").clear();
		});
		Exception updateException = assertThrows(UnsupportedOperationException.class, () -> {
			cServ.updateContact(contact).clear();
		});
		//throws UnsupportedOperationException when trying to modify returned unmodifiableMap 
		assertTrue(addException.toString().contains("UnsupportedOperationException"));
		assertTrue(deleteException.toString().contains("UnsupportedOperationException"));
		assertTrue(updateException.toString().contains("UnsupportedOperationException"));
	}
}
