/*
 * Author: Chris Ellis
 * Date: 11/25/2023
 * Class: CS320 Prof. Toledo
 * AppointmentService.java acts as a service layer on top of Appointment.java to store multiple appointments
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AppointmentService {
    // Service will store a list of appointments
    private List<Appointment> appointments;

    // Constructor
    public AppointmentService() {
        this.appointments = new ArrayList<>();
    }

    // Add an appointment with a unique ID
    public void addAppointment(Appointment appointment) {
        // Check if appointmentID is unique
        if (isAppointmentIDUnique(appointment.getAppointmentID())) {
            appointments.add(appointment);
        } else {
            throw new IllegalArgumentException("AppointmentID is already in use, you must choose a unique ID");
        }
    }

    // Delete an appointment by appointment ID
    public void deleteAppointment(String appointmentID) {
        Iterator<Appointment> iterator = appointments.iterator();
        while (iterator.hasNext()) {
            Appointment appointment = iterator.next();
            if (appointment.getAppointmentID().equals(appointmentID)) {
                iterator.remove();
                return; // don't keep iterating if we found the appointment
            }
        }
        throw new IllegalArgumentException("Appointment with ID, " + appointmentID + " was not found");
    }

    // Get an appointment by ID
    public Appointment getAppointmentByID(String appointmentID) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentID().equals(appointmentID)) {
                return appointment;
            }
        }
        throw new IllegalArgumentException("Appointment with ID, " + appointmentID + " was not found");
    }

    // Check if an appointment with the given ID already exists
    private boolean isAppointmentIDUnique(String appointmentID) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentID().equals(appointmentID)) {
                return false; // appointment was already found
            }
        }
        return true; // Appointment ID is unique
    }

    // Utility method to Get the list of appointments for tests
    public List<Appointment> getAppointmentList() {
        return appointments;
    }
}
