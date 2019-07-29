package org.ogorodin.controllers;

import java.util.Date;

import org.ogorodin.entity.helpers.LoginCredentials;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {

	// UNDER CONSTRUCTION
	@GetMapping("/register")
	public ModelAndView registerCustomer() {
		System.err.println("IN registerCustomer() / LoginController");
		ModelAndView modelAndView = new ModelAndView("registration_form");
		return modelAndView;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(@RequestBody LoginCredentials credentials) {
		System.err.println("In login() / LoginController");
		String username = credentials.getUsername();
		String password = credentials.getPassword();
		System.out.println("User: " + username + "\nPass: " + password);
		System.out.println("Date: " + new Date().toString());

	}

}
