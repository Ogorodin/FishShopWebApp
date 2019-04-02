package org.ogorodin.entity.helpers;

public class ProductForAdminView {

	private int id;
	private String productType;
	private String title;
	private int quantity;
	private double price;

	public ProductForAdminView(int id, String productType, String title, int quantity, double price) {
		this.id = id;
		this.productType = productType;
		this.title = title;
		this.quantity = quantity;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getProductType() {
		return productType;
	}

	public String getTitle() {
		return title;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return price;
	}

}
