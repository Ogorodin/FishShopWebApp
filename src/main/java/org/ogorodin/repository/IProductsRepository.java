package org.ogorodin.repository;

import java.util.List;

import org.ogorodin.entity.Products;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IProductsRepository extends CrudRepository<Products, Integer> {

	@Query(value = "SELECT products.id, products.title, products.the_type, stock.price, stock.quantity "
			+ "FROM products "
			+ "RIGHT OUTER JOIN stock on products.id=stock.product_id",	nativeQuery = true)
	List<Products> getProductsInfoForTheHomePage();

}
