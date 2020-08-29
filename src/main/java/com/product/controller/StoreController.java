package com.product.controller;

import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64;
import com.product.model.StoreMap;
import com.product.service.EmailService;
import com.product.service.StoreMapService;

@RestController
public class StoreController {
	@Autowired
	StoreMapService service;

	@Autowired
	EmailService Eservice;


	@Autowired
	StoreMapService StoreService;
	
	@GetMapping
	@RequestMapping("/isadmin")
	public boolean isadmin() {
		return (service.isAdmin());
	}
  	@PostMapping
	@RequestMapping("/sentEmail")
	public boolean sentMail(@RequestBody String image) {
  		Document document = new Document(PageSize.A4, 20.0f, 20.0f, 20.0f, 150.0f);
  		String output = "Invoice.pdf";
  		try {
            PdfWriter.getInstance(document, new FileOutputStream(output));
            document.open();
            byte[] decoded = Base64.decode(image);            
            Image img = Image.getInstance(decoded);
            img.setAbsolutePosition(0, 0);
            img.scaleToFit(PageSize.A4.getWidth(), PageSize.A4.getHeight());
            document.add(img);
            document.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		String host = StoreService.fetchStoreMapByCategory("mail.smtp.host").get().get(0).getValue();
		String port = StoreService.fetchStoreMapByCategory("mail.smtp.port").get().get(0).getValue();
		String email = StoreService.fetchStoreMapByCategory("mail.smtp.email").get().get(0).getValue();
		String password = StoreService.fetchStoreMapByCategory("mail.smtp.password").get().get(0).getValue();
		String auth = StoreService.fetchStoreMapByCategory("mail.smtp.auth").get().get(0).getValue();
		String tls = StoreService.fetchStoreMapByCategory("mail.smtp.starttls.enable").get().get(0).getValue();
		//map.getCustomer().getMail().toString().trim()
		return Eservice.sentEmail(host	,port , Boolean.parseBoolean(auth), Boolean.parseBoolean(tls), email, password, "kuaranmani92@gmail.com", "Regd: Invoice (MSR Info Tech)", "Dear Customer "+" greetings, ");
	}
	@PostMapping
	@RequestMapping("/options")
	public ResponseEntity<?> storeTicket(@RequestBody StoreMap storeMap) {
		if(!service.isAdmin())
			return ResponseEntity.status(499).body(""); 
		return ResponseEntity.ok().body(service.saveStoreMap(storeMap));
	}
	
	@GetMapping
	@RequestMapping("/getoptions/{id}")
	public Optional<StoreMap> fetch(@PathVariable Long id) { 
		return service.fetchStoreMapById(id); 
	}
	
	@GetMapping
	@RequestMapping("/getalloptions/{key}")
	public Optional<List<StoreMap>> fetchByName(@PathVariable String key) { 
		return service.fetchStoreMapByCategory(key); 
	}
	
	@GetMapping
	@RequestMapping("/alloptions")
	public Iterable<StoreMap> fetchAll() { 
		return service.fetchStoreMapAll(); 
	}
	
	@DeleteMapping
	@RequestMapping("/options/{did}")
	public ResponseEntity delete(@PathVariable Long did) {
		if(!service.isAdmin())
			return ResponseEntity.status(499).body(""); 
		return ResponseEntity.ok().body(service.deleteStoreMapById(did)); 
	} 
}
