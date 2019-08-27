package org.ogorodin.services;

import org.ogorodin.entity.helpers.UserDTO;
import org.springframework.stereotype.Service;

public interface IDtoService {
	
	public UserDTO convertToDTO(String username);

}
