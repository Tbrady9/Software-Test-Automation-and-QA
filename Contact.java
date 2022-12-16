package test;

import java.util.Comparator;

public class Contact {

	// Variables
	private String contactID;
	private String firstName;
	private String lastName;
	private String phoneNum;
	private String contactAddress;
	
	// Constructor
	public Contact(String contactID, String firstName, String lastName, String phoneNum, String contactAddress) {
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.contactAddress = contactAddress;
	}
	
	// Setters and getters
	// ContactID
	public String getContactID() {
		return contactID;
	}
	public void setContactID(String contactID) {
		this.contactID = contactID;
	}
	
	// FirstName
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	// LastName
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	// PhoneNum
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	// ContactAddress
	public String getContactAddress() {
		return contactAddress;
	}
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
	
	public static Comparator<Contact> idCompare = new Comparator<Contact>() {
        public int compare(Contact contact, Contact contact2) {
            return contact.getContactID().compareTo(contact2.getContactID());
        }
    };
}
