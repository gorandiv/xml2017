package company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping(path = "/sent", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Faktura> getSentInvoices() {
		return invoiceService.getSentInvoices();
	}
	
	@GetMapping(path = "/received", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Faktura> getReceivedInvoices() {
		return invoiceService.getReceivedInvoices();
	}
	
}
