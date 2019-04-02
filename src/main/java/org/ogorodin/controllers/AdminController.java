package org.ogorodin.controllers;

import java.util.List;

import org.ogorodin.entity.helpers.Converter;
import org.ogorodin.entity.helpers.EmployeeForAdminView;
import org.ogorodin.services.web.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IUsersService _usersService;

	@GetMapping({ "", "/", "/index" })
	public ModelAndView showAdminHome() {
		ModelAndView modelAndView = new ModelAndView("admin/index.html");
		Converter converter = new Converter();
		List<EmployeeForAdminView> listOfEmployees =
				converter.convertToEmployeeForAdminView(_usersService.getEmployeeDetailsForAdminView());
		modelAndView.addObject("empDetailsList", listOfEmployees);
		return modelAndView;
	}

}
