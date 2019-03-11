package org.ogorodin.repository;

import org.ogorodin.entity.Stock;
import org.springframework.data.repository.CrudRepository;

public interface IStockRepository extends CrudRepository<Stock, Integer> {

}
