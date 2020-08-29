package com.product.serviceimpl;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.model.Invoice;
import com.product.model.Ticket;
import com.product.repository.InvoiceRepository;
import com.product.repository.TicketRepository;
import com.product.service.InvoiceService;
import com.product.service.TicketService;


@Service("InvoiceService")
public class InvoiceServiceImpl implements InvoiceService{
	@Autowired
	InvoiceRepository repository;

	@Override
	public Invoice storeInvoice(Invoice invoice) {
		
		return repository.save(invoice); 
	}

	@Override
	public Optional<Invoice> fetchInvoiceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInvoiceById(Long id) {
		// TODO Auto-generated method stub
		
	}
	


}
