package com.product.serviceimpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.model.Estimation;
import com.product.repository.EstimationRepository;
import com.product.service.EstimationService;


@Service("EstimationService")
public class EstimationServiceImpl implements EstimationService{
	@Autowired
	EstimationRepository repository;
	
	@Override
	public Estimation storeEstimation(Estimation Estimation) { 
		return repository.save(Estimation);
	}

	@Override
	public Optional<Estimation> fetchEstimationById(Long id) {
 		return repository.findById(id);
	}
	
	@Override
	public void deleteEstimationById(Long id) {
 		repository.deleteById(id);
	}

}
