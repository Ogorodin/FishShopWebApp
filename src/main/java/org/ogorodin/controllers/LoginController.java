package org.ogorodin.controllers;

import org.ogorodin.entity.Users;
import org.ogorodin.entity.helpers.LoginCredentials;
import org.ogorodin.services.web.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {

	@Autowired
	private IUsersService _usersService;

	// UNDER CONSTRUCTION
	@GetMapping("/register")
	public ModelAndView registerCustomer() {
		System.err.println("IN registerCustomer() / LoginController");
		ModelAndView modelAndView = new ModelAndView("registration_form");
		return modelAndView;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(@RequestBody LoginCredentials credentials) {
		String username = credentials.getUsername();
		// find the user with the requested user-name
		try {
			Users user = _usersService.findUserByUsername(username);
			if (user != null) {
				boolean isAuthenticated = BCrypt.checkpw(credentials.getPassword(), user.getPassword());
				if (isAuthenticated) {
					// user is found in db and authenticated
					System.out.println("User found: ");
					System.out.println(user.getId() + "  " + user.getEmail() + " " + user.getPassword() + " "
							+ user.getUsername() + " " + user.getRole());

				} else {
					// passwords don't match
					System.out.println("Invalid password");
				}

			} else {
				System.out.println("No such user in db!");
			}
		} catch (Exception exc) {
			System.out.println("Can't connect to database.");
			exc.printStackTrace();
		}

	}

}
