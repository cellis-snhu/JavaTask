/*
 * Author: Chris Ellis
 * Date: 11/17/2023
 * Class: CS320 Prof. Toledo
 * TaskService.java implements a service that contains a list of tasks,
 * and functionality to add/delete/update tasks.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskService {
    // Service will store a list of tasks
    private List<Task> tasks;

    // Constructor
    public TaskService() {
        this.tasks = new ArrayList<>();
    }

    // Add a task with a unique ID
    public void addTask(Task task) {
        // Check if taskID is unique
        if (isTaskIDUnique(task.getTaskID())) {
            tasks.add(task);
        } else {
            throw new IllegalArgumentException("TaskID is already in use, you must choose a unique ID");
        }
    }

    // Delete a task by task ID
    public void deleteTask(String taskID) {
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getTaskID().equals(taskID)) {
                iterator.remove();
                return; // don't keep iterating if we found the task
            }
        }
        throw new IllegalArgumentException("Task with ID, " + taskID + " was not found");
    }

    // Get a task by ID
    public Task getTaskByID(String taskID) {
        for (Task task : tasks) {
            if (task.getTaskID().equals(taskID)) {
                return task;
            }
        }
        throw new IllegalArgumentException("Task with ID, " + taskID + " was not found");
    }

    // Check if a task with the given ID already exists
    private boolean isTaskIDUnique(String taskID) {
        for (Task task : tasks) {
            if (task.getTaskID().equals(taskID)) {
                return false; // task was already found
            }
        }
        return true; // Task ID is unique
    }

    // Update name of a task
    public void updateTaskName(String taskID, String newName) {
        Task task = getTaskByID(taskID);
        task.setName(newName);
    }

    // Update description of a task
    public void updateTaskDescription(String taskID, String newDescription) {
        Task task = getTaskByID(taskID);
        task.setDescription(newDescription);
    }

    public List<Task> getTaskList() { return tasks;}
}