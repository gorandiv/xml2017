package company.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import company.bean.Firma;
import company.bean.NalogZaPrenos;
import company.dao.CompanyDao;
import company.dao.PaymentOrderDao;

@Service
public class PaymentOrderServiceImpl implements PaymentOrderService {
	
	@Autowired
	private PaymentOrderDao paymentOrderDao;
	
	@Autowired
	private CompanyDao companyDAO;

	@Value("${companyName}")
	private String companyName;
	
	@Value("${companyId}")
	private String companyId;
	
	@Override
	public List<NalogZaPrenos> getCreatedPaymentOrders() {
		return paymentOrderDao.findByDuznikAndPoslatFalse(companyName);
	}

	@Override
	public List<NalogZaPrenos> getSentPaymentOrders() {
		return paymentOrderDao.findByDuznikAndPoslatTrue(companyName);
	}
	
	
	@Override
	public NalogZaPrenos createPaymentOrder(NalogZaPrenos paymentOrder) {
		String now = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		
		paymentOrder.getPodaciOUplati().setDatumNaloga(now);
		paymentOrder.getPodaciOUplati().setDatumValute(now);
		
		return paymentOrderDao.save(paymentOrder);
	}

	@Override
	public NalogZaPrenos sendPaymentOrder(Integer paymentOrderId) {
		paymentOrderDao.setPoslatById(paymentOrderId);
		return paymentOrderDao.findById(paymentOrderId);
	}

	@Override
	public void removePaymentOrder(Integer paymentOrderId) {
		paymentOrderDao.removeById(paymentOrderId);

	}

	@Override
	public void sendPaymentOrderToBank(Integer paymentOrderId) {
		NalogZaPrenos nalog = paymentOrderDao.findById(paymentOrderId);
		sendRequest(nalog);
	}
		
	private Firma getCompany(){
		return companyDAO.findById(Integer.parseInt(companyId));
	}
	
	private void sendRequest(NalogZaPrenos request){
		 Firma thisCompany = getCompany();
		 System.out.println("-----------------------------Poslat Nalog----------------------");
	     WebServiceTemplate webServiceTemplate = configWebServiceTemplate("company.bean",
	        		"http://"+ thisCompany.getBanka().getAdresa() + "/ws/nalog_za_prenos");
	     webServiceTemplate.marshalSendAndReceive(request);
	     System.out.println("--------------------------Primljen Nalog--------------------");
	}
	
	private WebServiceTemplate configWebServiceTemplate(String contextPath, String url){
       Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
       jaxb2Marshaller.setContextPath(contextPath);

       WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
       webServiceTemplate.setMarshaller(jaxb2Marshaller);
       webServiceTemplate.setUnmarshaller(jaxb2Marshaller);
       webServiceTemplate.setDefaultUri(url);

       return webServiceTemplate;
   }

}
