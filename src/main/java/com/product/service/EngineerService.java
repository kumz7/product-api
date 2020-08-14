package com.product.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.product.model.Engineer;


public interface EngineerService {
	public Engineer storeEngineer(Engineer Engineer);
	public List<Engineer> fetchEngineerBySearch(String key);
	public void deleteEngineerById(Long id);
}
