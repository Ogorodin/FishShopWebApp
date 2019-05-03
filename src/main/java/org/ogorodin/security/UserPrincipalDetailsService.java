package org.ogorodin.security;

import org.ogorodin.entity.Users;
import org.ogorodin.repository.IUsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
	
	private IUsersRepository usersRepository;	
	
	public UserPrincipalDetailsService(IUsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = usersRepository.findByUsername(username);
		UsersPrincipal userPrincipal = new UsersPrincipal(user);
		return userPrincipal;
	}

}
