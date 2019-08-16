package org.ogorodin.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

	@GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}

}
