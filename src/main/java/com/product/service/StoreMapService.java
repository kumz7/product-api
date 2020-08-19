package com.product.service;

import java.util.List;
import java.util.Optional;

import com.product.model.StoreMap;

public interface StoreMapService {
	public StoreMap saveStoreMap(StoreMap StoreMap);
	public Optional<StoreMap> fetchStoreMapById(Long id);
	public Iterable<StoreMap> fetchStoreMapAll();
	public Optional<List<StoreMap>> fetchStoreMapByCategory(String key);
	public void deleteStoreMapById(Long id);
	
}

