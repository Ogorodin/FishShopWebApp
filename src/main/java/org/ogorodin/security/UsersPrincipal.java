package org.ogorodin.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.ogorodin.entity.helpers.UserDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public class UsersPrincipal implements UserDetails {

//	private Users _user;
	private UserDTO _userDTO;

	public UsersPrincipal(UserDTO userDTO) {
//		this._user = user;
		this._userDTO = userDTO;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		System.err.println("IN Users Principal");
		System.err.println(_userDTO);
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(_userDTO.getRole().toString());
		authorities.add(grantedAuthority);
		return authorities;
	}

	@Override
	public String getPassword() {
		return _userDTO.getPassword();
	}

	@Override
	public String getUsername() {
		return _userDTO.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
