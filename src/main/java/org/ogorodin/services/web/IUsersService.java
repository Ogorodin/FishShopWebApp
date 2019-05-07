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

	public void insertEmployeeWithDetails(String firstName, String lastName, String address, String username,
			String password, String email);

	public void updateEmployeeWithDetails(int id, String firstName, String lastName, String address, String username,
			String email);

}
