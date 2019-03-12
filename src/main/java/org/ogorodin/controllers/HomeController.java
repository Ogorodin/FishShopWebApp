package org.ogorodin.controllers;

import java.util.ArrayList;
import java.util.List;

import org.ogorodin.entity.Products;
import org.ogorodin.entity.helpers.ProductsObj;
import org.ogorodin.services.web.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired
	IProductsService _productsService;

	private ProductsObj _productsObj;

	@GetMapping({ "", "/", "/index", "/home" })
	public ModelAndView ModelAndView() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("product_list", _productsService.getAllProducts());
		organizeProductByType();
		modelAndView.addObject("organized_list", _productsObj);

		modelAndView.setViewName("index");
		return modelAndView;
	}

	public void organizeProductByType() {
		_productsObj = new ProductsObj();
		Iterable<Products> productList = _productsService.getAllProducts();

		// organize product in major 3 categories
		List<Products> fishProducts = new ArrayList<>();
		List<Products> plantProducts = new ArrayList<>();
		List<Products> otherProducts = new ArrayList<>();
		for (Products product : productList) {
			String productType = product.getProductType().toString();
			if (productType.contains("_FISH")) {
				fishProducts.add(product);
			} else if (productType.contains("_PLANT")) {
				plantProducts.add(product);
			} else {
				otherProducts.add(product);
			}
		}
		_productsObj.setFishProducts(fishProducts);
		_productsObj.setPlantProducts(plantProducts);
		_productsObj.setOtherProducts(otherProducts);

		// organize products in sub-categories
		for (Products product : productList) {
			String type = product.getProductType().toString();
			switch (type) {
			case "FW_FISH":
				_productsObj.addFreshWaterFish();
				break;
			case "SW_FISH":
				_productsObj.addSaltWaterFish();
				break;
			case "P_FISH":
				_productsObj.addPondFish();
				break;
			case "CRAB_FISH":
				_productsObj.addCrab();
				break;
			case "FW_PLANT":
				_productsObj.addFreshWaterPlant();
				break;
			case "P_PLANT":
				_productsObj.addPondPlant();
				break;
			case "TANK":
				_productsObj.addTank();
				break;
			case "FILTER":
				_productsObj.addFilterItem();
				break;
			case "CO2":
				_productsObj.addCo2Item();
				break;
			case "FOOD":
				_productsObj.addFoodItem();
				break;

			}
		}

	}

}
