package com.product.serviceimpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.model.Customer;
import com.product.model.Product;
import com.product.repository.CustomerRepository;
import com.product.repository.ProductRepository;
import com.product.service.CustomerService;
import com.product.service.ProductService;

@Service("ProductService")
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepository repository;
	
	@Override
	public Product storeProduct(Product product) { 
		return repository.save(product);
	}

	@Override
	public Optional<Product> fetchProductById(Long id) {
 		return repository.findById(id);
	}
	
	@Override
	public void deleteProductById(Long id) {
 		repository.deleteById(id);
	}

}
