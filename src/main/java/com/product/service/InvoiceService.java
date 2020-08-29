package com.product.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.product.model.Customer;
import com.product.model.Invoice;


public interface InvoiceService {
	public Invoice storeInvoice(Invoice Invoice);
	public Optional<Invoice> fetchInvoiceById(Long id);
	public void deleteInvoiceById(Long id);

}
