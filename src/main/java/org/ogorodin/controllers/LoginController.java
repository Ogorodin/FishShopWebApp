package org.ogorodin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	// UNDER CONSTRUCTION
	@GetMapping("/register")
	public ModelAndView registerCustomer() {
		System.err.println("IN registerCustomer() / LoginController");
		ModelAndView modelAndView = new ModelAndView("registration_form");
		return modelAndView;
	}

	@PostMapping("/login")
	public ModelAndView login() {
		System.err.println("In login() / LoginController");
		ModelAndView modelAndView = new ModelAndView("index");

		return modelAndView;

	}

}
