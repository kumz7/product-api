package com.product.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.product.model.Customer;
import com.product.model.Mapping;


public interface MappingService {
	public Mapping storeMapping(Mapping ticket);
	public Optional<Mapping> fetchMappingById(Long id);
	public List<Mapping> fetchMappingBySearch(String key);
	public void deleteMappingById(Long id);
	

}
