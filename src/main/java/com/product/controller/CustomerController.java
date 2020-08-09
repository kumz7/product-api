package com.product.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Customer;
import com.product.service.CustomerService;

@RestController
public class CustomerController { 

	@Autowired
	CustomerService service;
	
	@PostMapping
	@RequestMapping("/customer")
	public Customer storeCustomer(@RequestBody Customer customer) {
		return service.storeCustomer(customer); 
	}
	/*
	 * Key may contain name/number/ticket id
	 */
	@GetMapping
	@RequestMapping("/customer/{key}")
	public List<Customer> fetch(@PathVariable String key) {
		return service.fetchCustomerBySearch(key); 
	}
}
