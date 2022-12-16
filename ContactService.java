package test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ContactService {

	// New array for contact
	public static List<Contact> contactList = new ArrayList<>();
	
	public static void main(String[] args) {

		// New contact service
		ContactService contactServ = new ContactService();
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
