package company.service;

import java.util.List;

import company.bean.Faktura;

public interface InvoiceService {

	List<Faktura> getReceivedInvoices();

	List<Faktura> getSentInvoices();

	Faktura createInvoice(Faktura invoice);

	List<Faktura> getCreatedInvoices();

	Faktura sendInvoice(Integer invoiceId);

	void removeInvoice(Integer invoiceId);

	void sendInvoiceToBank();

}
