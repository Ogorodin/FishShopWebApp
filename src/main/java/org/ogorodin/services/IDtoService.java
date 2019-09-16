package org.ogorodin.services;

import org.ogorodin.entity.helpers.dtos.UserDTO;

public interface IDtoService {
	
	public UserDTO convertToUserDTO(String username);

}
