package com.product.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.product.model.Customer;
import com.product.model.Product;




public interface ProductService {
	public Product storeProduct(Product product);
	public Optional<Product> fetchProductById(Long id);
	public void deleteProductById(Long id);
	
}
