package com.product.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.product.model.StoreMap;
import com.product.repository.StoreMapRepository;
import com.product.service.StoreMapService;

@Service("StoreMapService")
public class StoreMapServiceImpl implements StoreMapService{
	
	@Autowired
	StoreMapRepository repository;
	@Override
	public StoreMap saveStoreMap(StoreMap StoreMap) {
		return repository.save(StoreMap);
	}
	
	@Override
	public Iterable<StoreMap> fetchStoreMapAll(){
		return repository.findAll();
	}

	@Override
	public Optional<StoreMap> fetchStoreMapById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Optional<List<StoreMap>> fetchStoreMapByCategory(String key) {
		// TODO Auto-generated method stub
		return repository.getMapByKey(key);
	}

	@Override
	public boolean deleteStoreMapById(Long id) {
		repository.deleteById(id);
		return true;
	}
	@Override
	public boolean isAdmin() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
		String role = authentication.getAuthorities().toArray()[0].toString();
		return role.equals("ROLE_ADMIN");
	} 
	
}
