package com.product.serviceimpl;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.model.Engineer;
import com.product.model.Mapping;
import com.product.repository.EngineerRepository;
import com.product.service.EngineerService;

@Service("EngineerService")
public class EngineerServiceImpl implements EngineerService{
	@Autowired
	EngineerRepository repository;
	
	@Override
	public Iterable<Engineer> storeEngineer(Engineer engineer, Mapping map) {
		List<Engineer> list = new ArrayList<>();
		map.getEngineer().forEach(tomap->{
			tomap.setMapping(map); 
		});
		engineer.setMapping(map);
		engineer.setId(map.getId()); 
		list.addAll(map.getEngineer());
		list.add(engineer);
		return repository.saveAll(list);
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
