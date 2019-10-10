package org.ogorodin.controllers;

import java.util.HashMap;

import org.ogorodin.entity.Products;
import org.ogorodin.entity.helpers.dtos.CartDTO;
import org.ogorodin.entity.helpers.dtos.ProductDTO;
import org.ogorodin.entity.helpers.dtos.UserDTO;
import org.ogorodin.services.IDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private IDtoService _dtoService;

	private ModelAndView _modelAndView = new ModelAndView("cart");

	// map of customerId and CartDTO pairs
	private HashMap<Integer, CartDTO> _allCarts = new HashMap<>();

	@GetMapping("/{id}")
	public ModelAndView showCart(@PathVariable String id, @ModelAttribute UserDTO userDTO,
			@ModelAttribute CartDTO cartDTO) {

		return _modelAndView;
	}

	@GetMapping(value = "/addToCart", params = { "productId", "qtyInCart" })
	public ModelAndView addToCart(@RequestParam int customerId, @RequestParam int productId,
			@RequestParam int qtyInCart) {

		ProductDTO productDto = _dtoService.convertProductsToProductDto(productId);

		if (_allCarts.isEmpty() || !_allCarts.containsKey(customerId)) {
			CartDTO cartDTO = new CartDTO(productId, qtyInCart);
			_allCarts.put(customerId, cartDTO);
		} else {
			CartDTO tempCartDto = _allCarts.get(customerId);
			tempCartDto.insertIntoCart(productId, qtyInCart);
			_allCarts.replace(customerId, tempCartDto);
		}

		UserDTO userDTO = _dtoService.getUserDTO();
		if (userDTO != null) {
			_modelAndView.addObject("userDTO", userDTO);
		}

		System.out.println("CUSTOMER ID: " + customerId);
		System.out.println("ALL CARTS: \n >>>>>>>>>> " + _allCarts);

		_modelAndView.setViewName("redirect:/");
		return _modelAndView;
	}

	@GetMapping("/refreshCartView")
	public ModelAndView refreshCartView(@ModelAttribute UserDTO UserDTO, @RequestParam String qty,
			@ModelAttribute HashMap<Products, Integer> productAndQtyPairs) {

		return _modelAndView;
	}

	@GetMapping("/deleteProduct")
	public ModelAndView deleteProduct(@ModelAttribute UserDTO UserDTO, @RequestParam int productId) {

		_modelAndView.setViewName("redirect:/cart");
		return _modelAndView;
	}
}
