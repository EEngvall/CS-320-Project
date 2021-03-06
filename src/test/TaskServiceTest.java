package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.TaskService;
import main.Task;

public class TaskServiceTest {

	private TaskService taskService;
	
	@BeforeEach
	void setup() {
		taskService = new TaskService();
	}
	
	@Test
	void testAddTaskSuccess() {
		Task task = new Task("123456", "Task Name", "Task Description");
		assertTrue(taskService.addTask(task));
		
		Task getTask = taskService.getTask("123456");
		
		assertTrue(getTask != null);
		assertTrue(getTask.getTaskId().equals("123456"));
		assertTrue(getTask.getTaskName().equals("Task Name"));
		assertTrue(getTask.getTaskDescription().equals("Task Description"));
	}
	
	@Test
	void testAddMultipleTasksSuccess() {
		Task task1 = new Task("123456", "Task Name1", "Task Description1");
		Task task2 = new Task("789012", "Task Name2", "Task Description2");
		
		assertTrue(taskService.addTask(task1));
		assertTrue(taskService.addTask(task2));
	}
//	
	@Test
	void testAddDuplicateIdFail() {
		Task task1 = new Task("123456", "Task Name1", "Task Description1");
		Task task2 = new Task("123456", "Task Name2", "Task Description2");
		
		assertTrue(taskService.addTask(task1));
		assertFalse(taskService.addTask(task2));
	}
	
	@Test
	void testGetTaskAndUpdateSuccess() {
		Task task1 = new Task("123456", "Task Name1", "Task Description1");

		assertTrue(taskService.addTask(task1));
		Task updateTask = taskService.getTask(task1.getTaskId());
		
		updateTask.setTasktName("New Task Name");
		updateTask = taskService.getTask(updateTask.getTaskId());
		assertTrue(updateTask.getTaskName().equals("New Task Name"));
	}
	
	@Test
	void testGetTaskAndDeleteSuccess() {
		Task task1 = new Task("123456", "Task Name1", "Task Description1");
		assertTrue(taskService.addTask(task1));
		
		Task task2 = taskService.getTask(task1.getTaskId());
		assertTrue(taskService.deleteTask(task2.getTaskId()));
		
		assertTrue(taskService.getTask(task2.getTaskId()) == null);
		
	}
	
	@Test
	void testDeleteInvalidTaskFail() {
		String invalidContactId = "1";

		assertFalse(taskService.deleteTask(invalidContactId));
	}

}
