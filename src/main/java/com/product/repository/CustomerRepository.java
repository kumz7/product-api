package com.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.product.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	@Query("from Customer where contact like %:key% or name like %:key% ")
	public List<Customer> fetchCustomerBySearch(@Param("key") String key);
	
}
