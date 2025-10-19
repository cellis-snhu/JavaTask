/*
 * Author: Chris Ellis
 * Date: 11/17/2023
 * Class: CS320 Prof. Toledo
 * TaskServiceTest.java is used to test the TaskService.java class functionality
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    private TaskService taskService;

    // test tasks to use in service
    private Task task1;
    private Task task2;
    private Task task3;

    @BeforeEach
    public void setUpValidTaskService() {
        // setup a task service for each test
        taskService = new TaskService();

        // test tasks to populate task service array list
        task1 = new Task("task1", "Task 1", "Description for Task 1");
        task2 = new Task("task2", "Task 2", "Description for Task 2");
        task3 = new Task("task3", "Task 3", "Description for Task 3");
    }

    @AfterEach
    public void tearDown() {
        // delete the task service after each test
        taskService = null;
    }

    // test valid entries for the TaskService methods
    @DisplayName("Test valid addTask")
    @Test
    public void testAddSingleTask() {
        taskService.addTask(task1);
        // get and store the task list for easy access to size()
        List<Task> tasks = taskService.getTaskList();
        assertEquals(1, tasks.size());
        assertEquals(task1, tasks.get(0));
    }

    // test adding multiple tasks results in the correct number of tasks
    @DisplayName("Test multiple valid addTask")
    @Test
    public void testAddMultipleTasks() {
        taskService.addTask(task1);
        taskService.addTask(task2);
        taskService.addTask(task3);

        List<Task> tasks = taskService.getTaskList();
        assertEquals(3, tasks.size());
        assertEquals(task1, tasks.get(0));
        assertEquals(task2, tasks.get(1));
        assertEquals(task3, tasks.get(2));
    }

    @DisplayName("Test deleting a task")
    @Test
    public void testDeleteSingleTask() {
        // add a test task
        taskService.addTask(task1);
        // get and store the task list for easy access to size()
        List<Task> tasks = taskService.getTaskList();

        // check the size of the list is one after adding task
        assertEquals(1, tasks.size());
        // delete the same task
        taskService.deleteTask("task1");
        // check that the task with id no longer exists
        assertThrows(IllegalArgumentException.class, () -> taskService.getTaskByID("task1"));
        // check that the list size is zero after deletion
        assertEquals(0, tasks.size());
    }

    @DisplayName("Test getTaskByID")
    @Test
    public void testGetTaskByID() {
        taskService.addTask(task1);
        Task foundTask = taskService.getTaskByID("task1");

        assertNotNull(foundTask);
        assertEquals(task1, foundTask);
    }

    @DisplayName("Test updateTaskName")
    @Test
    public void testUpdateTaskName() {
        taskService.addTask(task1);
        taskService.updateTaskName("task1", "Updated Task Name");

        // Check if the task name was updated
        Task updatedTask = taskService.getTaskByID("task1");

        assertNotNull(updatedTask);
        assertEquals("Updated Task Name", updatedTask.getName());
        assertNotEquals("Task 1", updatedTask.getName());
        assertEquals("Description for Task 1", updatedTask.getDescription());
    }

    @DisplayName("Test updateTaskDescription")
    @Test
    public void testUpdateTaskDescription() {
        taskService.addTask(task1);
        taskService.updateTaskDescription("task1", "Updated Task Description");

        // Check if the task description was updated
        Task updatedTask = taskService.getTaskByID("task1");

        assertNotNull(updatedTask);
        assertEquals("Task 1", updatedTask.getName());
        assertEquals("Updated Task Description", updatedTask.getDescription());
        assertNotEquals("Description for Task 1", updatedTask.getDescription());
    }

    /*
     * Test invalid entries for methods
     */

    @DisplayName("Test addTask when task already exists")
    @Test
    public void testAddTaskAlreadyExists() {
        taskService.addTask(task1);
        assertThrows(IllegalArgumentException.class, () -> taskService.addTask(task1));
    }

    @DisplayName("Test deleteTask exception when task not found")
    @Test
    public void testDeleteTaskNotFound() {
        assertThrows(IllegalArgumentException.class, () -> taskService.deleteTask("task1"));
    }

    @DisplayName("Test updateTaskName exception not found")
    @Test
    public void testUpdateTaskNameNotFound() {
        assertThrows(IllegalArgumentException.class, () -> taskService.updateTaskName("nonexistentTask", "Updated Task Name"));
    }

    @DisplayName("Test updateTaskDescription exception not found")
    @Test
    public void testUpdateTaskDescriptionNotFound() {
        assertThrows(IllegalArgumentException.class, () -> taskService.updateTaskDescription("nonexistentTask", "Updated Task Description"));
    }

}
