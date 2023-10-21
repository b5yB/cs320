package test;

import static org.junit.jupiter.api.Assertions.*;
import java.nio.file.AccessDeniedException;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import model.Appointment;

class AppointmentTest {
	
	//Initialize class-level date value
	private LocalDate date = LocalDate.now();

	@Test
	void appointmentConstructorTest() {
		//initialize appointment object
		Appointment appointment = new Appointment("0", date, "description");
		//all values match
		assertTrue(appointment.getId().equals("0"));
		assertTrue(appointment.getDate().equals(date));
		assertTrue(appointment.getDescription().equals("description"));
	}
	
	@Test
	void settersTest() {
		Appointment appointment = new Appointment("0", date, "description");
		//does update appointment object fields
		assertTrue(appointment.setDate(date.plusDays(1)));
		assertTrue(appointment.setDescription("test"));

	}
	
	@Test
	void IdTest() {
		Appointment appointment = new Appointment("0", date, "description");
		//does not add Appointment with id > 10 characters
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345678901", date, "description");
		});
		//does not add Appointment with null id
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, date, "description");
		});
		//does not update Appointment id
		assertThrows(AccessDeniedException.class, () -> {
			appointment.setId("1");
		});
	}

	@Test
	void dateTest() {
		Appointment appointment = new Appointment("0", date, "description");
			
		//does not add Appointment with null date 
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("0", null, "description");
		});
		//does not add Appointment with date in the past
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("0", date.minusDays(1), "description");
		});
		//does not update Appointment to null date
		assertThrows(IllegalArgumentException.class, () -> {
			appointment.setDate(null);
		});
		//does not update Appointment to date in the past
		assertThrows(IllegalArgumentException.class, () -> {
			appointment.setDate(date.minusDays(1));
		});
	}
	
	@Test
	void DescriptionTest() {
		Appointment Appointment = new Appointment("0", date, "description");
		//does not add Appointment with description > 50 characters
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("0", date, "longerthanfiftycharacters+longerthanfiftycharacters");
		});
		//does not add Appointment with null description
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("0", date, null);
		});
		//does not update Appointment to description > 50 characters
		assertThrows(IllegalArgumentException.class, () -> {
			Appointment.setDescription("longerthanfiftycharacters+longerthanfiftycharacters");
		});
		//does not update Appointment to null description
		assertThrows(IllegalArgumentException.class, () -> {
			Appointment.setDescription(null);
		});
	}
}
