package org.ogorodin.services.web;

import java.util.Optional;

import org.ogorodin.entity.Users;
import org.ogorodin.entity.helpers.IEmployeeDetailsForAdmin;
import org.ogorodin.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService implements IUsersService {

	@Autowired
	IUsersRepository _repository;

	@Override
	public Iterable<Users> getAllUsers() {
		return _repository.findAll();
	}

	@Override
	public Optional<Users> findUserById(Integer id) {
		return _repository.findById(id);
	}

	@Override
	public boolean addOrUpdateUser(Users user) {
		if (_repository.save(user) != null) {
			return true;
		} else
			return false;
	}

	@Override
	public void deleteUserById(Integer id) {
		_repository.deleteById(id);
	}

	@Override
	public Iterable<IEmployeeDetailsForAdmin> getEmployeeDetailsForAdminView() {
		return _repository.getEmployeeDetailsForAdminView();
	}

}