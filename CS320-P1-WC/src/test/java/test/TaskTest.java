package test;

import static org.junit.jupiter.api.Assertions.*;
import java.nio.file.AccessDeniedException;
import org.junit.jupiter.api.Test;
import model.Task;

class TaskTest {

	@Test
	void constructorTest() {
		//initializes task object
		Task task = new Task("0", "name", "description");
		//all values match
		assertTrue(task.getTaskId().equals("0"));
		assertTrue(task.getName().equals("name"));
		assertTrue(task.getDescription().equals("description"));
	}
	
	@Test
	void settersTest() {
		Task task = new Task("0", "name", "description");
		//does update task object fields
		assertTrue(task.setName("test"));
		assertTrue(task.setDescription("test"));

	}
	
	@Test
	void idTest() {
		Task task = new Task("0", "name", "description");
		//does not add task with id > 10 characters
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345678901", "name", "description");
		});
		//does not add task with null id
		assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "name", "description");
		});
		//does not update task id
		assertThrows(AccessDeniedException.class, () -> {
			task.setTaskId("1");
		});
	}

	
	@Test
	void nameTest() {
		Task task = new Task("0", "name", "description");
		//does not add task with name > 20 characters
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("0", "morethantwentycharacters", "description");
		});
		//does not add task with null name 
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("0", null, "description");
		});
		//does not update task to name > 20 characters
		assertThrows(IllegalArgumentException.class, () -> {
			task.setName("morethantwentycharacters");
		});
		//does not update task to null name
		assertThrows(IllegalArgumentException.class, () -> {
			task.setName(null);
		});
	}
	
	
	@Test
	void descriptionTest() {
		Task task = new Task("0", "name", "description");
		//does not add task with description > 50 characters
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("0", "name", "longerthanfiftycharacters+longerthanfiftycharacters");
		});
		//does not add task with null description
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("0", "name", null);
		});
		//does not update task to description > 20 characters
		assertThrows(IllegalArgumentException.class, () -> {
			task.setDescription("longerthanfiftycharacters+longerthanfiftycharacters");
		});
		//does not update task to null description
		assertThrows(IllegalArgumentException.class, () -> {
			task.setDescription(null);
		});
	}
	
	
}
