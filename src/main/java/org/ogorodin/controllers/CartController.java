package org.ogorodin.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.ogorodin.entity.helpers.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {

	private ModelAndView _modelAndView = new ModelAndView("cart");

	private HashMap<Integer, Integer> _productIdAndQtyPairs = new HashMap<>();

	@GetMapping
	public ModelAndView showCart(@ModelAttribute UserDTO userDTO) {
		System.out.println("CART CONTROLLER ---> DTO object: ");
		System.out.println(userDTO.toString());
		if (userDTO != null) {
			_modelAndView.addObject("listOfProducts", userDTO.getListOfProducts());
		}
		return _modelAndView;
	}

	@GetMapping(value = "/addToCart", params = { "productId", "qtyInCart" })
	public ModelAndView addToCart(@RequestParam Integer productId, @RequestParam Integer qtyInCart) {
		if (_productIdAndQtyPairs.isEmpty() || !_productIdAndQtyPairs.containsKey(productId)) {
			_productIdAndQtyPairs.put(productId, qtyInCart);
		} else {
			_productIdAndQtyPairs.replace(productId, _productIdAndQtyPairs.get(productId) + qtyInCart);
		}

		System.out.println(_productIdAndQtyPairs);

		return new ModelAndView("redirect:/");
	}
}
