package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	
	// New array for contact
		public static List<Contact> contactList = new ArrayList<>();
		
		public static void main(String[] args) {

			// New contact service
			ContactService contactServ = new ContactService();
			
			
		}

	// Test a long ID
	@Test
	public void testContactIDLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("123456789011111", "Tim", "Brady", "4435550123", "123 JumpMoveDance Road");
			addContact(contact);
		});
	}
		
	// Test a long first name
	@Test
	public void testContactFNameLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("1234567890", "Timmmmmmmmmmmmmmmm", "Brady", "4435550123", "123 JumpMoveDance Road");
			addContact(contact);
		});
	}
		
	// Test a long last name
	@Test
	public void testContactLNameLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("1234567890", "Tim", "Bradyyyyyyyyyyyy", "4435550123", "123 JumpMoveDance Road");
			addContact(contact);
		});
	}
		
	// Test a long phone number
	@Test
	public void testPhoneNumberLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("1234567890", "Tim", "Brady", "443555012300000000", "123 JumpMoveDance Road");
			addContact(contact);
		});
	}
		
	// Test a long address
	@Test
	public void testApptIDLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("1234567890", "Tim", "Brady", "4435550123", "123 JumpMoveDance Roaddddddddddddddddddddddddddddddddddddddd");
			addContact(contact);
		});
	}
	
	// Test adding an contact
	@Test
	public void testAddContact() {
		Contact contact = new Contact("1234567890", "Tim", "Brady", "4435550123", "123 JumpMoveDance Road");
		addContact(contact);
		int index = getContactIndex(contact);
		assertTrue(index >= 0);
	}
	
	// Test delete an contact
	@Test
	public void testDeleteContact() {
		Contact contact = new Contact("1234567890", "Tim", "Brady", "4435550123", "123 JumpMoveDance Road");
		deleteContact("1234567890");
		int index = getContactIndex(contact);
		assertTrue(index < 0);
	}
	
	// Validate ID format
	public boolean validateID(String id) {
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid contact ID");
		}
		if (id != null && id.length() <= 10) {
		    return true;
		}
		return false;
	}
						
	// Validate first name format
	public boolean validateFName(String fname) {
		if (fname == null || fname.length() > 10) {
			throw new IllegalArgumentException("Invalid contact first name");
		}
		if (fname != null && fname.length() <= 10)
		   return true;
		return false;
	}
			
	// Validate last name format
	public boolean validateLName(String lname) {
		if (lname == null || lname.length() > 10) {
			throw new IllegalArgumentException("Invalid contact last name");
		}
		if (lname != null && lname.length() <= 10)
		   return true;
		return false;
	}
				
	// Validate phone number format
	public boolean validatePhoneNum(String phoneNum) {
		if (phoneNum == null || phoneNum.length() > 10) {
			throw new IllegalArgumentException("Invalid contact phone number");
		}
		if (phoneNum != null && phoneNum.length() <= 10)
		   return true;
		return false;
	}
				
	// Validate contact address format
	public boolean validateContactAddress(String contactAddress) {
		if (contactAddress == null || contactAddress.length() > 50) {
			throw new IllegalArgumentException("Invalid contact address");
		}
		if (contactAddress != null && contactAddress.length() <= 50)
		   return true;
		return false;
	}
									
	// Add contact
	public boolean addContact(Contact contact) {
		int index = getContactIndex(contact);
			if (index < 0 && validateID(contact.getContactID()) && validateFName(contact.getFirstName()) && validateLName(contact.getLastName()) && validatePhoneNum(contact.getPhoneNum()) && validateContactAddress(contact.getContactAddress())) {
				contactList.add(contact);
				return true;
			}
			return false;
		}
				
	// Delete contact
	public void deleteContact(String id) {
		int index = getContactIndex(new Contact(id, "", "", "", ""));
	    if (index >= 0)
	    	contactList.remove(index);
		}
				
	// Update contact
	public void updateContact(Contact contact) {
		for (Contact obj : contactList) {
			if (obj.equals(contact) && validateFName(contact.getFirstName()) && validateLName(contact.getLastName()) && validatePhoneNum(contact.getPhoneNum()) && validateContactAddress(contact.getContactAddress())) {
				obj.setFirstName(contact.getFirstName());
			    obj.setLastName(contact.getLastName());
			    obj.setPhoneNum(contact.getPhoneNum());
			    obj.setContactAddress(contact.getContactAddress());
		    }
		}
	}
				
	// Get index
	public int getContactIndex(Contact contact) {
		int index = Collections.binarySearch(contactList, contact, Contact.idCompare);
		return index;
	}
}
