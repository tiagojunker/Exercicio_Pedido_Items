package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Client {
	
	protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private String name;
	private String email;
	private LocalDate birthDate;
	
	public Client() {	
	}

	public Client(String name, String email, String birthDate) {
		this.name = name;
		this.email = email;
		this.birthDate = dateFormatter(birthDate);;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthDate() {
		return formatter.format(birthDate);
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = dateFormatter(birthDate);
	}
	
	protected LocalDate dateFormatter(String date) {		
		LocalDate formatedDate = LocalDate.parse(date, formatter);
		return formatedDate;
	}
	
	
}
