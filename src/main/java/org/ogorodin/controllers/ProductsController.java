package org.ogorodin.controllers;

import java.util.Optional;

import org.ogorodin.entity.Products;
import org.ogorodin.services.web.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductsController {

	@Autowired
	private IProductsService _productService;

	@GetMapping("/products")
	public Iterable<Products> getAllProducts() {
		return _productService.getAllProducts();
	}

	@GetMapping("/products/{productId}")
	public Optional<Products> getProductById(@PathVariable String productId) {
		return _productService.findById(Integer.parseInt(productId));
	}

	@PostMapping("/products")
	public boolean insertProduct(@RequestBody Products product) {
		return _productService.insertOrUpdateProduct(product);
	}

	@PutMapping("/products/{productId}")
	public boolean updateProduct(@RequestBody Products product, @PathVariable String productId) {
		if (_productService.findById(Integer.parseInt(productId)).isPresent()) {
			return _productService.insertOrUpdateProduct(product);
		} else
			return false;
	}
}
