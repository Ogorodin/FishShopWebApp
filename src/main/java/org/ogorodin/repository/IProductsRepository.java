package org.ogorodin.repository;

import org.ogorodin.entity.Products;
import org.ogorodin.entity.helpers.IProductHomePageSummary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IProductsRepository extends CrudRepository<Products, Integer> {

	@Query(nativeQuery = true, value = "SELECT products.id, products.title, products.the_type AS productType,stock.price, stock.quantity FROM products LEFT	JOIN stock on products.id=stock.product_id")
	Iterable<IProductHomePageSummary> getProductsInfoForTheHomePage();



}