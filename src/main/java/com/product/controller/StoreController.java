package com.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.StoreMap;
import com.product.model.Ticket;
import com.product.service.StoreMapService;
import com.product.service.TicketService;

@RestController
public class StoreController {
	@Autowired
	StoreMapService service;
	
	@PostMapping
	@RequestMapping("/options")
	public StoreMap storeTicket(@RequestBody StoreMap storeMap) {
		return service.saveStoreMap(storeMap); 
	}
	
	@GetMapping
	@RequestMapping("/getoptions/{id}")
	public Optional<StoreMap> fetch(@PathVariable Long id) { 
		return service.fetchStoreMapById(id); 
	}
	
	@GetMapping
	@RequestMapping("/getalloptions/{key}")
	public Optional<List<StoreMap>> fetchByName(@PathVariable String key) { 
		return service.fetchStoreMapByCategory(key); 
	}
	
	@GetMapping
	@RequestMapping("/alloptions")
	public Iterable<StoreMap> fetchAll() { 
		return service.fetchStoreMapAll(); 
	}
	
	@DeleteMapping
	@RequestMapping("/options/{did}")
	public void delete(@PathVariable Long did) { 
		service.deleteStoreMapById(did); 
	}
}
