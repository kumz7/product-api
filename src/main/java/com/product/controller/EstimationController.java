package com.product.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Estimation;
import com.product.service.EstimationService;


@RestController
public class EstimationController { 

	@Autowired
	EstimationService service;
	
	@PostMapping
	@RequestMapping("/estimation")
	public Estimation storeEstimation(@RequestBody Estimation Estimation) {
		return service.storeEstimation(Estimation); 
	}
	/*
	 * Key may contain name/number/Estimation id
	 */
	@GetMapping
	@RequestMapping("/estimation/{id}")
	public Optional<Estimation> fetch(@PathVariable Long id) { 
		return service.fetchEstimationById(id); 
	}
}
