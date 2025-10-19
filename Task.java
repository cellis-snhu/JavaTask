/*
 * Author: Chris Ellis
 * Date: 11/17/2023
 * Class: CS320 Prof. Toledo
 * Task.java is a class that stores data about a task including a unique ID, name,
 * and description.
 */

public class Task {

    private String taskID; // taskID is immutable
    private String name;
    private String description;

    // Constructor
    public Task(String taskID, String name, String description) {
        setTaskID(taskID);
        setName(name);
        setDescription(description);
    }

    // Task getter functions
    public String getTaskID() {
        return taskID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // Setter for taskID with validation
    private void setTaskID(String taskID) {
        // error when taskID is null or is longer than 10 characters
        if (taskID == null || taskID.length() > 10) {
            throw new IllegalArgumentException("Invalid taskID, taskID must be less than 10 characters long and cannot be null");
        }
        this.taskID = taskID;
    }

    // Setter for name with validation
    public void setName(String name) {
        // error when name is null or greater than 20 characters
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid task name, task name must be less than 20 characters long and cannot be null");
        }
        this.name = name;
    }

    // Setter for description with validation
    public void setDescription(String description) {
        // error when description is null or greater than 50 characters
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description, description must be less than 50 characters and not be null.");
        }
        this.description = description;
    }
}
