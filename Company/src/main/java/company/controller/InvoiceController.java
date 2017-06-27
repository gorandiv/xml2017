package company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import company.bean.Faktura;
import company.service.InvoiceService;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
	
	@Autowired
	private InvoiceService invoiceService;
	
	// ne zaboraviti @RequestBody anotaciju kada prima parametar sa klijenta! consumes se takodje postavlja u mapping anotaciju
	
	@GetMapping(path = "/created", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Faktura> getCreatedInvoices() {
		return invoiceService.getCreatedInvoices();
	}
	
	@GetMapping(path = "/sent", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Faktura> getSentInvoices() {
		return invoiceService.getSentInvoices();
	}
	
	@GetMapping(path = "/received", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Faktura> getReceivedInvoices() {
		return invoiceService.getReceivedInvoices();
	}
	
	@PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Faktura createInvoice(@RequestBody Faktura invoice) {
		return invoiceService.createInvoice(invoice);
	}
	
	@PostMapping(path = "/send", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void sendInvoice(@RequestBody Faktura invoice) {
		invoiceService.sendInvoice(invoice);
	}
	
	@PostMapping(path = "/receive", consumes = MediaType.APPLICATION_XML_VALUE)
	public void receiveInvoice(@RequestBody Faktura invoice) {
		invoiceService.receiveInvoice(invoice);
	}
	
	@PutMapping(path = "/remove/{invoiceId}")
	public void removeInvoice(@PathVariable("invoiceId") Integer invoiceId) {
		invoiceService.removeInvoice(invoiceId);
	}
	
}
