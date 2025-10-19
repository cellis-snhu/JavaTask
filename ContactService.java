/*
 * Author: Chris Ellis
 * Date: 11/12/2023
 * Class: CS320 Prof. Toledo
 * ContactService.java acts as a service layer on top of Contact.java to store multiple contacts
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ContactService {
    // Service will store a list of contacts
    private List<Contact> contacts;

    // Constructor
    public ContactService() {
        this.contacts = new ArrayList<>();
    }

    // Add a contact with a unique ID
    public void addContact(Contact contact) {
        // Check if contactID is unique
        if (isContactIDUnique(contact.getContactID())) {
            contacts.add(contact);
        } else {
            throw new IllegalArgumentException("ContactID is already in use, you must choose a unique ID");
        }
    }

    // Delete a contact by contact ID
    public void deleteContact(String contactID) {
        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getContactID().equals(contactID)) {
                iterator.remove();
                return; // don't keep iterating if we found the contact
            }
        }
        throw new IllegalArgumentException("Contact with ID, " + contactID + " was not found");
    }

    // Get a contact by ID
    public Contact getContactByID(String contactID) {
        for (Contact contact : contacts) {
            if (contact.getContactID().equals(contactID)) {
                return contact;
            }
        }
        throw new IllegalArgumentException("Contact with ID, " + contactID + " was not found");
    }


    // Update the first name value of an existing contact
    public void updateContactFirstName(String ContactID, String newFirstName) {
        Contact contact = getContactByID(ContactID);
        contact.setFirstName(newFirstName);
    }

    // Update the last name value of an existing contact
    public void updateContactLastName(String ContactID, String newLastName) {
        Contact contact = getContactByID(ContactID);
        contact.setLastName(newLastName);
    }

    // Update the phone number value of an existing contact
    public void updateContactPhoneNumber(String ContactID, String newPhoneNumber) {
        Contact contact = getContactByID(ContactID);
        contact.setPhone(newPhoneNumber);
    }

    // Update the address value of an existing contact
    public void updateContactAddress(String ContactID, String newAddress) {
        Contact contact = getContactByID(ContactID);
        contact.setAddress(newAddress);
    }


    // Check if a contact with the given ID already exists
    private boolean isContactIDUnique(String contactID) {
        for (Contact contact : contacts) {
            if (contact.getContactID().equals(contactID)) {
                return false; // contact was already found
            }
        }
        return true; // Contact ID is unique
    }

    // Utility method to Get the list of contacts for tests
    public List<Contact> getContactList() {
        return  contacts;
    }

}
