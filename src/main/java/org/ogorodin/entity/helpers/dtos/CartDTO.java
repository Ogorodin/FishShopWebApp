package org.ogorodin.entity.helpers.dtos;

import java.util.HashMap;

public class CartDTO {

	// pairs of productID and quantity
	private HashMap<Integer, Integer> _cart = new HashMap<>();

	public CartDTO() {
	}

	public CartDTO(int productId, int qty) {
		insertIntoCart(productId, qty);
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
