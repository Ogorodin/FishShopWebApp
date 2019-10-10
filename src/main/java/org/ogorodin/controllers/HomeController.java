package org.ogorodin.controllers;

import java.util.List;

import org.ogorodin.entity.helpers.Converter;
import org.ogorodin.entity.helpers.ProductForHomeView;
import org.ogorodin.entity.helpers.ProductsOrganizer;
import org.ogorodin.entity.helpers.dtos.UserDTO;
import org.ogorodin.services.IDtoService;
import org.ogorodin.services.web.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired
	private IProductsService _productsService;
	@Autowired
	private IDtoService _dtoService;

	private ModelAndView _modelAndView = new ModelAndView("index");

	@GetMapping({ "", "/", "/index", "/home" })
	public ModelAndView showHomePage() {

		Converter converter = new Converter();
		List<ProductForHomeView> listOfProducts = converter
				.convertToProductForHomeView(_productsService.getProductsInfoForTheHomePage());

		ProductsOrganizer organizedProducts = new ProductsOrganizer(listOfProducts);
		_modelAndView.addObject("organizedProducts", organizedProducts);

		// pagination part // UNDER CONSTRUCTION // got stuck
		PagedListHolder<ProductForHomeView> fishPagedList = new PagedListHolder<>(
				(List<ProductForHomeView>) organizedProducts.fishProducts);
		fishPagedList.setPageSize(3);
		PagedListHolder<ProductForHomeView> plantsPagedList = new PagedListHolder<>(
				(List<ProductForHomeView>) organizedProducts.plantProducts);
		plantsPagedList.setPageSize(3);
		PagedListHolder<ProductForHomeView> otherPagedList = new PagedListHolder<>(
				(List<ProductForHomeView>) organizedProducts.otherProducts);
		otherPagedList.setPageSize(3);
		_modelAndView.addObject("maxFishes", fishPagedList.getPageCount());
		_modelAndView.addObject("maxPlants", plantsPagedList.getPageCount());
		_modelAndView.addObject("maxOther", otherPagedList.getPageCount());

		UserDTO userDTO = _dtoService.getUserDTO();
		if (userDTO != null) {
			_modelAndView.addObject("userDTO", userDTO);
		}

		return _modelAndView;
	}

}
