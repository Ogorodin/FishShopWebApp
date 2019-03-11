package org.ogorodin.services;

import java.util.Optional;

import org.ogorodin.entity.Stock;

public interface IStockService {

	public Iterable<Stock> getAllStock();

	public Optional<Stock> findStockById(Integer stockId);

	public boolean insertOrUpdateStock(Stock stock);

	public void deleteStockById(Integer stockId);

}
