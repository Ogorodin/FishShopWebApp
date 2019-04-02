package org.ogorodin.services.web;

import java.util.Optional;

import org.ogorodin.entity.Users;
import org.ogorodin.entity.helpers.IEmployeeDetailsForAdmin;

public interface IUsersService {

	public Iterable<Users> getAllUsers();

	public Optional<Users> findUserById(Integer id);

	public boolean addOrUpdateUser(Users user);

	public void deleteUserById(Integer id);
	
	public Iterable<IEmployeeDetailsForAdmin> getEmployeeDetailsForAdminView();
}
