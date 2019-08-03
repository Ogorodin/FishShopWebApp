package org.ogorodin.security;

import org.ogorodin.entity.Users;
import org.ogorodin.repository.IUsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
	
	private IUsersRepository _usersRepository;	
	
	public UserPrincipalDetailsService(IUsersRepository usersRepository) {
		this._usersRepository = usersRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("In loaduserbyusername - user principal details service");
		Users user = _usersRepository.findByUsername(username);
		System.err.println("In userPrincipalDetailsSerrvice.java");
		System.out.println(user.getUsername());
		System.out.println(user.getEmail());
		UsersPrincipal userPrincipal = new UsersPrincipal(user);
		return userPrincipal;
	}

}
