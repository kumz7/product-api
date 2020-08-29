package com.product.serviceimpl;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
	public long countTicket(String year) {
		
		return repository.countTicket(year);
	}
	@Override
	public Ticket storeTicket(Ticket Ticket) {

		Calendar calendar = new GregorianCalendar();
		if(Ticket.getTicket()== null || Ticket.getTicket().trim().isEmpty()) {
			//ticket date
//			LocalDateTime myDateObj = LocalDateTime.now();
//		    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//		    String formattedDate = myDateObj.format(myFormatObj);
//		    Ticket.setDate(formattedDate);
			//ticket info
			String year = ""+calendar.get(calendar.YEAR);
			long tkt = countTicket(year);
			Ticket.setTicket("TKT"+tkt+year);
		}
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
