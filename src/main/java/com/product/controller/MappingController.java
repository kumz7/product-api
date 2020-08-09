package com.product.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Mapping;
import com.product.model.Ticket;
import com.product.service.MappingService;
import com.product.service.TicketService;


@RestController
public class MappingController { 

	@Autowired
	MappingService service;
	
	@PostMapping
	@RequestMapping("/mapping")
	public Mapping storeMapping(@RequestBody Mapping map) {
		return service.storeMapping(map);
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
