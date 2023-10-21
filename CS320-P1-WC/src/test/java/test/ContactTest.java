package test;
import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.AccessDeniedException;

import org.junit.jupiter.api.Test;
import model.Contact;

public class ContactTest {

	@Test
	void constructorTest() {
		//initialize contact object
		Contact c = new Contact("1", "firstName", "lastName", "1234567890", "address");
		//all values were saved
		assertTrue(c.getContactId().equals("1"));
		assertTrue(c.getFirstName().equals("firstName"));
		assertTrue(c.getLastName().equals("lastName"));
		assertTrue(c.getNumber().equals("1234567890"));
		assertTrue(c.getAddress().equals("address"));	
	}
	
	@Test
	void settersTest() {
		Contact c = new Contact("1", "firstName", "lastName", "1234567890", "address");
		//does update contact object fields
		assertTrue(c.setFirstName("test"));
		assertTrue(c.setLastName("test"));
		assertTrue(c.setNumber("9876543210"));
		assertTrue(c.setAddress("test"));
	}
		
	@Test
	void idTest() {
		Contact c = new Contact("1", "firstName", "lastName", "1234567890", "address");
		//does not add contact with id greater than 10 characters
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678901", "firstName", "lastName", "1234567890", "address");
		});
		//does not add contact with null id
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "firstName", "lastName", "1234567890", "address");
		});
		//does not update contact id
		assertThrows(AccessDeniedException.class, () -> {
			c.setContactId("2");
		});
	}
		
	@Test
	void firstNameTest() {
		Contact c = new Contact("1", "firstName", "lastName", "1234567890", "address");
		//does not add contact with firstName greater than 10 characters
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "morethanten", "lastName", "1234567890", "address");
		});
		//does not add contact with null firstName
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", null, "lastName", "1234567890", "address");
		});
		//does not update contact to firstName greater than 10 characters
		assertThrows(IllegalArgumentException.class, () -> {
			c.setFirstName("morethanten");
		});
		//does not update contact to null firstName
		assertThrows(IllegalArgumentException.class, () -> {
			c.setFirstName(null);
		});
	}
		
	@Test
	void lastNameTest() {
		Contact c = new Contact("1", "firstName", "lastName", "1234567890", "address");
		//does not add contact with lastName greater than 10 characters
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "firstName", "morethanten", "1234567890", "address");
		});
		//does not add contact with null lastName
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "firstName", null, "1234567890", "address");
		});
		//does not update contact to lastName greater than 10 characters
		assertThrows(IllegalArgumentException.class, () -> {
			c.setLastName("morethanten");
		});
		//does not update contact to null lastName
		assertThrows(IllegalArgumentException.class, () -> {
			c.setLastName(null);
		});
	}
		
	@Test
	void numberTest() {
		Contact c = new Contact("1", "firstName", "lastName", "1234567890", "address");
		//does not add contact with number greater than 10 characters
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "firstName", "lastName", "12345678910", "address");
		});
		//does not add contact with number less than 10 characters
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "firstName", "lastName", "123456789", "address");
		});
		//does not add contact with null lastName
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "firstName", "lastName", null, "address");
		});
		//does not update contact to number greater than 10 characters
		assertThrows(IllegalArgumentException.class, () -> {
			c.setNumber("12345678910");
		});
		//does not update contact to number less than 10 characters
		assertThrows(IllegalArgumentException.class, () -> {
			c.setNumber("123456789");
		});
		//does not update contact to null lastName
		assertThrows(IllegalArgumentException.class, () -> {
			c.setNumber(null);
		});
	}
		
	@Test
	void addressTest() {
		Contact c = new Contact("1", "firstName", "lastName", "1234567890", "address");
		//does not add contact with address greater than 30 characters
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "firstName", "lastName", "1234567890", "addressaddressaddressaddressaddress");
		});
		//does not add contact with null address
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "firstName", "lastName", "1234567890", null);
		});
		//does not update contact to address greater than 30 characters
		assertThrows(IllegalArgumentException.class, () -> {
			c.setLastName("addressaddressaddressaddressaddress");
		});
		//does not update contact to null address
		assertThrows(IllegalArgumentException.class, () -> {
			c.setLastName(null);
		});
	}
	
	

}
