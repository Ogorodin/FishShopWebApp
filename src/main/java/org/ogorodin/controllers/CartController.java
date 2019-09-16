package org.ogorodin.controllers;

import java.util.HashMap;
import java.util.List;

import org.ogorodin.entity.Products;
import org.ogorodin.entity.Stock;
import org.ogorodin.entity.helpers.dtos.ProductDTO;
import org.ogorodin.entity.helpers.dtos.UserDTO;
import org.ogorodin.services.web.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	IProductsService _productsService;

	private ModelAndView _modelAndView = new ModelAndView("cart");

	private HashMap<ProductDTO, Integer> _productIdAndQtyPairs = new HashMap<>();

	@GetMapping
	public ModelAndView showCart(@ModelAttribute UserDTO userDTO,
			@ModelAttribute HashMap<Products, Integer> productAndQtyPairs) {

		_modelAndView.addObject("productAndQtyPairs", _productIdAndQtyPairs);
		System.out.println(_productIdAndQtyPairs);

		_modelAndView.setViewName("cart");
		return _modelAndView;
	}

	@GetMapping(value = "/addToCart", params = { "productId", "qtyInCart" })
	public ModelAndView addToCart(@RequestParam int productId, @RequestParam int qtyInCart) {

		Products product = _productsService.findById(productId).orElse(null);
		//
		double productPrice = product.getStock().get(0).getPrice();
		
		//
		ProductDTO productDto = new ProductDTO();
		if (product != null) {
			productDto.setId(productId);
			productDto.setTitle(product.getTitle());
			productDto.setDescription(product.getDescription());
			productDto.setPrice(productPrice);
			productDto.setSubtotal(qtyInCart * productPrice);
		}

		if (_productIdAndQtyPairs.isEmpty()) {
			System.out.println("Map is empty >>>> first insert");
			_productIdAndQtyPairs.put(productDto, qtyInCart);
		} else {
			System.out.println("Map not empty");
			boolean productIsInCart = false;
			ProductDTO tempDto = null;
			for (ProductDTO dto : _productIdAndQtyPairs.keySet()) {
				if (dto.getId() == productId) {
					productIsInCart = true;
					tempDto = dto;
				}
			}
			if (productIsInCart) {
				System.out.println("Product already in map");
				int newQty = (_productIdAndQtyPairs.get(tempDto) + qtyInCart);
				tempDto.setSubtotal(newQty * productDto.getPrice());
				_productIdAndQtyPairs.put(tempDto, newQty);
				
			} else {
				_productIdAndQtyPairs.put(productDto, qtyInCart);
			}
		}

		System.out.println("STATE OF THE MAP >>>>");
		System.out.println(_productIdAndQtyPairs);

		_modelAndView.addObject("productIdAndQtyPairs", _productIdAndQtyPairs);

		_modelAndView.setViewName("redirect:/");
		return _modelAndView;
	}
}
