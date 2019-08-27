package org.ogorodin.entity.helpers;

import java.util.ArrayList;
import java.util.List;

import org.ogorodin.entity.Products;
import org.ogorodin.entity.Products.EProductType;
import org.ogorodin.entity.Users.ERole;

public class UserDTO {

	private String _username;
	private String _password;
	private String _firstName;
	private String _lastName;
	private String _address;
	private ERole _role;

	private List<Products> _listOfProducts;

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

	public List<Products> getListOfProducts() {
		if (_listOfProducts == null) {
			_listOfProducts = new ArrayList<Products>();
		}
		return _listOfProducts;
	}

	public void setListOfProducts(List<Products> listOfProducts) {
		this._listOfProducts = listOfProducts;
	}

	@Override
	public String toString() {
		return "UserDTO [_username=" + _username + ", _password=" + _password + ", _firstName=" + _firstName
				+ ", _lastName=" + _lastName + ", _address=" + _address + ", _role=" + _role + ", _listOfProducts="
				+ _listOfProducts + "]";
	}

}
