package org.ogorodin.entity.helpers;

import java.util.ArrayList;
import java.util.List;

import org.ogorodin.entity.Products;

public class ProductsObj {

	private List<Products> fishProducts;
	private List<Products> plantProducts;
	private List<Products> otherProducts;

	private int numOfFreshWaterFish;
	private int numOfSaltWaterFish;
	private int numOfPondFish;
	private int numOfCrabs;

	private int numOfFreshWaterPlants;
	private int numOfPondPlants;

	private int numOfTanks;
	private int numOfCo2Items;
	private int numOfFoodItems;
	private int numOfFilterItems;

	public ProductsObj() {
		fishProducts = new ArrayList<>();
		plantProducts = new ArrayList<>();
		otherProducts = new ArrayList<>();
	}

	public void setFishProducts(List<Products> fishProducts) {
		this.fishProducts = fishProducts;
	}

	public void setPlantProducts(List<Products> plantProducts) {
		this.plantProducts = plantProducts;
	}

	public void setOtherProducts(List<Products> otherProducts) {
		this.otherProducts = otherProducts;
	}

	public List<Products> getFishProducts() {
		return fishProducts;
	}

	public List<Products> getPlantProducts() {
		return plantProducts;
	}

	public List<Products> getOtherProducts() {
		return otherProducts;
	}

	public int getNumOfFreshWaterFish() {
		return numOfFreshWaterFish;
	}

	public int getNumOfSaltWaterFish() {
		return numOfSaltWaterFish;
	}

	public int getNumOfPondFish() {
		return numOfPondFish;
	}

	public int getNumOfCrabs() {
		return numOfCrabs;
	}

	public int getNumOfFreshWaterPlants() {
		return numOfFreshWaterPlants;
	}

	public int getNumOfPondPlants() {
		return numOfPondPlants;
	}

	public int getNumOfTanks() {
		return numOfTanks;
	}

	public int getNumOfCo2Items() {
		return numOfCo2Items;
	}

	public int getNumOfFoodItems() {
		return numOfFoodItems;
	}

	public int getNumOfFilterItems() {
		return numOfFilterItems;
	}

	public void addFreshWaterFish() {
		numOfFreshWaterFish += 1;
	}

	public void addSaltWaterFish() {
		numOfSaltWaterFish += 1;
	}

	public void addPondFish() {
		numOfPondFish += 1;
	}

	public void addCrab() {
		numOfCrabs += 1;
	}

	public void addFreshWaterPlant() {
		numOfFreshWaterPlants += 1;
	}

	public void addPondPlant() {
		numOfPondPlants += 1;
	}

	public void addTank() {
		numOfFoodItems += 1;
	}

	public void addFoodItem() {
		numOfTanks += 1;
	}

	public void addFilterItem() {
		numOfFilterItems += 1;
	}

	public void addCo2Item() {
		numOfCo2Items += 1;
	}
}
