package com.product.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Customer;
import com.product.model.Product;
import com.product.service.CustomerService;
import com.product.service.ProductService;

@RestController
public class ProductController { 

	@Autowired
	ProductService service;
	
	@PostMapping
	@RequestMapping("/product")
	public Product storeProduct(@RequestBody Product product) {
		return service.storeProduct(product); 
	}
	/*
	 * Key may contain name/number/ticket id
	 */
	@GetMapping
	@RequestMapping("/product/{id}")
	public Optional<Product> fetch(@PathVariable Long id) { 
		return service.fetchProductById(id); 
	}
}
