package org.ogorodin.services;

import org.ogorodin.entity.Users;
import org.ogorodin.entity.helpers.UserDTO;
import org.ogorodin.services.web.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DTOService implements IDtoService {

	@Autowired
	private IUsersService _usersService;

	private UserDTO _userDto;

	public UserDTO getUserDTO() {
		return this._userDto;
	}

	@Override
	public UserDTO convertToDTO(String username) {
		_userDto = new UserDTO();
		Users user = _usersService.findUserByUsername(username);

		_userDto.setUsername(user.getUsername());
		if (user.getInfo() != null) {
			_userDto.setPassword(user.getPassword());
			_userDto.setUsername(user.getUsername());
			_userDto.setFirstName(user.getInfo().getLastName());
			_userDto.setLastName(user.getInfo().getLastName());
			_userDto.setAddress(user.getInfo().getAddress());
			_userDto.setRole(user.getRole());
		}

		_userDto.setListOfProducts(null);

		System.out.println("converted to DTO: " + _userDto.toString());

		return _userDto;
	}

}
