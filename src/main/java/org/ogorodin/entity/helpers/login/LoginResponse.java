package org.ogorodin.entity.helpers.login;

import org.springframework.security.core.userdetails.UserDetails;

/*
 * This object is sent back from the LoginController to the AJAX in index.html
 */
public class LoginResponse {

	private UserDetails _userDetails;
	private boolean _validated;
	private boolean _attemptedLogin;
	private String _message;

	public LoginResponse(boolean attemptedLogin) {
		this._attemptedLogin = attemptedLogin;
	}

	public UserDetails get_userDetails() {
		return _userDetails;
	}

	public void set_userDetails(UserDetails _userDetails) {
		this._userDetails = _userDetails;
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

	public String getMessage() {
		return _message;
	}

	public void setMessage(String message) {
		this._message = message;
	}

}
