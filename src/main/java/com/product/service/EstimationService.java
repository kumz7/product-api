package com.product.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.product.model.Customer;
import com.product.model.Estimation;


public interface EstimationService {
	public Estimation storeEstimation(Estimation estimation);
	public Optional<Estimation> fetchEstimationById(Long id);
	public void deleteEstimationById(Long id);
}
