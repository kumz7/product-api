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

//		Calendar calendar = new GregorianCalendar();
//		if(Ticket.getTicket()== null || Ticket.getTicket().trim().isEmpty()) {
//			String year = ""+calendar.get(calendar.YEAR);
//			long tkt = countTicket("MSR/"+year.substring(0, 2))+1;
//			int len = (""+tkt).length();
//			String prefix = len==1?"000":len==2?"00":len==3?"0":"";	
//			Ticket.setTicket("MSR/"+year.substring(0, 2)+"/"+prefix+tkt);
//		}
		return repository.save(Ticket);
	} 
	@Override
	public String getTicket() {
		Calendar calendar = new GregorianCalendar();
		String year = ""+calendar.get(calendar.YEAR);
		long tkt = countTicket("MSR/"+year.substring(0, 2))+1;
		int len = (""+tkt).length();
		String prefix = len==1?"000":len==2?"00":len==3?"0":"";	
		return "MSR/"+year.substring(0, 2)+"/"+prefix+tkt;
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
