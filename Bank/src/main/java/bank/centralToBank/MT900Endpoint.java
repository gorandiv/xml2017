package bank.centralToBank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.strukturartgsnaloga.Mt900;
import com.strukturartgsnaloga.Mt910;
import com.strukturartgsnaloga.StrukturaRtgsNaloga;

import bank.bankToCentral.ReservedRepository;
import bank.bean.Firma;
import bank.bean.RacunFirme;
import bank.bean.Reservation;
import bank.dao.CompanyDao;
import bank.dao.RacuniDAO;
@Endpoint
public class MT900Endpoint {
	
	@Autowired
	private ReservedRepository reservedRepository;
	
	@Autowired
	private RacuniDAO racuniDAO;
	
	@Autowired
	private CompanyDao companyDAO;
	
	private static final String NAMESPACE_URI = "http://strukturaRtgsNaloga.com";


	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "mt900")
	@ResponsePayload
	public Mt900 getCountry(@RequestPayload Mt900 request) {
		
		Reservation r=reservedRepository.getMap().get(request.getIdPorukeNaloga());
		reservedRepository.getMap().remove(request.getIdPorukeNaloga());
		
		r.getRacunFirme().setStanjeRacuna(r.getRacunFirme().getStanjeRacuna().subtract(r.getAmount()));
		racuniDAO.save(r.getRacunFirme());
		
		return request;
	}
	
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "mt910")
	@ResponsePayload
	public Mt910 getCountry(@RequestPayload Mt910 request) {
		
		
		
		return request;
	}
	
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "strukturaRtgsNaloga")
	@ResponsePayload
	public StrukturaRtgsNaloga getCountry(@RequestPayload StrukturaRtgsNaloga request) {
		//Firma poverilac = companyDAO.findByIme(request.getPrimalacPoverilac());
		
		RacunFirme racunPoverioca = racuniDAO.findById(Integer.parseInt(request.getRacunPoverioca()));
		racunPoverioca.setStanjeRacuna(racunPoverioca.getStanjeRacuna().add(request.getIznos()));
		racuniDAO.save(racunPoverioca);
		System.out.println("posle");
		return request;
	}

}
