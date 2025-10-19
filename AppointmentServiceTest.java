/*
 * Author: Chris Ellis
 * Date: 11/25/2023
 * Class: CS320 Prof. Toledo
 * AppointmentServiceTest.java is used to test the AppointmentService.java class functionality
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentServiceTest {

    private AppointmentService appointmentService;

    // test appointments to use in service
    private Appointment meeting1;
    private Appointment meeting2;
    private Appointment meeting3;

    @BeforeEach
    public void setUpValidAppointmentService() {
        // setup an appointment service for each test
        appointmentService = new AppointmentService();

        // test appointment info to populate appointment service array list
        meeting1 = new Appointment("appt123", new Date(System.currentTimeMillis() + 1000000), "Project Meeting");
        meeting2 = new Appointment("appt456", new Date(System.currentTimeMillis() + 2000000), "Team Lunch");
        meeting3 = new Appointment("appt789", new Date(System.currentTimeMillis() + 3000000), "Client Presentation");
    }

    @AfterEach
    public void tearDown() {
        // delete the appointment service after each test
        appointmentService = null;
    }

    // test valid entries for the AppointmentService methods
    @DisplayName("Test valid addAppointment")
    @Test
    public void testAddSingleAppointment() {
        appointmentService.addAppointment(meeting1);
        // get and store the appointment list for easy access to size()
        List<Appointment> appointments = appointmentService.getAppointmentList();
        assertEquals(1, appointments.size());
        assertEquals(meeting1, appointments.get(0));
    }

    // test adding multiple appointments results in the correct number of appointments
    @DisplayName("Test multiple valid addAppointment")
    @Test
    public void testAddMultipleAppointments() {
        appointmentService.addAppointment(meeting1);
        appointmentService.addAppointment(meeting2);
        appointmentService.addAppointment(meeting3);

        List<Appointment> appointments = appointmentService.getAppointmentList();
        assertEquals(3, appointments.size());
        assertEquals(meeting1, appointments.get(0));
        assertEquals(meeting2, appointments.get(1));
        assertEquals(meeting3, appointments.get(2));
    }

    @DisplayName("Test deleting an appointment")
    @Test
    public void testDeleteSingleAppointment() {
        // add a test appointment
        appointmentService.addAppointment(meeting1);
        // get and store the appointment list for easy access to size()
        List<Appointment> appointments = appointmentService.getAppointmentList();

        // check size of list is one after adding appointment
        assertEquals(1, appointments.size());
        // delete the same appointment
        appointmentService.deleteAppointment("appt123");
        // check that the appointment with id no longer exists
        assertThrows(IllegalArgumentException.class, () -> appointmentService.getAppointmentByID("appt123"));
        // check that the list size is zero after deletion
        assertEquals(0, appointments.size());
    }

    @DisplayName("Test getAppointmentByID")
    @Test
    public void testGetAppointmentByID() {
        appointmentService.addAppointment(meeting1);
        Appointment foundAppointment = appointmentService.getAppointmentByID("appt123");

        assertNotNull(foundAppointment);
        assertEquals(meeting1, foundAppointment);
    }

    /*
     * Test invalid entries for methods
     */

    @DisplayName("Test addAppointment when appointment already exists")
    @Test
    public void testAddAppointmentAlreadyExists() {
        appointmentService.addAppointment(meeting1);
        assertThrows(IllegalArgumentException.class, () -> appointmentService.addAppointment(meeting1));
    }

    @DisplayName("Test deleteAppointment exception when appointment not found")
    @Test
    public void testDeleteAppointmentNotFound() {
        assertThrows(IllegalArgumentException.class, () -> appointmentService.deleteAppointment("appt123"));
    }
}
