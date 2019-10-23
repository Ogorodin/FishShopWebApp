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
	private int _stock;

	public ProductDTO() {
	}

	public ProductDTO(int _id, String _title, String _description, double _price, double _subtotal, int _stock) {
		this._id = _id;
		this._title = _title;
		this._description = _description;
		this._price = _price;
		this._subtotal = _subtotal;
		this._stock = _stock;
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

	public int getStock() {
		return _stock;
	}

	public void setStock(int stock) {
		this._stock = stock;
	}

	@Override
	public String toString() {
		return "ProductDTO [_id=" + _id + ", _title=" + _title + ", _description=" + _description + ", _price=" + _price
				+ ", _subtotal=" + _subtotal + ", _stock=" + _stock + "]";
	}

}
