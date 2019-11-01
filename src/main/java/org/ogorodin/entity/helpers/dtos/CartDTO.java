package org.ogorodin.entity.helpers.dtos;

import java.util.HashMap;

public class CartDTO {

	// pairs of productID and quantity
	private HashMap<Integer, Integer> _cart = new HashMap<>();
	private int _customerId;

	public CartDTO() {
	}

	public CartDTO(int customerId, int productId, int qty) {
		this._customerId = customerId;
		insertIntoCart(productId, qty);
	}

	public int getCustomerId() {
		return _customerId;
	}

	public void setCustomerId(int customerId) {
		this._customerId = customerId;
	}

	public void setCart(HashMap<Integer, Integer> cart) {
		this._cart = cart;
	}

	public HashMap<Integer, Integer> getCart() {
		return _cart;
	}

	public CartDTO insertIntoCart(int productId, int qty) {
		if (_cart.isEmpty() || !_cart.containsKey(productId)) {
			_cart.put(productId, qty);
		} else {
			int newQty = _cart.get(productId) + qty;
			_cart.replace(productId, newQty);
		}
		return this;
	}

	@Override
	public String toString() {
		return "CartDTO [" + _cart + "]";
	}

}
