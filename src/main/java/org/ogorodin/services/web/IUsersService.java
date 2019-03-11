package org.ogorodin.services.web;

import java.util.Optional;

import org.ogorodin.entity.Users;

public interface IUsersService {

	public Iterable<Users> getAllUsers();

	public Optional<Users> findUserById(Integer id);

	public boolean addOrUpdateUser(Users user);

	public void deleteUserById(Integer id);
}
