package org.ogorodin.controllers;

import java.util.List;

import org.ogorodin.entity.Products;
import org.ogorodin.entity.helpers.ProductForHomeView;
import org.ogorodin.entity.helpers.IProductHomePageSummary;
import org.ogorodin.entity.helpers.ProductsOrganizer;
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

	private ProductsOrganizer _organizedProducts;

	@GetMapping({ "", "/", "/index", "/home" })
	public ModelAndView ModelAndView() {
		ModelAndView modelAndView = new ModelAndView();

		Iterable<IProductHomePageSummary> productListForHomePage = _productsService.getProductsInfoForTheHomePage();
		_organizedProducts = new ProductsOrganizer(productListForHomePage);
		modelAndView.addObject("organizedProducts", _organizedProducts);

		// pagination part // NOT CLOSE TO BE DONE...
		PagedListHolder<ProductForHomeView> fishPagedList = new PagedListHolder<>(
				(List<ProductForHomeView>) _organizedProducts.fishProducts);
		fishPagedList.setPageSize(3);
		PagedListHolder<ProductForHomeView> plantsPagedList = new PagedListHolder<>(
				(List<ProductForHomeView>) _organizedProducts.plantProducts);
		plantsPagedList.setPageSize(3);
		PagedListHolder<ProductForHomeView> otherPagedList = new PagedListHolder<>(
				(List<ProductForHomeView>) _organizedProducts.otherProducts);
		otherPagedList.setPageSize(3);
		modelAndView.addObject("maxFishes", fishPagedList.getPageCount());
		modelAndView.addObject("maxPlants", plantsPagedList.getPageCount());
		modelAndView.addObject("maxOther", otherPagedList.getPageCount());

		modelAndView.setViewName("index");
		return modelAndView;
	}

}
