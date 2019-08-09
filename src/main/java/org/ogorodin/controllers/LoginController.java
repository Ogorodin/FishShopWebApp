package org.ogorodin.controllers;

import java.util.Scanner;

import org.ogorodin.entity.Users;
import org.ogorodin.entity.helpers.login.LoginCredentials;
import org.ogorodin.entity.helpers.login.LoginResponse;
import org.ogorodin.services.web.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.ui.Model;
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

//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public ModelAndView login(@RequestBody LoginCredentials credentials) {
//		System.err.println("Inside the controller!");
//		System.out.println(credentials.getUsername());
//		System.out.println(credentials.getPassword());
//		String username = credentials.getUsername();
//		
//		ModelAndView modelAndView = new ModelAndView();
//
//		try {
//			// find the user with the requested user-name
//			Users user = _usersService.findUserByUsername(username);
//			if (user != null) {
//				boolean isAuthenticated = BCrypt.checkpw(credentials.getPassword(), user.getPassword());
//				if (isAuthenticated) {
//					// user is found in DB and authenticated
//					System.out.println("User is authenticated as: " + user);
//					// for testing modal response
//					Scanner user_input = new Scanner(System.in);
//					System.out.println("Enter random number");
//					int i = user_input.nextInt();
//
//					modelAndView.addObject("theUser", user);
//
//				} else {
//					// user-name found but passwords don't match
//					System.err.println("Passwords don't match.");
//					modelAndView.addObject("errorMessage", "Username or password don't match.");	
//					
//				}
//
//			} else {
//				// user-name not found in database
//				System.err.println("User-name not found in database");
//				modelAndView.addObject("errorMessage", "Username or password don't match.");	
//			}
//		} catch (Exception exc) {
//			System.out.println("Can't connect to database.");
//			exc.printStackTrace();
//		}
//		return modelAndView;
//
//	}
	

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public LoginResponse login(@RequestBody LoginCredentials credentials) {
		LoginResponse loginResponse = new LoginResponse(true);
		String username = credentials.getUsername();

		try {
			// find the user with the requested user-name
			Users user = _usersService.findUserByUsername(username);
			if (user != null) {
				boolean isAuthenticated = BCrypt.checkpw(credentials.getPassword(), user.getPassword());
				if (isAuthenticated) {
					// user is found in DB and authenticated
					System.out.println("User is authenticated as: " + user);
					// for testing modal response
					Scanner user_input = new Scanner(System.in);
					System.out.println("Enter random number");
					int i = user_input.nextInt();

					loginResponse.setValidated(true);
					loginResponse.setMessage("You logged in successfully.");
					loginResponse.setUser(user);
					System.err.println("Successful login!");
					
				} else {
					// user-name found but passwords don't match
					System.out.println("Passwords don't match.");
					loginResponse.setMessage("Invalid username or password.");					
				}

			} else {
				// user-name not found in database
				loginResponse.setValidated(false);
				loginResponse.setMessage("Invalid username or password.");
			}
		} catch (Exception exc) {
			System.out.println("Can't connect to database.");
			exc.printStackTrace();
		}
		return loginResponse;

	}

}
