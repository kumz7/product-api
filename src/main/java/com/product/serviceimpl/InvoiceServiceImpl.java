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
		Calendar calendar = new GregorianCalendar();
		if(!invoice.getDate().isEmpty()&& invoice.getInvoice_no()==null) {  
			String year = ""+calendar.get(calendar.YEAR);
			long tkt = countInvoice("MSR/SI/"+year.substring(0, 2))+1;
			int len = (""+(tkt)).length();
			String prefix = len==1?"000":len==2?"00":len==3?"0":"";	
			invoice.setInvoice_no(("MSR/SI/"+year.substring(0, 2)+"/"+prefix+tkt));
		}
		return repository.save(invoice); 
	}
	private long countInvoice(String search){
		return repository.countInvoice(search); 
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
