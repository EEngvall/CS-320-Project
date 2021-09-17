package main;

public class Task {

	private String taskName;
	private String taskDescription;
	private String uniqueId;
	
	private String INITIALIZED_VALUE = "DEFAULT";
	
	private int TASK_NAME_MAX_LENGTH = 20;
	private int TASK_DESCRIPTION_MAX_LENGTH = 50;
	
	public Task() {
		this.uniqueId = INITIALIZED_VALUE;
		this.taskName = INITIALIZED_VALUE;
		this.taskDescription = INITIALIZED_VALUE;
		
	}
	public Task(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public Task(String uniueId, String taskName) {
		this.uniqueId = uniueId;
		updateTaskName(taskName);
		this.taskDescription = INITIALIZED_VALUE;
	}
	public Task(String uniueId, String taskName, String taskDescription) {
		this.uniqueId = uniueId;
		updateTaskName(taskName);
		updateTaskDescription(taskDescription);
	}
	
	public void updateTaskName(String taskName) {
		if (taskName == null) {
			throw new IllegalArgumentException("Task name can not be empty.");
		} else if (taskName.length() > TASK_NAME_MAX_LENGTH) {
			throw new IllegalArgumentException("Task name can not be more than " + TASK_DESCRIPTION_MAX_LENGTH + " characters.");
		} else {
			this.taskName = taskName;
		}
	}
	public String getTaskName() {
		return this.taskName;
	}

	public void updateTaskDescription(String taskDescription) {
		if (taskDescription == null) {
			throw new IllegalArgumentException("Task name can not be null."); 
		} else if (taskDescription.length() > TASK_DESCRIPTION_MAX_LENGTH) {
			throw new IllegalArgumentException("Task description can not be more than " + TASK_DESCRIPTION_MAX_LENGTH + " charcters.");
		} else {
			this.taskDescription = taskDescription;
		}
	}
	public String getTaskDescription() {
		return this.taskDescription;
	}
	
	public String getTaskId() {
		return this.uniqueId;
	}
}