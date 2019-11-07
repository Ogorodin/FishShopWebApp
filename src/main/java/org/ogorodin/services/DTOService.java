package org.ogorodin.services;

import org.ogorodin.entity.Products;
import org.ogorodin.entity.Stock;
import org.ogorodin.entity.Users;
import org.ogorodin.entity.helpers.dtos.ProductDTO;
import org.ogorodin.entity.helpers.dtos.UserDTO;
import org.ogorodin.services.web.IProductsService;
import org.ogorodin.services.web.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DTOService implements IDtoService {

	@Autowired
	private IUsersService _usersService;
	@Autowired
	private IProductsService _productsService;

	private UserDTO _userDto;

	@Override
	public UserDTO getUserDTO() {
		return this._userDto;
	}

	@Override
	public UserDTO convertUserToUserDTO(String username) {
		_userDto = new UserDTO();
		Users user = _usersService.findUserByUsername(username);

		_userDto.setUsername(user.getUsername());
		if (user.getInfo() != null) {
			_userDto.setId(user.getId());
			_userDto.setPassword(user.getPassword());
			_userDto.setFirstName(user.getInfo().getFirstName());
			_userDto.setLastName(user.getInfo().getLastName());
			_userDto.setAddress(user.getInfo().getAddress());
			_userDto.setEmail(user.getEmail());
			_userDto.setRole(user.getRole());
		}
		return _userDto;
	}

	@Override
	public ProductDTO convertProductsToProductDto(Integer productId) {
		ProductDTO productDto = new ProductDTO();
		Products product = _productsService.findById(productId).orElse(null);
		if (product != null) {
			productDto.setId(product.getId());
			productDto.setTitle(product.getTitle());
			productDto.setDescription(product.getDescription());
			for (Stock stock : product.getStock()) {
				productDto.setPrice(stock.getPrice());
				productDto.setStock(stock.getQuantity());
			}
		}
		return productDto;
	}

}
