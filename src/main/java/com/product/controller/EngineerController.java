package com.product.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Engineer;
import com.product.model.Estimation;
import com.product.service.EngineerService;
import com.product.service.StoreMapService;

@RestController
public class EngineerController {

	@Autowired
	EngineerService service;

	
	@DeleteMapping
	@RequestMapping("/engineer/{id}")
	public void storeEngineer(@PathVariable Long id) {
		service.deleteEngineerById(id);
		
	}

}
