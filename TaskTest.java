/*
 * Author: Chris Ellis
 * Date: 11/17/2023
 * Class: CS320 Prof. Toledo
 * TaskTest.java is used to test the Task.java class functionality
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    // Valid Constructor var
    private Task validTask;
    // Valid task data for constructor
    private final String validTaskID = "1";
    private final String validName = "taskname";
    private final String validDescription = "null";

    // Invalid task data
    private final String invalidTaskIDTooLong = "12345678901"; // 11 chars
    private final String invalidTaskIDNull = null;

    // Setup and teardown a valid constructor for each test to use, invalid constructors are initialized explicitly
    // in 'invalid constructor' test methods
    @BeforeEach
    public void setUpValidTask() {
        // Common setup for tests that require a valid task
        validTask = new Task(validTaskID, validName, validDescription);
    }

    @AfterEach
    public void tearDown() {
        // Common cleanup tasks, e.g., setting the reference to null
        validTask = null;
    }

    // Test constructor with all valid entries
    @DisplayName("Test valid constructor")
    @Test
    public void testValidTaskConstructor() {
        // Check that getters return the expected values
        assertEquals(validTaskID, validTask.getTaskID());
        assertEquals(validName, validTask.getName());
        assertEquals(validDescription, validTask.getDescription());
    }

    // Test constructor with a taskID longer than 10 characters
    @DisplayName("Test invalid constructor where taskID is too many characters")
    @Test
    public void testInvalidTaskConstructorTaskIDTooLong() {
        try {
            // Test valid task creation
            new Task(invalidTaskIDTooLong, validName, validDescription);
            fail("Expected IllegalArgumentException for invalid taskID");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception: " + e);
        }
    }

    // Test constructor with a null taskID
    @DisplayName("Test invalid constructor where taskID is null")
    @Test
    public void testInvalidTaskConstructorTaskIDNull() {
        try {
            // Test valid task creation
            new Task(invalidTaskIDTooLong, validName, validDescription);
            fail("Expected IllegalArgumentException for invalid taskID");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception: " + e);
        }
    }

    /*
     * Testing valid setter methods correctly function
     */

    @DisplayName("Test valid setName outside constructor")
    @Test
    public void testValidSetName() {
        String newName = "NewName";
        validTask.setName(newName);

        assertEquals(newName, validTask.getName());
    }

    @DisplayName("Test valid setDescription outside constructor")
    @Test
    public void testValidSetDescription() {
        String newDescription = "New description for the task.";
        validTask.setDescription(newDescription);

        assertEquals(newDescription, validTask.getDescription());
    }

    /*
     * Test invalid entries for setters
     */

    @DisplayName("Test invalid setName (null)")
    @Test
    public void testInvalidSetNameNull() {
        // Attempt to set the name to null
        assertThrows(IllegalArgumentException.class, () -> validTask.setName(null));
    }

    @DisplayName("Test invalid setName (too long)")
    @Test
    public void testInvalidSetNameTooLong() {
        // Attempt to set the name to a value longer than 20 characters
        assertThrows(IllegalArgumentException.class, () -> validTask.setName("TooLongOfANameForTask"));
    }

    @DisplayName("Test invalid setDescription (null)")
    @Test
    public void testInvalidSetDescriptionNull() {
        // Attempt to set the description to null
        assertThrows(IllegalArgumentException.class, () -> validTask.setDescription(null));
    }

    @DisplayName("Test invalid setDescription (too long)")
    @Test
    public void testInvalidSetDescriptionTooLong() {
        // Attempt to set the description to a value longer than 50 characters
        assertThrows(IllegalArgumentException.class, () -> validTask.setDescription("TooLongDescriptionForTaskThatIsInvalidBecauseItIsMoreThan50Characters"));
    }

    /*
     * Test getter methods retrieve correct values
     */

    @DisplayName("Test getTaskID")
    @Test
    public void testGetTaskID() {
        assertEquals(validTaskID, validTask.getTaskID());
    }

    @DisplayName("Test getName")
    @Test
    public void testGetName() {
        assertEquals(validName, validTask.getName());
    }

    @DisplayName("Test getDescription")
    @Test
    public void testGetDescription() {
        assertEquals(validDescription, validTask.getDescription());
    }

}