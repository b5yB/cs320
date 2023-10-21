package service;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import model.Appointment;

public class AppointmentService {

	private Map<String, Appointment> appointments = new HashMap<String, Appointment>();
		
	public Map<String, Appointment> addAppointment (Appointment appointment){
		appointments.putIfAbsent(appointment.getId(), appointment);
		Map<String, Appointment> appointmentsCopy = Collections.unmodifiableMap(appointments);
		return appointmentsCopy;
	}
	
	public Map<String, Appointment> deleteAppointment (String key){
		appointments.remove(key);	
		Map<String, Appointment> appointmentsCopy = Collections.unmodifiableMap(appointments);
		return appointmentsCopy;
	}
}
