package company.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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
	public List<Faktura> getCreatedInvoices() {
		return invoiceDao.findByZaglavljeFakturePibDobavljacaAndPoslataFalse(companyPib);
	}

	@Override
	public List<Faktura> getSentInvoices() {
		return invoiceDao.findByZaglavljeFakturePibDobavljacaAndPoslataTrue(companyPib);
	}

	@Override
	public List<Faktura> getReceivedInvoices() {
		return invoiceDao.findByZaglavljeFakturePibKupcaAndPoslataTrue(companyPib);
	}

	@Override
	public Faktura createInvoice(Faktura invoice) {
		String now = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		invoice.getZaglavljeFakture().setDatumRacuna(now);
		invoice.getZaglavljeFakture().setDatumValute(now);
		invoice.getZaglavljeFakture().setBrojRacuna(Integer.toString(ThreadLocalRandom.current().nextInt(1000, 9999)));
		return invoiceDao.save(invoice);
	}

	@Override
	public Faktura sendInvoice(Integer invoiceId) {
		invoiceDao.setPoslataById(invoiceId);
		return invoiceDao.findById(invoiceId);
	}

	@Override
	public void removeInvoice(Integer invoiceId) {
		invoiceDao.removeById(invoiceId);

	}

	@Override
	public void sendInvoiceToBuyer() {
		// TODO GORAN OVDE MECE

	}

}
