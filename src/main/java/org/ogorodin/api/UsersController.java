package org.ogorodin.api;

import java.util.Optional;

import org.ogorodin.entity.Users;
import org.ogorodin.services.web.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UsersController {

	@Autowired
	private IUsersService _usersService;

	@GetMapping("/users")
	public Iterable<Users> getAllUsers() {
		return _usersService.getAllUsers();
	}

	@GetMapping("/users/{userId}")
	public Optional<Users> getUserById(@PathVariable String userId) {
		return _usersService.findUserById(Integer.parseInt(userId));
	}

	@PostMapping("/users")
	public boolean insertUser(@RequestBody Users user) {
		return _usersService.addOrUpdateUser(user);
	}

	@PutMapping("/users/{userId}")
	public boolean updateUser(@RequestBody Users user, @PathVariable String userId) {
		if (_usersService.findUserById(Integer.parseInt(userId)).isPresent()) {
			return _usersService.addOrUpdateUser(user);
		} else
			return false;
	}

}
