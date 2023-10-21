package model;
import java.nio.file.AccessDeniedException;
import java.time.LocalDate;

public class Appointment {

	private String id;
	private LocalDate date;
	private String description;
	
	public Appointment(String id, LocalDate date, String description) {
		if(validateId(id)){
			this.id = id;
		}
		if(validateDate(date)) {
			this.date = date;
		}
		if(validateDescription(description)) {
			this.description = description;
		}
	}
	
	public boolean validateId(String id) {
		if(id==null || id.length()>10){
			throw new IllegalArgumentException("invalid id");
		}
		else {
			return true;
		}
	}
	
	public boolean validateDate(LocalDate date) {
		if(date==null || date.isBefore(LocalDate.now())){
			throw new IllegalArgumentException("invalid date");
		}
		else {
			return true;
		}
	}
	
	public boolean validateDescription(String description) {
		if(description==null || description.length()>50){
			throw new IllegalArgumentException("invalid id");
		}
		else {
			return true;
		}
	}

	public String getId() {
		return id;
	}

	public String setId(String id)throws AccessDeniedException{
		throw new AccessDeniedException("Field not updatable");
	}

	public LocalDate getDate() {
		return date;
	}

	public boolean setDate(LocalDate date) {
		if(validateDate(date)) {
			this.date = date;
		}
		return true;
	}

	public String getDescription() {
		return description;
	}

	public boolean setDescription(String description) {
		if(validateDescription(description)) {
			this.description = description;
		}
		return true;
	}
}
