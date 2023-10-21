package service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import model.Contact;

public class ContactService {

	private Map<String, Contact> contacts = new HashMap<String, Contact>();

	public Map<String, Contact> addContact (Contact contact){
		contacts.putIfAbsent(contact.getContactId(), contact);
		Map<String, Contact> contactsCopy = Collections.unmodifiableMap(contacts);
		return contactsCopy;
	}
	
	public Map<String, Contact> deleteContact (String key){
		contacts.remove(key);
		Map<String, Contact> contactsCopy = Collections.unmodifiableMap(contacts);
		return contactsCopy;
	}
	
	public Map<String, Contact> updateContact (Contact contact){
		contacts.replace(contact.getContactId(), contact);
		Map<String, Contact> contactsCopy = Collections.unmodifiableMap(contacts);
		return contactsCopy;
	}
}
