package model;

import java.nio.file.AccessDeniedException;

public class Task {
	
	private String taskId;
	private String name;
	private String description;
		
	public Task(String taskId, String name, String description) {
		if(validateId(taskId)) {
			this.taskId = taskId;
		}
		if(validateName(name)) {
			this.name = name;
		}
		if(validateDescription(description)) {
			this.description = description;
		}
	}
	
	public boolean validateId (String taskId) {
		if(taskId == null || taskId.length()>10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		else {
			return true;
		}
	}
	
	public boolean validateName (String name) {
		if (name == null || name.length()>20) {
			throw new IllegalArgumentException("Invalid Name");
		}
		else {
			return true;
		}
	}
	
	public boolean validateDescription (String description) {
		if (description == null || description.length()>50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		else {
			return true;
		}
	}
	
	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) throws AccessDeniedException {
		throw new AccessDeniedException("Field not updatable");
	}

	public String getName() {
		return name;
	}

	public boolean setName(String name) {
		if (validateName(name)){
			this.name = name;
		}
		return true;
	}

	public String getDescription() {
		return description;
	}

	public boolean setDescription(String description) {
		if (validateDescription(description)){
			this.description = description;
		}
		return true;
	}		
}
