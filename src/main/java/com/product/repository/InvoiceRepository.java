package com.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.product.model.Customer;
import com.product.model.Invoice;
import com.product.model.Product;
import com.product.model.Ticket;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
	
//	@Query("select count(*) from Ticket where ticket like %:year% ")
//	public long countTicket(@Param("year") String year);
	@Query("select count(*) from Invoice where invoice_no like %:year% ")
	public long countInvoice(@Param("year") String year);
	
}