package company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import company.bean.Faktura;
import company.dao.InvoiceDao;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	
	@Autowired
	private InvoiceDao invoiceDao;
	
	@Value("${companyPib}")
	private String companyPib;
	
	@Override
	public List<Faktura> getReceivedInvoices() {
		return invoiceDao.findByZaglavljeFakturePibDobavljaca(companyPib);
	}

	@Override
	public List<Faktura> getSentInvoices() {
		return invoiceDao.findByZaglavljeFakturePibKupca(companyPib);
	}

}
