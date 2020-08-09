package com.product.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.model.Customer;

import com.product.repository.CustomerRepository;
import com.product.service.CustomerService;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerRepository repository;
	
	@Override
	public Customer storeCustomer(Customer customer) {
//		List<Customer> updateCustomer = fetchCustomerBySearch(customer.getContact());
//		if(updateCustomer.size()>0)
//			customer.setId(updateCustomer.get(0).getId());
		return repository.save(customer);
	}

	@Override
	public List<Customer> fetchCustomerBySearch(String key) {
		return repository.fetchCustomerBySearch(key);		
	}
	@Override
	public void deleteCustomerById(Long id) {
		repository.deleteById(id);		
	}
	
}
