package org.ogorodin.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.ogorodin.entity.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public class UsersPrincipal implements UserDetails {

	private Users _user;

	public UsersPrincipal(Users user) {
		this._user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(_user.getRole().toString());
		authorities.add(grantedAuthority);
		return authorities;
	}

	@Override
	public String getPassword() {
		return _user.getPassword();
	}

	@Override
	public String getUsername() {
		return _user.getUsername();
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
