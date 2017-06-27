package bank.centralToBank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.bankxml.bankxml.mt102.Mt102;

import bank.bankToCentral.ReservedRepository;
import bank.bean.Firma;
import bank.bean.RacunFirme;
import bank.bean.Reservation;
import bank.dao.CompanyDao;
import bank.dao.RacuniDAO;
@Endpoint
public class MT102Endpoint {

	private static final String NAMESPACE_URI = "http://mt102.BankXml.bankXml.example.com";

	@Autowired
	private ReservedRepository reservedRepository;
	
	@Autowired
	private RacuniDAO racuniDAO;
	
	@Autowired
	private CompanyDao companyDAO;
	

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "mt102")
	@ResponsePayload
	public Mt102 getCountry(@RequestPayload Mt102 request) {
		String id=request.getNalogZaMT102().get(0).getPrimalacPoverilac();
		Firma poverilac = companyDAO.findByIme(id);
		RacunFirme racunPoverioca = racuniDAO.findByFirma_Id(poverilac.getId());
		racunPoverioca.setStanjeRacuna(racunPoverioca.getStanjeRacuna().add(request.getUkupanIznos()));
		racuniDAO.save(racunPoverioca);
		return request;
	}
	
}
