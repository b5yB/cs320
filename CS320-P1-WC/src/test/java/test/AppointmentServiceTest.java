package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import model.Appointment;
import service.AppointmentService;

class AppointmentServiceTest {

	//initializes class level AppointmentService object
	private AppointmentService aServ = new AppointmentService();
	//Initialize class-level date value
	private LocalDate date = LocalDate.now();
	
	@Test
	void addAppointmentTest() {
		Appointment appointment = new Appointment("1", date, "description");
		Appointment appointment2 = new Appointment("1", date, "description");
		//adds appointment by unique id
		assertTrue(aServ.addAppointment(appointment).get("1").equals(appointment));
		//does not add appointment by non-unique id
		assertEquals(appointment, aServ.addAppointment(appointment2).get("1"));
	}
		
	@Test
	void deleteAppointmentTest() {
		Appointment appointment = new Appointment("1", date, "description");
		aServ.addAppointment(appointment);
		//deletes appointment by id
		assertEquals(null, aServ.deleteAppointment("1").get("1"));
	}
	
	@Test
	void unmodifiableTest() {
		Appointment appointment = new Appointment("1", date, "description");
		//initialize exception objects from service methods
		Exception addException = assertThrows(UnsupportedOperationException.class, () -> {
			aServ.addAppointment(appointment).clear();
		});
		Exception deleteException = assertThrows(UnsupportedOperationException.class, () -> {
			aServ.deleteAppointment("1").clear();
		});
		//throws UnsupportedOperationException when trying to modify returned unmodifiableMap 
		assertTrue(addException.toString().contains("UnsupportedOperationException"));
		assertTrue(deleteException.toString().contains("UnsupportedOperationException"));
	}
}
