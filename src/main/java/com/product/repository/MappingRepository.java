package com.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.product.model.Customer;
import com.product.model.Mapping;
import com.product.model.Product;
import com.product.model.Ticket;

@Repository
public interface MappingRepository extends CrudRepository<Mapping, Long> {
	@Query("from Mapping where LOWER(customer.contact) like %:key% or LOWER(customer.name) like %:key% or ticket.ticket like %:key%")
	public List<Mapping> findByKey(@Param("key") String key);
	

}