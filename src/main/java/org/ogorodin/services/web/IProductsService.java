package org.ogorodin.services.web;

import java.util.Optional;

import org.ogorodin.entity.Products;
import org.ogorodin.entity.helpers.IProductDetailsForAdmin;
import org.ogorodin.entity.helpers.IProductHomePageSummary;

public interface IProductsService {

	public Iterable<Products> getAllProducts();

	public Optional<Products> findById(Integer productId);

	public boolean insertOrUpdateProduct(Products product);

	public Iterable<IProductHomePageSummary> getProductsInfoForTheHomePage();
	
	public Iterable<IProductDetailsForAdmin> getProductDetailsForAdminView();

}
