package org.ogorodin.repository;

import org.ogorodin.entity.Users;
import org.springframework.data.repository.CrudRepository;

public interface IUsersRepository extends CrudRepository<Users, Integer> {

}
