package org.ogorodin.entity.helpers.dtos;

/*
 * This class is used to pass the Product properties and values needed when products are added/removed into/from the cart
 */
public class ProductDTO {

	private int _id;
	private String _title;
	private String _description;
	private double _price;
	private double _subtotal;

	public ProductDTO() {
	}

	public ProductDTO(int id, String title, String description, double price, double subtotal) {
		this._id = id;
		this._title = title;
		this._description = description;
		this._price = price;
		this._subtotal = subtotal;
	}

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		this._id = id;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		this._title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		this._description = description;
	}

	public double getPrice() {
		return _price;
	}

	public void setPrice(double price) {
		this._price = price;
	}

	public double getSubtotal() {
		return _subtotal;
	}

	public void setSubtotal(double subtotal) {
		this._subtotal = subtotal;
	}

	@Override
	public String toString() {
		return "ProductDTO [id=" + _id + ", title=" + _title + ", description=" + _description + ", price=" + _price
				+ "]";
	}

}
