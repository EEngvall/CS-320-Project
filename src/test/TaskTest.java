package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.Task;

class TaskTest {

	public String uniqueId;
	public String taskName;
	public String taskDescription;
	public String taskNameLong;
	public String taskDescriptionLong;
	
	
	//A SetUp method to preset the variables each test will use.
	@BeforeEach
	public void setUp() {
		uniqueId = "1234567890";
		taskName = "Test Task Name";
		taskDescription = "Task Description";
		taskNameLong = "This sentence is too long for the task.";
		taskDescriptionLong = "This sentence is too long for the task description string and should be an error.";
		System.out.println("Setting up...");
	}

	//Test for the initial constructor
	@Test
	void constructorTest() {
		Task task = new Task(uniqueId, taskName, taskDescription);
		assertAll("Task Constructor Test", 
				() -> assertEquals(taskName, task.getTaskName()),
				() -> assertEquals(taskDescription, task.getTaskDescription()));		
		System.out.println("Constructor Test...");
	}
	
	//Test to verify that the default values are not null when instantiated even without input.
	@Test
	public void updateNullTest() {
		Task task = new Task();
		assertAll("Contact Null Update",
				() -> assertNotNull(task.getTaskId()),
				() -> assertNotNull(task.getTaskName()),
				() -> assertNotNull(task.getTaskDescription()));
		System.out.println("Not null test...");
	}
	
	//Test to verify the name meets length requirements
	@Test
	void updateTaskNameLengthTest() {
		Task task = new Task();
		assertThrows(IllegalArgumentException.class, () -> task.updateTaskName(taskNameLong));
		System.out.println("Name Length Test...");
	}
	
	//Test to verify description meets length requirements. 
	@Test
	void updateTaskDescriptionLengthTest() {
		Task task = new Task();
		assertThrows(IllegalArgumentException.class, () -> task.updateTaskDescription(taskDescriptionLong));
		System.out.println("Description Length Test...");
	}

}
