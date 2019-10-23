package org.ogorodin.security;

import org.ogorodin.entity.helpers.dtos.UserDTO;
import org.ogorodin.repository.IUsersRepository;
import org.ogorodin.services.IDtoService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

	private IUsersRepository _usersRepository;
	private IDtoService _dtoService;

	public UserPrincipalDetailsService(IUsersRepository usersRepository, IDtoService dtoService) {
		this._usersRepository = usersRepository;
		this._dtoService = dtoService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDTO userDTO = _dtoService.convertUserToUserDTO(username);
		UsersPrincipal userPrincipal = new UsersPrincipal(userDTO);
		return userPrincipal;

	}

}
