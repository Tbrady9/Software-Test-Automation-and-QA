package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {

	// Test that data is being returned
	@Test 
	public void testContact() {
		Contact contact = new Contact("1234567890", "Tim", "Brady", "4435550123", "123 HateItHere Road");
		assertTrue(contact.getContactID().equals("1234567890"));
		assertTrue(contact.getFirstName().equals("Tim"));
		assertTrue(contact.getLastName().equals("Brady"));
		assertTrue(contact.getPhoneNum().equals("4435550123"));
		assertTrue(contact.getContactAddress().equals("123 HateItHere Road"));
	}
}
