package org.ogorodin.entity.helpers.login;

/*
 * This class's sole purpose is to represent the user credentials
 * sent from the login form via AJAX (/templates/index.html) call to the controller
 */
public class LoginCredentials {

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
