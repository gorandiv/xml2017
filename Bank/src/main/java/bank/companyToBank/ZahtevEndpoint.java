package bank.companyToBank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import bank.bean.Presek;
import bank.bean.Presek.Zaglavlje;
import bank.bean.ZahtevZaIzvod;
import bank.dao.BankDAO;
import bank.dao.CompanyDao;
import bank.dao.OverviewSectionDao;
import bank.dao.RacuniDAO;

@Endpoint
public class ZahtevEndpoint {

	private static final String NAMESPACE_URI = "http://www.ftn.uns.ac.rs/ZahtevZaIzvod";

	@Value("${bankId}")
	private String bankId;
	
	@Autowired
	private BankDAO bankDAO;
	@Autowired
	private CompanyDao companyDAO;
	@Autowired
	private RacuniDAO racuniDAO;
	
	@Autowired
	private OverviewSectionDao overviewSectionDao;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "zahtev_za_izvod")
	@ResponsePayload
	public Presek handleRequest(@RequestPayload ZahtevZaIzvod request) {		

		//TODO implementirati sta banka radi kada dobiej zahtjev, pred kraj
		
		System.out.println("USAO SAM U ZAHTEV ENDPOINT - BANKA");
		
		System.out.println(Integer.parseInt(request.getRedniBrojPreseka().toString()) + "**************************************************");
		
		return overviewSectionDao.findByZaglavljeBrojPresekaAndDatumNalogaAndBrojRacuna(request.getRedniBrojPreseka(), request.getDatum(), request.getBrojRacuna());
	}
	
}
