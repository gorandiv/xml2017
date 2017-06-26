package company.service;

import java.util.List;

import company.bean.NalogZaPrenos;

public interface PaymentOrderService {

	NalogZaPrenos createPaymentOrder(NalogZaPrenos paymentOrder);

	void sendPaymentOrderToBank();

	NalogZaPrenos sendPaymentOrder(Integer paymentOrderId);

	void removePaymentOrder(Integer paymentOrderId);

	List<NalogZaPrenos> getCreatedPaymentOrders();

	List<NalogZaPrenos> getSentPaymentOrders();

}
