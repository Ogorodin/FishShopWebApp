package org.ogorodin.controllers;

import org.ogorodin.entity.helpers.ProductsOrganizer;
import org.ogorodin.services.web.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired
	private IProductsService _productsService;

	private ProductsOrganizer _organizedProducts;

	@GetMapping({ "", "/", "/index", "/home" })
	public ModelAndView ModelAndView() {
		ModelAndView modelAndView = new ModelAndView();		
		modelAndView.addObject("product_list", _productsService.getAllProducts());		
		_organizedProducts = new ProductsOrganizer(_productsService.getAllProducts());
		modelAndView.addObject("organizedProducts", _organizedProducts);
		modelAndView.setViewName("index");
		return modelAndView;
	}



}
