package org.ogorodin.entity.helpers.dtos;

import org.ogorodin.entity.Users.ERole;

public class UserDTO {

	private int _id;
	private String _username;
	private String _password;
	private String _firstName;
	private String _lastName;
	private String _address;
	private ERole _role;
	private CartDTO _cartDTO;

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		this._id = id;
	}

	public String getUsername() {
		return _username;
	}

	public void setUsername(String username) {
		this._username = username;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		this._password = password;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		this._firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		this._lastName = lastName;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		this._address = address;
	}

	public ERole getRole() {
		return _role;
	}

	public void setRole(ERole role) {
		this._role = role;
	}

	public CartDTO getCartDTO() {
		return _cartDTO;
	}

	public void setCartDTO(CartDTO cartDTO) {
		this._cartDTO = cartDTO;
	}

	@Override
	public String toString() {
		return "UserDTO [_id=" + _id + ", _username=" + _username + ", _password=" + _password + ", _firstName="
				+ _firstName + ", _lastName=" + _lastName + ", _address=" + _address + ", _role=" + _role
				+ ", _cartDTO=" + _cartDTO + "]";
	}

}
