package com.product.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Ticket;
import com.product.service.TicketService;


@RestController
public class TicketController { 

	@Autowired
	TicketService service;
	
	@PostMapping
	@RequestMapping("/ticket")
	public Ticket storeTicket(@RequestBody Ticket Ticket) {
		return service.storeTicket(Ticket); 
	}
	/*
	 * Key may contain name/number/ticket id
	 */
	@GetMapping
	@RequestMapping("/ticket/{id}")
	public Optional<Ticket> fetch(@PathVariable Long id) { 
		return service.fetchTicketById(id); 
	}
	@GetMapping
	@RequestMapping("/ticketno")
	public String getTicketNo() {
		return service.getTicket();
	}
}
