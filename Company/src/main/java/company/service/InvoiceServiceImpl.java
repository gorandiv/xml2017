package company.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import company.bean.Faktura;
import company.bean.Firma;
import company.dao.CompanyDao;
import company.dao.InvoiceDao;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceDao invoiceDao;
	
	@Autowired
	private CompanyDao companyDao;
	
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
		invoice.getZaglavljeFakture().setBrojRacuna(Integer.toString(ThreadLocalRandom.current().nextInt(100000, 999999)));
		return invoiceDao.save(invoice);
	}

	@Override
	public void removeInvoice(Integer invoiceId) {
		invoiceDao.removeById(invoiceId);

	}
	
	@Override
	public void receiveInvoice(Faktura invoice) {
		Faktura i = invoiceDao.findByZaglavljeFaktureBrojRacuna(invoice.getZaglavljeFakture().getBrojRacuna());
		i.setPoslata(true);
		invoiceDao.save(i);
	}

	@Override
	public void sendInvoice(Faktura invoice) {
		Firma company = companyDao.findByPib(invoice.getZaglavljeFakture().getPibKupca());
		ResteasyClient client = new ResteasyClientBuilder().build();
		WebTarget target = client.target("http://" + company.getIp() + "/Firma/invoice/receive");
		target.request().post(Entity.entity(invoice	, MediaType.APPLICATION_XML));
	}

}
