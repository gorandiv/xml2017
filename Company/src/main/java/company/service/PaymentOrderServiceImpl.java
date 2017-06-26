package company.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import company.bean.NalogZaPrenos;
import company.dao.PaymentOrderDao;

@Service
public class PaymentOrderServiceImpl implements PaymentOrderService {
	
	@Autowired
	private PaymentOrderDao paymentOrderDao;
	

	@Value("${companyName}")
	private String companyName;
	
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
	public void sendPaymentOrderToBank() {
		// TODO MILENKO OVDE MECE
		

	}

}
