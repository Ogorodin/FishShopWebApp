package org.ogorodin.entity.helpers.login;

import org.ogorodin.entity.Users;

/*
 * This object is sent back from the LoginController to the AJAX in index.html
 */
public class LoginResponse {

	private Users _user;
	private boolean _validated;
	private boolean _attemptedLogin;
	private String _errorMessage;	

	public LoginResponse(boolean attemptedLogin) {
		this._attemptedLogin = attemptedLogin;
	}

	public Users getUser() {
		return _user;
	}

	public void setUser(Users user) {
		this._user = user;
	}

	public boolean isValidated() {
		return _validated;
	}

	public void setValidated(boolean validated) {
		this._validated = validated;
	}

	public boolean isAttemptedLogin() {
		return _attemptedLogin;
	}

	public void setAttemptedLogin(boolean attemptedLogin) {
		this._attemptedLogin = attemptedLogin;
	}

	public String getErrorMessage() {
		return _errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this._errorMessage = errorMessage;
	}

}
