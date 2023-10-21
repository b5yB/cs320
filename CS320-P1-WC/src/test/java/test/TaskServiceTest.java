package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.Task;
import service.TaskService;

class TaskServiceTest {

	//initializes class level TaskService object
	TaskService tServ = new TaskService();
	
	@Test
	void addTaskTest() {
		Task task = new Task("1", "name", "description");
		Task task2 = new Task("1", "name2", "description2");
		//adds task by unique id
		assertTrue(tServ.addTask(task).get("1").equals(task));
		//does not add task by non-unique id
		assertEquals(task, tServ.addTask(task2).get("1"));
	}
	
	@Test
	void deleteTaskTest() {
		Task task = new Task("1", "name", "description");
		tServ.addTask(task);
		//deletes task by id
		assertEquals(null, tServ.deleteTask("1").get("1"));
	}
	
	@Test
	void updateTaskTest() {
		Task task = new Task("1", "name", "description");
		Task task2 = new Task("1", "name2", "description2");
		tServ.addTask(task);
		//updates task by id
		assertEquals(task2, tServ.updateTask(task2).get("1"));	
	}
	
	@Test
	void unmodifiableTest() {
		Task task = new Task("1", "name", "description");
		//initialize exception objects from service methods
		Exception addException = assertThrows(UnsupportedOperationException.class, () -> {
			tServ.addTask(task).clear();
		});
		Exception deleteException = assertThrows(UnsupportedOperationException.class, () -> {
			tServ.deleteTask("1").clear();
		});
		Exception updateException = assertThrows(UnsupportedOperationException.class, () -> {
			tServ.updateTask(task).clear();
		});
		//throws UnsupportedOperationException when trying to modify returned unmodifiableMap 
		assertTrue(addException.toString().contains("UnsupportedOperationException"));
		assertTrue(deleteException.toString().contains("UnsupportedOperationException"));
		assertTrue(updateException.toString().contains("UnsupportedOperationException"));
	}
}
