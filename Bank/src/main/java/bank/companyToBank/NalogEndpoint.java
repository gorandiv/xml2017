package bank.companyToBank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import bank.bean.Banka;
import bank.bean.Firma;
import bank.bean.NalogZaPrenos;
import bank.bean.RacunFirme;
import bank.dao.BankDAO;
import bank.dao.CompanyDao;
import bank.dao.RacuniDAO;

@Endpoint
public class NalogEndpoint {

	private static final String NAMESPACE_URI = "http://www.ftn.uns.ac.rs/nalogZaPrenos";

	@Value("${bankId}")
	private String bankId;
	
	@Autowired
	private BankDAO bankDAO;
	@Autowired
	private CompanyDao companyDAO;
	@Autowired
	private RacuniDAO racuniDAO;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "nalog_za_prenos")
	@ResponsePayload
	public NalogZaPrenos handleRequest(@RequestPayload NalogZaPrenos request) {		
		Banka thisBank = bankDAO.findById(Integer.parseInt(bankId));
		try{
			Firma poverilac = companyDAO.findByIme(request.getPoverilac());
			Firma duznik  = companyDAO.findByIme(request.getDuznik());
			if (poverilac.getBanka().getId().equals(duznik.getBanka().getId())){
				System.out.println("----------------------Firme se nalaze u istoj banci.-----------------------------");
				RacunFirme racunPoverioca = racuniDAO.findByFirma_Id(poverilac.getId());
				RacunFirme racunDuznika = racuniDAO.findByFirma_Id(duznik.getId());
				System.out.println("----------------------Skidam sa racuna.------------------------------------------");
				racunDuznika.setStanjeRacuna(racunDuznika.getStanjeRacuna().subtract(request.getPodaciOUplati().getIznos()));
				racuniDAO.save(racunDuznika);
				System.out.println("----------------------Dodajem na racun.------------------------------------------");
				racunPoverioca.setStanjeRacuna(racunPoverioca.getStanjeRacuna().add(request.getPodaciOUplati().getIznos()));
				racuniDAO.save(racunPoverioca);
			}else sendRequestToCentralBank(thisBank, poverilac.getBanka());
		}catch(Exception e){
			System.out.println("Nepostojeca firma!");
		}	
		return null;
	}

	private NalogZaPrenos sendRequestToCentralBank(Banka mojaBanka, Banka bankaPoverioca){
		//LUKA TODO
		return null;
	}
	
	
}
