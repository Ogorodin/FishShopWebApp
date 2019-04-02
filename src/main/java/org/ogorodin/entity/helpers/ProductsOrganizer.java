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

	public List<ProductForHomeView> fishProducts;
	public List<ProductForHomeView> plantProducts;
	public List<ProductForHomeView> otherProducts;

	public int numOfFreshWaterFish;
	public int numOfSaltWaterFish;
	public int numOfPondFish;
	public int numOfCrabs;

	public int numOfFreshWaterPlants;
	public int numOfPondPlants;

	public int numOfTanks;
	public int numOfCo2Items;
	public int numOfFoodItems;
	public int numOfFilterItems;

	public ProductsOrganizer(Iterable<IProductHomePageSummary> products) {
		convertToProductForHomeView(products);

		fishProducts = new ArrayList<>();
		plantProducts = new ArrayList<>();
		otherProducts = new ArrayList<>();
		organizeProductsInCategories();
		
	}	

	public List<ProductForHomeView> get_productsForHomeView() {
		return _productsForHomeView;
	}

	// convenience method for converting IProductHomePageSummary to
	// ProductForHomeView
	public void convertToProductForHomeView(Iterable<IProductHomePageSummary> products) {
		for (IProductHomePageSummary p : products) {
			_productsForHomeView.add(
					new ProductForHomeView(p.getId(), p.getTitle(), p.getProductType(), p.getPrice(), p.getQuantity()));
		}
	}

	public void organizeProductsInCategories() {
		for (ProductForHomeView product : _productsForHomeView) {
			switch (product.getProductType()) {
			case FW_FISH:
				fishProducts.add(product);
				numOfFreshWaterFish += 1;
				break;
			case SW_FISH:
				fishProducts.add(product);
				numOfSaltWaterFish += 1;
				break;
			case CRAB_FISH:
				fishProducts.add(product);
				numOfCrabs += 1;
				break;
			case P_FISH:
				fishProducts.add(product);
				numOfPondFish += 1;
				break;
			case FW_PLANT:
				plantProducts.add(product);
				numOfFreshWaterPlants += 1;
				break;
			case P_PLANT:
				plantProducts.add(product);
				numOfPondPlants += 1;
				break;
			case TANK:
				otherProducts.add(product);
				numOfTanks += 1;
				break;
			case FILTER:
				otherProducts.add(product);
				numOfFilterItems += 1;
				break;
			case CO2:
				otherProducts.add(product);
				numOfCo2Items += 1;
				break;
			case FOOD:
				otherProducts.add(product);
				numOfFoodItems += 1;
				break;
			}
		}
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