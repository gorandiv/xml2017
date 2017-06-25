package company.service;

import java.util.List;

import company.bean.Faktura;

public interface InvoiceService {

	List<Faktura> getReceivedInvoices();

	List<Faktura> getSentInvoices();

}
