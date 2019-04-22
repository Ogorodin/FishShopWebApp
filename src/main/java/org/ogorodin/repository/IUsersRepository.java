package org.ogorodin.repository;

import org.ogorodin.entity.Users;
import org.ogorodin.entity.helpers.IEmployeeDetailsForAdmin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IUsersRepository extends CrudRepository<Users, Integer> {
	
	Users findByUsername(String username);

	// this query summons all the info about the user; both from users and user_info tables
	@Query(nativeQuery = true, value = "SELECT users.id, user_info.first_name AS firstName, user_info.last_name AS lastName, user_info.address, users.email, users.username, users.password FROM users RIGHT JOIN user_info ON users.user_info_id = user_info.id WHERE users.roles = 'ROLE_EMPLOYEE'")
	Iterable<IEmployeeDetailsForAdmin> getEmployeeDetailsForAdminView();

	@Query(nativeQuery = true, value = "{call insertEmployeeWithDetails(:firstName, :lastName, :address, :username, :password, :email)}")
	void insertEmployeeWithDetails(@Param(value = "firstName") String firstName,
			@Param(value = "lastName") String lastName, @Param(value = "address") String address,
			@Param(value = "username") String username, @Param(value = "password") String password,
			@Param(value = "email") String email);

}
