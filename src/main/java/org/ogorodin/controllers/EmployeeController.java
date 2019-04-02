package org.ogorodin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

	@GetMapping({ "", "/", "/index" })
	public ModelAndView showEmployeeHome() {
		ModelAndView modelAndView = new ModelAndView("employee/index.html");
		return modelAndView;
	}

}
