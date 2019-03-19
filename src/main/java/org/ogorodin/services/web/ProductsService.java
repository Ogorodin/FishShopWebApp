package org.ogorodin.services.web;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.ogorodin.entity.Products;
import org.ogorodin.repository.IProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductsService implements IProductsService {

	@Autowired
	IProductsRepository _repository;

	@Override
	public Iterable<Products> getAllProducts() {
		return _repository.findAll();
	}

	@Override
	public Optional<Products> findById(Integer id) {
		return _repository.findById(id);
	}

	@Override
	public boolean insertOrUpdateProduct(Products product) {
		if (_repository.save(product) != null) {
			return true;
		} else
			return false;
	}



}
