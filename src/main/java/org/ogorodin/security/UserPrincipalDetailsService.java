package org.ogorodin.security;

import org.ogorodin.entity.helpers.UserDTO;
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
		System.err.println("In loadUserByUsername - user principal details service");
		// Users user = _usersRepository.findByUsername(username);
		UserDTO userDTO = _dtoService.convertToDTO(username);
		System.err.println(userDTO);
		System.err.println("In userPrincipalDetailsSerrvice.java");
		UsersPrincipal userPrincipal = new UsersPrincipal(userDTO);
		return userPrincipal;

	}

}
