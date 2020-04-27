package org.ogorodin.entity.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.ogorodin.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class ProductsOrganizer {

	private List<ProductForHomeView> _productsForHomeView = new ArrayList<>();

	// trying to tidy up code on index.html
	private List<List<ProductForHomeView>> _listOfProducts = new ArrayList<>();

	public List<ProductForHomeView> _fishProducts;
	public List<ProductForHomeView> _plantProducts;
	public List<ProductForHomeView> _otherProducts;

	public int _numOfFreshWaterFish;
	public int _numOfSaltWaterFish;
	public int _numOfPondFish;
	public int _numOfCrabs;

	public int _numOfFreshWaterPlants;
	public int _numOfPondPlants;

	public int _numOfTanks;
	public int _numOfCo2Items;
	public int _numOfFoodItems;
	public int _numOfFilterItems;

	public ProductsOrganizer(List<ProductForHomeView> products) {
		this._productsForHomeView = products;
		_fishProducts = new ArrayList<>();
		_plantProducts = new ArrayList<>();
		_otherProducts = new ArrayList<>();
		organizeProductsInCategories();
	}

	public List<ProductForHomeView> getProductsForHomeView() {
		return _productsForHomeView;
	}	

	public List<List<ProductForHomeView>> getListOfProducts() {
		return _listOfProducts;
	}

	public void organizeProductsInCategories() {
		for (ProductForHomeView product : _productsForHomeView) {
			switch (product.getProductType()) {
			case FW_FISH:
				_fishProducts.add(product);
				_numOfFreshWaterFish += 1;
				break;
			case SW_FISH:
				_fishProducts.add(product);
				_numOfSaltWaterFish += 1;
				break;
			case CRAB_FISH:
				_fishProducts.add(product);
				_numOfCrabs += 1;
				break;
			case P_FISH:
				_fishProducts.add(product);
				_numOfPondFish += 1;
				break;
			case FW_PLANT:
				_plantProducts.add(product);
				_numOfFreshWaterPlants += 1;
				break;
			case P_PLANT:
				_plantProducts.add(product);
				_numOfPondPlants += 1;
				break;
			case TANK:
				_otherProducts.add(product);
				_numOfTanks += 1;
				break;
			case FILTER:
				_otherProducts.add(product);
				_numOfFilterItems += 1;
				break;
			case CO2:
				_otherProducts.add(product);
				_numOfCo2Items += 1;
				break;
			case FOOD:
				_otherProducts.add(product);
				_numOfFoodItems += 1;
				break;
			}
		}
		this._listOfProducts.add(this._fishProducts);
		this._listOfProducts.add(this._plantProducts);
		this._listOfProducts.add(this._otherProducts);
	}

	// PAGINATION // NOT DONE // RESEARCH
	public Page<Products> findPaginated(Pageable pageable, List<Products> productsList) {
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<Products> list;

		if (productsList.size() < startItem) {
			list = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, productsList.size());
			list = productsList.subList(startItem, toIndex);
		}

		Page<Products> productPage = new PageImpl<Products>(list, PageRequest.of(currentPage, pageSize),
				productsList.size());

		return productPage;
	}

}
