package org.ogorodin.controllers;

import java.util.List;

import org.ogorodin.entity.helpers.Converter;
import org.ogorodin.entity.helpers.EmployeeDetails;
import org.ogorodin.entity.helpers.EmployeeForAdminView;
import org.ogorodin.entity.helpers.ProductForAdminView;
import org.ogorodin.services.web.IProductsService;
import org.ogorodin.services.web.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IUsersService _usersService;
	@Autowired
	private IProductsService _productsService;

	@GetMapping({ "", "/", "/index" })
	public ModelAndView showAdminHome() {
		ModelAndView modelAndView = new ModelAndView("admin/index.html");
		Converter converter = new Converter();
		List<EmployeeForAdminView> listOfEmployees = converter
				.convertToEmployeeForAdminView(_usersService.getEmployeeDetailsForAdminView());
		modelAndView.addObject("empDetailsList", listOfEmployees);
		List<ProductForAdminView> listOfProducts = converter
				.convertToProductForAdminView(_productsService.getProductDetailsForAdminView());
		modelAndView.addObject("productDetailsList", listOfProducts);
		modelAndView.addObject("employeeDetailsObj", new EmployeeDetails());
		return modelAndView;
	}

	@PostMapping("/processForm")
	public RedirectView processForm(@ModelAttribute EmployeeDetails employeeDetails) {
		System.err.println(employeeDetails);
		return new RedirectView("/admin");
	}

}
