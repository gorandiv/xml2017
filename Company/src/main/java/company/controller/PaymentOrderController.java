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

import company.bean.NalogZaPrenos;
import company.service.PaymentOrderService;

@RestController
@RequestMapping("/payment-order")
public class PaymentOrderController {
	
	@Autowired
	private PaymentOrderService paymentOrderService;
	
	@GetMapping(path = "/created", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<NalogZaPrenos> getCreatedPaymentOrders() {
		return paymentOrderService.getCreatedPaymentOrders();
	}
	
	@GetMapping(path = "/sent", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<NalogZaPrenos> getSentPaymentOrders() {
		return paymentOrderService.getSentPaymentOrders();
	}
	
	@PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody NalogZaPrenos createPaymentOrder(@RequestBody NalogZaPrenos paymentOrder) {
		return paymentOrderService.createPaymentOrder(paymentOrder);
	}
	
	@PutMapping(path = "/send/{paymentOrderId}")
	public @ResponseBody NalogZaPrenos sendPaymentOrder(@PathVariable("paymentOrderId") Integer paymentOrderId) {
		paymentOrderService.sendPaymentOrderToBank();
		return paymentOrderService.sendPaymentOrder(paymentOrderId);
	}
	
	@PutMapping(path = "/remove/{paymentOrderId}")
	public void removePaymentOrder(@PathVariable("paymentOrderId") Integer paymentOrderId) {
		paymentOrderService.removePaymentOrder(paymentOrderId);
	}

}
