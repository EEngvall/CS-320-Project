package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.Task;

class TaskTest {

	public String taskName;
	public String taskDescription;
	public String taskNameLong;
	public String taskDescriptionLong;
	
	@BeforeEach
	public void setUp() {
		taskName = "Test Task Name";
		taskDescription = "Task Description";
		taskNameLong = "This sentence is too long for the task.";
		taskDescriptionLong = "This sentence is too long for the task description string and should be an error.";
		System.out.println("Setting up...");
	}

	@Test
	void taskConstructortest() {
		Task task = new Task(taskName, taskDescription);
		assertAll("Task Constructor Test", 
				() -> assertEquals(taskName, task.getTaskName()),
				() -> assertEquals(taskDescription, task.getTaskDescription()));		
		System.out.println("Constructor Test...");
	}
	
	@Test
	void taskNameUpdateTestLength() {
		Task task = new Task();
		assertThrows(IllegalArgumentException.class, () -> task.updateTaskName(taskNameLong));
		System.out.println("Name Length Test...");
	}

}
