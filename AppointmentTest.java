/*
 * Author: Chris Ellis
 * Date: 11/25/2023
 * Class: CS320 Prof. Toledo
 * AppointmentTest.java is used to test the Appointment.java class functionality
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {
    // Valid appointment object
    private Appointment validAppointment;

    // Valid appointment data for constructor
    private final String validAppointmentID = "appt1";
    private final Date validAppointmentDate = new Date(System.currentTimeMillis() + 1000000); // Set to a future date
    private final String validDescription = "This is an appointment.";

    // Invalid appointment data
    private final String invalidAppointmentIDTooLong = "12345678901";
    private final String invalidAppointmentIDNull = null;

    // Setup and teardown a valid constructor for each test to use, invalid constructors are initialized explicitly
    // in 'invalid constructor' test methods
    @BeforeEach
    public void setUpValidAppointment() {
        // Common setup for tests that require a valid appointment
        validAppointment = new Appointment(validAppointmentID, validAppointmentDate, validDescription);
    }

    @AfterEach
    public void tearDown() {
        // Common cleanup tasks, e.g., setting the reference to null
        validAppointment = null;
    }

    // Test constructor with all valid entries
    @DisplayName("Test valid constructor")
    @Test
    public void testValidAppointmentConstructor() {

        // Check that getters return the expected values
        assertEquals(validAppointmentID, validAppointment.getAppointmentID());
        assertEquals(validAppointmentDate, validAppointment.getAppointmentDate());
        assertEquals(validDescription, validAppointment.getDescription());
    }

    // Test constructor with an appointmentID longer than 10 characters
    @DisplayName("Test invalid constructor where appointmentID is too many characters")
    @Test
    public void testInvalidAppointmentConstructorAppointmentIDTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
                new Appointment(invalidAppointmentIDTooLong, validAppointmentDate, validDescription));
    }

    // Test constructor with a null appointmentID
    @DisplayName("Test invalid constructor where appointmentID is null")
    @Test
    public void testInvalidAppointmentConstructorAppointmentIDNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Appointment(invalidAppointmentIDNull, validAppointmentDate, validDescription));
    }

    /*
     * Testing valid setter methods correctly function
     */

    @DisplayName("Test valid setAppointmentDate outside constructor")
    @Test
    public void testValidSetAppointmentDate() {
        Date newAppointmentDate = new Date(System.currentTimeMillis() + 2000000); // Set to a future date
        validAppointment.setAppointmentDate(newAppointmentDate);

        assertEquals(newAppointmentDate, validAppointment.getAppointmentDate());
    }

    @DisplayName("Test valid setDescription outside constructor")
    @Test
    public void testValidSetDescription() {
        String newDescription = "New Meeting";
        validAppointment.setDescription(newDescription);

        assertEquals(newDescription, validAppointment.getDescription());
    }

    /*
     * Test invalid entries for setters
     */

    @DisplayName("Test invalid setAppointmentDate (null)")
    @Test
    public void testInvalidSetAppointmentDateNull() {
        assertThrows(IllegalArgumentException.class, () -> validAppointment.setAppointmentDate(null));
    }

    @DisplayName("Test invalid setAppointmentDate (in the past)")
    @Test
    public void testInvalidSetAppointmentDatePast() {
        Date pastDate = new Date(System.currentTimeMillis() - 60000); // Set date to one minute in the past
        assertThrows(IllegalArgumentException.class, () -> validAppointment.setAppointmentDate(pastDate));
    }

    @DisplayName("Test invalid setDescription (null)")
    @Test
    public void testInvalidSetDescriptionNull() {
        assertThrows(IllegalArgumentException.class, () -> validAppointment.setDescription(null));
    }

    @DisplayName("Test invalid setDescription (too long)")
    @Test
    public void testInvalidSetDescriptionTooLong() {
        // Attempt to set the description to a value longer than 50 characters
        assertThrows(IllegalArgumentException.class, () ->
                validAppointment.setDescription("TooLongDescriptionThatIsInvalidBecauseItIsMoreThan50Characters"));
    }

    /*
     * Test getter methods retrieve correct values
     */

    @DisplayName("Test getAppointmentID")
    @Test
    public void testGetAppointmentID() {
        assertEquals(validAppointmentID, validAppointment.getAppointmentID());
    }

    @DisplayName("Test getAppointmentDate")
    @Test
    public void testGetAppointmentDate() {
        assertEquals(validAppointmentDate, validAppointment.getAppointmentDate());
    }

    @DisplayName("Test getDescription")
    @Test
    public void testGetDescription() {
        assertEquals(validDescription, validAppointment.getDescription());
    }
}
