package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Task;

class TaskTest {

	@Test
	void testCreateTaskSuccess() {
		Task task = new Task("123456", "Task Name", "Task Description");
		
		assertTrue(task != null);
		assertTrue(task.getTaskId().equals("123456"));
		assertTrue(task.getTaskName().equals("Task Name"));
		assertTrue(task.getTaskDescription().equals("Task Description"));
	}
	
	@Test
	void testCreateTaskIdFails() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345678901", "Task Name", "Task Description");
		});
	}
	
	@Test
	void testCreateTaskNameFails() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("123456789", "Task Name is way too long for test", "Task Description");
		});
	}
	
	@Test
	void testCreateTaskDescriptionFails() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("123456789", "Task Name", "Task Description is too long for the description of the task used to create the task");
		});
	}
	
	@Test
	void testUpdateTaskSuccess() {
		Task task = new Task("123456", "Task Name", "Task Description");
		
		task.setTasktName("New Task Name");
		task.setTaskDescription("New Task Description");
		
		assertTrue(task.getTaskId().equals("123456"));
		assertTrue(task.getTaskName().equals("New Task Name"));
		assertTrue(task.getTaskDescription().equals("New Task Description"));
	}
	
	@Test
	void testUpdateTaskNameFails() {
		Task task = new Task("123456", "Task Name", "Task Description");
		assertFalse(task.setTasktName("Task Name Too Long For Task"));

	}
	
	@Test
	void testUpdateTaskDescriptionFails() {
		Task task = new Task("123456", "Task Name", "Task Description");
		assertFalse(task.setTaskDescription("This task description is too long to be used as valid input for a task description"));
		
	}
	
	
	
	
	//Test to verify the name meets length requirements
	
	
	//Test to verify description meets length requirements. 
}
