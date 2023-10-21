package service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import model.Task;

public class TaskService {
	
	private Map<String, Task> tasks = new HashMap<String, Task>();
		
	public Map<String, Task> addTask (Task task){
		tasks.putIfAbsent(task.getTaskId(), task);
		Map<String, Task> tasksCopy = Collections.unmodifiableMap(tasks);
		return tasksCopy;
	}
		
	public Map<String, Task> deleteTask (String key){
		tasks.remove(key);
		Map<String, Task> tasksCopy = Collections.unmodifiableMap(tasks);
		return tasksCopy;
	}
		
	public Map<String, Task> updateTask (Task task){
		tasks.replace(task.getTaskId(), task);
		Map<String, Task> tasksCopy = Collections.unmodifiableMap(tasks);
		return tasksCopy;
	}	
}
