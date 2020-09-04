package com.product.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.product.model.Engineer;
import com.product.model.Mapping;


public interface EngineerService {
	public Iterable<Engineer> storeEngineer(Engineer engineer, Mapping map);
	public List<Engineer> fetchEngineerBySearch(String key);
	public void deleteEngineerById(Long id);
}
