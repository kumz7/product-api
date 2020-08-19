package com.product.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.product.model.Customer;
import com.product.model.Ticket;


public interface TicketService {
	public Ticket storeTicket(Ticket ticket);
	public Optional<Ticket> fetchTicketById(Long id);
	public void deleteTicketById(Long id);
	public long countTicket(String year);
}
