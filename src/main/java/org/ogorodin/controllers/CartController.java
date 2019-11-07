package org.ogorodin.controllers;

import java.util.HashMap;

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

	@RequestMapping("{customerId}")
	public ModelAndView showCart(@PathVariable String customerId) {

//		System.err.println("Customer ID: " + customerId);
		UserDTO userDto = _dtoService.getUserDTO();
		CartDTO cartDto = _allCarts.get(Integer.parseInt(customerId));

		HashMap<ProductDTO, Integer> cart = new HashMap<>();
		ProductDTO productDto = new ProductDTO();

//		System.out.println("CART DTO: \n" + cartDto + "\n>>>>>>>>>>>>>>>");
		if (cartDto != null) {
			double total = 0;
			for (int id : cartDto.getCart().keySet()) {
				productDto = _dtoService.convertProductsToProductDto(id);
				double subtotal = cartDto.getCart().get(productDto.getId()) * productDto.getPrice();
				productDto.setSubtotal(subtotal);
				total += subtotal;
				cart.put(productDto, cartDto.getCart().get(productDto.getId()));
			}
			_modelAndView.addObject("total", total);
		}

		_modelAndView.addObject("userDTO", userDto);
		_modelAndView.addObject("cart", cart);

		_modelAndView.setViewName("cart");
		return _modelAndView;
	}

	@GetMapping(value = "/addToCart", params = { "productId", "qtyInCart" })
	public ModelAndView addToCart(@RequestParam int customerId, @RequestParam int productId,
			@RequestParam int qtyInCart) {

		// ProductDTO productDto = _dtoService.convertProductsToProductDto(productId);

		if (_allCarts.isEmpty() || !_allCarts.containsKey(customerId)) {
			CartDTO cartDTO = new CartDTO(customerId, productId, qtyInCart);

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

//		System.out.println("CUSTOMER ID: " + customerId);
//		System.out.println("ALL CARTS: \n >>>>>>>>>> " + _allCarts);

		_modelAndView.setViewName("redirect:/");
		return _modelAndView;
	}

	@GetMapping("{customerId}/deleteProduct")
	public ModelAndView deleteProduct(@PathVariable String customerId, @RequestParam String productId) {
		CartDTO cartDto = _allCarts.get(Integer.parseInt(customerId));
		cartDto.getCart().remove(Integer.parseInt(productId));
		_allCarts.replace(Integer.parseInt(customerId), cartDto);
		_modelAndView.setViewName("redirect:/cart/" + customerId);
		return _modelAndView;
	}

	@RequestMapping("/{customerId}/checkout")
	public ModelAndView checkout(@ModelAttribute UserDTO userDto) {

		System.err.println("IN CHECKOUT CONTROLLER METHOD");
		System.err.println("USER DTO: >>>>>>>>>>>>>>>>\n" + userDto);

		HashMap<ProductDTO, Integer> cart = new HashMap<>();
		CartDTO cartDTO = _allCarts.get(userDto.getId());
		for (int id : cartDTO.getCart().keySet()) {
			ProductDTO productDTO = _dtoService.convertProductsToProductDto(id);
			cart.put(productDTO, cartDTO.getCart().get(productDTO.getId()));
		}

		System.err.println("CART: \n" + cart);

		_modelAndView.addObject("userDTO", userDto);
		_modelAndView.addObject("cart", cart);
		_modelAndView.setViewName("checkout");
		return _modelAndView;
	}
}
