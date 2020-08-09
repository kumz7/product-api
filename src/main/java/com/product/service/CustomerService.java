package com.product.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.product.model.Customer;


public interface CustomerService {
	public Customer storeCustomer(Customer customer);
	public List<Customer> fetchCustomerBySearch(String key);
	public void deleteCustomerById(Long id);
}
