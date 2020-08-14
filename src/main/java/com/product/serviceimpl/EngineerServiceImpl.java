package com.product.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.model.Engineer;

import com.product.repository.EngineerRepository;
import com.product.service.EngineerService;

@Service("EngineerService")
public class EngineerServiceImpl implements EngineerService{
	@Autowired
	EngineerRepository repository;
	
	@Override
	public Engineer storeEngineer(Engineer Engineer) {
//		List<Engineer> updateEngineer = fetchEngineerBySearch(Engineer.getContact());
//		if(updateEngineer.size()>0)
//			Engineer.setId(updateEngineer.get(0).getId());
		return repository.save(Engineer);
	}

	@Override
	public List<Engineer> fetchEngineerBySearch(String key) {
		return repository.fetchEngineerBySearch(key);		
	}
	@Override
	public void deleteEngineerById(Long id) {
		repository.deleteById(id);		
	}
	
}
