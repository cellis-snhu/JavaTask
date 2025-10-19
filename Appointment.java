/*
 * Author: Chris Ellis
 * Date: 11/25/2023
 * Class: CS320 Prof. Toledo
 * Appointment.java is a class that stores data about an appointment including a unique ID,
 * appointment date, and a description
 */

import java.util.Date;

public class Appointment {
    // appointment fields
    private String appointmentID; // ID is unique and immutable
    private Date appointmentDate;
    private String description;

    // Constructor
    public Appointment(String appointmentID, Date appointmentDate, String description) {
        setAppointmentID(appointmentID);
        setAppointmentDate(appointmentDate);
        setDescription(description);
    }

    // Setter for appointmentID with validation
    private void setAppointmentID(String appointmentID) {
        if (appointmentID == null || appointmentID.length() > 10) {
            throw new IllegalArgumentException("Invalid appointmentID, appointmentID must be less than 10 characters long and cannot be null");
        }
        this.appointmentID = appointmentID;
    }

    // Setter for appointmentDate with validation
    public void setAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment date, it cannot be in the past and cannot be null");
        }
        this.appointmentDate = appointmentDate;
    }

    // Setter for description with validation
    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description, description must be less than 50 characters long and cannot be null");
        }
        this.description = description;
    }

    // Getter methods for all class variables
    public String getAppointmentID() { return appointmentID; }

    public Date getAppointmentDate() { return appointmentDate; }

    public String getDescription() { return description; }
}