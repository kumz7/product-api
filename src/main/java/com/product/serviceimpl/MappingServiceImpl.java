package com.product.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.model.Customer;
import com.product.model.Engineer;
import com.product.model.Mapping;
import com.product.model.Ticket;
import com.product.repository.CustomerRepository;
import com.product.repository.MappingRepository;
import com.product.service.CustomerService;
import com.product.service.EngineerService;
import com.product.service.EstimationService;
import com.product.service.InvoiceService;
import com.product.service.IssueService;
import com.product.service.MappingService;
import com.product.service.ProductService;
import com.product.service.TicketService;

@Service("MappingService")
public class MappingServiceImpl implements MappingService {

	@Autowired
	MappingRepository repository;

	@Autowired
	CustomerService customerService;

	@Autowired
	TicketService ticketService;

	@Autowired
	IssueService issueService;

	@Autowired
	EstimationService estimationService;

	@Autowired
	ProductService productService;

	@Autowired
	InvoiceService invoiceService;

	@Autowired
	EngineerService engineerServicer;
	@Override
	@Transactional
	public Mapping storeMapping(Mapping mapping) {
		// TODO Auto-generated method stub
		Optional<Mapping> checkIf = repository.findById(mapping.getId());
		
		if(checkIf.isPresent()) {
			Mapping map = checkIf.get();
			mapping.getCustomer().setMapping(map.getCustomer().getMapping());
			mapping.getTicket().setMapping(map.getTicket().getMapping());
			mapping.getIssue().setMapping(map.getIssue().getMapping());
			mapping.getEstimation().setMapping(map.getEstimation().getMapping());
			mapping.getProduct().setMapping(map.getProduct().getMapping());
			mapping.getInvoice().setMapping(map.getInvoice().getMapping());
			
			customerService.storeCustomer(mapping.getCustomer());   
			ticketService.storeTicket(mapping.getTicket());   
			issueService.storeIssue(mapping.getIssue());  
			estimationService.storeEstimation(mapping.getEstimation());    
			productService.storeProduct(mapping.getProduct());  
			invoiceService.storeInvoice(mapping.getInvoice());
			ArrayList<Engineer> list = new ArrayList<>(mapping.getEngineer());
			synchronized (map) {
				map = repository.findById(mapping.getId()).get();
				map.getEngineer().clear();
				map.getEngineer().addAll(mapping.getEngineer());
				repository.save(map);
			}
			  
			return map;
		}
		customerService.storeCustomer(mapping.getCustomer()); 
		Mapping object = repository.save(mapping);
		return object;
	}

	@Override
	public Optional<Mapping> fetchMappingById(Long id) {
		//Avoid loop of death on linked list of mapping
		Mapping object = repository.findById(id).get();
		return Optional.of(makeNull(object));  
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
	@Override
	public List<Mapping> fetchMappingBySearch(String key) {
			key = key.toLowerCase();
		List<Mapping> list = repository.findByKey(key);
		list.forEach(object->{
			object.getCustomer().setMapping(null);
			object.getEstimation().setMapping(null);
			object.getIssue().setMapping(null);
			object.getTicket().setMapping(null);
			object.getProduct().setMapping(null);		
			object.getEngineer().forEach(data->{
				data.setMapping(null);
			});
			object.getInvoice().setMapping(null); 
		});
		return list;
	}

	@Override
	public void deleteMappingById(Long id) {
		// TODO Auto-generated method stub

	}

}
