package org.ogorodin.entity.helpers;

import org.ogorodin.entity.Products.EProductType;

public class ProductForHomeView {

	private int id;
	private String title;
	private EProductType productType;
	private double price;
	private int quantity;

	public ProductForHomeView(int id, String title, EProductType productType, double price, int quantity) {
		this.id = id;
		this.title = title;
		this.productType = productType;
		this.price = price;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public EProductType getProductType() {
		return productType;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setProductType(EProductType productType) {
		this.productType = productType;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
