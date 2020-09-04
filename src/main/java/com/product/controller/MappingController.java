package com.product.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Mapping;
import com.product.model.Ticket;
import com.product.service.EmailService;
import com.product.service.MappingService;
import com.product.service.StoreMapService;
import com.product.service.TicketService;
import com.product.serviceimpl.EmailServiceImpl;


@RestController
public class MappingController { 

	@Autowired
	MappingService service;
	
	@Autowired
	EmailService Eservice;
	
	@PostMapping
	@RequestMapping("/mapping")
	public Mapping storeMapping(@RequestBody Mapping map) {
		return makeNull(service.storeMapping(map));
	}
	public Mapping makeNull(Mapping object){
		object.getCustomer().setMapping(null); 
		object.getEstimation().setMapping(null);
		object.getIssue().setMapping(null);
		object.getTicket().setMapping(null);
		object.getProduct().setMapping(null);
		object.getEngineer().forEach(data->{
			data.setMapping(null); 
		});
		object.getInvoice().setMapping(null); 
		return object;
	}
	/*
	 * Key may contain name/number/ticket id
	 */
	@GetMapping
	@RequestMapping("/mapping/{id}")
	public Optional<Mapping> fetch(@PathVariable Long id) { 
		return service.fetchMappingById(id);  
	}
	@GetMapping
	@RequestMapping("/search/{key}")
	public List<Mapping> fetch(@PathVariable String key) { 
		return service.fetchMappingBySearch(key);
	}
} 
