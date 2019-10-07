package org.ogorodin.services;

import org.ogorodin.entity.helpers.dtos.ProductDTO;
import org.ogorodin.entity.helpers.dtos.UserDTO;

public interface IDtoService {
	
	public UserDTO convertUserToUserDTO(String username);
	
	public ProductDTO convertProductsToProductDto(Integer productId);

	public UserDTO getUserDTO();

}
