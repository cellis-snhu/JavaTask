/*
 * Author: Chris Ellis
 * Date: 11/12/2023
 * Class: CS320 Prof. Toledo
 * Contact.java is a class that stores data about a contact including a unique ID / username,
 * and the contacts first name, last name, phone number, and address.
 */

public class Contact {
    // contact fields
    private String contactID; // ID is unique and immutable
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor
    public Contact(String contactID, String firstName, String lastName, String phone, String address) {
        setContactID(contactID);
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }

    // Setter for contactID with validation
    private void setContactID(String contactID) {
        if (contactID == null || contactID.length() > 10) {
            throw new IllegalArgumentException("Invalid contactID, contactID must be less than 10 characters long and cannot be null");
        }
        this.contactID = contactID;
    }

    // Setter for firstName with validation
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name, first name must be less than 10 characters long and cannot be null");
        }
        this.firstName = firstName;
    }

    // Setter for lastName with validation
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name, last name must be less than 10 characters long and cannot be null");
        }
        this.lastName = lastName;
    }

    // Setter for phone with validation
    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid phone number, phone number must be exactly 10 numerical digits");
        }
        this.phone = phone;
    }

    // Setter for address with validation
    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address, address must be 30 characters or less");
        }
        this.address = address;
    }

    // Getter methods for all class variables
    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

}
