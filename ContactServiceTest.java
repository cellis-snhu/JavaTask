/*
 * Author: Chris Ellis
 * Date: 11/12/2023
 * Class: CS320 Prof. Toledo
 * ContactServiceTest.java is used to test the ContactService.java class functionality
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {

    private ContactService contactService;

    // test contacts to use in service
    private Contact chrisEllis;
    private Contact tonyStark;
    private Contact steveRogers;

    @BeforeEach
    public void setUpValidContactService() {
        // setup a contact service for each test
        contactService = new ContactService();

        // test contact info to populate contact service array list
        chrisEllis = new Contact("chrisellis", "Chris", "Ellis", "6465559999", "144 Ridge Street");
        tonyStark = new Contact("tonystark", "Tony", "Stark", "1234567890", "123 Some Street");
        steveRogers = new Contact("steveroger", "Steve", "Rogers", "9876543210", "123 Some Street");
    }

    @AfterEach
    public void tearDown() {
        // delete the contact service after each test
        contactService = null;
    }

    // test valid entries for the ContactService methods
    @DisplayName("Test valid addContact")
    @Test
    public void testAddSingleContact() {
        contactService.addContact(chrisEllis);
        // get and store the contact list for easy access to size()
        List<Contact> contacts = contactService.getContactList();
        assertEquals(1, contacts.size());
        assertEquals(chrisEllis, contacts.get(0));
    }

    // test adding multiple contacts results in correct number of contacts
    @DisplayName("Test multiple valid addContact")
    @Test
    public void testAddMultipleContacts() {
        contactService.addContact(chrisEllis);
        contactService.addContact(tonyStark);
        contactService.addContact(steveRogers);

        List<Contact> contacts = contactService.getContactList();
        assertEquals(3, contacts.size());
        assertEquals(chrisEllis, contacts.get(0));
        assertEquals(tonyStark, contacts.get(1));
        assertEquals(steveRogers, contacts.get(2));
    }

    @DisplayName("Test deleting a contact")
    @Test
    public void testDeleteSingleContact() {
        // add a test user
        contactService.addContact(chrisEllis);
        // get and store the contact list for easy access to size()
        List<Contact> contacts = contactService.getContactList();

        // check size of list is one after adding user
        assertEquals(1, contacts.size());
        // delete the same user
        contactService.deleteContact("chrisellis");
        // check that the user with id no longer exists
        assertThrows(IllegalArgumentException.class, () -> contactService.getContactByID("chrisellis"));
        // check that the list size is zero after deletion
        assertEquals(0, contacts.size());
    }

    @DisplayName("Test getContactByID")
    @Test
    public void testGetContactByID() {
        contactService.addContact(chrisEllis);
        Contact foundContact = contactService.getContactByID("chrisellis");

        assertNotNull(foundContact);
        assertEquals(chrisEllis, foundContact);
    }

    @Test
    @DisplayName("Update contact first name")
    void testUpdateContactFirstName() {
        String newFirstName = "Mike";
        contactService.addContact(chrisEllis);
        Contact testContact = contactService.getContactByID("chrisellis");

        contactService.updateContactFirstName(testContact.getContactID(), newFirstName);

        Contact updatedContact = contactService.getContactByID(testContact.getContactID());
        assertEquals(newFirstName, updatedContact.getFirstName());
    }

    @Test
    @DisplayName("Update contact last name")
    void testUpdateContactLastName() {
        String newLastName = "Smith";
        contactService.addContact(chrisEllis);
        Contact testContact = contactService.getContactByID("chrisellis");

        contactService.updateContactLastName(testContact.getContactID(), newLastName);

        Contact updatedContact = contactService.getContactByID(testContact.getContactID());
        assertEquals(newLastName, updatedContact.getLastName());
    }

    @Test
    @DisplayName("Update contact phone number")
    void testUpdateContactPhoneNumber() {
        String newPhoneNumber = "5555555555";
        contactService.addContact(chrisEllis);
        Contact testContact = contactService.getContactByID("chrisellis");

        contactService.updateContactPhoneNumber(testContact.getContactID(), newPhoneNumber);

        Contact updatedContact = contactService.getContactByID(testContact.getContactID());
        assertEquals(newPhoneNumber, updatedContact.getPhone());
    }

    @Test
    @DisplayName("Update contact address")
    void testUpdateContactAddress() {
        String newAddress = "789 Pine St";
        contactService.addContact(chrisEllis);
        Contact testContact = contactService.getContactByID("chrisellis");

        contactService.updateContactAddress(testContact.getContactID(), newAddress);

        Contact updatedContact = contactService.getContactByID(testContact.getContactID());
        assertEquals(newAddress, updatedContact.getAddress());
    }


    /*
     * Test invalid entries for methods
     */

    @DisplayName("Test addContact when contact already exists")
    @Test
    public void testAddContactAlreadyExists() {
        contactService.addContact(chrisEllis);
        assertThrows(IllegalArgumentException.class, () -> contactService.addContact(chrisEllis));
    }

    @DisplayName("Test deleteContact exception when contact not found")
    @Test
    public void testDeleteContactNotFound() {
        assertThrows(IllegalArgumentException.class, () -> contactService.deleteContact("chrisellis"));
    }

    @Test
    @DisplayName("Update non-existing contact firstName throws IllegalArgumentException")
    void testUpdateNonExistingContact() {
        String contactID = "nonexist";
        String newFirstName = "Mike";

        assertThrows(IllegalArgumentException.class,
                () -> contactService.updateContactFirstName(contactID, newFirstName));
    }

    @Test
    @DisplayName("Update non-existing contact lastName throws IllegalArgumentException")
    void testUpdateNonExistingContactLastName() {
        String contactID = "nonexist";
        String newLastName = "Smith";

        assertThrows(IllegalArgumentException.class,
                () -> contactService.updateContactLastName(contactID, newLastName));
    }

    @Test
    @DisplayName("Update non-existing contact phoneNumber throws IllegalArgumentException")
    void testUpdateNonExistingContactPhoneNumber() {
        String contactID = "nonexist";
        String newPhoneNumber = "5555555555";

        assertThrows(IllegalArgumentException.class,
                () -> contactService.updateContactPhoneNumber(contactID, newPhoneNumber));
    }

    @Test
    @DisplayName("Update non-existing contact address throws IllegalArgumentException")
    void testUpdateNonExistingContactAddress() {
        String contactID = "nonexist";
        String newAddress = "789 Pine St";

        assertThrows(IllegalArgumentException.class,
                () -> contactService.updateContactAddress(contactID, newAddress));
    }
}
