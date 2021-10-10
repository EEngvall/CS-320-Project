package main;

import java.util.HashMap;
import java.util.Map;

public class TaskService {

	
	private final Map<String, Task> taskList;
	
	
	public TaskService() {
		this.taskList = new HashMap<String, Task>();
	}
	
	
	public boolean addTask(Task task) {
		boolean isSuccess = false;
		
		if(!taskList.containsKey(task.getTaskId())) {
			taskList.put(task.getTaskId(), task);
			isSuccess = true;
		}
		return isSuccess;
	}
	
	public boolean deleteTask(String taskId) {
		return taskList.remove(taskId) != null;
	}
	
	public Task getTask(String taskId) {
		return taskList.get(taskId);
	}
	
	
	
	
	
	
	
	
	
}
