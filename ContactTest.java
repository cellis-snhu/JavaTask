/*
 * Author: Chris Ellis
 * Date: 11/12/2023
 * Class: CS320 Prof. Toledo
 * ContactTest.java is used to test the Contact.java class functionality
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {
    // Valid Constructor var
    private Contact validContact;
    // Valid contact data for constructor
    private final String validContactID = "chrisellis";
    private final String validFirstName = "Chris";
    private final String validLastName = "Ellis";
    private final String validPhone = "6465559999";
    private final String validAddress = "144 Ridge Street";

    // Invalid contact data
    private final String invalidContactIDTooLong = "12345678901";
    private final String invalidContactIDNull = null;

    // Setup and teardown a valid constructor for each test to use, invalid constructors are initialized explicitly
    // in 'invalid constructor' test methods
    @BeforeEach
    public void setUpValidContact() {
        // Common setup for tests that require a valid contact
        validContact = new Contact(validContactID,validFirstName, validLastName, validPhone, validAddress);
    }

    @AfterEach
    public void tearDown() {
        // Common cleanup tasks, e.g., setting the reference to null
        validContact = null;
    }

    // Test constructor with all valid entries
    @DisplayName("Test valid constructor")
    @Test
    public void testValidContactConstructor() {

        // Check that getters return the expected values
        assertEquals(validContactID, validContact.getContactID());
        assertEquals(validFirstName, validContact.getFirstName());
        assertEquals(validLastName, validContact.getLastName());
        assertEquals(validPhone, validContact.getPhone());
        assertEquals(validAddress, validContact.getAddress());
    }

    /*
    *  As the contactID is the unique id for the class as another layer to ensure correctness,
    *  we are testing the constructor throws the correct errors even though the validation
    *  is also tested in the setter
    */

    // Test constructor with a contactID longer than 10 characters
    @DisplayName("Test invalid constructor where contactID is too many characters")
    @Test
    public void testInvalidContactConstructorContactIDTooLong() {
        try {
            // Test valid contact creation
            new Contact(invalidContactIDTooLong, validFirstName, validLastName, validPhone, validAddress);
            fail("Expected IllegalArgumentException for invalid contactID");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception: " + e);
        }
    }

    // Test constructor with a null contactID
    @DisplayName("Test invalid constructor where contactID is null")
    @Test
    public void testInvalidContactConstructorContactIDNull() {
        try {
            // Test valid contact creation
            new Contact(invalidContactIDNull, validFirstName, validLastName, validPhone, validAddress);
            fail("Expected IllegalArgumentException for invalid contactID");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception: " + e);
        }
    }

    /*
    * Testing valid setter methods correctly function
    */

    @DisplayName("Test valid setFirstName outside constructor")
    @Test
    public void testValidSetFirstName() {
        String newFirstName = "FirstName";
        validContact.setFirstName(newFirstName);

        assertEquals(newFirstName, validContact.getFirstName());
    }

    @DisplayName("Test valid setLastName outside constructor")
    @Test
    public void testValidSetLastName() {
        String newLastName = "LastName";
        validContact.setLastName(newLastName);

        assertEquals(newLastName, validContact.getLastName());
    }

    @DisplayName("Test valid setPhone outside constructor")
    @Test
    public void testValidSetPhone() {
        String newPhone = "1234567890";
        validContact.setPhone(newPhone);

        assertEquals(newPhone, validContact.getPhone());
    }

    @DisplayName("Test valid setAddress outside constructor")
    @Test
    public void testValidSetAddress() {
        String newAddress = "456 New St";
        validContact.setAddress(newAddress);

        assertEquals(newAddress, validContact.getAddress());
    }

    /*
     * Test invalid entries for setters
     */

    @DisplayName("Test invalid setFirstName (null)")
    @Test
    public void testInvalidSetFirstNameNull() {
        // Attempt to set the first name to null
        assertThrows(IllegalArgumentException.class, () -> validContact.setFirstName(null));
    }

    @DisplayName("Test invalid setFirstName (too long)")
    @Test
    public void testInvalidSetFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> validContact.setFirstName("ANameThatIsTooLong"));
    }

    @DisplayName("Test invalid setLastName (null)")
    @Test
    public void testInvalidSetLastNameNull() {
        // Attempt to set the last name to null
        assertThrows(IllegalArgumentException.class, () -> validContact.setLastName(null));
    }

    @DisplayName("Test invalid setLastName (too long)")
    @Test
    public void testInvalidSetLastNameTooLong() {
        // Attempt to set the last name to a value longer than 10 characters
        assertThrows(IllegalArgumentException.class, () -> validContact.setLastName("TooLongLastName"));
    }

    @DisplayName("Test invalid setPhone (null)")
    @Test
    public void testInvalidSetPhoneNull() {
        // Attempt to set the phone to null
        assertThrows(IllegalArgumentException.class, () -> validContact.setPhone(null));
    }

    @DisplayName("Test invalid setPhone (not 10 digits)")
    @Test
    public void testInvalidSetPhoneNotTenDigits() {
        // Attempt to set the phone to a value not exactly 10 digits
        assertThrows(IllegalArgumentException.class, () -> validContact.setPhone("123456789"));
    }

    @DisplayName("Test invalid setPhone (not numeric digits)")
    @Test
    public void testInvalidSetPhoneNotNumber() {
        // Attempt to set the phone to a value that is not numeric
        assertThrows(IllegalArgumentException.class, () -> validContact.setPhone("not_digits"));
    }

    @DisplayName("Test invalid setAddress (null)")
    @Test
    public void testInvalidSetAddressNull() {
        // Attempt to set the address to null
        assertThrows(IllegalArgumentException.class, () -> validContact.setAddress(null));
    }

    @DisplayName("Test invalid setAddress (too long)")
    @Test
    public void testInvalidSetAddressTooLong() {
        // Attempt to set the address to a value longer than 30 characters
        assertThrows(IllegalArgumentException.class, () -> validContact.setAddress("TooLongAddressThatIsInvalidBecauseItIsMoreThan30Characters"));
    }

    /*
     * Test getter methods retrieve correct values
     */

    @DisplayName("Test getContactID")
    @Test
    public void testGetContactID() {
        assertEquals(validContactID, validContact.getContactID());
    }

    @DisplayName("Test getFirstName")
    @Test
    public void testGetFirstName() {
        assertEquals(validFirstName, validContact.getFirstName());
    }

    @DisplayName("Test getLastName")
    @Test
    public void testGetLastName() {
        assertEquals(validLastName, validContact.getLastName());
    }

    @DisplayName("Test getPhone")
    @Test
    public void testGetPhone() {
        assertEquals(validPhone, validContact.getPhone());
    }

    @DisplayName("Test getAddress")
    @Test
    public void testGetAddress() {
        assertEquals(validAddress, validContact.getAddress());
    }


}