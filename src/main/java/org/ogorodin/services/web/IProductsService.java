package org.ogorodin.services.web;

import java.util.Optional;

import org.ogorodin.entity.Products;

public interface IProductsService {

	public Iterable<Products> getAllProducts();

	public Optional<Products> findById(Integer productId);

	public boolean insertOrUpdateProduct(Products product);


}
