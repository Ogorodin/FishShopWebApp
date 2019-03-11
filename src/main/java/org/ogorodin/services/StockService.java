package org.ogorodin.services;

import java.util.Optional;

import org.ogorodin.entity.Stock;
import org.ogorodin.repository.IStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService implements IStockService {
	
	@Autowired
	IStockRepository _repository;

	@Override
	public Iterable<Stock> getAllStock() {
		return  _repository.findAll();
	}

	@Override
	public Optional<Stock> findStockById(Integer stockId) {
				return _repository.findById(stockId);
	}

	@Override
	public boolean insertOrUpdateStock(Stock stock) {
		if(_repository.save(stock)!= null) {
			return true;
		}else
			return false;
	}

	@Override
	public void deleteStockById(Integer stockId) {
		_repository.deleteById(stockId);
	}

}
