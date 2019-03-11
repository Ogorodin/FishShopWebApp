package org.ogorodin.repository;

import org.ogorodin.entity.Products;
import org.springframework.data.repository.CrudRepository;

public interface IProductsRepository extends CrudRepository<Products, Integer>{

}
