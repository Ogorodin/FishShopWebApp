package org.ogorodin.entity.helpers;

public class EmployeeForAdminView {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String username;

	public EmployeeForAdminView(int id, String firstName, String lastName, String email, String username) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

}
