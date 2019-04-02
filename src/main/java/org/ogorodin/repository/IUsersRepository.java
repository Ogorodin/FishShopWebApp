package org.ogorodin.repository;

import org.ogorodin.entity.Users;
import org.ogorodin.entity.helpers.IEmployeeDetailsForAdmin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUsersRepository extends CrudRepository<Users, Integer> {

	@Query(nativeQuery = true, value = "SELECT users.id, user_info.first_name AS firstName, user_info.last_name AS lastName, users.email, users.username FROM users RIGHT JOIN user_info ON users.user_info_id = user_info.id WHERE users.roles = 'ROLE_EMPLOYEE'")
	Iterable<IEmployeeDetailsForAdmin> getEmployeeDetailsForAdminView();

}
