package org.ogorodin.services;

import java.util.ArrayList;
import java.util.List;

import org.ogorodin.entity.Products;
import org.ogorodin.entity.Users;
import org.ogorodin.entity.Products.EProductType;
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
			_userDto.setId(user.getId());
			_userDto.setPassword(user.getPassword());
			_userDto.setUsername(user.getUsername());
			_userDto.setFirstName(user.getInfo().getLastName());
			_userDto.setLastName(user.getInfo().getLastName());
			_userDto.setAddress(user.getInfo().getAddress());
			_userDto.setRole(user.getRole());
		}

		List<Products> products = new ArrayList<>();
		products.add(new Products("Some fish", "some slipery fish", EProductType.FW_FISH));
		products.add(new Products("Some crab", "some slipery crab", EProductType.CRAB_FISH));

		_userDto.setListOfProducts(products);

		System.out.println("converted to DTO: " + _userDto.toString());

		return _userDto;
	}

}
