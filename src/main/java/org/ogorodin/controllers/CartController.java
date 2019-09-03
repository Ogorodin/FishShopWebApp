package org.ogorodin.controllers;

import org.ogorodin.entity.helpers.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {

	private ModelAndView _modelAndView = new ModelAndView("cart");

	@GetMapping(value = "/cart")
	public ModelAndView showCart(@ModelAttribute UserDTO userDTO) {
		System.out.println("CART CONTROLLER ---> DTO object: ");
		System.out.println(userDTO.toString());
		if (userDTO != null) {
			_modelAndView.addObject("listOfProducts", userDTO.getListOfProducts());
		}
		return _modelAndView;
	}

	public ModelAndView addToCart() {
		return _modelAndView;
	}
}
