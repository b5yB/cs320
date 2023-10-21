package model;

import java.nio.file.AccessDeniedException;

public class Contact {

	private String contactId;
	private String firstName;
	private String lastName;
	private String number;
	private String address;
	
	public Contact(String contactId, String firstName, String lastName, String number, String address) {		
		
		if(validateId(contactId)) {
			this.contactId = contactId;
		}
		if(validateFirstName(firstName)) {
			this.firstName = firstName;
		}
		if(validatelastName(lastName)) {
			this.lastName = lastName;
		}
		if(validateNumber(number)) {
			this.number = number;
		}
		if(validateAddress(address)) {
			this.address = address;
		}
	}

	public boolean validateId (String contactId) {
		if(contactId == null || contactId.length()>10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		else {
			return true;
		}
	}
	
	public boolean validateFirstName (String firstName) {
		if (firstName == null || firstName.length()>10) {
			throw new IllegalArgumentException("Invalid First Name");
		}	
		else {
			return true;
		}
	}
	
	public boolean validatelastName (String lastName) {
		if (lastName == null || lastName.length()>10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		else {
			return true;
		}
	}
	
	public boolean validateNumber (String number) {
		if (number == null || number.length()!=10) {
			throw new IllegalArgumentException("Invalid Number");
		}
		else {
			return true;
		}
	}
	
	public boolean validateAddress (String address) {
		if (address == null || address.length()>30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		else {
			return true;
		}
	}
	
	public String setContactId(String contactId) throws AccessDeniedException {
		throw new AccessDeniedException("Field not updatable");
	}
	
	public String getContactId() {
		return contactId;
	}

	public String getFirstName() {
		return firstName;
	}

	public boolean setFirstName(String firstName) {
		if(validateFirstName(firstName)) {
			this.firstName = firstName;
		}
		return true;
	}

	public String getLastName() {
		return lastName;
	}

	public boolean setLastName(String lastName) {
		if(validatelastName(lastName)) {
			this.lastName = lastName;
		}
		return true;
	}

	public String getNumber() {
		return number;
	}

	public boolean setNumber(String number) {
		if(validateNumber(number)) {
			this.number = number;
		}
		return true;
	}

	public String getAddress() {
		return address;
	}

	public boolean setAddress(String address) {
		if(validateAddress(address)) {
			this.address = address;
		}
		return true;
	}
}
