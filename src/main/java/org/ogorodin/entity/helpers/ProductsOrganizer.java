package org.ogorodin.entity.helpers;

import java.util.ArrayList;
import java.util.List;

import org.ogorodin.entity.Products;

public class ProductsOrganizer {

	private Iterable<Products> _allProducts;

	public List<Products> fishProducts;
	public List<Products> plantProducts;
	public List<Products> otherProducts;

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

	public ProductsOrganizer(Iterable<Products> allProducts) {
		this._allProducts = allProducts;
		fishProducts = new ArrayList<>();
		plantProducts = new ArrayList<>();
		otherProducts = new ArrayList<>();
		organizeProductsInCategories();
	}

	public void organizeProductsInCategories() {
		for (Products product : _allProducts) {
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

}
