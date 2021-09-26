package main;

public class Task {

	private String taskName;
	private String taskDescription;
	private String taskId;	
	private int TASK_NAME_MAX_LENGTH = 20;
	private int TASK_DESCRIPTION_MAX_LENGTH = 50;
	

	public Task(String taskId, String taskName, String taskDescription) {
		boolean isValid = validateInput(taskId, 10);
		
		if (isValid) {
			this.taskId = taskId;
		}
		
		isValid = isValid && setTasktName(taskName);
		isValid = isValid && setTaskDescription(taskDescription);
		
		if(!isValid) {
			throw new IllegalArgumentException("Invalid input");
		}
	}

	public boolean setTasktName(String taskName) {
		boolean isValid = validateInput(taskName, TASK_NAME_MAX_LENGTH);
		
		if(isValid) {
			this.taskName = taskName;
		}
		return isValid;
	}
	
	public boolean setTaskDescription(String taskDescription) {
		boolean isValid = validateInput(taskDescription, TASK_DESCRIPTION_MAX_LENGTH);
		
		if(isValid) {
			this.taskDescription = taskDescription;
		}
		return isValid;
	}
	
	
	public String getTaskName() {
		return this.taskName;
	}

	
	public String getTaskDescription() {
		return this.taskDescription;
	}
	
	public String getTaskId() {
		return this.taskId;
	}
	
	private boolean validateInput(String item, int length) {
		return (item != null && item.length() <= length);
	}
}

