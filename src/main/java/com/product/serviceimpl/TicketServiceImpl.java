package com.product.serviceimpl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.model.Ticket;
import com.product.repository.TicketRepository;
import com.product.service.TicketService;


@Service("TicketService")
public class TicketServiceImpl implements TicketService{
	@Autowired
	TicketRepository repository;
	
	@Override
	public Ticket storeTicket(Ticket Ticket) { 
		return repository.save(Ticket);
	}

	@Override
	public Optional<Ticket> fetchTicketById(Long id) {
 		return repository.findById(id);
	}
	
	@Override
	public void deleteTicketById(Long id) {
 		repository.deleteById(id);
	}

}
